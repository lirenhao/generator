package com.baomidou.mybatisplus.generator.code;

/**
 * 代码生成
 */
public class CodeGenerator {

    public static void main(String[] args) {
        CodeConfig.generator("material",
            new String[]{"material_label", "material_image", "material_video", "material_label_relation"}
        );
        CodeConfig.generator("client",
            new String[]{"client_user"}
        );
        CodeConfig.generator("qnr",
            new String[]{"qnr_questionnaire", "qnr_question", "qnr_question_option"}
        );
        CodeConfig.generator("scale",
            new String[]{"scale_type", "scale_info"}
        );
        CodeConfig.generator("rights",
            new String[]{"rights_info", "rights_order", "rights_refund", "rights_scale_relation"}
        );
    }
}
