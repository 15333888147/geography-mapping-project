package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.ProjectMapper;
import com.aaa.gpm.model.TMappingProject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gcy
 * @DateTime: 2020/7/14 15:00
 * @Description: TODO
 */
@Service
public class ProjectService  extends BaseService<TMappingProject> {
    @Autowired
    private ProjectMapper projectMapper;
    /**@DateTime: 2020/7/15 22:13
    * @Params: [id]
    * @Return com.aaa.gpm.model.TMappingProject
    * 描述：
     *      通过Id查询对象
    */
    public TMappingProject selectById(Long id){
        TMappingProject tMappingProject = new TMappingProject();
        tMappingProject.setId(id);
        List<TMappingProject> tMappingProjects = super.selectList(tMappingProject);
        if (null != tMappingProjects && !"".equals(tMappingProjects)){
            return tMappingProjects.get(0);
        }
        return null;
    }
    /**@DateTime: 2020/7/14 15:04
    * @Params: [pageNo, pageSize]
    * @Return com.github.pagehelper.PageInfo
    * 描述： 分页查询所有项目
    */
    public PageInfo allProjects(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<TMappingProject> tMappingProjects = projectMapper.selectAll();
        PageInfo pageInfo = new PageInfo(tMappingProjects);
        if (null != pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }
    /**@DateTime: 2020/7/14 19:46
    * @Params: [name]
    * @Return com.aaa.gpm.model.TMappingProject
    * 描述：根据名字查询项目
    */
    public TMappingProject selectProjectByName(String name){
        TMappingProject tMappingProject = new TMappingProject();
        tMappingProject.setProjectName(name);
        TMappingProject project = super.selectOne(tMappingProject);
        if (null != project && !"".equals(project)){
            return project;
        }
        return null;
    }
    /**@DateTime: 2020/7/16 9:29
    * @Params: []
    * @Return java.util.List<com.aaa.gpm.model.TMappingProject>
    * 描述：
     *      查询没有通过审核的项目
    */
    public List<TMappingProject> selectNotAduitPass(){
        List<TMappingProject> tMappingProjects = projectMapper.selectNotAduitPass();
        if (tMappingProjects != null && tMappingProjects.size()>0){
            return tMappingProjects;
        }
        return null;
    }
}
