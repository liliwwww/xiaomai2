package androidx.core.view.accessibility;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AccessibilityViewCommand$MoveAtGranularityArguments extends AccessibilityViewCommand$CommandArguments {
    public boolean getExtendSelection() {
        return this.mBundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
    }

    public int getGranularity() {
        return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
    }
}
