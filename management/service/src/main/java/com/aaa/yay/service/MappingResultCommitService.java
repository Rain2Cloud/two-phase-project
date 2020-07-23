package com.aaa.yay.service;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.mapper.ResultCommitMapper;
import com.aaa.yay.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.yay.status.OperationStatus.*;

/**
 * @Author 十八
 * @Date 2020/7/21 17:11
 * @Version 1.0
 */
@Service
public class MappingResultCommitService extends BaseService<ResultCommit> {

    @Autowired
    private ResultCommitMapper resultCommitMapper;


        /**
        * @Auther: czb
        * @Description:
         * 据传过来的条件去查询需要测绘成果
        * @Date: 2020/7/21 19:12
        * @param [hashMap]
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
    public Map<String, Object> selcetAllResult(HashMap hashMap){

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<HashMap> restdata = new ArrayList<HashMap>();
        System.out.println(hashMap.size());
        if (hashMap.size()>0){
            restdata= resultCommitMapper.selcetResultByFeild(hashMap);
        }else {
            restdata = resultCommitMapper.selectAllResult();
        }
        if (restdata.size()>0){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",restdata);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }


        /**
        * @Auther: czb
        * @Description:
         *  查询数据中所有的测绘类型，可以让前台进行选择查询
        * @Date: 2020/7/21 19:13
        * @param []
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
    public Map<String, Object> SelectProjectType(){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<HashMap> restdata= resultCommitMapper.SelectProjectType();
         if (restdata.size()>0){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",restdata);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }



    /**
     * @Description: 查询出成果的详细信息
     * @Param: [mappingUnit]
     * @return: java.util.HashMap<java.lang.String,java.lang.Object>
     * @Author: czb
     * @Date: 2020/7/21 19:20
     */
    public HashMap<String,Object> resultDetail(String id) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        if (null != id && !("").equals(id)) {
            List<HashMap> restdata = resultCommitMapper.resultDetail(id);
            if ( restdata.size() ==1) {
                resultMap.put("code", SELECT_DATA_BY_ID_SUCCESS.getCode());
                resultMap.put("msg", SELECT_DATA_BY_ID_SUCCESS.getMsg());
                resultMap.put("data", restdata);
                return resultMap;
            }
        }
        resultMap.put("code", SELECT_DATA_BY_ID_FAILED.getCode());
        resultMap.put("msg", SELECT_DATA_BY_ID_FAILED.getMsg());
        return resultMap;
    }


}
