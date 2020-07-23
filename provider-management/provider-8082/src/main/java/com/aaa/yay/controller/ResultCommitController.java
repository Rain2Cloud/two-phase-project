package com.aaa.yay.controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.ResultCommit;
import com.aaa.yay.service.MappingResultCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.aaa.yay.status.OperationStatus.SELECT_DATA_BY_ID_SUCCESS;
import static com.aaa.yay.status.OperationStatus.SELECT_DATA_SUCCESS;

/**
 * @Author 十八
 * @Date 2020/7/21 19:17
 * @Version 1.0
 */
@RequestMapping("/resultCommit")
@RestController
public class ResultCommitController extends CommonController<ResultCommit> {

    @Autowired
    private MappingResultCommitService mappingResultCommitService;

    @Override
    public BaseService<ResultCommit> getBaseService() {
      return mappingResultCommitService;
    }

        /**
        * @Auther: czb
        * @Description:
         *根据传过来的条件查询所需要的 测绘 成果
        * @Date: 2020/7/21 19:35
        * @param [hashMap]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/selcetAllResult")
    public ResultData selcetAllResult(@RequestBody HashMap hashMap){
        System.out.println(hashMap);
        Map<String, Object> resultMap = mappingResultCommitService.selcetAllResult(hashMap);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else{
            return super.selectFailed();
        }
    }


    /**
    * @Auther: czb
    * @Description:
     *查询数据中所有的测绘类型，可以让前台进行选择查询
    * @Date: 2020/7/21 19:46
    * @param []
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/SelectProjectType")
    public ResultData SelectProjectType(){
        Map<String, Object> resultMap = mappingResultCommitService.SelectProjectType();
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else{
            return super.selectFailed();
        }
    }


            /**
            * @Auther: czb
            * @Description:
             * 查询出成果的详细信息
            * @Date: 2020/7/21 19:50
            * @param [id]
            * @return com.aaa.yay.base.ResultData
            */
    @PostMapping("/resultDetail")
    public ResultData resultDetail(@RequestParam("id") String id){
        Map<String, Object> resultMap = mappingResultCommitService.resultDetail(id);
        if (SELECT_DATA_BY_ID_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else{
            return super.selectFailed();
        }
    }

}
