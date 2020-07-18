package com.aaa.yay.controller;

import com.aaa.yay.base.BaseController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.User;
import com.aaa.yay.service.SystemApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author 十八
 * @Date 2020/7/16 22:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private SystemApi systemApi;

    /**
    * @Auther:czb
    * @Description:
     * 新增用户
    * @Date: 2020/7/16 23:13
    * @param [user]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
    @PostMapping("/addUser")
    public ResultData addUser(User user){
               return  systemApi.addUser(user);
    }


    /**
    * @Auther: czb
    * @Description:
     * 删除用户
    * @Date: 2020/7/16 23:22
    * @param [ids]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
    @DeleteMapping("/delUser")
    public ResultData delUser(@RequestBody List<Long> ids){
        return systemApi.delUser(ids);
    }


    /**
    * @Auther: czb
    * @Description:
     * 修改用户信息
    * @Date: 2020/7/17 22:24
    * @param [user]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestBody User user){
        return systemApi.updateUser(user);
    }



    /**
     * @Description: 查询全部用户
     * @Author: czb
     * @Date: 2020/7/17 22:54
     * @Param:
     * @return: com.aaa.qy108.base.ResultData
     */
    @PostMapping("selectAll")
    public ResultData selectAll(User user){
        return systemApi.selectAll(user);
    }


        /**
        * @Auther: czb
        * @Description:
         * 查询全部用户(分页)
        * @Date: 2020/7/17 14:49
        * @param [pageNo, pageSize]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/selectAllUserPage")
    public ResultData selectAllUserPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return systemApi.selectAllUserPage(pageNo, pageSize);
    }
}
