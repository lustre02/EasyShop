package com.lustre.mall.admin.message.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TbAdminLoginLogSource {

    @Output("mall-admin-login-log-insert-topic")
    MessageChannel insert();

}
