package okhttp3;

import java.util.Collections;
import java.util.List;
import tb.y70;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new C1408a();

    /* compiled from: Taobao */
    /* renamed from: okhttp3.CookieJar$a */
    /* loaded from: classes2.dex */
    class C1408a implements CookieJar {
        C1408a() {
        }

        @Override // okhttp3.CookieJar
        public List<y70> loadForRequest(C1472l c1472l) {
            return Collections.emptyList();
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(C1472l c1472l, List<y70> list) {
        }
    }

    List<y70> loadForRequest(C1472l c1472l);

    void saveFromResponse(C1472l c1472l, List<y70> list);
}
