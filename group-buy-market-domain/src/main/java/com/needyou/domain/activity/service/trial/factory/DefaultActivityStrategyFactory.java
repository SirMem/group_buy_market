package com.needyou.domain.activity.service.trial.factory;


import com.needyou.domain.activity.model.entity.MarketProductEntity;
import com.needyou.domain.activity.model.entity.TrialBalanceEntity;
import com.needyou.domain.activity.service.trial.node.RootNode;
import com.needyou.types.design.framework.tree.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 活动策略工厂
 * @create 2024-12-14 13:41
 */
@Service
public class DefaultActivityStrategyFactory {

    private final RootNode rootNode;

    public DefaultActivityStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity> strategyHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

    }

}
