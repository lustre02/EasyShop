package com.lustre.mall.item.api;

import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.item.dto.CatTreeBO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ItemCatApi {
    @GetMapping(path = "api/item/cat/tree")
    ResponseResult<List<CatTreeBO>> ItemCatTree();
}
