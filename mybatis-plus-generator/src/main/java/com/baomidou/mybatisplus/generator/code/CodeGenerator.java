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
        String moduleName = "expert";
        // 要构建代码的表名
        String[] tableNames = {"exp_order", "exp_evaluate", "exp_ratings"};
        FastAutoGenerator.create(
                "jdbc:mysql://192.168.11.99:3306/zl_new", "test_root", "root123123"
            )
            // 全局配置
            .globalConfig(builder -> builder.author("lirenhao").enableSwagger())
            // 包配置
            .packageConfig(builder -> builder.parent("").xml("mapper")
                .entity(String.format("com.kejian.tool.zl.dao.%s.entity", moduleName))
                .mapper(String.format("com.kejian.tool.zl.dao.%s.mapper", moduleName))
                .service(String.format("com.kejian.tool.zl.service.%s", moduleName))
                .serviceImpl(String.format("com.kejian.tool.zl.service.%s.impl", moduleName))
                .controller(String.format("com.kejian.tool.zl.app.controller.%s", moduleName))
                .pathInfo(getPathInfo(moduleName)))
            // 策略配置
            .strategyConfig(builder -> builder.addInclude(tableNames)
                .entityBuilder()
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
