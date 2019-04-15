package cn.ccnu.demo.controller;

import cn.ccnu.demo.bean.Res;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
//@CrossOrigin
@RequestMapping("/cor")
public class CRSTestController {

//    @RequestMapping(value = "/login",method = RequestMethod.OPTIONS)
//    public void getPreCheck(HttpServletRequest request, HttpServletResponse response){
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "PUT");
//        response.addHeader("Access-Control-Allow-Headers", "content-type");
//        System.out.println(request.getHeaderNames());
//    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,String> getUserInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody Res res){
//        System.out.println(request.getHeaderNames());
        System.out.println(res.toString());
        if(request.getCookies()!=null){
            for (int i = 0; i < request.getCookies().length; i++) {
                System.out.println(request.getCookies()[i].getName()+request.getCookies()[i].getValue());
            }
        }else {
            Cookie cookie = new Cookie("sessionId","123");
            cookie.setPath("/");
//            cookie.setDomain("127.0.0.1");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
        }

        Map<String,String> map = new HashMap<>();
        map.put("msg","ok");
        return map;
    }
}
