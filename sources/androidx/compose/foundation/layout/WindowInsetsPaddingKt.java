package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsetsPaddingKt$consumeWindowInsets$;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt$windowInsetsPadding$;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WindowInsetsPaddingKt {

    @NotNull
    private static final ProvidableModifierLocal<WindowInsets> ModifierLocalConsumedWindowInsets = ModifierLocalKt.modifierLocalOf(new Function0<WindowInsets>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$ModifierLocalConsumedWindowInsets$1
        @NotNull
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WindowInsets m242invoke() {
            return WindowInsetsKt.WindowInsets(0, 0, 0, 0);
        }
    });

    @Stable
    @NotNull
    public static final Modifier consumeWindowInsets(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        return modifier.then(new UnionInsetsConsumingModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumeWindowInsets$.inlined.debugInspectorInfo.1(windowInsets) : InspectableValueKt.getNoInspectorInfo()));
    }

    @ExperimentalLayoutApi
    @NotNull
    @Stable
    @Deprecated(message = "Use consumeWindowInsets", replaceWith = @ReplaceWith(expression = "this.consumeWindowInsets(insets)", imports = {}))
    public static final Modifier consumedWindowInsets(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        return consumeWindowInsets(modifier, windowInsets);
    }

    @NotNull
    public static final ProvidableModifierLocal<WindowInsets> getModifierLocalConsumedWindowInsets() {
        return ModifierLocalConsumedWindowInsets;
    }

    @Stable
    @NotNull
    public static final Modifier onConsumedWindowInsetsChanged(@NotNull Modifier modifier, @NotNull final Function1<? super WindowInsets, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        return modifier.then(new ConsumedInsetsModifier(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("onConsumedWindowInsetsChanged");
                inspectorInfo.getProperties().set("block", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @NotNull
    public static final Modifier windowInsetsPadding(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        return modifier.then(new InsetsPaddingModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$windowInsetsPadding$.inlined.debugInspectorInfo.1(windowInsets) : InspectableValueKt.getNoInspectorInfo()));
    }

    @ExperimentalLayoutApi
    @NotNull
    @Stable
    @Deprecated(message = "Use onConsumedWindowInsetsChanged", replaceWith = @ReplaceWith(expression = "onConsumedWindowInsetsChanged(block)", imports = {}))
    public static final Modifier withConsumedWindowInsets(@NotNull Modifier modifier, @NotNull Function1<? super WindowInsets, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        return onConsumedWindowInsetsChanged(modifier, function1);
    }

    @ExperimentalLayoutApi
    @NotNull
    @Stable
    @Deprecated(message = "Use consumeWindowInsets", replaceWith = @ReplaceWith(expression = "this.consumeWindowInsets(paddingValues)", imports = {}))
    public static final Modifier consumedWindowInsets(@NotNull Modifier modifier, @NotNull PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return consumeWindowInsets(modifier, paddingValues);
    }

    @Stable
    @ExperimentalLayoutApi
    @NotNull
    public static final Modifier consumeWindowInsets(@NotNull Modifier modifier, @NotNull PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return modifier.then(new PaddingValuesConsumingModifier(paddingValues, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumeWindowInsets$.inlined.debugInspectorInfo.2(paddingValues) : InspectableValueKt.getNoInspectorInfo()));
    }
}
