package com.aaa.gpm.vo;

import com.aaa.gpm.model.TRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoleMenuVo implements Serializable {

    private List<Long> menuId;

    private TRole role;

}
