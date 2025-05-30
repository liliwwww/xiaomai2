package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class NoIndication implements Indication {

    @NotNull
    public static final NoIndication INSTANCE = new NoIndication();

    private NoIndication() {
    }

    @Composable
    @NotNull
    public IndicationInstance rememberUpdatedInstance(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(285654452);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(285654452, i, -1, "androidx.compose.foundation.NoIndication.rememberUpdatedInstance (Indication.kt:140)");
        }
        NoIndicationInstance noIndicationInstance = NoIndicationInstance.INSTANCE;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return noIndicationInstance;
    }
}
