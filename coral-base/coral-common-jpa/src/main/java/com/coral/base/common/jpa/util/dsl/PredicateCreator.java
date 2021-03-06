package com.coral.base.common.jpa.util.dsl;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description: dsl predicat创建器
 * @author: huss
 * @time: 2020/7/14 16:00
 */
public class PredicateCreator {

    private List<Predicate> predicateList;

    public PredicateCreator() {
        this.predicateList = new ArrayList<>();
    }

    public static PredicateCreator builder() {
        return new PredicateCreator();
    }

    public PredicateCreator link(Predicate predicate) {
        if (Objects.nonNull(predicate)) {
            this.predicateList.add(predicate);
        }
        return this;
    }

    public Predicate build() {
        return ExpressionUtils.allOf(this.predicateList);
    }

}
