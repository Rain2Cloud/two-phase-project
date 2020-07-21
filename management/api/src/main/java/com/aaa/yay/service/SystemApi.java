package com.aaa.yay.service;

import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.*;
import com.aaa.yay.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @Author yay
 * @Description feignAPI
 *      在开发阶段不能开启熔断，因为一旦开启熔断，异常会被捕捉，不容易发现问题
 *      api接口一定要和provider的controller一模一样
 * @CreatTime 2020年 07月15日 星期三 16:54:39
 */
@FeignClient(value = "system-interface")
public interface SystemApi {

    /**
     * 执行登录操作
     *
     * @param user
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/15 19:40
     */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
     * 新增日志
     *
     * @param loginLog
     * @return java.lang.Integer
     * @throws
     * @author yay
     * @updateTime 2020/07/15 19:44
     */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);


    //--------------------------Role-----------------------------

    /**
     * 新增角色
     *
     * @param roleVo
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/17 10:39
     */
    @PostMapping("/role/addRole")
    ResultData addRole(@RequestBody RoleVo roleVo);

    /**
     * 删除角色
     *
     * @param roleId
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/17 10:45
     */
    @PostMapping("/role/delRole")
    ResultData deleteRole(@RequestParam("roleId") Long roleId);

    /**
     * 修改角色及其权限
     *
     * @param roleVo
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/17 10:41
     */
    @PostMapping("/role/updateRole")
    ResultData updateRole(@RequestBody RoleVo roleVo);

    /**
     * 分页查询所有角色
     *
     * @param pageNo pageSize
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/17 10:46
     */
    @PostMapping("/role/selectAll")
    ResultData selectAllRoles(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);


    //User(用户管理)

    /**
     * @param [user]
     * @return com.aaa.czb.base.ResultData
     * @Auther: czb
     * @Description: 查询全部
     * @Date: 2020/7/16 9:17
     */
    @PostMapping("user/selectUser")
    ResultData selectAll(User user);


    /**
     * @param [user]
     * @return com.aaa.czb.base.ResultData
     * @Auther: czb
     * @Description: 批量删除用户
     * @Date: 2020/7/16 9:32
     */
    @DeleteMapping("user/delUser")
    ResultData delUser(@RequestBody List<Long> ids);


    /**
     * @param [user]
     * @return com.aaa.czb.base.ResultData
     * @Auther: czb
     * @Description: 增加用户
     * @Date: 2020/7/16 9:32
     */
    @PostMapping("user/addUser")
    ResultData addUser(@RequestBody User user);

    /**
     * @param [user]
     * @return com.aaa.czb.base.ResultData
     * @Auther: czb
     * @Description: 修改用户信息
     * @Date: 2020/7/16 9:34
     */
    @PostMapping("user/updateUser")
    ResultData updateUser(@RequestBody User user);

//    /**
//     * @param [map]
//     * @return com.aaa.czb.base.ResultData
//     * @Auther: czb
//     * @Description: 条件分页查询全部用户
//     * @Date: 2020/7/16 23:28
//     */
//
//    @PostMapping("user/selectAllUserPage")
//    ResultData selectAllUserPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

        /**
        * @Auther: czb
        * @Description:分页查询所有用户
        * @Date: 2020/7/20 20:19
        * @param [map]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/user/selectUserAll")
    ResultData selectUserAll(@RequestBody HashMap map);


//   Dict(字典信息管理)

    /**
     * @Description: 分页查询字典信息
     * @Param: [hashMap]
     * @Author: czb
     * @Return: com.aaa.qy108.base.ResultData
     * @Date: 2020/7/17 18:08
     **/
    @PostMapping("dict/selectAllDictByPage")
    ResultData selectAllDictByPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 新增字典信息
     * @Param: [dict]
     * @Author: czb
     * @Return: com.aaa.qy108.base.ResultData
     * @Date: 2020/7/17 18:12
     **/
    @PostMapping("dict/addDict")
    ResultData addDict(@RequestBody Dict dict);

    /**
     * @Description: 批量删除字典信息
     * @Param: [ids]
     * @Author: czb
     * @Return: com.aaa.qy108.base.ResultData
     * @Date: 2020/7/17 18:12
     **/
    @DeleteMapping("/dict/delDictsById")
    ResultData delDictsById(@RequestBody List<Long> ids);

    /**
     * @Description: 修改字典信息
     * @Param: [dict]
     * @Author: czb
     * @Return: com.aaa.qy108.base.ResultData
     * @Date: 2020/7/17 18:12
     **/
    @PostMapping("dict/updateDict")
    ResultData updateDict(@RequestBody Dict dict);


    //------------------------------Menu------------------------------

    /**
     * 增加菜单
     *
     * @param menu
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/18 14:25
     */
    @PostMapping("/menu/addMenu")
    ResultData addMenu(@RequestBody Menu menu);

    /**
     * 根据主键删除菜单
     *
     * @param menu
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/18 14:28
     */
    @PostMapping("/menu/delMenu")
    ResultData delMenu(@RequestBody Menu menu);

    /**
     * 根据主键批量删除菜单
     *
     * @param ids
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/18 14:28
     */
    @PostMapping("/menu/batchDelete")
    ResultData batchDelete(@RequestParam("ids") Integer[] ids);

    /**
     * 根据主键修改属性不为空的菜单
     *
     * @param menu
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/18 14:29
     */
    @PostMapping("/menu/updateMenu")
    ResultData updateMenu(@RequestBody Menu menu);

    /**
     * 查询所有菜单
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/18 14:29
     */
    @GetMapping("/menu/getMenus")
    ResultData selectAllMenus();

    //部门管理

    /**
     * @Param: [dept]
     * @Return: com.aaa.qy108.base.ResultData
     * 通过条件查询部门信息
     * @Author: czb
     * @Date: 2020/7/18 19:41
     */
    @PostMapping("dept/selectAllDept")
    ResultData selectAllDept(@RequestBody HashMap map);

    /**
     * @Param: [dept]
     * @Return: com.aaa.qy108.base.ResultData
     * 添加部门信息
     * @Author: czb
     * @Date: 2020/7/18 19:50
     */
    @PostMapping("dept/addDept")
    ResultData addDept(@RequestBody Dept dept);

    /**
     * @Param: [dept]
     * @Return: com.aaa.qy108.base.ResultData
     * 修改部门信息
     * @Author: czb
     * @Date: 2020/7/18 20:11
     */
    @PostMapping("dept/updateDept")
    ResultData updateDept(@RequestBody Dept dept);

    /**
     * @Param: [ids]
     * @Return: com.aaa.qy108.base.ResultData
     * 批量删除部门信息
     * @Author: czb
     * @Date: 2020/5/22 15:12
     */
    @DeleteMapping("dept/delDept")
    ResultData delDept(@RequestBody List<Long> ids);
}

