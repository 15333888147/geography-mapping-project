package com.aaa.gpm.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.util.Sqls;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.gpm.status.OperationStatus.SUCCESS;

/**
 * @Author: zj
 * @Date: 2020/7/8
 */
public abstract class CommonController<T> extends BaseController {

    public abstract  BaseService<T> getBaseService();

    /**
     * 钩子函数
     *  在新增之前去执行某些操作
     *
     *  eg：
     *      下单操作:
     *          需求
     *              在购物车中当点击立即下单按钮的时候--->跳转下单页面(选择地址，选择优惠券...)
     *              把购物车中的这个商品删除
     *              deleteCart(List<Integer> id);--->是优先于insertOrder前置执行
     *
     *          insertOrder(Order oder);
     * @param map
     */
    protected void beforeAdd(Map map){

    }

    /**
     * 钩子函数
     *  是在新增之后执行
     *
     *  eg：
     *      int result = insertOrder(Order order)
     *      if(result > 0) {
     *          insertOrderDetail(OrderDetail orderDetail);
     *      }
     *
     * @param map
     */
    protected void afterAdd(Map map){

    }

    /**
     * 通用新增方法
     *  目前公司使用的全是异步 ， 所传递数据是json格式
     *  之前在controller的方法中接收固定的实体类 ， 是因为你知道前端给你传递的是哪个实体类
     *  但是通用，前端所传递的类型就不会固定 ---> 所以使用Map类型来统一接收
     * @param map
     * @return
     */
    public ResultData add(@RequestBody Map map){
        //根据封装规则，在service中是需要传递泛型的，就意味着service需要接收固定的实体类，但controller是一个Map类型
        beforeAdd(map);
        //Map转实体类
        T instance = getBaseService().newInstance(map);
        //通用service
        Integer addResult = getBaseService().add(instance);
        if (addResult > 0){
            afterAdd(map);
            return super.addSuccess();
        }
        return super.addFailed();
    }

    /**
     * 删除操作
     * @param map
     * @return
     */
    public ResultData delete(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer deleteResult = getBaseService().delete(instance);
        if (deleteResult > 0){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public ResultData batchDelete(@RequestParam("ids[]") Integer[] ids){
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if (deleteResult > 0){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
    }

    /**
     * 更新操作
     * @param map
     * @return
     */
    public ResultData update(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer updateResult = getBaseService().update(instance);
        if (updateResult > 0 ){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }

    /**
     * 批量更新
     * @param map
     * @param ids
     * @return
     */
    public ResultData batchUpdate(@RequestBody Map map,@RequestParam("ids[]") Integer[] ids){
       T instance = getBaseService().newInstance(map);
        Integer updateResult = getBaseService().batchUpdate(instance, ids);
        if (updateResult > 0 ){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }

    /**
     * 查询一条数据
     * @param map
     * @return
     */
    public ResultData selectOne(@RequestBody Map map){
        ResultData resultData = new ResultData();
        T instance = getBaseService().newInstance(map);
        T selectResult = getBaseService().selectOne(instance);
        if (null != selectResult){
            return super.operationSuccess(selectResult);
        }
        return super.operationFailed();
    }

    /**
     * 查询数据列表
     * @param map
     * @return
     */
    public ResultData selectList(@RequestBody Map map){
        ResultData resultData = new ResultData();
        T instance = getBaseService().newInstance(map);
        List<T> selectList = getBaseService().selectList(instance);
        if (null != selectList){
            return super.operationSuccess(selectList,"查询数据列表成功!");
        }
        return super.operationFailed("查询数据列表失败!");
    }

    /**
     * 不带条件分页查询
     * @param map
     * @return
     */
    public ResultData selectListByPage(@RequestBody Map map){
        Integer pageNo = (Integer) map.get("pageNo");
        Integer pageSize = (Integer) map.get("pageSize");
        Object t = map.get("t");
        PageInfo<T> tPageInfo = getBaseService().selectListByPage((T) t, pageNo, pageSize);
        if (null != tPageInfo){
            return super.operationSuccess(tPageInfo,"分页查询数据列表成功!");
        }
        return super.operationFailed("分页查询数据列表失败!");
    }




}
