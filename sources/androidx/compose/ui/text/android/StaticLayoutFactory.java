package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class StaticLayoutFactory {

    @NotNull
    public static final StaticLayoutFactory INSTANCE = new StaticLayoutFactory();

    @NotNull
    private static final StaticLayoutFactoryImpl delegate;

    static {
        delegate = Build.VERSION.SDK_INT >= 23 ? new StaticLayoutFactory23() : new StaticLayoutFactoryDefault();
    }

    private StaticLayoutFactory() {
    }

    @NotNull
    public final StaticLayout create(@NotNull CharSequence charSequence, int i, int i2, @NotNull TextPaint textPaint, int i3, @NotNull TextDirectionHeuristic textDirectionHeuristic, @NotNull Layout.Alignment alignment, @IntRange(from = 0) int i4, @Nullable TextUtils.TruncateAt truncateAt, @IntRange(from = 0) int i5, @FloatRange(from = 0.0d) float f, float f2, int i6, boolean z, boolean z2, int i7, int i8, int i9, int i10, @Nullable int[] iArr, @Nullable int[] iArr2) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(textDirectionHeuristic, "textDir");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return delegate.create(new StaticLayoutParams(charSequence, i, i2, textPaint, i3, textDirectionHeuristic, alignment, i4, truncateAt, i5, f, f2, i6, z, z2, i7, i8, i9, i10, iArr, iArr2));
    }

    public final boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout staticLayout, boolean z) {
        Intrinsics.checkNotNullParameter(staticLayout, "layout");
        return delegate.isFallbackLineSpacingEnabled(staticLayout, z);
    }
}
