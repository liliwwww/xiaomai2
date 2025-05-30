package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.text.input.TextInputService;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public final class LocalSoftwareKeyboardController {
    public static final int $stable = 0;

    @NotNull
    public static final LocalSoftwareKeyboardController INSTANCE = new LocalSoftwareKeyboardController();

    @NotNull
    private static final ProvidableCompositionLocal<SoftwareKeyboardController> LocalSoftwareKeyboardController = CompositionLocalKt.compositionLocalOf$default(null, new Function0<SoftwareKeyboardController>() { // from class: androidx.compose.ui.platform.LocalSoftwareKeyboardController$LocalSoftwareKeyboardController$1
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SoftwareKeyboardController m4537invoke() {
            return null;
        }
    }, 1, null);

    private LocalSoftwareKeyboardController() {
    }

    @Composable
    private final SoftwareKeyboardController delegatingController(Composer composer, int i) {
        composer.startReplaceableGroup(1835581880);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1835581880, i, -1, "androidx.compose.ui.platform.LocalSoftwareKeyboardController.delegatingController (LocalSoftwareKeyboardController.kt:45)");
        }
        TextInputService textInputService = (TextInputService) composer.consume(CompositionLocalsKt.getLocalTextInputService());
        if (textInputService == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return null;
        }
        int i2 = TextInputService.$stable;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(textInputService);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DelegatingSoftwareKeyboardController(textInputService);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DelegatingSoftwareKeyboardController delegatingSoftwareKeyboardController = (DelegatingSoftwareKeyboardController) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return delegatingSoftwareKeyboardController;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getCurrent$annotations() {
    }

    @Composable
    @JvmName(name = "getCurrent")
    @Nullable
    public final SoftwareKeyboardController getCurrent(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1059476185);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1059476185, i, -1, "androidx.compose.ui.platform.LocalSoftwareKeyboardController.<get-current> (LocalSoftwareKeyboardController.kt:40)");
        }
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composer.consume(LocalSoftwareKeyboardController);
        if (softwareKeyboardController == null) {
            softwareKeyboardController = delegatingController(composer, i & 14);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return softwareKeyboardController;
    }

    @NotNull
    public final ProvidedValue<SoftwareKeyboardController> provides(@NotNull SoftwareKeyboardController softwareKeyboardController) {
        Intrinsics.checkNotNullParameter(softwareKeyboardController, "softwareKeyboardController");
        return LocalSoftwareKeyboardController.provides(softwareKeyboardController);
    }
}
