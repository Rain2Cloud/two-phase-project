package com.aaa.yay.service;

import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.LoginLog;
import com.aaa.yay.model.User;
import com.aaa.yay.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
}
