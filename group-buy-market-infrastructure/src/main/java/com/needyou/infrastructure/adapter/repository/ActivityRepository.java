package com.needyou.infrastructure.adapter.repository;

import com.needyou.domain.activity.adapter.repository.IActivityRepository;
import com.needyou.domain.activity.model.valobj.DiscountTypeEnum;
import com.needyou.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.needyou.domain.activity.model.valobj.SCSkuActivityVO;
import com.needyou.domain.activity.model.valobj.SkuVO;
import com.needyou.infrastructure.dao.IGroupBuyActivityDao;
import com.needyou.infrastructure.dao.IGroupBuyDiscountDao;
import com.needyou.infrastructure.dao.ISCSkuActivityDao;
import com.needyou.infrastructure.dao.ISkuDao;
import com.needyou.infrastructure.dao.po.GroupBuyActivity;
import com.needyou.infrastructure.dao.po.GroupBuyDiscount;
import com.needyou.infrastructure.dao.po.SCSkuActivity;
import com.needyou.infrastructure.dao.po.Sku;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 活动仓储
 * @create 2024-12-21 10:10
 */
@Repository
@Slf4j
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;
    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;
    @Resource
    private ISkuDao skuDao;

    @Resource
    private ISCSkuActivityDao skuActivityDao;

    @Override
    public GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId) {
        // 根据SC渠道值查询配置中最新的1个有效的活动
        GroupBuyActivity groupBuyActivityRes = groupBuyActivityDao.queryValidGroupBuyActivityId(activityId);

        if (null == groupBuyActivityRes) { return null; }

        String discountId = groupBuyActivityRes.getDiscountId();

        GroupBuyDiscount groupBuyDiscountRes = groupBuyDiscountDao.queryGroupBuyActivityDiscountByDiscountId(discountId);
        if (null == groupBuyDiscountRes) { return null; }

        GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount = GroupBuyActivityDiscountVO.GroupBuyDiscount.builder()
                .discountName(groupBuyDiscountRes.getDiscountName())
                .discountDesc(groupBuyDiscountRes.getDiscountDesc())
                .discountType(DiscountTypeEnum.get(groupBuyDiscountRes.getDiscountType()))
                .marketPlan(groupBuyDiscountRes.getMarketPlan())
                .marketExpr(groupBuyDiscountRes.getMarketExpr())
                .tagId(groupBuyDiscountRes.getTagId())
                .build();

        return GroupBuyActivityDiscountVO.builder()
                .activityId(groupBuyActivityRes.getActivityId())
                .activityName(groupBuyActivityRes.getActivityName())
                .groupBuyDiscount(groupBuyDiscount)
                .groupType(groupBuyActivityRes.getGroupType())
                .takeLimitCount(groupBuyActivityRes.getTakeLimitCount())
                .target(groupBuyActivityRes.getTarget())
                .validTime(groupBuyActivityRes.getValidTime())
                .status(groupBuyActivityRes.getStatus())
                .startTime(groupBuyActivityRes.getStartTime())
                .endTime(groupBuyActivityRes.getEndTime())
                .tagId(groupBuyActivityRes.getTagId())
                .tagScope(groupBuyActivityRes.getTagScope())
                .build();
    }

    @Override
    public SkuVO querySkuByGoodsId(String goodsId) {
        Sku sku = skuDao.querySkuByGoodsId(goodsId);
        return SkuVO.builder()
                .goodsId(sku.getGoodsId())
                .goodsName(sku.getGoodsName())
                .originalPrice(sku.getOriginalPrice())
                .build();
    }


    @Override
    public SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId) {
        SCSkuActivity scSkuActivityReq = new SCSkuActivity();
        scSkuActivityReq.setSource(source);
        scSkuActivityReq.setChannel(channel);
        scSkuActivityReq.setGoodsId(goodsId);

        SCSkuActivity scSkuActivity = skuActivityDao.querySCSkuActivityBySCGoodsId(scSkuActivityReq);
        log.info("scSkuActivity信息为:{}", scSkuActivity);

        return SCSkuActivityVO.builder()
                .source(scSkuActivity.getSource())
                .activityId(scSkuActivity.getActivityId())
                .channel(scSkuActivity.getChannel())
                .goodsId(scSkuActivity.getGoodsId())
                .build();
    }
}
