package com.aaa.gpm.controller;

import com.aaa.gpm.model.TMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/13
 */
@RestController
public class MenuController {

    @Autowired
    com.zj.springcloud.mapper.service.SpringcloudGpmService springcloudGpmService;

    @GetMapping("/firstMenu")
    @ResponseBody
    public List<TMenu> firstMenu(Long id){
        return springcloudGpmService.firstMenu(id);
    }

}
