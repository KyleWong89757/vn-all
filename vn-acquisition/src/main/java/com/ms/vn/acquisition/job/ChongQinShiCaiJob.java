package com.ms.vn.acquisition.job;

import com.ms.vn.acquisition.target.Task;
import com.ms.vn.domain.LotteryBaseCQShiCai;
import com.ms.vn.domain.dto.LotteryDto;
import com.ms.vn.rabbitmq.sender.MessageSender;
import com.ms.vn.redis.utils.RedisUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("chongQinShiCaiJob")
public  abstract class ChongQinShiCaiJob  extends Task<LotteryBaseCQShiCai> implements Job
{
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private MessageSender firstSender;
//    @Override
    public void executeInternal(JobExecutionContext context)
    {
        System.out.println("ChongQinShiCaiJob--------------------"+new Date());
        process();
    }
//    protected  LotteryDto drawLotteryCode(Long preDrawIssue){
//        return null;
//    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println("ChongQinShiCaiJob---------------job-----"+new Date());
        process();
        if(redisUtils.exists("Operation1")){
//            System.out.println("redis value=============" + redisUtils.get("Operation1").toString());
        }else {
            redisUtils.set("Operation1","redis value111111");
//            System.out.println("redis value---------------------" + redisUtils.get("Operation1").toString());
        }
        LotteryDto dto = new LotteryDto();
        dto.setPreDrawCode("PreDrawCode############"+new Date());
        firstSender.send(dto,"vn.south.henei");
        firstSender.send(dto,"vn.north.henei");
//        redisTemplate.opsForValue().set("num","123");
//        System.out.println(redisTemplate.opsForValue().get("num"));//  输出结果为123
    }
}
