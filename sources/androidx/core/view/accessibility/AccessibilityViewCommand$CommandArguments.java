package androidx.core.view.accessibility;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class AccessibilityViewCommand$CommandArguments {
    Bundle mBundle;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void setBundle(@Nullable Bundle bundle) {
        this.mBundle = bundle;
    }
}
