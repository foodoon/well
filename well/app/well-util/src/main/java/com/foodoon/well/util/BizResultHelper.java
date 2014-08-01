package com.foodoon.well.util;

import com.foodoon.tools.web.page.BizResult;
import org.springframework.util.StringUtils;

/**
 * Created by foodoon on 2014/8/1.
 */
public class BizResultHelper {

    public static void setResultCode(BizResult bizResult, String code) {
        if (!StringUtils.hasText(code)) {
            return;
        }
        bizResult.code = code;
        bizResult.msg = ErrorCode.getMessage(code);
    }
}
