package com.aaa.yay.controller;

import com.aaa.yay.base.BaseController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.News;
import com.aaa.yay.service.MappingApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 十八
 * @Date 2020/7/27 18:51
 * @Version 1.0
 */

@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    private MappingApi mappingApi;


    /**
    * @Auther: czb
    * @Description:
     * 增加信息(news)
    * @Date: 2020/7/27 18:59
    * @param [news]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addNews")
    public ResultData addNews(@RequestBody News news){
        return mappingApi.addNews(news);
    }


    /**
    * @Auther: czb
    * @Description:
     * 批量删除信息(News)
    * @Date: 2020/7/27 19:01
    * @param [ids]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/delNews")
    public ResultData delNews(@RequestBody List<Long> ids){
        return mappingApi.delNews(ids);
    }



    /**
    * @Auther: czb
    * @Description:
     * 分页查询新闻信息(News)
    * @Date: 2020/7/27 19:05
    * @param [pageNo, pageSize]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAllNews")
    public ResultData selectAllNews(@RequestParam("pageNo") Integer pageNo ,@RequestParam("pageSize") Integer pageSize){
        return mappingApi.selectAllNews(pageNo,pageSize);
    }


}
