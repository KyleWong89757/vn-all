package com.ms.vn.rabbitmq.dispatcher;

import com.ms.vn.domain.dto.LotteryDto;

public interface AbstractNorthDispatcher {
    public void Dispatch(LotteryDto commonDto);
}
