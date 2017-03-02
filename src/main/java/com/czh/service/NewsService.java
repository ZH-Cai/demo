package com.czh.service;

import com.czh.dao.NewsDAO;

import com.czh.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1 0001.
 */
@Service
public class NewsService {
    @Autowired
    NewsDAO newsDAO;

    public List<News> getlastestNews(int userid,int offest,int limit){
        return newsDAO.selectByUserIdAndOffset(userid,offest,limit);
    }
}
