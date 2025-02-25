package com.baomidou.mybatisplus.generator.code.energy;

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
        pathInfo.put(OutputFile.entity, String.format("%s/model/entity/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.mapper, String.format("%s/dao/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.xml, String.format("%s/mapper/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.service, String.format("%s/service/%s", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.serviceImpl, String.format("%s/service/%s/impl", PARENT_DIR, moduleName));
        pathInfo.put(OutputFile.controller, String.format("%s/manager/controller/%s", PARENT_DIR, moduleName));
        return pathInfo;
    }

    public static void main(String[] args) {
        String moduleName = "sys";
        // 要构建代码的表名
        String[] tableNames = {"sys_org"};
        FastAutoGenerator.create(
                "jdbc:mysql://47.92.67.211:8267/kejian-framework-energy", "root", "daidaihuanbao2020"
            )
            // 全局配置
            .globalConfig(builder -> builder.author("lirenhao").enableSwagger())
            // 包配置
            .packageConfig(builder -> builder.parent("").xml("mapper")
                .entity(String.format("com.kejian.framework.energy.model.entity.%s", moduleName))
                .mapper(String.format("com.kejian.framework.energy.dao.%s", moduleName))
                .service(String.format("com.kejian.framework.energy.service.%s", moduleName))
                .serviceImpl(String.format("com.kejian.framework.energy.service.%s.impl", moduleName))
                .controller(String.format("com.kejian.framework.energy.manager.controller.%s", moduleName))
                .pathInfo(getPathInfo(moduleName)))
            // 策略配置
            .strategyConfig(builder -> builder.addInclude(tableNames)
                .entityBuilder()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .logicDeleteColumnName("deleted")
                .idType(IdType.ASSIGN_ID)
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                .controllerBuilder()
                .enableRestStyle()
                .formatFileName("%sController")
                .serviceBuilder()
                .superServiceClass(IService.class)
                .formatServiceFileName("I%sService")
                .formatServiceImplFileName("%sServiceImp")
                .mapperBuilder()
                .enableBaseResultMap()
                .enableBaseColumnList()
                .superClass(BaseMapper.class)
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
            )
            // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}
