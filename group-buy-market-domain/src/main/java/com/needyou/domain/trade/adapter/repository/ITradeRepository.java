package com.needyou.domain.trade.adapter.repository;

import com.needyou.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.needyou.domain.trade.model.entity.GroupBuyActivityEntity;
import com.needyou.domain.trade.model.entity.MarketPayOrderEntity;
import com.needyou.domain.trade.model.valobj.GroupBuyProgressVO;

public interface ITradeRepository {

    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    GroupBuyActivityEntity queryGroupBuyActivityEntityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

}
