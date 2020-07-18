package com.aaa.yay.Controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Menu;
import com.aaa.yay.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yay
 * @Description MenuController
 * @CreatTime 2020年 07月17日 星期五 22:16:27
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends CommonController<Menu> {

    @Autowired
    private MenuService menuService;

    @Override
    public BaseService<Menu> getBaseService() {
        return menuService;
    }

    /**
     * 增加菜单
     * @param menu
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/17 22:27
     */
    @PostMapping("/addMenu")
    public ResultData addMenu(@RequestBody Menu menu) {
        Integer addResult = getBaseService().add(menu);
        return addResult > 0 ? operationSuccess("增加成功") : operationFailed("增加失败");
    }

    /**
     * 根据主键删除菜单
     * @param menu
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/17 22:41
     */
    @PostMapping("/delMenu")
    public ResultData delMenu(@RequestBody Menu menu) {
        Integer deleteResult = getBaseService().delete(menu);
        return deleteResult > 0 ? operationSuccess("删除成功") : operationFailed("删除失败");
    }

    /**
     * 根据主键批量删除菜单
     * @param ids
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/17 22:43
     */
    @Override
    @PostMapping("/batchDelete")
    public ResultData batchDelete(@RequestParam("ids") Integer[] ids) {
        return super.batchDelete(ids);
    }

    /**
    * 根据主键修改属性不为空的菜单
    * @author yay
    * @param menu
    * @updateTime 2020/07/17 23:11
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updateMenu")
    public ResultData updateMenu(@RequestBody Menu menu){
        Integer updateResult = getBaseService().update(menu);
        return updateResult > 0 ? operationSuccess("修改成功") : operationFailed("修改失败");
    }

    /**
    * 查询所有菜单
    * @author yay
    * @param
    * @updateTime 2020/07/18 11:35
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @GetMapping("/getMenus")
    public ResultData selectAllMenus(){
        List<Menu> menuList = menuService.selectAllMenus();
        return menuList.size() > 0 ? operationSuccess(menuList,"查询成功") : operationFailed("查询失败");
    }
}
