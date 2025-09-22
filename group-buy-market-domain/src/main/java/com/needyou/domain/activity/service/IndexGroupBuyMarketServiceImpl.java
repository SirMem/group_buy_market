package com.needyou.domain.activity.service;


import com.needyou.domain.activity.adapter.repository.IActivityRepository;
import com.needyou.domain.activity.model.entity.MarketProductEntity;
import com.needyou.domain.activity.model.entity.TrialBalanceEntity;
import com.needyou.domain.activity.model.entity.UserGroupBuyOrderDetailEntity;
import com.needyou.domain.activity.model.valobj.TeamStatisticVO;
import com.needyou.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.needyou.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 首页营销服务
 * @create 2024-12-14 14:33
 */
@Service
public class IndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService {

    @Resource
    private IActivityRepository repository;

    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {

        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();

        return strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());
    }

    @Override
    public List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailList(Long activityId, String userId, Integer ownerCount, Integer randomCount) {
        List<UserGroupBuyOrderDetailEntity> unionAllList = new ArrayList<>();

        // 查询个人拼团数据
        if (0 != ownerCount) {
            List<UserGroupBuyOrderDetailEntity> ownerList = repository.queryInProgressUserGroupBuyOrderDetailListByOwner(activityId, userId, ownerCount);
            if (null != ownerList && !ownerList.isEmpty()){
                unionAllList.addAll(ownerList);
            }
        }

        // 查询其他非个人拼团
        if (0 != randomCount) {
            List<UserGroupBuyOrderDetailEntity> randomList = repository.queryInProgressUserGroupBuyOrderDetailListByRandom(activityId, userId, randomCount);
            if (null != randomList && !randomList.isEmpty()){
                unionAllList.addAll(randomList);
            }
        }

        return unionAllList;
    }

    @Override
    public TeamStatisticVO queryTeamStatisticByActivityId(Long activityId) {
        return repository.queryTeamStatisticByActivityId(activityId);
    }


}
