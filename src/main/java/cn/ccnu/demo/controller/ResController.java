package cn.ccnu.demo.controller;

import cn.ccnu.demo.bean.Res;
import cn.ccnu.demo.sevice.impl.ResServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResController {

    @Autowired
    ResServicelmpl resServicelmpl;

    @RequestMapping(value = "/res",method = RequestMethod.GET)
    public Res getResById(@RequestParam("rId") int rId){
        return resServicelmpl.getResById(rId);
    }

    @RequestMapping(value = "/listres",method = RequestMethod.GET)
    public List<Res> listRes(){
        return resServicelmpl.getAllRes();
    }


}
