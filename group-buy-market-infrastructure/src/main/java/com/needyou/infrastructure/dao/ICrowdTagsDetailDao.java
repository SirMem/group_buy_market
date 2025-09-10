package com.needyou.infrastructure.dao;

import com.needyou.infrastructure.dao.po.CrowdTagsDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICrowdTagsDetailDao {

    void addCrowdTagsUserId(CrowdTagsDetail crowdTagsDetailReq);
}
