package com.coral.web.core.json;


import com.coral.base.common.DatePattern;
import com.coral.base.common.json.module.BladeJavaTimeModule;
import com.coral.base.common.json.module.EnumModule;
import com.coral.base.common.json.module.ParameterNamesModule;
import com.coral.base.common.json.module.String2EscapeHtml4Module;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author huss
 */
public class MyJackson2ObjectMapperBuilder extends Jackson2ObjectMapperBuilder {
    private static final Locale CHINA = Locale.CHINA;

    public MyJackson2ObjectMapperBuilder() {
        // 设置地点为中国
        super.locale(CHINA);
        // 去掉默认的时间戳格式
        super.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 设置为中国上海时区
        super.timeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        // 序列化时，日期的统一格式
        super.dateFormat(new SimpleDateFormat(DatePattern.PATTERN_DATETIME, Locale.CHINA));

        // 失败处理
        super.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        super.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 单引号处理
        super.featuresToEnable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);

        // 禁用科学计数法
        super.featuresToEnable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
        super.featuresToEnable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        // 日期格式化
        super.modules(new ParameterNamesModule(), new BladeJavaTimeModule(), new EnumModule(),
            new String2EscapeHtml4Module());
        // 属性可视化范围
        // super.visibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PUBLIC_ONLY);
    }

    public static Jackson2ObjectMapperBuilder json() {
        return new MyJackson2ObjectMapperBuilder();
    }
}
