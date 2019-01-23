package cn.ccnu.demo.mapper;

import cn.ccnu.demo.bean.Res;

import java.util.List;

public interface ResMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Res record);

    int insertSelective(Res record);

    Res selectByPrimaryKey(Integer rId);

    List<Res> selectAllRes();

    int updateByPrimaryKeySelective(Res record);

    int updateByPrimaryKey(Res record);
}