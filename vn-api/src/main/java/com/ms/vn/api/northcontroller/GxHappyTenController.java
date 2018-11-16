package com.ms.vn.api.northcontroller;

import com.ms.vn.vndao.model.GxHappyTen;
import com.ms.vn.vndao.service.TestService;
import com.ms.vn.vnservice.service.IGxHappyTenService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gx")
public class GxHappyTenController {
    @Autowired
    private IGxHappyTenService gxHappyTenService;

    @ApiOperation(value="获取广西快乐十分详细信息", notes="根据url的id来获取广西快乐十分详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping("/get")
    public GxHappyTen createUser(Long id) {
        GxHappyTen findUser = gxHappyTenService.findUser(2L);
        System.out.println(findUser.hashCode());
        return findUser;
    }
}
