package com.needyou.infrastructure.dao;

import com.needyou.infrastructure.dao.po.CrowdTagsJob;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICrowdTagsJobDao {
    CrowdTagsJob queryCrowdTagsJob(CrowdTagsJob crowdTagsJobReq);
}
