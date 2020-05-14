package com.lustre.mall.content.api;

import com.lustre.mall.content.dto.BaseContentBO;
import com.lustre.mall.content.dto.CategoryListBO;
import com.lustre.mall.content.dto.CategoryTreeBO;
import com.lustre.mall.content.vo.InsertVO;
import com.lustre.mall.core.dto.ResponseResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContentApi {

    @GetMapping("api/content/page/{cid}")
    ResponseResult<List<BaseContentBO>> pageByCid(
            @PathVariable("cid") Long cid,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "4") int pageSize);

    @GetMapping("api/content/list")
    ResponseResult<List<BaseContentBO>> list();

    @GetMapping("api/content/list/{cid}")
    ResponseResult<List<BaseContentBO>> ListByCid(@PathVariable("cid") Long cid);

    @GetMapping("api/content/total/{cid}")
    ResponseResult<Long> totalByCid(@PathVariable("cid") Long cid);

    @PostMapping("api/content/insert")
    ResponseResult<Void> insert(@RequestBody InsertVO vo);

    @GetMapping("api/content/delete/{id}")
    ResponseResult<Void> deleteById(@PathVariable("id") Long id);

    @GetMapping("/api/content/category/tree")
    ResponseResult<List<CategoryTreeBO>> categoryTree();

    @GetMapping("/api/content/category/list")
    ResponseResult<List<CategoryListBO>> categoryList();

}
