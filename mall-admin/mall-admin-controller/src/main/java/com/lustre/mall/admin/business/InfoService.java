package com.lustre.mall.admin.business;

import com.google.common.collect.Lists;
import com.lustre.mall.admin.domain.TbAdmin;
import com.lustre.mall.admin.pojo.InfoBO;
import com.lustre.mall.admin.service.TbAdminService;
import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.state.ResponseState;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Reference
    private TbAdminService tbAdminService;

    public ResponseResult<InfoBO> info(String username) {
        TbAdmin admin = tbAdminService.getByUsername(username);
        if (admin != null) {
            InfoBO dto = new InfoBO();
            dto.setRoles(Lists.newArrayList());
            dto.setAvatar(admin.getIcon());
            dto.setName(admin.getNickName());
            dto.setIntroduction(admin.getNote());
            return new ResponseResult<InfoBO>(ResponseState.OK, "查询用户信息成功", dto);
        }
        return new ResponseResult<InfoBO>(ResponseState.USER_NOTFOUND, "用户不存在");
    }

}
