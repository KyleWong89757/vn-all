package com.ms.vn.vndao;

import com.github.pagehelper.PageInfo;
import com.ms.vn.vndao.model.GxHappyTen;
import com.ms.vn.vndao.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VnDaoApplicationTests {
    @Autowired
    private TestService service ;
    @Test
    public void contextLoads() {
        GxHappyTen findUser = service.findUser(2L);
        System.out.println(findUser.toString());
        PageInfo result = service.findAll(1,10);
        System.out.println(result);
    }

}
