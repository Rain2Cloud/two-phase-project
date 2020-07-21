package com.aaa.yay.mapper;

import com.aaa.yay.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author 十八
 */
public interface UserMapper extends Mapper<User> {

    /**
     * @param map
     * 条件分页查询所有用户
     * @return
     */
    List<HashMap> selectUserAll(HashMap map);

}