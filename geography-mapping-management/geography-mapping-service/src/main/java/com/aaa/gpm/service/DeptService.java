package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.DeptMapper;
import com.aaa.gpm.model.TDept;
import com.aaa.gpm.model.TMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/14
 * 部门管理
 */
@Service
public class DeptService extends BaseService<TDept> {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有的一级部门以及其下面的子部门
     * @return
     */
    public List<TDept> deptList() {
        List<TDept> deptList = new ArrayList<TDept>();
        TDept deptId = new TDept();
        deptId.setParentId(0L);
        //获取所有的一级部门
        List<TDept> tDepts = super.selectList(deptId);
        if (null != tDepts && tDepts.size() > 0){
            for (int i = 0; i < tDepts.size(); i++) {
                //获取当前一级部门
                TDept depts = tDepts.get(i);
                TDept dept = new TDept();
                dept.setParentId(depts.getDeptId());
                //获取当前一级部门中所有的子部门
                List<TDept> subDept = super.selectList(dept);
                depts.setSubDept(subDept);
                deptList.add(depts);
            }
        }
        return deptList;
    }

    /**
     * 批量删除部门信息
     * @param ids
     * @return
     */
    public Integer delDeptAlls(List<Long> ids){
        Example example = Example.builder(TDept.class).where(Sqls.custom().andIn("deptId",ids)).build();
        return deptMapper.deleteByExample(example);
    }

    /**
     * 导出部门信息Excel表格
     * @return
     */
    public List<TDept> exportDeptExcel(){
        List<TDept> depts = deptMapper.selectAll();
        if (null != depts && depts.size() >0){
            return depts;
        }
        return null;
    }
}
