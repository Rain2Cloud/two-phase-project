package com.aaa.yay.mapper;

import com.aaa.yay.model.MappingUnit;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
* @Description:  测绘单位查询
* @Author:czb
* @Date: 2020/7/22
*/
public interface MappingUnitMapper extends Mapper<MappingUnit> {
    /**
     * @Description: 测绘单位查询，单位名称模糊查询，单位地域和单位资质准确查询
     * @Param: [hashMap]
     * @return: java.util.List<java.util.HashMap>
     * @Author:czb
     * @Date: 2020/7/22
     */
    List<HashMap> selcetUnit(MappingUnit mappingUnit);
    /**
    * @Description: 查询所有的测绘单位，但是只返回单位名称和id
    * @Param: []
    * @return: java.util.List<java.util.HashMap>
    * @Author:czb
    * @Date: 2020/7/22
    */
     List<HashMap> selectAllUnit();
    /**
    * @Description: 通过字段查询所有的区域和资质，进行分组
    * @Param: []
    * @return: java.util.List<java.util.HashMap>
    * @Author:czb
    * @Date: 2020/5/23
    */
     List<HashMap> selectGroupByFeild(String feild);
    
    /**
    * @Description: 通过id查询详细地单位信息
    * @Param: [id]
    * @return: java.util.List<java.util.HashMap>
    * @Author:czb
    * @Date: 2020/5/30
    */
    List<HashMap> unitDetail(String id);




}