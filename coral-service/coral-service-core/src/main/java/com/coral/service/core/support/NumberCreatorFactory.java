package com.coral.service.core.support;

import com.coral.base.common.SnowFlakeCreator;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * @description: 创建分布式唯一编号
 * @author: huss
 * @time: 2020/7/7 17:33
 */
public class NumberCreatorFactory {

    @Getter(AccessLevel.PRIVATE)
    private SnowFlakeCreator snowFlakeCreator;

    public NumberCreatorFactory(SnowFlakeCreator snowFlakeCreator) {
        this.snowFlakeCreator = snowFlakeCreator;
    }

    /**
     * 创建分布式唯一编号
     * 
     * @return
     */
    public Long createUniqueNo() {
        return this.getSnowFlakeCreator().nextId();
    }

}
