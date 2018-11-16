package com.ms.vn.vnservice.service;

import com.github.pagehelper.PageInfo;
import com.ms.vn.vndao.model.GxHappyTen;

public interface IGxHappyTenService {
    public abstract GxHappyTen findUser(Long userId);
    public abstract PageInfo<GxHappyTen> findAll(int pageNum, int pageSize);
}
