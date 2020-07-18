package com.aaa.yay.controller;

import com.aaa.yay.base.BaseController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Dict;
import com.aaa.yay.service.SystemApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 十八
 * @Date 2020/7/17 22:10
 * @Version 1.0
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
        @Autowired
    private SystemApi systemApi;
        /**
        * @Auther: czb
        * @Description:
         * 新增字典信息
        * @Date: 2020/7/17 22:22
        * @param [dict]
        * @return com.aaa.yay.base.ResultData
        */
        @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict){
            return systemApi.addDict(dict);
        }
    /**
    * @Auther: czb
    * @Description:
     * 根据主键id批量删除字典信息
    * @Date: 2020/7/17 22:30
    * @param [ids]
    * @return com.aaa.yay.base.ResultData
    */
        @DeleteMapping("/delDictsById")
    public ResultData delDictsById(@RequestBody List<Long> ids){
            return systemApi.delDictsById(ids);
        }
        /**
        * @Auther: czb
        * @Description:
         * 修改字典信息
        * @Date: 2020/7/17 22:36
        * @param [dict]
        * @return com.aaa.yay.base.ResultData
        */
        @PostMapping("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
            return systemApi.updateDict(dict);
        }

        /**
        * @Auther: czb
        * @Description:
         * 查询全部字典信息(分页)
        * @Date: 2020/7/17 22:39
        * @param [pageNo, pageSize]
        * @return com.aaa.yay.base.ResultData
        */
        @PostMapping("/selectAllDictByPage")
    public ResultData selectAllDictByPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
            return systemApi.selectAllDictByPage(pageNo, pageSize);
        }



}
