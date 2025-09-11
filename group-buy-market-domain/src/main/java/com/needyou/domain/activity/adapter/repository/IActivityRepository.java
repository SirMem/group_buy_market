package com.needyou.domain.activity.adapter.repository;

import com.needyou.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.needyou.domain.activity.model.valobj.SCSkuActivityVO;
import com.needyou.domain.activity.model.valobj.SkuVO;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 活动仓储
 * @create 2024-12-21 10:06
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);

    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);

    boolean isTagCrowdRange(String tagId, String userId);

}
