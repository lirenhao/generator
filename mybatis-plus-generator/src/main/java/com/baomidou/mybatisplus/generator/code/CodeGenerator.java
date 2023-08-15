package com.baomidou.mybatisplus.generator.code;

/**
 * 代码生成
 */
public class CodeGenerator {

    public static void main(String[] args) {
        CodeConfig.generator("common",
            new String[]{
//                "biz_basic",
                  "biz_user_page_num"
//                "biz_open_count", "biz_use_duration", "biz_use_count", "biz_keep_day", "biz_huahua_community", "active_user"
//                "biz_spm_user", "biz_page_user", "biz_area_user",
//                "biz_os_version_device", "biz_oems_device", "biz_device_model_device", "biz_network_type_device", "biz_telco_device", "biz_app_version_device",
            }
        );
    }
}
