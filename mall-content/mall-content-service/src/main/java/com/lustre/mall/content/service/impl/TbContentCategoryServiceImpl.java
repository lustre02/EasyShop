package com.lustre.mall.content.service.impl;

import com.google.common.collect.Lists;
import com.lustre.mall.content.domain.TbContentCategory;
import com.lustre.mall.content.domain.TbContentCategoryExample;
import com.lustre.mall.content.dto.CategoryTreeBO;
import com.lustre.mall.content.mapper.TbContentCategoryMapper;
import com.lustre.mall.content.service.TbContentCategoryService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<CategoryTreeBO> treeCategory() {
        return treeByParentId(0L);
    }

    private List<CategoryTreeBO> treeByParentId(Long parentId){
        TbContentCategoryExample e = new TbContentCategoryExample();
        e.createCriteria().andParentIdEqualTo(parentId);
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(e);

        List<CategoryTreeBO> result = Lists.newArrayList();
        tbContentCategories.forEach(tbContentCategory -> {
            CategoryTreeBO dto = new CategoryTreeBO();
            dto.setId(tbContentCategory.getId());
            dto.setLabel(tbContentCategory.getName());

            if (tbContentCategory.getIsParent()) {
                dto.setChildren(treeByParentId(tbContentCategory.getId()));
            }

            result.add(dto);
        });

        return result;
    }

    @Override
    public List<TbContentCategory> listCategory() {
        return tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
    }
}
