package com.aaa.yay.controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.News;
import com.aaa.yay.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 十八
 * @Date 2020/7/25 18:21
 * @Version 1.0
 */
@RestController
@RequestMapping("/news")
public class NewsController extends CommonController<News> {
    @Autowired
    private NewsService newsService;

    @Override
    public BaseService<News> getBaseService() {
        return newsService;
    }
    /**
    * @Auther: czb
    * @Description:
     * 增加信息
    * @Date: 2020/7/25 18:24
    * @param [news]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addNews")
    public ResultData addNews(News news){
        return newsService.addNews(news);
    }


    /**
    * @Auther: czb
    * @Description:
     * 批量删除信息
    * @Date: 2020/7/26 16:20
    * @param [ids]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("delNews")
    public  ResultData delNews(@RequestBody List<Long> ids){
        return  newsService.delNews(ids);
    }





    /**
    * @Auther: czb
    * @Description:
     * 带条件分页查询信息
    * @Date: 2020/7/27 8:21
    * @param [pageNo, pageSize]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAllNews")
    public ResultData selectAllNews(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        List<News>  newsList = getBaseService().selectByFileds(pageNo,pageSize,null, null, null, (String[]) null);
        if (newsList.size()>0){
            return super.operationSuccess(newsList,"查询成功");
                }
             return super.operationFailed("查询失败");
    }

}
