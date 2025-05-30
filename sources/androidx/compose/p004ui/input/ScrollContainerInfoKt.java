package androidx.compose.p004ui.input;

import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.modifier.ModifierLocalConsumerKt;
import androidx.compose.p004ui.modifier.ModifierLocalKt;
import androidx.compose.p004ui.modifier.ModifierLocalReadScope;
import androidx.compose.p004ui.modifier.ProvidableModifierLocal;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ScrollContainerInfoKt {

    @NotNull
    private static final ProvidableModifierLocal<ScrollContainerInfo> ModifierLocalScrollContainerInfo = ModifierLocalKt.modifierLocalOf(new Function0<ScrollContainerInfo>() { // from class: androidx.compose.ui.input.ScrollContainerInfoKt$ModifierLocalScrollContainerInfo$1
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ScrollContainerInfo m3365invoke() {
            return null;
        }
    });

    public static final boolean canScroll(@NotNull ScrollContainerInfo scrollContainerInfo) {
        Intrinsics.checkNotNullParameter(scrollContainerInfo, "<this>");
        return scrollContainerInfo.canScrollVertically() || scrollContainerInfo.canScrollHorizontally();
    }

    @NotNull
    public static final Modifier consumeScrollContainerInfo(@NotNull Modifier modifier, @NotNull final Function1<? super ScrollContainerInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "consumer");
        return ModifierLocalConsumerKt.modifierLocalConsumer(modifier, new Function1<ModifierLocalReadScope, Unit>() { // from class: androidx.compose.ui.input.ScrollContainerInfoKt$consumeScrollContainerInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ModifierLocalReadScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
                Intrinsics.checkNotNullParameter(modifierLocalReadScope, "$this$modifierLocalConsumer");
                function1.invoke(modifierLocalReadScope.getCurrent(ScrollContainerInfoKt.getModifierLocalScrollContainerInfo()));
            }
        });
    }

    @NotNull
    public static final ProvidableModifierLocal<ScrollContainerInfo> getModifierLocalScrollContainerInfo() {
        return ModifierLocalScrollContainerInfo;
    }

    @NotNull
    public static final Modifier provideScrollContainerInfo(@NotNull Modifier modifier, @NotNull final ScrollContainerInfo scrollContainerInfo) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(scrollContainerInfo, "scrollContainerInfo");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.ScrollContainerInfoKt$provideScrollContainerInfo$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("provideScrollContainerInfo");
                inspectorInfo.setValue(ScrollContainerInfo.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.input.ScrollContainerInfoKt$provideScrollContainerInfo$2
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
                ScrollContainerInfoModifierLocal scrollContainerInfoModifierLocal = (ScrollContainerInfoModifierLocal) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return scrollContainerInfoModifierLocal;
            }
        });
    }
}
