package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextLayout$Companion {
    private TextLayout$Companion() {
    }

    public /* synthetic */ TextLayout$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @VisibleForTesting
    @NotNull
    public final StaticLayout constructStaticLayout(@NotNull CharSequence charSequence, int i, @NotNull TextPaint textPaint, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        return StaticLayoutFactory.create$default(StaticLayoutFactory.INSTANCE, charSequence, 0, 0, textPaint, i, (TextDirectionHeuristic) null, (Layout.Alignment) null, 0, (TextUtils.TruncateAt) null, 0, 0.0f, 0.0f, 0, false, false, i4, i3, i5, i2, (int[]) null, (int[]) null, 1605606, (Object) null);
    }
}
