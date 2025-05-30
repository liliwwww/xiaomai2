package androidx.appcompat.widget;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(16)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AppCompatTextViewAutoSizeHelper$Api16Impl {
    private AppCompatTextViewAutoSizeHelper$Api16Impl() {
    }

    @NonNull
    @DoNotInline
    static StaticLayout createStaticLayoutForMeasuring(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i, @NonNull TextView textView, @NonNull TextPaint textPaint) {
        return new StaticLayout(charSequence, textPaint, i, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
    }

    @DoNotInline
    static int getMaxLines(@NonNull TextView textView) {
        return textView.getMaxLines();
    }
}
