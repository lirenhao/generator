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
        pathInfo.put(OutputFile.entity, String.format("%s/model/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.mapper, String.format("%s/dao/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.xml, String.format("%s/mapper/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.service, String.format("%s/service", PARENT_DIR));
        pathInfo.put(OutputFile.serviceImpl, String.format("%s/service/impl", PARENT_DIR));
        pathInfo.put(OutputFile.controller, String.format("%s/schedule", PARENT_DIR));
        pathInfo.put(OutputFile.dto, String.format("%s/model/dto/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.vo, String.format("%s/model/vo/%s", PARENT_DIR, moduleName));
        return pathInfo;
    }

    public static void generator(String moduleName, String[] tableNames) {
        FastAutoGenerator.create(
                "jdbc:mysql://192.168.11.21:3306/event-tracking-common", "event-tracking-common", "kejiankeji"
            )
            // 全局配置
            .globalConfig(builder -> builder
                .author("lirenhao")
                .enableSwagger())
            // 其他配置
            .injectionConfig(InjectionConfig.Builder::build)
            // 包配置
            .packageConfig(builder -> builder.parent("").xml("mapper")
                .entity(String.format("com.kejian.eventTracking.umeng.model.%s", moduleName))
                .mapper(String.format("com.kejian.eventTracking.umeng.dao.%s", moduleName))
                .service("com.kejian.eventTracking.umeng.service")
                .serviceImpl("com.kejian.eventTracking.umeng.service.impl")
                .controller("com.kejian.eventTracking.umeng.schedule")
                .pathInfo(getPathInfo(moduleName)))
            // 策略配置
            .strategyConfig(builder -> builder.addInclude(tableNames)
                .entityBuilder()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .formatFileName("%s")
                .enableFileOverride()
                .controllerBuilder()
                .enableRestStyle()
                .formatFileName("%sSchedule")
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
                .formatMapperFileName("%sDao")
                .formatXmlFileName("%sMapper")
                .enableFileOverride()
            )
            // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}
