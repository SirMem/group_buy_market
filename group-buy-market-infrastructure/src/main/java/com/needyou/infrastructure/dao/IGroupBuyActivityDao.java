package com.needyou.infrastructure.dao;

import com.needyou.infrastructure.dao.po.GroupBuyActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGroupBuyActivityDao {

    List<GroupBuyActivity> queryGroupBuyActivityList();

    GroupBuyActivity queryValidGroupBuyActivity (GroupBuyActivity groupBuyActivityReq);

    GroupBuyActivity queryValidGroupBuyActivityId (Long activityId);
}