package androidx.compose.ui.input;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.ScrollContainerInfoKt$provideScrollContainerInfo$;
import androidx.compose.ui.modifier.ModifierLocalConsumerKt;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ScrollContainerInfoKt {

    @NotNull
    private static final ProvidableModifierLocal<ScrollContainerInfo> ModifierLocalScrollContainerInfo = ModifierLocalKt.modifierLocalOf(ModifierLocalScrollContainerInfo.1.INSTANCE);

    public static final boolean canScroll(@NotNull ScrollContainerInfo scrollContainerInfo) {
        Intrinsics.checkNotNullParameter(scrollContainerInfo, "<this>");
        return scrollContainerInfo.canScrollVertically() || scrollContainerInfo.canScrollHorizontally();
    }

    @NotNull
    public static final Modifier consumeScrollContainerInfo(@NotNull Modifier modifier, @NotNull Function1<? super ScrollContainerInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "consumer");
        return ModifierLocalConsumerKt.modifierLocalConsumer(modifier, new consumeScrollContainerInfo.1(function1));
    }

    @NotNull
    public static final ProvidableModifierLocal<ScrollContainerInfo> getModifierLocalScrollContainerInfo() {
        return ModifierLocalScrollContainerInfo;
    }

    @NotNull
    public static final Modifier provideScrollContainerInfo(@NotNull Modifier modifier, @NotNull final ScrollContainerInfo scrollContainerInfo) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(scrollContainerInfo, "scrollContainerInfo");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ScrollContainerInfoKt$provideScrollContainerInfo$.inlined.debugInspectorInfo.1(scrollContainerInfo) : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.input.ScrollContainerInfoKt$provideScrollContainerInfo$2
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(198234108);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(198234108, i, -1, "androidx.compose.ui.input.provideScrollContainerInfo.<anonymous> (ScrollContainerInfo.kt:73)");
                }
                boolean changed = composer.changed(ScrollContainerInfo.this);
                ScrollContainerInfo scrollContainerInfo2 = ScrollContainerInfo.this;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new ScrollContainerInfoModifierLocal(scrollContainerInfo2);
                    composer.updateRememberedValue(rememberedValue);
                }
                ModifierLocalProvider modifierLocalProvider = (ScrollContainerInfoModifierLocal) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return modifierLocalProvider;
            }
        });
    }
}
