package com.lustre.mall.admin.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginVO {
    @NotNull(message = "用户名不能为空")
    @Size(min = 6,message = "用户名最小长度为6")
    private String username;
    @NotNull(message = "密码不能为空")
    @Size(min = 6,max = 20,message = "密码长度8-20")
    private String password;
}
