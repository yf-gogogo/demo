package cn.ccnu.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class AuthorizationTestController {
    @GetMapping("/auth")
    public void getAuth(HttpServletRequest request, HttpServletResponse response){
        if(request.getHeader("authorization") == null){
            response.setStatus(401);
            response.setHeader("WWW-Authenticate","Basic realm=\"Input your Id and Password\"");
        }else {
            System.out.println(request.getHeader("authorization"));

        }
    }
}
