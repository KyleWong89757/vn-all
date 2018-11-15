package com.ms.vn.acquisitionxskt.job;

import com.ms.vn.acquisition.job.ChongQinShiCaiJob;
import com.ms.vn.domain.dto.LotteryDto;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @author Andy
 * @version 1.0.0
 * @创建时间: 2017年1月9日 下午5:53:31
 */
@Component("yibfChongQinShiCaiJob")
public class YibfChongQinShiCaiJob extends ChongQinShiCaiJob
{




    @Override
    protected LotteryDto drawLotteryCode(Long preDrawIssue)
    {
        LotteryDto dto = new LotteryDto();
        dto.setPreDrawCode("111111=========xskt");
        return dto;
    }



    public static void main(String[] args)
    {
        YibfChongQinShiCaiJob y = new YibfChongQinShiCaiJob();
        System.out.println(y.drawLotteryCode(20180820052L));
    }
}
