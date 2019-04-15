package cn.ccnu.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CookieSessionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<String,HttpSession> sessionMap = new HashMap();
    @PostMapping("/login")
    public void login(HttpServletRequest request,HttpServletResponse response, @RequestParam String name, @RequestParam String pwd){
        HttpSession session = request.getSession();
        session.setAttribute("name",name);
        session.setAttribute("pwd",pwd);
        String sessionId = session.getId();
        if(session.isNew()){
            logger.info("创建新的session");
        }
        sessionMap.put(sessionId,session);
        Cookie cookie = new Cookie("sessionId",sessionId);
        cookie.setMaxAge(30);
        response.addCookie(cookie);
    }
    @GetMapping("/islogin")
    public Map isLogin(HttpServletRequest request, HttpServletResponse response){
        Map<String,String> map = new HashMap<>();
        map.put("msg","fail");
        Cookie[] cookies = request.getCookies();
        if(cookies==null) return map;
        for (Cookie c: cookies) {
            if("sessionId".equals(c.getName())){
                logger.info(c.getName());
                map.put("msg","ok");
                HttpSession session = sessionMap.get(c.getValue());
                map.put("name",session.getAttribute("name").toString());
            }
        }
        return map;
    }
}
