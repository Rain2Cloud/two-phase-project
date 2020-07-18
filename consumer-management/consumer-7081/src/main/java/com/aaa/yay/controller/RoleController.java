package com.aaa.yay.controller;

import com.aaa.yay.base.ResultData;
import com.aaa.yay.service.SystemApi;
import com.aaa.yay.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yay
 * @Description TODO
 * @CreatTime 2020年 07月17日 星期五 16:54:15
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private SystemApi systemApi;

    /**
    * 新增角色
    * @author yay
    * @param roleVo
    * @updateTime 2020/07/17 17:15
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addRole")
    public ResultData addRole(@RequestBody RoleVo roleVo) {
        return systemApi.addRole(roleVo);
    }

    /**
    * 删除角色
    * @author yay
    * @param roleId
    * @updateTime 2020/07/17 17:17
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("delRole")
    public ResultData deleteRole(@RequestParam("roleId") Long roleId){
        return systemApi.deleteRole(roleId);
    }

    /**
    * 修改角色及其权限
    * @author yay
    * @param roleVo
    * @updateTime 2020/07/17 17:18
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleVo roleVo){
        return systemApi.updateRole(roleVo);
    }

    /**
    * 分页查询所有角色
    * @author yay
    * @param pageNo pageSize
    * @updateTime 2020/07/17 17:19
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAll")
    public ResultData selectAllRoles(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return systemApi.selectAllRoles(pageNo,pageSize);
    }
}
