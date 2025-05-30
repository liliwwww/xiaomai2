package androidx.versionedparcelable;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* compiled from: Taobao */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class CustomVersionedParcelable implements VersionedParcelable {
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void onPostParceling() {
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void onPreParceling(boolean z) {
    }
}
