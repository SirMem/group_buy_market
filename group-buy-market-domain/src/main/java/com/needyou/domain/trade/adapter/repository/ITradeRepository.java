package com.needyou.domain.trade.adapter.repository;

import com.needyou.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.needyou.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import com.needyou.domain.trade.model.entity.GroupBuyActivityEntity;
import com.needyou.domain.trade.model.entity.GroupBuyTeamEntity;
import com.needyou.domain.trade.model.entity.MarketPayOrderEntity;
import com.needyou.domain.trade.model.entity.NotifyTaskEntity;
import com.needyou.domain.trade.model.valobj.GroupBuyProgressVO;

import java.util.List;

public interface ITradeRepository {

    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    GroupBuyActivityEntity queryGroupBuyActivityEntityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    void settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);

    boolean isSCBlackIntercept(String source, String channel);

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList();

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList(String teamId);

    int updateNotifyTaskStatusSuccess(String teamId);

    int updateNotifyTaskStatusError(String teamId);

    int updateNotifyTaskStatusRetry(String teamId);

}
