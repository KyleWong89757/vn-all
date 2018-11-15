package com.ms.vn.vndao.dao;

import com.ms.vn.vndao.model.GxHappyTen;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
public interface GxHappyTenMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GxHappyTen record);

    int insertSelective(GxHappyTen record);

    GxHappyTen selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GxHappyTen record);

    int updateByPrimaryKey(GxHappyTen record);
    List<GxHappyTen> selectGxHappyTenList();
}