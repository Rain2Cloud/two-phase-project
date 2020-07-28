package com.aaa.yay.mapper;

import com.aaa.yay.model.News;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
//(不报错)
public interface NewsMapper extends Mapper<News> {
}

