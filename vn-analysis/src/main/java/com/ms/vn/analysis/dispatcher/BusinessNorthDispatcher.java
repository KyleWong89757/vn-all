package com.ms.vn.analysis.dispatcher;

import com.ms.vn.domain.dto.LotteryDto;
import com.ms.vn.rabbitmq.dispatcher.AbstractNorthDispatcher;
import org.springframework.stereotype.Component;

@Component
public class BusinessNorthDispatcher implements AbstractNorthDispatcher {
    @Override
    public void Dispatch(LotteryDto commonDto) {
        System.out.println("北方进行数据分析。。。。");
    }
}
