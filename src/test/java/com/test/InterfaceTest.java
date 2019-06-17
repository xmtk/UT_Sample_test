package com.test;

import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import com.test.tools.*;

public class InterfaceTest {
    /**
     * 检查返回值参数接口测试
     */
//    @Test
    public void checkURLParams(){
        String protocal = "http";
        String url = "httpbin.org/get";
        String key1 = "param1";
        String key2 = "param2";
        String value1 = "value1";
        String value2 = "value2";

        String requestUrl = protocal + "://" + url + "?" + key1 + "=" + value1 + "&" + key2 + "=" + value2;
        String responseString = RequestClient.doGet(requestUrl);
        JSONObject jsonObject = JSONObject.fromObject(responseString);
        String urlObj = (String)jsonObject.get("url");
        String verifyUrl = "http" + "://" + url + "?" + key1 + "=" + value1 + "&" + key2 + "=" + value2;
        Assert.assertTrue("Check URL object", urlObj.contains(verifyUrl));
    }
}
