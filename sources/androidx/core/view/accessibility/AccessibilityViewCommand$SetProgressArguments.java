package androidx.core.view.accessibility;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AccessibilityViewCommand$SetProgressArguments extends AccessibilityViewCommand$CommandArguments {
    public float getProgress() {
        return this.mBundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
    }
}
