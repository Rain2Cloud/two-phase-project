package com.aaa.yay.service;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.mapper.NewsMapper;
import com.aaa.yay.model.News;
import com.aaa.yay.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

import static com.aaa.yay.status.OperationStatus.*;

/**
 * @Author 十八
 * @Date 2020/7/25 10:16
 * @Version 1.0
 */
@Service
public class NewsService extends BaseService<News> {

    @Autowired
    private NewsMapper newsMapper;

    /**
    * @Auther: czb
    * @Description:
     * 添加新闻信息
    * @Date: 2020/7/25 11:28
    * @param [news]
    * @return com.aaa.yay.base.ResultData
    */
    public ResultData addNews(News news){
        ResultData resultData = new ResultData();
        int i = newsMapper.insert(news);
        if (i > 0){
           return resultData.setCode(ADD_SUCCESS.getCode()).setMsg(ADD_SUCCESS.getMsg());
        }else {
            return resultData.setCode(ADD_FAILED.getCode()).setMsg(ADD_FAILED.getMsg());
        }
    }

      /**
       *  @Auther: czb
       * @Description:
       * 批量删除信息（news）
       * @Date: 2020/7/25 15:01
       * @param [ids]* @return com.aaa.yay.base.ResultData
       */
    public  ResultData delNews(List<Long> ids){
        ResultData resultData = new ResultData();
        Example example= Example.builder(News.class).where(Sqls.custom().andIn("id",ids)).build();
        int i  = newsMapper.deleteByExample(example);
        if (i >0){
            return  resultData.setCode(DEL_SUCCESS.getCode()).setMsg(DEL_FAILED.getMsg());
        }else {
            return resultData.setCode(DEL_FAILED.getCode()).setMsg(DEL_FAILED.getMsg());
        }
    }





}
