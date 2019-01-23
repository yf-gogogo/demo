package cn.ccnu.demo.sevice;

import cn.ccnu.demo.bean.Res;

import java.util.List;

public interface IResService {
    public Res getResById(int rId);
    public List<Res> getAllRes();
}
