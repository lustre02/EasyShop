package com.lustre.mall.content.service;

import com.lustre.mall.content.domain.TbContentCategory;
import com.lustre.mall.content.dto.CategoryTreeBO;

import java.util.List;

public interface TbContentCategoryService {
    /**
     * 内容类目树
     * @return
     */
    List<CategoryTreeBO> treeCategory();

    /**
     * 内容类目列表
     * @return
     */
    List<TbContentCategory> listCategory();
}
