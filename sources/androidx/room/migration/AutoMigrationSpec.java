package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.p008db.SupportSQLiteDatabase;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
