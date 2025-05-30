package okhttp3;

import java.util.List;
import tb.y70;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new a();

    List<y70> loadForRequest(l lVar);

    void saveFromResponse(l lVar, List<y70> list);
}
