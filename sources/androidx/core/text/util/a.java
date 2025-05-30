package androidx.core.text.util;

import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* synthetic */ class a implements Comparator {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return LinkifyCompat.a((LinkifyCompat$LinkSpec) obj, (LinkifyCompat$LinkSpec) obj2);
    }
}
