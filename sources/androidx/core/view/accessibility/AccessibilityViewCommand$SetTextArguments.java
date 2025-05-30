package androidx.core.view.accessibility;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AccessibilityViewCommand$SetTextArguments extends AccessibilityViewCommand$CommandArguments {
    @Nullable
    public CharSequence getText() {
        return this.mBundle.getCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE);
    }
}
