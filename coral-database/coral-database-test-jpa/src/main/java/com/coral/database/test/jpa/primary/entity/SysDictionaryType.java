package com.coral.database.test.jpa.primary.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


import com.coral.base.common.jpa.entity.IdAndStatusKey;
import lombok.Data;
import lombok.ToString;

/**
 * @description: 字典类型
 * @author: huss
 * @time: 2020/7/13 11:08
 */
@Entity
@Table
@Data
@ToString(callSuper = true)
public class SysDictionaryType extends IdAndStatusKey {

    private String no;

    private String name;
    private Long id;

}
