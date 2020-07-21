package com.aaa.yay.controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Role;
import com.aaa.yay.service.RoleService;
import com.aaa.yay.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yay
 * @Description Role
 * @CreatTime 2020年 07月16日 星期四 16:52:34
 */
@RestController
@RequestMapping("/role")
public class RoleController extends CommonController<Role> {

    @Autowired
    private RoleService roleService;
    @Override
    public BaseService<Role> getBaseService() {
        return roleService;
    }

    /**
    * 新增角色
    * @author yay
    * @param roleVo
    * @updateTime 2020/07/16 20:15
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addRole")
    public ResultData addRole(@RequestBody RoleVo roleVo){
        Boolean aBoolean = roleService.addRole(roleVo);
        return aBoolean ? operationSuccess("新增成功") : operationFailed("新增失败");
    }

    /**
    * 删除角色
    * @author yay
    * @param roleId
    * @updateTime 2020/07/16 22:19
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("delRole")
    public ResultData deleteRole(@RequestParam("roleId") Long roleId){
        Boolean aBoolean = roleService.deleteRole(roleId);
        return aBoolean ? operationSuccess("删除成功") : operationFailed("删除失败");
    }

    /**
    * 修改角色及其权限
    * @author yay
    * @param roleVo
    * @updateTime 2020/07/16 23:28
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleVo roleVo){
        Boolean aBoolean = roleService.updateRole(roleVo);
        return aBoolean ? operationSuccess("修改成功") : operationFailed("修改失败");
    }

    /**
    * 分页查询所有角色
    * @author yay
    * @param
    * @updateTime 2020/07/16 23:30
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAll")
    public ResultData selectAllRoles(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        List<Role> roleList = getBaseService().selectByFileds(pageNo, pageSize, null, null, null, (String[]) null);
        return roleList.size() > 0 ? operationSuccess("查询成功") : operationFailed("查询失败");
    }
}
