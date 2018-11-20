package com.ms.vn.vnservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.vn.vndao.dao.GxHappyTenMapper;
import com.ms.vn.vndao.model.GxHappyTen;
import com.ms.vn.vnservice.service.IGxHappyTenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GxHappyTenServiceImpl implements IGxHappyTenService {
    @Autowired
    private GxHappyTenMapper gxHappyTenMapper;
    Logger logger = LoggerFactory.getLogger(getClass());
    public GxHappyTen findUser(Long userId) {
        GxHappyTen gxHappyTen = gxHappyTenMapper.selectByPrimaryKey(userId);
        logger.trace("这是一个trace日志service");
        logger.debug("这是一个debug日志service");
        logger.info("这是一个info日志service");
        logger.warn("这是一个warn日志service");
        logger.error("这是一个error日志service");
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
