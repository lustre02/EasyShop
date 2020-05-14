package com.lustre.mall.core.redis;

import java.util.concurrent.TimeoutException;

public class LockTemplate {

    private RedisFacade redisFacade;

    public LockTemplate(RedisFacade redisFacade) {
        this.redisFacade = redisFacade;
    }

    public Object exec(String lock, LockCall call) {
        Boolean flag = redisFacade.lock(lock);
        Object result = null;

        if (flag) {
            result = call.callback();
            redisFacade.unlock(lock);
        } else {
            int count = 0;
            try {
                while (!flag) {
                    Thread.sleep(200);
                    flag = redisFacade.lock(lock);

                    if (count++ >= 10) {
                        throw new TimeoutException();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            result = call.callback();
            redisFacade.unlock(lock);
        }
        return result;
    }

    public interface LockCall {
        Object callback();
    }
}
