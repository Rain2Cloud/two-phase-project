package com.aaa.yay.mapper;

import com.aaa.yay.model.ResultCommit;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author 十八
 */
public interface ResultCommitMapper extends Mapper<ResultCommit> {


    /**
     * @Description: 根据传过来的条件查询测绘成果
     * @Param: [hashMap]
     * @return: java.util.List<java.util.HashMap>
     * @Author: czb
     * @Date: 2020/7/21 19:11
     */
   List<HashMap> selcetResultByFeild(HashMap hashMap);

    /**
     * @Description: 如果没有传过来查询条件，证明是查询所有的测绘成果
     * @Param: []
     * @return: java.util.List<java.util.HashMap>
     * @Author: czb
     * @Date: 2020/7/21 19:17
     */
  List<HashMap> selectAllResult();

    /**
     * @Description: 查询数据中所有的测绘类型，可以让前台进行选择查询
     * @Param: []
     * @return: java.util.List<java.util.HashMap>
     * @Author: czb
     * @Date: 2020/7/21 19:18
     */
   List<HashMap> SelectProjectType();

    /**
     * @Description: 查询出成果的详细信息
     * @Param: []
     * @return: java.util.HashMap<java.lang.String,java.lang.Object>
     * @Author: czb
     * @Date: 2020/7/21 19:24
     */
    List<HashMap> resultDetail(String id);
}