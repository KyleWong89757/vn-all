package com.ms.vn.api.northcontroller;

import com.ms.vn.vndao.model.GxHappyTen;
import com.ms.vn.vndao.service.TestService;
import com.ms.vn.vnservice.service.IGxHappyTenService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gx")
public class GxHappyTenController {
    @Autowired
    private IGxHappyTenService gxHappyTenService;
    Logger logger = LoggerFactory.getLogger(getClass());
    @ApiOperation(value="获取广西快乐十分详细信息", notes="根据url的id来获取广西快乐十分详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/get",method= RequestMethod.GET)
    public GxHappyTen createUser(Long id) {
        GxHappyTen findUser = gxHappyTenService.findUser(2L);
        System.out.println(findUser.hashCode());
        logger.trace("这是一个trace日志");
        logger.debug("这是一个debug日志");
        logger.info("这是一个info日志");
        logger.warn("这是一个warn日志");
        logger.error("这是一个error日志");
        return findUser;
    }
}
