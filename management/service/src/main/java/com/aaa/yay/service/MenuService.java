package com.aaa.yay.service;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.model.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yay
 * @Description MenuService
 * @CreatTime 2020年 07月17日 星期五 22:13:49
 */
@Service
public class MenuService extends BaseService<Menu> {

    /**
    * 获取全部菜单信息
    * @author yay
    * @param
    * @updateTime 2020/07/18 11:24
    * @throws
    * @return java.util.List<com.aaa.yay.model.Menu>
    */
    public List<Menu> selectAllMenus(){
        // 菜单树
        List<Menu> menuList = new ArrayList<>();
        // 全部菜单信息
        List<Menu> allMenuList = getMapper().selectAll();
        // 判断得到的菜单信息是否为空
        if (null != allMenuList && 0 < allMenuList.size()){
            for (Menu menu: allMenuList) {
                if (menu.getParentId() == 0){
                    // 说明是一级菜单
                    menuList.add(menu);
                }
            }
            //获取一级菜单的子菜单
            for (Menu menu: menuList) {
                menu.setSubMenu(getSubMenu(menu.getMenuId(),allMenuList));
            }
        }
        return menuList.size() > 0 ? menuList : null;
    }

    /**
    * 获取上一级菜单的子菜单
    * @author yay
    * @param menuId allMenus
    * @updateTime 2020/07/18 11:04
    * @throws
    * @return java.util.List<com.aaa.yay.model.Menu>
    */
    private List<Menu> getSubMenu(Long menuId, @org.jetbrains.annotations.NotNull List<Menu> allMenus){

        // 子菜单(二级菜单)List
        List<Menu> subMenus = new ArrayList<>();
        // 循环遍历菜单
        for (Menu menu:allMenus) {
            // 判断 如果遍历出来的菜单的parentId和menuId相同,说明遍历出来的menu是当前菜单的子菜单
            if (menu.getParentId().equals(menuId)){
                // 添加进子菜单List
                subMenus.add(menu);
            }
        }
        // 循环遍历三级菜单 当递归进入，查找子菜单的子菜单，子菜单的数据在下面循环代码中的subMenus中
        for (Menu menu:subMenus) {
            menu.setSubMenu(getSubMenu(menu.getMenuId(),allMenus));
        }
        return subMenus.size() > 0 ? subMenus : null;
    }
}
