package com.needyou.domain.activity.service.trial;



import com.needyou.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.needyou.types.design.framework.tree.AbstractStrategyRouter;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 抽象的拼团营销支撑类
 * @create 2024-12-14 13:42
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractStrategyRouter<com.needyou.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, com.needyou.domain.activity.model.entity.TrialBalanceEntity> {



}
