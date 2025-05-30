package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
