package com.lustre.mall.admin.api;

import com.lustre.mall.admin.pojo.InfoBO;
import com.lustre.mall.admin.pojo.LoginBO;
import com.lustre.mall.admin.pojo.LoginVO;
import com.lustre.mall.admin.pojo.RegisterVO;
import com.lustre.mall.core.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminApi {

    @PostMapping(path = "api/admin/login")
    ResponseResult<LoginBO> login(@RequestBody LoginVO vo);

    @GetMapping(path = "api/admin/info")
    ResponseResult<InfoBO> info();

    @PostMapping(path = "api/admin/register")
    ResponseResult<Void> register(@RequestBody RegisterVO vo);

    @GetMapping(path = "api/admin/logout")
    ResponseResult<Void> logout();
}
