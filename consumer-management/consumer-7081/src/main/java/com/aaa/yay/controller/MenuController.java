package com.aaa.yay.controller;

import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Menu;
import com.aaa.yay.service.SystemApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yay
 * @Description MenuController
 * @CreatTime 2020年 07月18日 星期六 14:42:32
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private SystemApi systemApi;

    /**
    * 增加菜单
    * @author yay
    * @param menu
    * @updateTime 2020/07/18 14:45
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/menu/addMenu")
    public ResultData addMenu(@RequestBody Menu menu){
        return systemApi.addMenu(menu);
    }

    /**
    * 根据主键删除菜单
    * @author yay
    * @param menu
    * @updateTime 2020/07/18 14:46
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/delMenu")
    public ResultData delMenu(@RequestBody Menu menu){
        return systemApi.delMenu(menu);
    }

    /**
    * 根据主键批量删除菜单
    * @author yay
    * @param ids
    * @updateTime 2020/07/18 14:47
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/batchDelete")
    public ResultData batchDelete(@RequestParam("ids") Integer[] ids){
        return systemApi.batchDelete(ids);
    }

    /**
    * 根据主键修改属性不为空的菜单
    * @author yay
    * @param menu
    * @updateTime 2020/07/18 14:49
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updateMenu")
    public ResultData updateMenu(@RequestBody Menu menu){
        return systemApi.updateMenu(menu);
    }

    /**
    * 查询所有菜单
    * @author yay
    * @param
    * @updateTime 2020/07/18 14:49
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @GetMapping("/getMenus")
    public ResultData selectAllMenus(){
        return systemApi.selectAllMenus();
    }
}
