package com.aaa.yay.mapper;

import com.aaa.yay.model.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface DeptMapper extends Mapper<Dept> {

    List<Dept> selectDeptByNameOrTime(HashMap map);
}