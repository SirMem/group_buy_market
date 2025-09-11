package com.needyou.api.dto;

import com.needyou.api.response.Response;

public interface IDCCService {
    Response<Boolean> updateConfig(String key, String value);
}
