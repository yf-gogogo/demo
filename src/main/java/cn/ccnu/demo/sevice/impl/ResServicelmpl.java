package cn.ccnu.demo.sevice.impl;

import cn.ccnu.demo.bean.Res;
import cn.ccnu.demo.mapper.ResMapper;
import cn.ccnu.demo.sevice.IResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResServicelmpl implements IResService {

    @Autowired(required = false)
    ResMapper resMapper;

    @Override
    public Res getResById(int rId) {
        return resMapper.selectByPrimaryKey(rId);

    }

    @Override
    public List<Res> getAllRes() {
        return resMapper.selectAllRes();
    }
}
