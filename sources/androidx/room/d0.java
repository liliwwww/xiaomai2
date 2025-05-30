package androidx.room;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ String b;

    public /* synthetic */ d0(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.a = queryInterceptorDatabase;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorDatabase.h(this.a, this.b);
    }
}
