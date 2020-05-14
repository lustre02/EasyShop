package com.lustre.mall.content.service.impl;

import com.github.pagehelper.PageHelper;
import com.lustre.mall.content.domain.TbContent;
import com.lustre.mall.content.domain.TbContentExample;
import com.lustre.mall.content.mapper.TbContentCategoryMapper;
import com.lustre.mall.content.mapper.TbContentMapper;
import com.lustre.mall.content.service.TbContentService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentMapper tbContentMapper;
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;


    private TbContentExample getEqualCidExample(Long cid){
        TbContentExample e = new TbContentExample();
        e.createCriteria().andCategoryIdEqualTo(cid);
        e.setOrderByClause("created DESC");
        return e;
    }

    @Override
    public List<TbContent> listByCid(Long cid) {
        return tbContentMapper.selectByExample(getEqualCidExample(cid));
    }

    @Override
    public List<TbContent> pageByCid(Long cid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tbContentMapper.selectByExample(getEqualCidExample(cid));
    }

    @Override
    public List<TbContent> list() {
        return tbContentMapper.selectByExample(new TbContentExample());
    }

    @Override
    public Long countByCid(Long cid) {
        return tbContentMapper.countByExample(getEqualCidExample(cid));
    }

    @Override
    public int insert(TbContent tbContent) {
        return tbContentMapper.insertSelective(tbContent);
    }

    @Override
    public int delById(Long id) {
        return tbContentMapper.deleteByPrimaryKey(id);
    }


}
