package club.gude.api.Authorize;

import club.gude.utils.http.OkHttpUtil;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static club.gude.utils.http.OkHttpUtil.syncGet;
import static java.security.KeyRep.Type.SECRET;

/**
 * @Author Gude
 * @Date 2016/4/20.
 * 网页授权
 */
public class AuthorizeApi {
    /**
     * 通过code换取网页授权access_token
     *
     * @param code
     * @param appid    公众号的唯一标识
     * @param appsecre
     * @return { "access_token":"ACCESS_TOKEN",
     * "expires_in":7200,
     * "refresh_token":"REFRESH_TOKEN",
     * "openid":"OPENID",
     * "scope":"SCOPE" }
     */
    public static String codeExchangeToken(String code, String appid, String appsecre) throws IOException {
        String url = " https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + appsecre + "&code=" + code + "&grant_type=authorization_code ";
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();
    }

    /**
     * 刷新access_token（如果需要）
     *
     * @param appid         公众号的唯一标识
     * @param refresh_token 填写通过access_token获取到的refresh_token参数
     * @throws IOException
     * @return{ "access_token":"ACCESS_TOKEN",
     * "expires_in":7200,
     * "refresh_token":"REFRESH_TOKEN",
     * "openid":"OPENID",
     * "scope":"SCOPE" }
     */
    public static String refreshToken(String appid, String refresh_token) throws IOException {
        String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + appid + "&grant_type=refresh_token&refresh_token=" + refresh_token;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     *
     * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid       用户的唯一标识
     * @return
     */
    public static String getUserInfo(String access_token, String openid) throws IOException {
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid + "&lang=zh_CN";
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();
    }

    /**
     * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid       用户的唯一标识
     * @param lang         国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     * @throws IOException
     */
    public static String getUserInfoByLang(String access_token, String openid, String lang) throws IOException {
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid + "&lang=" + lang;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();
    }

    /**
     * 检验授权凭证（access_token）是否有效
     *
     * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid       用户的唯一标识
     * @return
     * @throws IOException
     */
    public static String tokenCheck(String access_token, String openid) throws IOException {
        String url = "https://api.weixin.qq.com/sns/auth?access_token=" + access_token + "&openid=" + openid;
        ResponseBody responseBody = OkHttpUtil.syncGet(url);
        return responseBody.string();
    }

    /**
     * 页面链接生成
     *
     * @param appid
     * @param redirect_uri
     * @param scope        应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     * @param state        重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return
     */
    public static String createOauth2Link(String appid, String redirect_uri, String scope, String state) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=").append(appid).append("&redirect_uri=").append(URLEncoder.encode(redirect_uri, "utf-8")).append("&response_type=code").append("&scope=").append(scope);
        if (state != null) {
            sb.append("&state=").append(state);
        }
        sb.append("#wechat_redirect");
        return sb.toString();

    }

    /**
     * 页面链接生成
     *
     * @param appid
     * @param redirect_uri
     * @param scope        应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     * @return
     */
    public static String createOauth2Link(String appid, String redirect_uri, String scope) throws UnsupportedEncodingException {
        return createOauth2Link(appid, redirect_uri, scope, null);
    }
}
