package androidx.compose.p004ui.res;

import android.content.Context;
import android.os.Build;
import androidx.annotation.ColorRes;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ColorResources_androidKt {
    @Composable
    @ReadOnlyComposable
    public static final long colorResource(@ColorRes int i, @Nullable Composer composer, int i2) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1777644873, i2, -1, "androidx.compose.ui.res.colorResource (ColorResources.android.kt:36)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        long m4574getColorWaAFU9c = Build.VERSION.SDK_INT >= 23 ? ColorResourceHelper.INSTANCE.m4574getColorWaAFU9c(context, i) : ColorKt.Color(context.getResources().getColor(i));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m4574getColorWaAFU9c;
    }
}
