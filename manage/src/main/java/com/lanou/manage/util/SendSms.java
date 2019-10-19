package com.lanou.manage.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.Test;

import java.util.Random;

public class SendSms {
    @Test
    public void Test1(){

        System.out.println(sendMsg("18552147229"));
    }
    public static String sendMsg(String telphone){
        String code = code();
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FcNUp6wHjES9GKd9ekZ", "ZE7Wn8sLIBcSeKfmh3kr852ix6kJdV");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telphone);
        request.putQueryParameter("SignName", "转圈圈");
        request.putQueryParameter("TemplateCode", "SMS_175542100");
        request.putQueryParameter("TemplateParam", "{\"code\":" +code+"}");
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }
    //随机生产4位验证码
    public static String code(){
        int c = (int) Math.round(Math.random() * (9999-1000) +1000);
        return String.valueOf(c);
    }
}
