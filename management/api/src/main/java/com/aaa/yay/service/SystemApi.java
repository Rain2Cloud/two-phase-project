package com.aaa.yay.service;

import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Dict;
import com.aaa.yay.model.LoginLog;
import com.aaa.yay.model.User;
import com.aaa.yay.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    * @author yay
    * @param user
    * @updateTime 2020/07/15 19:40
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
    * 新增日志
    * @author yay
    * @param loginLog
    * @updateTime 2020/07/15 19:44
    * @throws
    * @return java.lang.Integer
    */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);





    /**
    * 新增角色
    * @author yay
    * @param roleVo
    * @updateTime 2020/07/17 10:39
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/role/addRole")
    ResultData addRole(@RequestBody RoleVo roleVo);

    /**
    * 删除角色
    * @author yay
    * @param roleId
    * @updateTime 2020/07/17 10:45
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/role/delRole")
    ResultData deleteRole(@RequestParam("roleId") Long roleId);

    /**
    * 修改角色及其权限
    * @author yay
    * @param roleVo
    * @updateTime 2020/07/17 10:41
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/role/updateRole")
    ResultData updateRole(@RequestBody RoleVo roleVo);

    /**
    * 分页查询所有角色
    * @author yay
    * @param pageNo pageSize
    * @updateTime 2020/07/17 10:46
    * @throws
    * @return com.aaa.yay.base.ResultData
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
    @PostMapping("/selectUser")
    ResultData selectAll(User user);


    /**
     * @param [user]
     * @return com.aaa.czb.base.ResultData
     * @Auther: czb
     * @Description: 物理删除
     * @Date: 2020/7/16 9:32
     */
    @DeleteMapping("/delUser")
    ResultData delUser(@RequestBody List<Long> ids);


    /**
     * @param [user]
     * @return com.aaa.czb.base.ResultData
     * @Auther: czb
     * @Description: 增加用户
     * @Date: 2020/7/16 9:32
     */
    @PostMapping("/addUser")
    ResultData addUser(@RequestBody User user);

    /**
     * @param [user]
     * @return com.aaa.czb.base.ResultData
     * @Auther: czb
     * @Description: 修改用户信息
     * @Date: 2020/7/16 9:34
     */
    @PostMapping("/updateUser")
    ResultData updateUser(@RequestBody User user);

    /**
     * @param [map]
     * @return com.aaa.czb.base.ResultData
     * @Auther: czb
     * @Description: 条件分页查询全部用户
     * @Date: 2020/7/16 23:28
     */

    @PostMapping("/selectAllUserPage")
    ResultData selectAllUserPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);


//   Dict(字典信息管理)
    /**
     * @Description: 分页查询字典信息
     * @Param: [hashMap]
     * @Author: czb
     * @Return: com.aaa.qy108.base.ResultData
     * @Date: 2020/7/17 18:08
     **/
    @PostMapping("/selectAllDictByPage")
    ResultData selectAllDictByPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 新增字典信息
     * @Param: [dict]
     * @Author: czb
     * @Return: com.aaa.qy108.base.ResultData
     * @Date: 2020/7/17 18:12
     **/
    @PostMapping("/addDict")
    ResultData addDict(@RequestBody Dict dict);

    /**
     * @Description: 批量删除字典信息
     * @Param: [ids]
     * @Author: czb
     * @Return: com.aaa.qy108.base.ResultData
     * @Date: 2020/7/17 18:12
     **/
    @DeleteMapping("/delDictsById")
    ResultData delDictsById(@RequestBody List<Long> ids);

    /**
     * @Description: 修改字典信息
     * @Param: [dict]
     * @Author: czb
     * @Return: com.aaa.qy108.base.ResultData
     * @Date: 2020/7/17 18:12
     **/
    @PostMapping("/updateDict")
    ResultData updateDict(@RequestBody Dict dict);







}

