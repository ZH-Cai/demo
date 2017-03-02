package com.czh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
@Controller
public class IndexController {
    @RequestMapping(path={"/","/index"})
    @ResponseBody
    public String  index(){
        return "Hello World";
    }
    //请求URI
    @RequestMapping(path={"/profile/{groupid}/{userid}"})
    @ResponseBody
    public String profile(@PathVariable("groupid") String groupid,
                          @PathVariable("userid") int userid,
                          @RequestParam(value ="type",defaultValue = "1") int type,
                          @RequestParam(value ="key",defaultValue = "1") String key) {
        return String.format("{%s},{%d},{%d},{%s}", groupid, userid, type, key);
        }

    @RequestMapping(path={"/vm"})
    public String  news(Model model){
        model.addAttribute("value1",123);
        return "news";
    }
    @RequestMapping(path={"/redirect/{code}"})
    public RedirectView redirect(@PathVariable(value = "code") int code){
        RedirectView view=new RedirectView("/",true);
        if(code ==301)
            view.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        return view;
    }
}



