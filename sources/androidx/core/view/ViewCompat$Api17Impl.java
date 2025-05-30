package androidx.core.view;

import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewCompat$Api17Impl {
    private ViewCompat$Api17Impl() {
    }

    @DoNotInline
    static int generateViewId() {
        return View.generateViewId();
    }

    @DoNotInline
    static Display getDisplay(@NonNull View view) {
        return view.getDisplay();
    }

    @DoNotInline
    static int getLabelFor(View view) {
        return view.getLabelFor();
    }

    @DoNotInline
    static int getLayoutDirection(View view) {
        return view.getLayoutDirection();
    }

    @DoNotInline
    static int getPaddingEnd(View view) {
        return view.getPaddingEnd();
    }

    @DoNotInline
    static int getPaddingStart(View view) {
        return view.getPaddingStart();
    }

    @DoNotInline
    static boolean isPaddingRelative(View view) {
        return view.isPaddingRelative();
    }

    @DoNotInline
    static void setLabelFor(View view, int i) {
        view.setLabelFor(i);
    }

    @DoNotInline
    static void setLayerPaint(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @DoNotInline
    static void setLayoutDirection(View view, int i) {
        view.setLayoutDirection(i);
    }

    @DoNotInline
    static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }
}
