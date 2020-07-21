package com.aaa.yay.service;

import cn.hutool.core.date.DateUtil;
import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.mapper.DeptMapper;
import com.aaa.yay.model.Dept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.yay.status.OperationStatus.*;

/**
 * @Author 十八
 * @Date 2020/7/18 10:46
 * @Version 1.0
 */
@Service
@Slf4j
public class DeptService extends BaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;


    /**
    * @Auther: czb
    * @Description:
     * 添加部门
    * @Date: 2020/7/18 11:15
    * @param [dept]
    * @return com.aaa.yay.base.ResultData
    */
    public ResultData addDept(Dept dept){
        ResultData resultData = new ResultData();
//        设置创建时间
        dept.setCreateTime(DateUtil.now());
        int addResult = deptMapper.insert(dept);
       return addResult > 0 ? resultData.setCode(ADD_SUCCESS.getCode()).setMsg(ADD_SUCCESS.getMsg())
               : resultData.setCode(ADD_FAILED.getCode()).setMsg(ADD_FAILED.getMsg());

    }

    /**
    * @Auther: czb
    * @Description:
     * 根据主键批量删除
    * @Date: 2020/7/18 11:28
    * @param [ids]
    * @return com.aaa.yay.base.ResultData
    */
        public ResultData delDept(List<Long> ids){
             ResultData resultData = new ResultData();
             Example example = Example.builder(Dept.class).where(Sqls.custom().andIn("deptId",ids)).build();
             int  delResult= deptMapper.deleteByExample(example);
            return delResult > 0 ? resultData.setCode(DEL_SUCCESS.getCode()).setMsg(DEL_SUCCESS.getMsg())
                    : resultData.setCode(DEL_FAILED.getCode()).setMsg(DEL_FAILED.getMsg());

    }

        /**
        * @Auther: czb
        * @Description:
         * 修改部门信息
        * @Date: 2020/7/18 11:49
        * @param [dept]
        * @return com.aaa.yay.base.ResultData
        */
        public ResultData updateDept(Dept dept){
            ResultData resultData = new ResultData();
//            设置修改时间
            dept.setModifyTime(DateUtil.now());
            Dept dept1 = deptMapper.selectByPrimaryKey(dept);
            if(dept1 != null){
                //判断是否为空  获取创建时间，创建件时间不会变)  并设置为参数
                String createTime = dept1.getCreateTime();
                dept.setCreateTime(createTime);
            }
            int updateResult = deptMapper.updateByPrimaryKey(dept);
            return updateResult > 0 ? resultData.setCode(UPDATE_SUCCESS.getCode()).setMsg(UPDATE_SUCCESS.getMsg())
                    : resultData.setCode(UPDATE_FAILED.getCode()).setMsg(UPDATE_FAILED.getMsg());
        }


        /**
        * @Auther: czb
        * @Description:
         * 根据条件查询部门信息
        * @Date: 2020/7/18 15:29
        * @param [hashMap]
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
    public Map<String,Object> selectAllDept(HashMap hashMap){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //根据条件查询部门
        List<Dept> depts = deptMapper.selectDeptByNameOrTime(hashMap);
        //判断查询出来的信息是否为空
        if(depts.size()>0 && depts !=null){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",depts);
        }else{
            resultMap.put("code", SELECT_DATA_FAILED.getCode());
            resultMap.put("msg", SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
}
