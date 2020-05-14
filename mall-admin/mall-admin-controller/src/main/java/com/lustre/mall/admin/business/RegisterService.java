package com.lustre.mall.admin.business;

import com.google.common.collect.Lists;
import com.lustre.mall.admin.domain.TbAdmin;
import com.lustre.mall.admin.pojo.RegisterVO;
import com.lustre.mall.admin.service.TbAdminService;
import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.state.ResponseState;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegisterService {

    @Reference
    private TbAdminService tbAdminService;
    @Reference
    private UserDetailsManager userDetailsManager;

    private PasswordEncoder passwordEncoder;


    public RegisterService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @GlobalTransactional(name = "register")
    public ResponseResult<Void> register(RegisterVO vo) {
        try {
            //装配Admin对象
            TbAdmin tbAdmin = new TbAdmin();
            tbAdmin.setUsername(vo.getUsername());
            tbAdmin.setPassword(vo.getPassword());
            tbAdmin.setIcon(vo.getIcon());
            tbAdmin.setEmail(vo.getEmail());
            tbAdmin.setNickName(vo.getNickName());
            tbAdmin.setNote(vo.getNote());
            tbAdmin.setCreateTime(new Date());
            tbAdmin.setLoginTime(new Date());
            tbAdmin.setStatus(1);
            //装配OAuthUser对象
            List<GrantedAuthority> authorities = Lists.newArrayList();
            authorities.add(new SimpleGrantedAuthority("ADMIN_INFO"));
            authorities.add(new SimpleGrantedAuthority("CONTENT_INSERT"));
            userDetailsManager.createUser(new User(tbAdmin.getUsername(), passwordEncoder.encode(tbAdmin.getPassword()), true, true, true, true, authorities));
            tbAdminService.insert(tbAdmin);
            return new ResponseResult<>(ResponseState.OK, "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<>(ResponseState.REGISTER_FAILED, "注册失败");
    }

}
