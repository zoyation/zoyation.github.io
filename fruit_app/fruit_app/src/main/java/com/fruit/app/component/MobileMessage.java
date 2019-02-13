package com.fruit.app.component;

import com.fruit.app.constant.MessageConstants;
import com.fruit.app.util.LogUtil;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送工具类
 * Created by zoyation on 2017-09-05.
 */
@Component
public class MobileMessage extends MessageTemplate {
    private static final Logger logger = LoggerFactory.getLogger(MobileMessage.class);
    private static Map<Integer, String> resultMsg = new HashMap<Integer, String>();

    static {
        resultMsg.put(-1, "没有该用户账户");
        resultMsg.put(-2, "接口密钥不正确 [查看密钥] 不是账户登陆密码");
        resultMsg.put(-21, "MD5接口密钥加密不正确");
        resultMsg.put(-3, "短信数量不足");
        resultMsg.put(-11, "该用户被禁用");
        resultMsg.put(-14, "短信内容出现非法字符");
        resultMsg.put(-4, "手机号格式不正确");
        resultMsg.put(-41, "手机号码为空");
        resultMsg.put(-42, "短信内容为空");
        resultMsg.put(-51, "短信签名格式不正确 接口签名格式为：【签名内容】");
        resultMsg.put(-6, "IP限制");
    }

    @Override
    public MsgResult sendMsg(String destination, String message) {
        MsgResult msgResult = new MsgResult();
        msgResult.setSuccess(true);
        HttpPost post = new HttpPost();
        HttpClient client = HttpClients.createDefault();
        RequestBuilder requestBuilder = RequestBuilder.post(propertiesConfig.getMobileUri());
        requestBuilder.addHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType() + ";charset=utf8");

        //本站用户名（如您无本站用户名请先注册）
        BasicNameValuePair uid = new BasicNameValuePair("Uid", propertiesConfig.getMobileUid());
        //注册时填写的接口秘钥（可到用户平台修改接口秘钥）如需要加密参数，请把Key变量名改成KeyMD5，KeyMD5=接口秘钥32位MD5加密，大写。
        BasicNameValuePair key = new BasicNameValuePair("Key", propertiesConfig.getMobileUidKey());

        //NameValuePair[] data ={ new NameValuePair("Uid", "本站用户名"),new NameValuePair("Key", "接口安全秘钥"),new NameValuePair("smsMob","手机号码"),new NameValuePair("smsText","验证码：8888")};
        //目的手机号码（多个手机号请用半角逗号隔开） 手机号
        BasicNameValuePair smsMob = new BasicNameValuePair("smsMob", destination);
        //短信内容，最多支持400个字，普通短信70个字/条，长短信64个字/条计费
        BasicNameValuePair smsText = new BasicNameValuePair("smsText", message);
        requestBuilder.addParameters(uid, key, smsMob, smsText);
        HttpUriRequest request = requestBuilder.build();
        //调用接口
        HttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(request);
            //处理返回结果
            Header[] headers = httpResponse.getAllHeaders();
            //通过响应对象获取响应码
            int statusCode = httpResponse.getStatusLine().getStatusCode();

            System.out.println("statusCode:" + statusCode);

            for (Header h : headers) {
                System.out.println(h.toString());
            }
            //如果响应码为200（成功响应码），则获取服务器返回的数据
            if (statusCode == HttpStatus.SC_OK) {
                //9.1：获取HttpEntity对象（通过响应来获取）
                HttpEntity entity = httpResponse.getEntity();
                //10：使用EntityUtils工具类，将获取到的数据（实体）转换为字节数组形式，任何文件都可以以字节的形式保存
                byte[] b = EntityUtils.toByteArray(entity);
                //输出内容
                String result = new String(b, Consts.UTF_8);
                int resultInt = Integer.parseInt(result);
                System.out.println(result);
                if (resultInt <= 0) {
                    //短信发送失败
                    String messageCode = Integer.toString(resultInt);
                    msgResult.setSuccess(false);
                    msgResult.setErrorCode(messageCode);
                    String backMsg = resultMsg.get(messageCode);
                    msgResult.setMsg(backMsg);
                    logger.error("发送短信失败：" + backMsg);
                }
            } else {
                //短信发送失败
                msgResult.setSuccess(false);
                msgResult.setErrorCode("statusCode:" + statusCode);
                msgResult.setMsg(localeMessageSource.getMessage(MessageConstants.SEND_PHONE_MSG_ERROR));
            }
        } catch (IOException e) {
            e.printStackTrace();
            String stackMsg = LogUtil.getStackMsg(e);
            logger.error("发送短信异常：" + stackMsg);
            msgResult.setSuccess(false);
            msgResult.setErrorCode(MessageConstants.SEND_PHONE_MSG_ERROR);
            msgResult.setMsg(localeMessageSource.getMessage(MessageConstants.SEND_PHONE_MSG_ERROR));
        }
        return msgResult;
    }
}