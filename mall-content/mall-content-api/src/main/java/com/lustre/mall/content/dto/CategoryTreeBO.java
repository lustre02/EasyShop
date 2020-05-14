package com.lustre.mall.content.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryTreeBO {
    /**
     * 类目ID
     */
    private Long id;


    /**
     * 分类名称
     */
    private String label;


    /**
     * 子类目
     */
    private List<CategoryTreeBO> children;
}
