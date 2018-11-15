package com.ms.vn.analysis.dispatcher;

import com.ms.vn.domain.dto.LotteryDto;
import com.ms.vn.rabbitmq.dispatcher.AbstractNorthDispatcher;
import com.ms.vn.rabbitmq.dispatcher.AbstractSouthDispatcher;
import org.springframework.stereotype.Component;

@Component
public class BusinessSouthDispatcher implements AbstractSouthDispatcher {
    @Override
    public void Dispatch(LotteryDto commonDto) {
        System.out.println("南方进行数据分析。。。。");
    }
}
