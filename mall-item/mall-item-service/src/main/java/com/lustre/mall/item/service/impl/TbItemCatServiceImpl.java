package com.lustre.mall.item.service.impl;

import com.google.common.collect.Lists;
import com.lustre.mall.item.domain.TbItemCat;
import com.lustre.mall.item.domain.TbItemCatExample;
import com.lustre.mall.item.dto.CatTreeBO;
import com.lustre.mall.item.mapper.TbItemCatMapper;
import com.lustre.mall.item.service.TbItemCatService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<CatTreeBO> tree() {
        return treeByParentId(0);
    }

    private List<CatTreeBO> treeByParentId(Integer parentId){
        TbItemCatExample e = new TbItemCatExample();
        e.createCriteria().andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(e);

        List<CatTreeBO> result = Lists.newArrayList();

        tbItemCats.forEach(tbItemCat -> {
            CatTreeBO dto = new CatTreeBO();
            dto.setId(tbItemCat.getId());
            dto.setName(tbItemCat.getName());
            if (tbItemCat.getIsParent()) {
                dto.setChildren(treeByParentId(tbItemCat.getId().intValue()));
            }
            result.add(dto);
        });

        return result;
    }
}
