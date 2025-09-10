package com.needyou.domain.activity.service.trial.thread;

import com.needyou.domain.activity.adapter.repository.IActivityRepository;
import com.needyou.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.needyou.domain.activity.model.valobj.SCSkuActivityVO;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 查询营销配置任务
 * @create 2024-12-21 09:46
 */
@Slf4j
public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    /**
     * 来源
     */
    private final String source;

    /**
     * 渠道
     */
    private final String channel;

    /**
     * 商品Id
     */
    private final String goodsId;
    /**
     * 活动仓储
     */
    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel, String goodsId, IActivityRepository activityRepository) {
        this.source = source;
        this.channel = channel;
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        log.info("开始根据GoodsId获得ActivityId");
        SCSkuActivityVO scSkuActivityVORes = activityRepository.querySCSkuActivityBySCGoodsId(source, channel, goodsId);
        if (null == scSkuActivityVORes) {return null;}
        return activityRepository.queryGroupBuyActivityDiscountVO(scSkuActivityVORes.getActivityId());
    }

}
