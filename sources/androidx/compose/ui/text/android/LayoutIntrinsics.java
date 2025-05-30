package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.TextPaint;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LayoutIntrinsics {
    public static final int $stable = 8;

    @NotNull
    private final Lazy boringMetrics$delegate;

    @NotNull
    private final Lazy maxIntrinsicWidth$delegate;

    @NotNull
    private final Lazy minIntrinsicWidth$delegate;

    public LayoutIntrinsics(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.boringMetrics$delegate = LazyKt.lazy(lazyThreadSafetyMode, new boringMetrics.2(i, charSequence, textPaint));
        this.minIntrinsicWidth$delegate = LazyKt.lazy(lazyThreadSafetyMode, new minIntrinsicWidth.2(charSequence, textPaint));
        this.maxIntrinsicWidth$delegate = LazyKt.lazy(lazyThreadSafetyMode, new maxIntrinsicWidth.2(this, charSequence, textPaint));
    }

    @Nullable
    public final BoringLayout.Metrics getBoringMetrics() {
        return (BoringLayout.Metrics) this.boringMetrics$delegate.getValue();
    }

    public final float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth$delegate.getValue()).floatValue();
    }

    public final float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth$delegate.getValue()).floatValue();
    }
}
