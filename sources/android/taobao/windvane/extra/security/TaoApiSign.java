package android.taobao.windvane.extra.security;

import android.taobao.windvane.connect.api.ApiConstants;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.TaoLog;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TaoApiSign {
    public static String getSign(Map<String, String> map) {
        try {
            String str = map.get(ApiConstants.APPKEY);
            String str2 = map.get(ApiConstants.APPSECRET);
            String str3 = map.get(ApiConstants.API);
            String str4 = map.get(ApiConstants.f5V);
            String str5 = map.get("imei");
            String str6 = map.get("imsi");
            String str7 = map.get(ApiConstants.DATA);
            String str8 = map.get(ApiConstants.f4T);
            String str9 = map.get(ApiConstants.ECODE);
            if (str4 == null || "".equals(str4)) {
                str4 = "*";
            }
            if (str7 == null) {
                str7 = "";
            }
            String md5ToHex = DigestUtils.md5ToHex(str);
            StringBuilder sb = new StringBuilder();
            if (str9 != null) {
                sb.append(str9);
                sb.append(ApiConstants.SPLIT_STR);
            }
            sb.append(str2);
            sb.append(ApiConstants.SPLIT_STR);
            sb.append(md5ToHex);
            sb.append(ApiConstants.SPLIT_STR);
            sb.append(str3);
            sb.append(ApiConstants.SPLIT_STR);
            sb.append(str4);
            sb.append(ApiConstants.SPLIT_STR);
            sb.append(str5);
            sb.append(ApiConstants.SPLIT_STR);
            sb.append(str6);
            sb.append(ApiConstants.SPLIT_STR);
            sb.append(DigestUtils.md5ToHex(str7));
            sb.append(ApiConstants.SPLIT_STR);
            sb.append(str8);
            return DigestUtils.md5ToHex(sb.toString());
        } catch (Exception e) {
            TaoLog.m21e("TaoApiSign", "generate sign fail." + e);
            return null;
        }
    }
}
