package com.needyou.test.trigger;

import com.alibaba.fastjson.JSON;
import com.needyou.api.dto.GoodsMarketRequestDTO;
import com.needyou.api.dto.GoodsMarketResponseDTO;
import com.needyou.api.response.Response;
import com.needyou.trigger.http.MarketIndexController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketIndexControllerTest {

    @Resource
    private MarketIndexController marketIndexController;

    @Test
    public void test_queryGroupBuyMarketConfig() {
        GoodsMarketRequestDTO requestDTO = new GoodsMarketRequestDTO();
        requestDTO.setSource("s01");
        requestDTO.setChannel("c01");
        requestDTO.setUserId("xfg01");
        requestDTO.setGoodsId("9890001");

        Response<GoodsMarketResponseDTO> response = marketIndexController.queryGroupBuyMarketConfig(requestDTO);

        log.info("请求参数:{}", JSON.toJSONString(requestDTO));
        log.info("应答结果:{}", JSON.toJSONString(response));
    }

}
