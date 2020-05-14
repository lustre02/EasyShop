package com.lustre.mall.admin.controller;

import com.lustre.mall.admin.api.AdminApi;
import com.lustre.mall.admin.business.InfoService;
import com.lustre.mall.admin.business.AuthService;
import com.lustre.mall.admin.business.RegisterService;
import com.lustre.mall.admin.pojo.InfoBO;
import com.lustre.mall.admin.pojo.LoginBO;
import com.lustre.mall.admin.pojo.LoginVO;
import com.lustre.mall.admin.pojo.RegisterVO;
import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.state.ResponseState;
import com.lustre.mall.core.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController implements AdminApi {

    private AuthService authService;

    private InfoService infoService;

    private RegisterService registerService;

    public AdminController(AuthService authService, InfoService infoService, RegisterService registerService) {
        this.authService = authService;
        this.infoService = infoService;
        this.registerService = registerService;
    }

    @Override
    public ResponseResult<LoginBO> login(LoginVO vo) {
        String s = ValidatorUtil.validate(vo);
        if (s != null) {
            return new ResponseResult<LoginBO>(ResponseState.VALID_FAIL, s);
        }
        return authService.login(vo);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN_INFO')")
    public ResponseResult<InfoBO> info() {
        return infoService.info(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public ResponseResult<Void> register(RegisterVO vo) {
        String validate = ValidatorUtil.validate(vo);
        if (validate != null) {
            return new ResponseResult<>(ResponseState.VALID_FAIL,validate);
        }
        return registerService.register(vo);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN_INFO')")
    public ResponseResult<Void> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authService.logout(authentication);
    }
}
