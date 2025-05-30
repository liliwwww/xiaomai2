package androidx.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ViewCompat$Api29Impl {
    private ViewCompat$Api29Impl() {
    }

    @DoNotInline
    static View.AccessibilityDelegate getAccessibilityDelegate(View view) {
        return view.getAccessibilityDelegate();
    }

    @DoNotInline
    static List<Rect> getSystemGestureExclusionRects(View view) {
        return view.getSystemGestureExclusionRects();
    }

    @DoNotInline
    static void saveAttributeDataForStyleable(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
    }

    @DoNotInline
    static void setSystemGestureExclusionRects(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }
}
