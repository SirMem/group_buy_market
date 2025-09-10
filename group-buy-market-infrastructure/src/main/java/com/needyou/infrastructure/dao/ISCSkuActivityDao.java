package com.needyou.infrastructure.dao;

import com.needyou.infrastructure.dao.po.SCSkuActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISCSkuActivityDao {

    SCSkuActivity querySCSkuActivityBySCGoodsId(SCSkuActivity scSkuActivity);
}
