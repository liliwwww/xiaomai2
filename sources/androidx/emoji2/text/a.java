package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* synthetic */ class a implements ThreadFactory {
    public final /* synthetic */ String a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.a(this.a, runnable);
    }
}
