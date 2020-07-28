package com.aaa.yay.controller;
import com.aaa.yay.base.BaseController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.service.MappingApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

/**
 * @Author 十八
 * @Date 2020/7/21 19:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/resultCommit")
public class ResultCommitController extends BaseController {
    @Autowired
    private MappingApi mappingApi;

    /**
    * @Auther: czb
    * @Description:
     * 根据传过 来的条件去查询需要测绘成果
    * @Date: 2020/7/21 19:53
    * @param [hashMap]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selcetAllResult")
    public ResultData selectAllResult(@RequestBody HashMap hashMap){
        return mappingApi.selcetAllResult(hashMap);
    }

        /**
        * @Auther: czb
        * @Description:
         * 查询数据中所有的测绘类型，可以让前台进行选择查询
        * @Date: 2020/7/21 19:54
        * @param []
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/SelectProjectType")
    public ResultData SelectProjectType(){
        return mappingApi.SelectProjectType();
    }

        /**
        * @Auther: czb
        * @Description:
         * 查询出成果的详细信息
        * @Date: 2020/7/21 19:54
        * @param [id]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/resultDetail")
    public ResultData resultDetail(@RequestParam("id") String id){
        System.out.println(id);
        return mappingApi.resultDetail(id);
    }

}
