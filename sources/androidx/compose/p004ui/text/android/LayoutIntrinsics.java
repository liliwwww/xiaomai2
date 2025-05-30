package androidx.compose.p004ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: classes.dex */
public final class LayoutIntrinsics {
    public static final int $stable = 8;

    @NotNull
    private final Lazy boringMetrics$delegate;

    @NotNull
    private final Lazy maxIntrinsicWidth$delegate;

    @NotNull
    private final Lazy minIntrinsicWidth$delegate;

    public LayoutIntrinsics(@NotNull final CharSequence charSequence, @NotNull final TextPaint textPaint, final int i) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.boringMetrics$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0<BoringLayout.Metrics>() { // from class: androidx.compose.ui.text.android.LayoutIntrinsics$boringMetrics$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BoringLayout.Metrics m4776invoke() {
                return BoringLayoutFactory.INSTANCE.measure(charSequence, textPaint, TextLayoutKt.getTextDirectionHeuristic(i));
            }
        });
        this.minIntrinsicWidth$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.android.LayoutIntrinsics$minIntrinsicWidth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m4778invoke() {
                return Float.valueOf(LayoutIntrinsicsKt.minIntrinsicWidth(charSequence, textPaint));
            }
        });
        this.maxIntrinsicWidth$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.android.LayoutIntrinsics$maxIntrinsicWidth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m4777invoke() {
                boolean shouldIncreaseMaxIntrinsic;
                Float valueOf = LayoutIntrinsics.this.getBoringMetrics() != null ? Float.valueOf(r0.width) : null;
                if (valueOf == null) {
                    CharSequence charSequence2 = charSequence;
                    valueOf = Float.valueOf((float) Math.ceil(Layout.getDesiredWidth(charSequence2, 0, charSequence2.length(), textPaint)));
                }
                shouldIncreaseMaxIntrinsic = LayoutIntrinsicsKt.shouldIncreaseMaxIntrinsic(valueOf.floatValue(), charSequence, textPaint);
                return shouldIncreaseMaxIntrinsic ? Float.valueOf(valueOf.floatValue() + 0.5f) : valueOf;
            }
        });
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
