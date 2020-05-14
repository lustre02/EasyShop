package com.lustre.mall.admin.business;

import com.lustre.mall.admin.domain.TbAdmin;
import com.lustre.mall.admin.domain.TbAdminLoginLog;
import com.lustre.mall.admin.message.sender.TbAdminLoginLogSender;
import com.lustre.mall.admin.pojo.LoginBO;
import com.lustre.mall.admin.pojo.LoginVO;
import com.lustre.mall.admin.service.TbAdminService;
import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.state.ResponseState;
import com.lustre.mall.core.utils.HttpClientUtil;
import com.lustre.mall.core.utils.MapperUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Service
public class AuthService {

    @Reference
    private TbAdminService tbAdminService;

    private final String accessTokenUri = "http://localhost/oauth/token";
    private final String clientId = "myshop";
    private final String clientSecret = "secret";

    private TbAdminLoginLogSender sender;

    private TokenStore tokenStore;

    public AuthService(TbAdminLoginLogSender sender, TokenStore tokenStore) {
        this.sender = sender;
        this.tokenStore = tokenStore;
    }

    public ResponseResult<LoginBO> login(LoginVO vo) {
        TbAdmin admin = tbAdminService.getByUsername(vo.getUsername());
        if (admin != null) {
            LoginBO token = token(vo.getUsername(), vo.getPassword());
            if (token.getToken() != null) {
                sendLoginLog(admin.getId());
                return new ResponseResult<>(ResponseState.OK, "登陆成功", token);
            }
            return new ResponseResult<LoginBO>(ResponseState.WRONG_LOGIN, "用户名或密码错误");
        } else {
            return new ResponseResult<>(ResponseState.USER_NOTFOUND, "用户不存在");
        }
    }

    /**
     * 获取OAuth认证服务器token
     *
     * @param username
     * @param password
     * @return
     */
    private LoginBO token(String username, String password) {
        LoginBO dto = new LoginBO();
        HttpClientUtil.getInstance().post(accessTokenUri, params -> {
            params.put("username", username);
            params.put("password", password);
            params.put("client_secret", clientSecret);
            params.put("client_id", clientId);
            params.put("grant_type", "password");
        }).then(response -> {
            Map<String, String> map = MapperUtil.toMap(response, String.class);
            if (map.get("access_token") != null) {
                dto.setToken(map.get("access_token"));
            }
        }).error(Exception::printStackTrace);
        return dto;
    }

    /**
     * 发送到消息队列
     *
     * @param adminId
     */
    private void sendLoginLog(Long adminId) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        TbAdminLoginLog log = new TbAdminLoginLog();
        log.setAdminId(adminId.intValue());
        log.setCreateTime(new Date());
        log.setUserAgent(request.getHeader("user-agent"));
        log.setIp(request.getHeader("x-forwarded-for"));
        log.setAddress(request.getHeader("x-forwarded-for"));
        sender.sendLog(log);
    }

    /**
     * 注销
     *
     * @param authentication
     * @return
     */
    public ResponseResult<Void> logout(Authentication authentication) {
        OAuth2AccessToken accessToken = tokenStore.getAccessToken((OAuth2Authentication) authentication);
        tokenStore.removeAccessToken(accessToken);
        return new ResponseResult<>(ResponseState.OK, "注销成功");
    }
}
