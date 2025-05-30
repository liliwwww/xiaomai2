package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextFieldColorsWithIcons$DefaultImpls {
    @Composable
    @NotNull
    public static State<Color> leadingIconColor(@NotNull TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(1279189910);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1279189910, i, -1, "androidx.compose.material.TextFieldColorsWithIcons.leadingIconColor (TextFieldDefaults.kt:159)");
        }
        State<Color> leadingIconColor = textFieldColorsWithIcons.leadingIconColor(z, z2, composer, (i & 14) | (i & 112) | ((i >> 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return leadingIconColor;
    }

    @Composable
    @NotNull
    public static State<Color> trailingIconColor(@NotNull TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(-712140408);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-712140408, i, -1, "androidx.compose.material.TextFieldColorsWithIcons.trailingIconColor (TextFieldDefaults.kt:176)");
        }
        State<Color> trailingIconColor = textFieldColorsWithIcons.trailingIconColor(z, z2, composer, (i & 14) | (i & 112) | ((i >> 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return trailingIconColor;
    }
}
