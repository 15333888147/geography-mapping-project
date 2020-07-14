package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.DeptMapper;
import com.aaa.gpm.model.TDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/14
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
        List<TDept> tDepts = super.selectList(null);
        if (null != tDepts && tDepts.size() > 0){
            for (int i = 0; i < tDepts.size(); i++) {
                TDept depts = tDepts.get(i);
                TDept dept = new TDept();
                dept.setParentId(depts.getDeptId());
                List<TDept> subDept = super.selectList(dept);
                depts.setSubDept(subDept);
                deptList.add(depts);
            }
        }
        return deptList;
    }
}
