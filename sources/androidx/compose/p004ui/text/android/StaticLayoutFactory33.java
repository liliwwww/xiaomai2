package androidx.compose.p004ui.text.android;

import android.graphics.text.LineBreakConfig;
import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: classes.dex */
final class StaticLayoutFactory33 {

    @NotNull
    public static final StaticLayoutFactory33 INSTANCE = new StaticLayoutFactory33();

    private StaticLayoutFactory33() {
    }

    @JvmStatic
    @DoNotInline
    public static final boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout staticLayout) {
        Intrinsics.checkNotNullParameter(staticLayout, "layout");
        return staticLayout.isFallbackLineSpacingEnabled();
    }

    @JvmStatic
    @DoNotInline
    public static final void setLineBreakConfig(@NotNull StaticLayout.Builder builder, int i, int i2) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        LineBreakConfig build = new LineBreakConfig.Builder().setLineBreakStyle(i).setLineBreakWordStyle(i2).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        builder.setLineBreakConfig(build);
    }
}
