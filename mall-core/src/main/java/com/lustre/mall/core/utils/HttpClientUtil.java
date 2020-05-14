package com.lustre.mall.core.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HttpClientUtil {

    private HttpClientBuilder httpClientBuilder;
    private static HttpClientUtil util;

    private HttpClientUtil() {
        this.httpClientBuilder = HttpClientBuilder.create();
    }

    public static HttpClientUtil getInstance() {
        if (util == null) {
            synchronized (HttpClientUtil.class) {
                if (util == null) {
                    util = new HttpClientUtil();
                }
            }
        }
        return util;
    }

    public Execute post(String url, Post f) {
        try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
            //post请求
            HttpPost post = new HttpPost(url);
            //参数
            Map<String, String> params = Maps.newHashMap();
            f.post(params);
            ArrayList<NameValuePair> nameValuePairs = Lists.newArrayList();
            params.forEach((s, s2) -> {
                nameValuePairs.add(new BasicNameValuePair(s, s2));
            });
            //设置post的请求体
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            //执行请求
            CloseableHttpResponse execute = httpClient.execute(post);
            //转成JSON字符串
            String json = EntityUtils.toString(execute.getEntity());
            return new Execute(json);
        } catch (Exception e) {
            return new Execute(e);
        }
    }

    public Execute get(String url, Get g) {
        try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
            //get
            HashMap<String, String> map = Maps.newHashMap();
            g.get(map);
            StringBuilder sb = new StringBuilder();
            map.forEach((s, s2) -> {
                sb.append(s).append("=").append(s2).append("&");
            });

            sb.deleteCharAt(sb.length() - 1);

            int i = url.indexOf("?");

            if (i == -1) {
                sb.insert(0, url + "?");
            } else if (i == url.length() - 1) {
                sb.insert(0, url);
            } else {
                sb.insert(0, url + "&");
            }
            HttpGet httpGet = new HttpGet(sb.toString());
            //参数
            //执行请求
            CloseableHttpResponse execute = httpClient.execute(httpGet);
            //转成JSON字符串
            String json = EntityUtils.toString(execute.getEntity());
            return new Execute(json);
        } catch (Exception e) {
            return new Execute(e);
        }
    }


    public interface Post {
        void post(Map<String, String> params);
    }

    public interface Get {
        void get(Map<String, String> params);
    }

    public class Execute {
        private final String result;
        private final Exception exception;

        public Execute(String result, Exception exception) {
            this.result = result;
            this.exception = exception;
        }

        public Execute(String result) {
            this(result, null);
        }

        public Execute(Exception exception) {
            this(null, exception);
        }

        public Execute then(Then then) {
            if (this.result != null) {
                then.callback(result);
            }
            return this;
        }

        public Execute error(Catch c) {
            if (this.exception != null) {
                c.callback(exception);
            }
            return this;
        }
    }

    public interface Then {
        void callback(String response);
    }

    public interface Catch {
        void callback(Exception e);
    }

}
