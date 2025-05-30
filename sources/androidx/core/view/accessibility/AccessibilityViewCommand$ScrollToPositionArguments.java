package androidx.core.view.accessibility;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AccessibilityViewCommand$ScrollToPositionArguments extends AccessibilityViewCommand$CommandArguments {
    public int getColumn() {
        return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_COLUMN_INT);
    }

    public int getRow() {
        return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_ROW_INT);
    }
}
