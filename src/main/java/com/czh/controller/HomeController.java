package com.czh.controller;

import com.czh.model.News;
import com.czh.model.ViewObject;
import com.czh.service.NewsService;
import com.czh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1 0001.
 */
@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    NewsService newsService;

    private List<ViewObject> getNews(int userid,int offest,int limit){
        List<News> newsList = newsService.getlastestNews(userid,0,10);
        List<ViewObject> vos=new ArrayList<>();
        for(News news:newsList){
            ViewObject vo=new ViewObject();
            vo.set("news",news);
            vo.set("user",userService.getUser(news.getUserId()));
            vos.add(vo);
        }
        return vos;
    }
    @RequestMapping(path={"/home"},method = {RequestMethod.GET,RequestMethod.POST})
    public String home(Model model){
        model.addAttribute("vos",getNews(0,0,10));
        return "home";
    }
    @RequestMapping(path={"/user/{userid}"},method = {RequestMethod.GET,RequestMethod.POST})
    public String usernews(Model model, @PathVariable("userid") int userid){
        model.addAttribute("vos",getNews(userid,0,10));
        return "home";
    }
}
