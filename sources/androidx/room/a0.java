package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ SupportSQLiteQuery b;
    public final /* synthetic */ QueryInterceptorProgram c;

    public /* synthetic */ a0(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.a = queryInterceptorDatabase;
        this.b = supportSQLiteQuery;
        this.c = queryInterceptorProgram;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryInterceptorDatabase.g(this.a, this.b, this.c);
    }
}
