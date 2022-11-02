package com.baomidou.mybatisplus.generator.config.builder;

import com.baomidou.mybatisplus.generator.ITemplate;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.function.ConverterFileName;
import com.baomidou.mybatisplus.generator.util.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dto implements ITemplate {

    private final static Logger LOGGER = LoggerFactory.getLogger(Dto.class);

    private String[] dtoTypes = new String[]{"Query", "Insert", "Update", "Delete"};

    private ConverterFileName converterQueryDtoFileName = (entityName -> entityName + "Query" + ConstVal.DTO);

    private ConverterFileName converterInsertDtoFileName = (entityName -> entityName + "Insert" + ConstVal.DTO);

    private ConverterFileName converterUpdateDtoFileName = (entityName -> entityName + "Update" + ConstVal.DTO);

    private ConverterFileName converterDeleteDtoFileName = (entityName -> entityName + "Delete" + ConstVal.DTO);

    /**
     * 是否覆盖已有文件（默认 false）
     *
     * @since 3.5.2
     */
    private boolean fileOverride;

    private Dto() {
    }

    public ConverterFileName getConverterQueryDtoFileName() {
        return converterQueryDtoFileName;
    }

    public ConverterFileName getConverterInsertDtoFileName() {
        return converterInsertDtoFileName;
    }

    public ConverterFileName getConverterUpdateDtoFileName() {
        return converterUpdateDtoFileName;
    }

    public ConverterFileName getConverterDeleteDtoFileName() {
        return converterDeleteDtoFileName;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    @Override
    @NotNull
    public Map<String, Object> renderData(@NotNull TableInfo tableInfo) {
        Map<String, Object> data = new HashMap<>();
        return data;
    }

    public static class Builder extends BaseBuilder {

        private final Dto dto = new Dto();

        public Builder(@NotNull StrategyConfig strategyConfig) {
            super(strategyConfig);
        }

        /**
         * 覆盖已有文件（该方法后续会删除，替代方法为enableFileOverride方法）
         *
         * @see #enableFileOverride()
         */
        @Deprecated
        public Builder fileOverride() {
            LOGGER.warn("fileOverride方法后续会删除，替代方法为enableFileOverride方法");
            this.dto.fileOverride = true;
            return this;
        }

        /**
         * 覆盖已有文件
         */
        public Builder enableFileOverride() {
            this.dto.fileOverride = true;
            return this;
        }

        @NotNull
        public Dto get() {
            return this.dto;
        }
    }
}
