package com.ms.vn.quartz.init;

import com.ms.vn.domain.ScheduleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ScheduleJobInit implements ApplicationRunner {

    @Qualifier("quartzScheduler")
    @Autowired
    private Scheduler scheduler;

    @Autowired()
    private Map<String, Job> jobsMap;

//    public Map<String, QuartzJobBean> getJobsMap() {
//        return jobsMap;
//    }
//
//    public void setJobsMap(Map<String, QuartzJobBean> jobsMap) {
//        this.jobsMap = jobsMap;
//    }

    @Override
    public void run(ApplicationArguments var) throws Exception {
//        List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
//        if (null != jobList)
//        {
            for (String in : jobsMap.keySet())
            {

                 ScheduleJob job = new ScheduleJob(); job.setJobName(in+"name");
                 job.setJobGroup(in+"group");
                TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
                // 获取trigger,即在spring配置文件中定义的 bean id="myTrigger"
                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                // 不存在，创建一个
                if (null == trigger) //&& null != jobsMap)
                {
//                    QuartzJob quartzJob = jobsMap.get(11);
//                    Class<? extends QuartzJobBean> jobClass = (Class<? extends QuartzJobBean>) Class.forName("chongQinShiCaiJsob").newInstance().getClass();
//                    if (null != quartzJob)
//                    {
                       /* MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
                        jobDetailFactoryBean.setTargetObject(YibfChongQinShiCaiJob.class);
                        jobDetailFactoryBean.setTargetMethod("invoke");
                        jobDetailFactoryBean.setGroup(job.getJobGroup());
                        jobDetailFactoryBean.setName(job.getJobName());
                        jobDetailFactoryBean.setConcurrent(false);*/
//                        jobDetailFactoryBean.afterPropertiesSet();
//                        JobDetail jobDetail = jobDetailFactoryBean.getObject();
                    Job b = jobsMap.get(in);

                    JobDetail jobDetail = JobBuilder.newJob(b.getClass())
                            .withIdentity(in+"jobname", in+"jobgroup")
                            .withDescription("定时比赛Id为")
                            .build();

                        // jobDetail.getJobDataMap().put("scheduleJob", job);
                        // 表达式调度构建器
                        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
                        // 按新的cronExpression表达式构建一个新的trigger
                        trigger = TriggerBuilder.newTrigger().withIdentity(in+"triggername", in+"triggergroup")
                                .withSchedule(scheduleBuilder).build();
                        scheduler.scheduleJob(jobDetail, trigger);
//                    }
//                    else
//                    {
//                        logger.error("没有找到对应的QuartzJob.从数据库中加载的job info:" + job);
//                    }
//                    JobDetail jobDetail2 = JobBuilder.newJob(ChongQinShiCaiJob2.class)
//                            .withIdentity("updateMatch2", "updateMatch2")
//                            .withDescription("定时比赛Id为2")
//                            .build();
//
//                    // jobDetail.getJobDataMap().put("scheduleJob", job);
//                    // 表达式调度构建器
//                    CronScheduleBuilder scheduleBuilder2 = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
//                    // 按新的cronExpression表达式构建一个新的trigger
//                    trigger = TriggerBuilder.newTrigger().withIdentity("updateMatch2", "updateMatch2")
//                            .withSchedule(scheduleBuilder).build();
//                    scheduler.scheduleJob(jobDetail2, trigger);
                }
                else
                {
                    // Trigger已存在，那么更新相应的定时设置
                    // 表达式调度构建器
                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                    // 按新的cronExpression表达式重新构建trigger
                    trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder)
                            .build();
                    // 按新的trigger重新设置job执行
                    scheduler.rescheduleJob(triggerKey, trigger);
                }
            }
//        }
    }


}
