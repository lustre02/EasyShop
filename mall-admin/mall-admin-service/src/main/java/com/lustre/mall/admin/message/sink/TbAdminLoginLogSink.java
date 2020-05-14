package com.lustre.mall.admin.message.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TbAdminLoginLogSink {

    @Input("mall-admin-login-log-insert-topic")
    SubscribableChannel insert();

}
