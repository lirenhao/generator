package com.baomidou.mybatisplus.generator.code;

/**
 * 代码生成
 */
public class CodeGenerator {

    public static void main(String[] args) {
        CodeConfig.generator("sys",
            new String[]{"sys_resource", "sys_role", "sys_role_resource", "sys_user_role", "sys_login_record", "sys_log"}
        );
        CodeConfig.generator("app",
            new String[]{"app_info", "app_page", "app_spm", "app_device", "page_flow", "app_dict_type", "app_dict_data"}
        );
    }
}
