package com.lustre.mall.content.controller;

import com.lustre.mall.content.api.ContentApi;
import com.lustre.mall.content.business.ContentCategoryService;
import com.lustre.mall.content.business.ContentService;
import com.lustre.mall.content.dto.BaseContentBO;
import com.lustre.mall.content.dto.CategoryListBO;
import com.lustre.mall.content.dto.CategoryTreeBO;
import com.lustre.mall.content.vo.InsertVO;
import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.state.ResponseState;
import com.lustre.mall.core.utils.ValidatorUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController implements ContentApi {

    private ContentService contentService;
    private ContentCategoryService contentCategoryService;

    public ContentController(ContentService contentService, ContentCategoryService contentCategoryService) {
        this.contentService = contentService;
        this.contentCategoryService = contentCategoryService;
    }

    @Override
    public ResponseResult<List<BaseContentBO>> pageByCid(Long cid, int pageNum, int pageSize) {
        return contentService.pageByCid(cid, pageNum, pageSize);
    }

    @Override
    public ResponseResult<List<BaseContentBO>> list() {
        return contentService.list();
    }

    @Override
    public ResponseResult<List<BaseContentBO>> ListByCid(Long cid) {
        return contentService.ListByCid(cid);
    }

    @Override
    public ResponseResult<Long> totalByCid(Long cid) {
        return contentService.totalByCid(cid);
    }

    @Override
    @PreAuthorize("hasAuthority('CONTENT_INSERT')")
    public ResponseResult<Void> insert(InsertVO vo) {
        String s = ValidatorUtil.validate(vo);
        if (s != null)
            return new ResponseResult<>(ResponseState.VALID_FAIL, s);
        else
            return contentService.insert(vo);
    }

    @Override
    public ResponseResult<Void> deleteById(Long id) {
        return contentService.deleteById(id);
    }

    @Override
    public ResponseResult<List<CategoryTreeBO>> categoryTree() {
        return contentCategoryService.categoryTree();
    }

    @Override
    public ResponseResult<List<CategoryListBO>> categoryList() {
        return contentCategoryService.categoryList();
    }
}
