package com.ms.vn.acquisition.job;

import com.ms.vn.acquisition.target.Task;
import com.ms.vn.domain.LotteryBaseCQShiCai;
import com.ms.vn.domain.dto.LotteryDto;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component("chongQinShiCaiJob2")
public abstract class ChongQinShiCaiJob2 extends Task<LotteryBaseCQShiCai> implements Job
{
//    @Autowired
//    private Task task;
//    @Override
    public void executeInternal(JobExecutionContext context)
    {
        System.out.println("ChongQinShiCaiJob--------22222------------");
//        task.process();
    }
//    protected  LotteryDto drawLotteryCode(Long preDrawIssue){
//        return null;
//    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("ChongQinShiCaiJob2--------22222--job----------");
        process();
    }
}
