package com.lustre.mall.item.controller;

import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.item.api.ItemCatApi;
import com.lustre.mall.item.business.ItemCatService;
import com.lustre.mall.item.dto.CatTreeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemCatController implements ItemCatApi {

    @Autowired
    private ItemCatService itemCatService;

    @Override
    public ResponseResult<List<CatTreeBO>> ItemCatTree() {
        return itemCatService.ItemCatTree();
    }
}
