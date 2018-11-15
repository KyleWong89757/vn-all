package com.ms.vn.acquisitionxskt.job;

import com.ms.vn.acquisition.job.ChongQinShiCaiJob2;
import com.ms.vn.domain.dto.LotteryDto;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @author Andy
 * @version 1.0.0
 * @创建时间: 2017年1月9日 下午5:53:31
 */
@Component("yibfChongQinShiCaiJob2")
public class YibfChongQinShiCaiJob2 extends ChongQinShiCaiJob2
{




    @Override
    protected LotteryDto drawLotteryCode(Long preDrawIssue)
    {
        LotteryDto dto = new LotteryDto();
        dto.setPreDrawCode("2222222=========xskt");
        return dto;
    }



    public static void main(String[] args)
    {
        YibfChongQinShiCaiJob2 y = new YibfChongQinShiCaiJob2();
        System.out.println(y.drawLotteryCode(20180820052L));
    }
}
