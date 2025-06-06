package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    /* compiled from: Taobao */
    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        @DoNotInline
        static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        @DoNotInline
        static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollX(i);
        }

        @DoNotInline
        static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.mRecord = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.mRecord));
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.mRecord;
        return accessibilityRecord == null ? accessibilityRecordCompat.mRecord == null : accessibilityRecord.equals(accessibilityRecordCompat.mRecord);
    }

    @Deprecated
    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.mRecord;
    }

    @Deprecated
    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.mRecord);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.mRecord);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.mRecord.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.mRecord;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.mRecord.recycle();
    }

    @Deprecated
    public void setAddedCount(int i) {
        this.mRecord.setAddedCount(i);
    }

    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        this.mRecord.setBeforeText(charSequence);
    }

    @Deprecated
    public void setChecked(boolean z) {
        this.mRecord.setChecked(z);
    }

    @Deprecated
    public void setClassName(CharSequence charSequence) {
        this.mRecord.setClassName(charSequence);
    }

    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        this.mRecord.setContentDescription(charSequence);
    }

    @Deprecated
    public void setCurrentItemIndex(int i) {
        this.mRecord.setCurrentItemIndex(i);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        this.mRecord.setEnabled(z);
    }

    @Deprecated
    public void setFromIndex(int i) {
        this.mRecord.setFromIndex(i);
    }

    @Deprecated
    public void setFullScreen(boolean z) {
        this.mRecord.setFullScreen(z);
    }

    @Deprecated
    public void setItemCount(int i) {
        this.mRecord.setItemCount(i);
    }

    @Deprecated
    public void setMaxScrollX(int i) {
        setMaxScrollX(this.mRecord, i);
    }

    @Deprecated
    public void setMaxScrollY(int i) {
        setMaxScrollY(this.mRecord, i);
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        this.mRecord.setParcelableData(parcelable);
    }

    @Deprecated
    public void setPassword(boolean z) {
        this.mRecord.setPassword(z);
    }

    @Deprecated
    public void setRemovedCount(int i) {
        this.mRecord.setRemovedCount(i);
    }

    @Deprecated
    public void setScrollX(int i) {
        this.mRecord.setScrollX(i);
    }

    @Deprecated
    public void setScrollY(int i) {
        this.mRecord.setScrollY(i);
    }

    @Deprecated
    public void setScrollable(boolean z) {
        this.mRecord.setScrollable(z);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public void setSource(View view) {
        this.mRecord.setSource(view);
    }

    @Deprecated
    public void setToIndex(int i) {
        this.mRecord.setToIndex(i);
    }

    public static int getMaxScrollX(@NonNull AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return Api15Impl.getMaxScrollX(accessibilityRecord);
        }
        return 0;
    }

    public static int getMaxScrollY(@NonNull AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return Api15Impl.getMaxScrollY(accessibilityRecord);
        }
        return 0;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public static void setMaxScrollX(@NonNull AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            Api15Impl.setMaxScrollX(accessibilityRecord, i);
        }
    }

    public static void setMaxScrollY(@NonNull AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            Api15Impl.setMaxScrollY(accessibilityRecord, i);
        }
    }

    @Deprecated
    public void setSource(View view, int i) {
        setSource(this.mRecord, view, i);
    }

    public static void setSource(@NonNull AccessibilityRecord accessibilityRecord, @Nullable View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.setSource(accessibilityRecord, view, i);
        }
    }
}
