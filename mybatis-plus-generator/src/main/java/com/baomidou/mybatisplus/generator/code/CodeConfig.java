package com.baomidou.mybatisplus.generator.code;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成
 */
public class CodeConfig {

    /**
     * 项目路径
     * System.getProperty("user.dir")
     */
    private static final String PARENT_DIR = "./build";

    /**
     * 获取路径信息map
     */
    private static Map<OutputFile, String> getPathInfo(String moduleName) {
        Map<OutputFile, String> pathInfo = new HashMap<>();
        pathInfo.put(OutputFile.entity, String.format("%s/model/entity/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.mapper, String.format("%s/dao/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.xml, String.format("%s/mapper/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.service, String.format("%s/service/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.serviceImpl, String.format("%s/service/%s/impl", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.controller, String.format("%s/manager/controller/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.dto, String.format("%s/model/dto/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.vo, String.format("%s/model/vo/%s", PARENT_DIR, moduleName));
        return pathInfo;
    }

    public static void generator(String moduleName, String[] tableNames) {
        FastAutoGenerator.create(
                "jdbc:mysql://192.168.11.21:3306/event-tracking", "event-tracking", "appmaidian"
            )
            // 全局配置
            .globalConfig(builder -> builder
                .author("lirenhao")
                .enableSwagger())
            // 其他配置
            .injectionConfig(InjectionConfig.Builder::build)
            // 包配置
            .packageConfig(builder -> builder.parent("").xml("mapper")
                .entity(String.format("com.kejian.eventTracking.backend.model.entity.%s", moduleName))
                .mapper(String.format("com.kejian.eventTracking.backend.dao.%s", moduleName))
                .service(String.format("com.kejian.eventTracking.backend.service.%s", moduleName))
                .serviceImpl(String.format("com.kejian.eventTracking.backend.service.%s.impl", moduleName))
                .controller(String.format("com.kejian.eventTracking.backend.manager.controller.%s", moduleName))
                .dto(String.format("com.kejian.eventTracking.backend.model.dto.%s", moduleName))
                .vo(String.format("com.kejian.eventTracking.backend.model.vo.%s", moduleName))
                .pathInfo(getPathInfo(moduleName)))
            // 策略配置
            .strategyConfig(builder -> builder.addInclude(tableNames)
                .entityBuilder()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .logicDeleteColumnName("deleted")
                .addSuperEntityColumns("id", "create_by", "create_time", "update_by", "update_time", "tenant_id", "deleted", "disabled", "sort")
                .formatFileName("%sEntity")
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
                .voBuilder()
                .enableFileOverride()
                .dtoBuilder()
                .enableFileOverride()
            )
            // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}
