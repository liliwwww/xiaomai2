package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BoringLayoutFactory {

    @NotNull
    public static final BoringLayoutFactory INSTANCE = new BoringLayoutFactory();

    private BoringLayoutFactory() {
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @NotNull
    public final BoringLayout create(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, int i, @NotNull BoringLayout.Metrics metrics, @NotNull Layout.Alignment alignment, boolean z, boolean z2, @Nullable TextUtils.TruncateAt truncateAt, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i2 >= 0) {
            return BuildCompat.isAtLeastT() ? BoringLayoutFactory33.create(charSequence, textPaint, i, alignment, 1.0f, 0.0f, metrics, z, z2, truncateAt, i2) : BoringLayoutFactoryDefault.create(charSequence, textPaint, i, alignment, 1.0f, 0.0f, metrics, z, truncateAt, i2);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public final boolean isFallbackLineSpacingEnabled(@NotNull BoringLayout boringLayout) {
        Intrinsics.checkNotNullParameter(boringLayout, "layout");
        if (BuildCompat.isAtLeastT()) {
            return BoringLayoutFactory33.INSTANCE.isFallbackLineSpacingEnabled(boringLayout);
        }
        return false;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public final BoringLayout.Metrics measure(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, @NotNull TextDirectionHeuristic textDirectionHeuristic) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(textDirectionHeuristic, "textDir");
        return BuildCompat.isAtLeastT() ? BoringLayoutFactory33.isBoring(charSequence, textPaint, textDirectionHeuristic) : BoringLayoutFactoryDefault.isBoring(charSequence, textPaint, textDirectionHeuristic);
    }
}
