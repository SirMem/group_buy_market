package com.needyou.domain.activity.service.trial.node;


import com.alibaba.fastjson.JSON;
import com.needyou.domain.activity.model.entity.MarketProductEntity;
import com.needyou.domain.activity.model.entity.TrialBalanceEntity;
import com.needyou.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.needyou.domain.activity.model.valobj.SkuVO;
import com.needyou.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.needyou.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.needyou.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 结束节点
 * @create 2024-12-14 14:31
 */
@Slf4j
@Service
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("拼团商品查询试算服务-EndNode userId:{} requestParameter:{}", requestParameter.getUserId(), JSON.toJSONString(requestParameter));

        GroupBuyActivityDiscountVO groupBuyActivityDiscountVO = dynamicContext.getGroupBuyActivityDiscountVO();
        SkuVO skuVO = dynamicContext.getSkuVO();

        // 折扣价格
        BigDecimal deductionPrice = dynamicContext.getDeductionPrice();

        // 返回空结果
        return TrialBalanceEntity.builder()
                .goodsId(skuVO.getGoodsId())
                .goodsName(skuVO.getGoodsName())
                .originalPrice(skuVO.getOriginalPrice())
                .deductionPrice(deductionPrice)
                .targetCount(groupBuyActivityDiscountVO.getTarget())
                .startTime(groupBuyActivityDiscountVO.getStartTime())
                .endTime(groupBuyActivityDiscountVO.getEndTime())
                .isVisible(false)
                .isEnable(false)
                .groupBuyActivityDiscountVO(groupBuyActivityDiscountVO)
                .build();

    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return defaultStrategyHandler;
    }

}