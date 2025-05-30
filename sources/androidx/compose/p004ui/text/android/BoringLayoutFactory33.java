package androidx.compose.p004ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: classes2.dex */
final class BoringLayoutFactory33 {

    @NotNull
    public static final BoringLayoutFactory33 INSTANCE = new BoringLayoutFactory33();

    private BoringLayoutFactory33() {
    }

    @JvmStatic
    @DoNotInline
    @NotNull
    public static final BoringLayout create(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, int i, @NotNull Layout.Alignment alignment, float f, float f2, @NotNull BoringLayout.Metrics metrics, boolean z, boolean z2, @Nullable TextUtils.TruncateAt truncateAt, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        BoringLayout create = BoringLayoutConstructor33.create(charSequence, textPaint, i, alignment, f, f2, metrics, z, truncateAt, i2, z2);
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            text…backLineSpacing\n        )");
        return create;
    }

    @JvmStatic
    @DoNotInline
    @Nullable
    public static final BoringLayout.Metrics isBoring(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, @NotNull TextDirectionHeuristic textDirectionHeuristic) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(textDirectionHeuristic, "textDir");
        return BoringLayout.isBoring(charSequence, textPaint, textDirectionHeuristic, true, null);
    }

    public final boolean isFallbackLineSpacingEnabled(@NotNull BoringLayout boringLayout) {
        Intrinsics.checkNotNullParameter(boringLayout, "layout");
        return boringLayout.isFallbackLineSpacingEnabled();
    }
}
