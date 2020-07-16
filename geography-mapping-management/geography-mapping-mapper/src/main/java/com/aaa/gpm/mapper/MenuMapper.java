package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TMenu;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/13
 */
public interface MenuMapper extends Mapper<TMenu> {

    /**
     * 一级菜单
     * @param id
     * @return
     */
    List<TMenu> selectFirstMenu(Long id);

    /**
     * 二级菜单
     * @param menuId
     * @return
     */
    @Select("select * from t_menu where PARENT_ID=#{menuId}")
    List<TMenu> selectSecondMenu(Long menuId);
}
