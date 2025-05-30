package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.p008db.SupportSQLiteOpenHelper;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
interface DelegatingOpenHelper {
    @NonNull
    SupportSQLiteOpenHelper getDelegate();
}
