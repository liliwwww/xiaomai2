package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidScrollable_androidKt {
    @Composable
    @NotNull
    public static final ScrollConfig platformScrollConfig(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1485272842);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1485272842, i, -1, "androidx.compose.foundation.gestures.platformScrollConfig (AndroidScrollable.android.kt:27)");
        }
        AndroidConfig androidConfig = AndroidConfig.INSTANCE;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidConfig;
    }
}
