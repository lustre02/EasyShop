package com.lustre.mall.item.dto;

import lombok.Data;

import java.util.List;

@Data
public class CatTreeBO {
    /**
     * 类目ID
     */
    private Long id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 子类目
     */
    private List<CatTreeBO> children;

}
