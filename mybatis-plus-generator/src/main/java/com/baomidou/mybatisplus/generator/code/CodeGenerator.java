package com.baomidou.mybatisplus.generator.code;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成
 */
public class CodeGenerator {

    /**
     * 项目路径
     * System.getProperty("user.dir")
     */
    private static final String PARENT_DIR = "./build";

    /**
     * 获取路径信息map
     *
     * @return {@link Map< OutputFile, String> }
     * @author MK
     * @date 2022/4/21 21:21
     */
    private static Map<OutputFile, String> getPathInfo(String moduleName) {
        Map<OutputFile, String> pathInfo = new HashMap<>();
        pathInfo.put(OutputFile.entity, String.format("%s/dao/%s/entity", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.mapper, String.format("%s/dao/%s/mapper", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.xml, String.format("%s/mapper/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.service, String.format("%s/service/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.serviceImpl, String.format("%s/service/%s/impl", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.controller, String.format("%s/manager/controller/%s", PARENT_DIR, moduleName));
        return pathInfo;
    }

    public static void main(String[] args) {
        String moduleName = "patient";
        // 要构建代码的表名
        String[] tableNames = {"tre_lesson_plan", "fd_face_record", "fd_evaluate", "sys_patient", "patient_collect_type", "patient_collect_item", "patient_collect_info", "patient_tenant"};
        FastAutoGenerator.create(
                "jdbc:mysql://192.168.11.21:3306/zl_new", "zhiliao", "zhiliaoproject002"
            )
            // 全局配置
            .globalConfig(builder -> builder.author("lirenhao").enableSwagger())
            // 包配置
            .packageConfig(builder -> builder.parent("").xml("mapper")
                .entity(String.format("com.daidai.zlbackend.dao.%s.entity", moduleName))
                .mapper(String.format("com.daidai.zlbackend.dao.%s.mapper", moduleName))
                .service(String.format("com.daidai.zlbackend.service.%s", moduleName))
                .serviceImpl(String.format("com.daidai.zlbackend.service.%s.impl", moduleName))
                .controller(String.format("com.daidai.zlbackend.web.controller.%s", moduleName))
                .pathInfo(getPathInfo(moduleName)))
            // 策略配置
            .strategyConfig(builder -> builder.addInclude(tableNames)
                .entityBuilder()
                .logicDeleteColumnName("deleted")
                .addTableFills(new Column("create_time", FieldFill.INSERT), new Column("update_time", FieldFill.INSERT_UPDATE))
                .formatFileName("%sDO")
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .idType(IdType.ASSIGN_ID)
                .enableFileOverride()
                .controllerBuilder()
                .enableRestStyle()
                .formatFileName("%sController")
                .enableFileOverride()
                .serviceBuilder()
                .superServiceClass(IService.class)
                .formatServiceFileName("I%sService")
                .formatServiceImplFileName("%sServiceImpl")
                .enableFileOverride()
                .mapperBuilder()
                .enableBaseResultMap()
                .enableBaseColumnList()
                .superClass(BaseMapper.class)
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
                .enableFileOverride()
            )
            // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}
