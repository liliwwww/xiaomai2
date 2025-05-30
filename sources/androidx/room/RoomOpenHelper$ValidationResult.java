package androidx.room;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* compiled from: Taobao */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class RoomOpenHelper$ValidationResult {

    @Nullable
    public final String expectedFoundMsg;
    public final boolean isValid;

    public RoomOpenHelper$ValidationResult(boolean z, @Nullable String str) {
        this.isValid = z;
        this.expectedFoundMsg = str;
    }
}
