package com.aaa.yay.service;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.mapper.UserMapper;
import com.aaa.yay.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

import static com.aaa.yay.status.OperationStatus.*;

/**
 * @Author 十八
 * @Date 2020/7/16 15:09
 * @Version 1.0
 */
@Service
@Slf4j
public class UserService extends BaseService<User> {

    @Autowired
    private UserMapper userMapper;



    /**
    * @Auther: yay
    * @Description:
     * 新增用户
    * @Date: 2020/7/16 15:53
    * @param [user]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
    public ResultData addUser(User user){
       ResultData resultData = new ResultData();
       int addResult = userMapper.insert(user);
       if (addResult >0){
           return resultData.setCode(ADD_SUCCESS.getCode()).setMsg(ADD_SUCCESS.getMsg());
       }
       return resultData.setCode(ADD_FAILED.getCode()).setMsg(ADD_FAILED.getMsg());
    }

    /**
    * @Auther: yay
    * @Description:
     * 批量删除用户(没有用通用的baseService)
    * @Date: 2020/7/16 17:00
    * @param [ids]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
    public ResultData delUser(List<Long> ids){
        ResultData resultData = new ResultData();
        Example example= Example.builder(User.class).where(Sqls.custom().andIn("id",ids)).build();
        int i = userMapper.deleteByExample(example);
        if (i >0){
           return resultData.setCode(DEL_SUCCESS.getCode()).setMsg(DEL_SUCCESS.getMsg());
        }
        return resultData.setCode(DEL_FAILED.getCode()).setMsg(DEL_FAILED.getMsg());
    }

        /**
        * @Auther: yay
        * @Description:
         *修改用户信息
        * @Date: 2020/7/16 17:35
        * @param [user]
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
    public ResultData updateUser(User user){
        ResultData resultData = new ResultData();
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i > 0){
         return    resultData.setCode(UPDATE_SUCCESS.getCode()).setMsg(UPDATE_SUCCESS.getMsg());
        }
        return resultData.setCode(UPDATE_FAILED.getCode()).setMsg(UPDATE_FAILED.getMsg());
    }

        /**
        * @Auther: yay
        * @Description:
         *查询全部用户
        * @Date: 2020/7/16 18:15
        * @param []
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
    public ResultData selectAll(User user){
       ResultData resultData = new ResultData();
        List<User> users = userMapper.selectAll();
        if (null != users && !users.isEmpty()){
        return  resultData.setCode(SELECT_DATA_SUCCESS.getCode()).setMsg(SELECT_DATA_SUCCESS.getMsg()).setData(users);
             }
                return resultData.setCode(SELECT_DATA_FAILED.getCode()).setMsg(SELECT_DATA_FAILED.getMsg());

    }




}








