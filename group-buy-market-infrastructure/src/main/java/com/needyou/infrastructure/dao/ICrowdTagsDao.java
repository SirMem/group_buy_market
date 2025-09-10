package com.needyou.infrastructure.dao;

import com.needyou.infrastructure.dao.po.CrowdTags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICrowdTagsDao {

    void updateCrowdTagsStatistics(CrowdTags crowdTagsReq);
}
