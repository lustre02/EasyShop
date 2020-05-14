package com.lustre.mall.admin.pojo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterVO {

    @NotNull(message = "用户名不能为空")
    @Size(min = 6,message = "用户名最小长度为6")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(min = 6,max = 20,message = "密码长度8-20")
    private String password;

    /**
     * 头像
     */
    @NotBlank(message = "头像不能为空")
    private String icon;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    /**
     * 备注信息
     */
    private String note;
}
