package com.lustre.mall.content.business;

import com.google.common.collect.Lists;
import com.lustre.mall.content.domain.TbContentCategory;
import com.lustre.mall.content.dto.CategoryListBO;
import com.lustre.mall.content.dto.CategoryTreeBO;
import com.lustre.mall.content.service.TbContentCategoryService;
import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.state.ResponseState;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentCategoryService {

    @Reference
    private TbContentCategoryService tbContentCategoryService;


    public ResponseResult<List<CategoryTreeBO>> categoryTree() {
        List<CategoryTreeBO> data = tbContentCategoryService.treeCategory();
        return new ResponseResult<>(ResponseState.OK, "查询成功", data);
    }

    public ResponseResult<List<CategoryListBO>> categoryList() {
        List<TbContentCategory> list = tbContentCategoryService.listCategory();
        List<CategoryListBO> data = Lists.newArrayList();
        list.forEach(tbContentCategory -> {
            CategoryListBO dto = new CategoryListBO();
            dto.setId(tbContentCategory.getId());
            dto.setName(tbContentCategory.getName());
            data.add(dto);
        });
        return new ResponseResult<>(ResponseState.OK, "查询成功", data);
    }

}
