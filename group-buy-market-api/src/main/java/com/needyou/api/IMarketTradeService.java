package com.needyou.api;

import com.needyou.api.dto.LockMarketPayOrderRequestDTO;
import com.needyou.api.dto.LockMarketPayOrderResponseDTO;
import com.needyou.api.response.Response;

public interface IMarketTradeService {
    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarketPayOrderRequestDTO);
}
