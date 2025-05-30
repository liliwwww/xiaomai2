package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(16)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class AccessibilityRecordCompat$Api16Impl {
    private AccessibilityRecordCompat$Api16Impl() {
    }

    @DoNotInline
    static void setSource(AccessibilityRecord accessibilityRecord, View view, int i) {
        accessibilityRecord.setSource(view, i);
    }
}
