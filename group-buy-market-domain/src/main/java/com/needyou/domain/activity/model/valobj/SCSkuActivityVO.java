package com.needyou.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SCSkuActivityVO {

    private String source;

    private String channel;

    private Long activityId;

    private String goodsId;

}
