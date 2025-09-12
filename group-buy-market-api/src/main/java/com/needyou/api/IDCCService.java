package com.needyou.api;

import com.needyou.api.response.Response;

public interface IDCCService {
    Response<Boolean> updateConfig(String key, String value);
}
