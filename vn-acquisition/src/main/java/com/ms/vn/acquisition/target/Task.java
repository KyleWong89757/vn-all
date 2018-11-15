package com.ms.vn.acquisition.target;

import com.ms.vn.domain.LotteryExtEntity;
import com.ms.vn.domain.dto.LotteryDto;

public abstract class Task<T extends LotteryExtEntity>
{
    protected abstract LotteryDto drawLotteryCode(Long preDrawIssue);
    public void process(){
//        System.out.println("Task  ++++++++++++　　process");
//        System.out.println(drawLotteryCode(123L));
    }
}
