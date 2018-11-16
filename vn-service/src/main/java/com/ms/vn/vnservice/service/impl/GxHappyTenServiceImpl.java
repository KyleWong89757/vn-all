package com.ms.vn.vnservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.vn.vndao.dao.GxHappyTenMapper;
import com.ms.vn.vndao.model.GxHappyTen;
import com.ms.vn.vnservice.service.IGxHappyTenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GxHappyTenServiceImpl implements IGxHappyTenService {
    @Autowired
    private GxHappyTenMapper gxHappyTenMapper;
    public GxHappyTen findUser(Long userId) {
        GxHappyTen gxHappyTen = gxHappyTenMapper.selectByPrimaryKey(userId);
        return gxHappyTen ;
    }
    //分页查询示例
    public PageInfo<GxHappyTen> findAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<GxHappyTen> userDomains = gxHappyTenMapper.selectGxHappyTenList();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }
}
