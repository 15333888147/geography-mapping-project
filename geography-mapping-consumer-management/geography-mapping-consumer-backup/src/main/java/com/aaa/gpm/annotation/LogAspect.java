package com.aaa.gpm.annotation;

import com.aaa.gpm.model.TLoginLog;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.SpringcloudGpmService;
import com.aaa.gpm.utils.AddressUtils;
import com.aaa.gpm.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.util.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;


import static com.aaa.gpm.staticproperties.TimeForatProperties.DATE_FORMAT;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 15:00
 * @Description: TODO
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    
    /**@DateTime: 2020/7/15 15:20
    * @Params: []
    * @Return void
    * 描述：
     *      定义切点信息
     *      这个时候就不能再按照常规的切点(service/controller)
     *      直接去切自定义的注解
     *      也就是说当检测自定义注解存在的时候，切面触发，也就是说AOP才会被触发
    */
    @Pointcut("@annotation(com.aaa.gpm.annotation.LoginAnnotation)")
    public void pointCut(){

    }
    /**@DateTime: 2020/7/15 15:22
    * @Params: [proceedingJoinPoint]
    * @Return java.lang.Object
    * 描述：   环形切面
     *         proceedingJoinPoint：封装了目标路径中的所用到的所有参数
    */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws ClassNotFoundException {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        /**
         * 获取Request对象
         */
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
        /**
         * 1.获取ip地址
         */
        String ipAddr = IPUtils.getIpAddr(request);
        /**
         * 2.获取地理位置
         */
        Map<String, Object> addressesMap = AddressUtils.getAddresses(ipAddr, "UTF-8");
        TLoginLog tLoginLog = new TLoginLog();
        tLoginLog.setIp(ipAddr).setLocation(addressesMap.get("province")+"|"+addressesMap.get("city")).setLoginTime(DateUtil.formatDate(new Date(),DATE_FORMAT));
        /**
         * 3.获取Username--->想要获取到username，必须要获取到目标方法的参数值
         */
        Object[] args = proceedingJoinPoint.getArgs();
        TUser tUser = (TUser) args[0];
        tLoginLog.setUsername(tUser.getUsername());
        /**
         * 4.获取操作的类型以及具体操作的内容(反射)
         * 4.1.获取目标类名(全限定名)
         */
        String tarClassName = proceedingJoinPoint.getTarget().getClass().getName();
        /**
         * 方法名
         */
        String tarMehtodName = proceedingJoinPoint.getSignature().getName();

        /**
         * 4.2.获取类对象
         */
        Class<?> tarClass = Class.forName(tarClassName);
        /**
         * 4.3.获取目标类中的所有方法
         */
        Method[] methods = tarClass.getMethods();

        String operationType = "";
        String operationName = "";

        for (Method method : methods){
            String methodName = method.getName();
            if (tarMehtodName.equals(methodName)){
                /**
                 *这个时候虽然已经确定了目标方法没有问题，但是有可能会出现方法的重载
                 * 还需要进一步判断
                 * 获取目标方法的参数
                 */
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == args.length){
                    operationType = method.getAnnotation(LoginAnnotation.class).opeationType();
                    operationName = method.getAnnotation(LoginAnnotation.class).opeationName();
                }
            }
        }
        tLoginLog.setOperationType(operationType);
        tLoginLog.setOperationName(operationName);

        springcloudGpmService.addLoginLog(tLoginLog);

        return result;
    }
}
