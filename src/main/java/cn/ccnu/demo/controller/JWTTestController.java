package cn.ccnu.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class JWTTestController {
    //生成token
    @PostMapping(value = "/jwt")
    public Map<String,String> geneJWT(@RequestParam String name,@RequestParam String pwd){

        //生成token
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("name",name)
                    .withExpiresAt(new Date(System.currentTimeMillis()+30000))
                    .withNotBefore(new Date())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        Map<String,String> map = new HashMap<>();
        map.put("msg","ok");
        map.put("token",token);
        return map;
    }
    //验证token
    @GetMapping("/autologinvertify")
    public Map<String,String> autoLogin(HttpServletRequest httpServletRequest){
        String token = null;
        token = httpServletRequest.getAuthType();
        Enumeration<String> stringEnum = httpServletRequest.getHeaderNames();
        while (stringEnum.hasMoreElements()){
            String head = stringEnum.nextElement();

            if("authorization".equals(head)){
                token = httpServletRequest.getHeader(head).split(" ")[1];
                System.out.println(token);
            }
        }
        Map<String,String> map = new HashMap<>();
        //验证token
        //时间是自动验证
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            String payLoad = jwt.getPayload();
            Map<String, Claim> claims = jwt.getClaims();
            System.out.println(payLoad);
            map.put("msg","ok");
            map.put("name",claims.get("name").asString());
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            System.out.println(exception.getMessage());
            map.put("msg","fail");
        }
        return map;
    }
}
