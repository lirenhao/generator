package com.baomidou.mybatisplus.generator.code;

/**
 * 代码生成
 */
public class CodeGenerator {

    public static void main(String[] args) {
        CodeConfig.generator("sys",
            new String[]{"sys_org", "sys_org_expend", "sys_resource", "sys_role", "sys_role_resource", "sys_user_role", "sys_login_record"}
        );

        CodeConfig.generator("contract",
            new String[]{"contract", "contract_price", "contract_active", "contract_resume"}
        );

        CodeConfig.generator("complex",
            new String[]{"contract", "contract_price", "contract_active", "contract_resume"}
        );

        CodeConfig.generator("base",
            new String[]{"base_seq", "base_app"}
        );

        CodeConfig.generator("delivery",
            new String[]{"delivery"}
        );
    }
}
