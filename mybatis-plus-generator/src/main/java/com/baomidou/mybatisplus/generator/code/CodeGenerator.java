package com.baomidou.mybatisplus.generator.code;

/**
 * 代码生成
 */
public class CodeGenerator {

    public static void main(String[] args) {
        CodeConfig.generator("common",
            new String[]{
                "biz_basic",
                "biz_scm", "biz_page", "biz_area", "biz_os_version", "biz_oems", "biz_device_model", "biz_network_type", "biz_telco", "biz_app_version",
                "biz_open_count", "biz_use_duration", "biz_use_count", "biz_keep_day", "biz_huahua_community"
            }
        );
    }
}
