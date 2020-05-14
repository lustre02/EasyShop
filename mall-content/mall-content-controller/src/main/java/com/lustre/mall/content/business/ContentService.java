package com.lustre.mall.content.business;

import com.google.common.collect.Lists;
import com.lustre.mall.content.domain.TbContent;
import com.lustre.mall.content.dto.BaseContentBO;
import com.lustre.mall.content.service.TbContentService;
import com.lustre.mall.content.vo.InsertVO;
import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.state.ResponseState;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentService {

    @Reference
    private TbContentService tbContentService;

    private BaseContentBO toBaseContent(TbContent content) {
        BaseContentBO dto = new BaseContentBO();
        dto.setId(content.getId());
        dto.setTitle(content.getTitle());
        dto.setRedirect(content.getUrl());
        dto.setImageUrl(content.getPic());
        dto.setContent(content.getContent());
        return dto;
    }

    private List<BaseContentBO> toBaseContentList(List<TbContent> list) {
        List<BaseContentBO> result = Lists.newArrayList();
        list.forEach(tbContent -> {
            result.add(toBaseContent(tbContent));
        });
        return result;
    }

    public ResponseResult<List<BaseContentBO>> pageByCid(Long cid, int pageNum, int pageSize) {
        List<BaseContentBO> data = toBaseContentList(tbContentService.pageByCid(cid, pageNum, pageSize));
        return new ResponseResult<>(ResponseState.OK, "查询成功", data);
    }

    public ResponseResult<List<BaseContentBO>> list() {
        List<BaseContentBO> data = toBaseContentList(tbContentService.list());
        return new ResponseResult<>(ResponseState.OK, "查询成功", data);
    }

    public ResponseResult<List<BaseContentBO>> ListByCid(Long cid) {
        List<BaseContentBO> data = toBaseContentList(tbContentService.listByCid(cid));
        return new ResponseResult<>(ResponseState.OK, "查询成功", data);
    }

    public ResponseResult<Long> totalByCid(Long cid) {
        Long data = tbContentService.countByCid(cid);
        return new ResponseResult<>(ResponseState.OK, "查询成功", data);
    }

    public ResponseResult<Void> insert(InsertVO vo) {
        TbContent tbContent = new TbContent();
        tbContent.setCategoryId(vo.getCategoryId());
        tbContent.setTitle(vo.getTitle());
        tbContent.setTitleDesc(vo.getTitle());
        tbContent.setUrl(vo.getRedirect());
        tbContent.setPic(vo.getImageUrl());
        tbContent.setContent(vo.getContent());
        tbContent.setCreated(new Date());
        tbContent.setUpdated(new Date());
        int i = tbContentService.insert(tbContent);
        if (i > 0) {
            return new ResponseResult<>(ResponseState.OK, "新增成功");
        }
        return new ResponseResult<>(ResponseState.INSERT_FAILED, "新增失败");
    }

    public ResponseResult<Void> deleteById(Long id) {
        int i = tbContentService.delById(id);
        if (i > 0) {
            return new ResponseResult<>(ResponseState.OK, "删除成功");
        }
        return new ResponseResult<>(ResponseState.DELETE_FAILED, "删除失败");
    }

}
