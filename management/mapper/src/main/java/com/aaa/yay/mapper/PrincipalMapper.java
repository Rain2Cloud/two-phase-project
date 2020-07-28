package com.aaa.yay.mapper;

import com.aaa.yay.model.Principal;
import tk.mybatis.mapper.common.Mapper;

/**
 * 测绘单位负责人的通用mapper
 * @author 十八
 */
public interface PrincipalMapper extends Mapper<Principal> {
    
    
    /** 
    * @Description: 查询单个负责人的信息
    * @Author: guohang
    * @Date: 2020/7/23 21:36
    * @Param: [id] 
    * @return: com.aaa.qy108.model.Principal 
    */ 
    Principal selectPrincipalById(String id);



}