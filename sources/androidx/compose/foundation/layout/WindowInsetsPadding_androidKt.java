package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$captionBarPadding$;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$imePadding$;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeContentPadding$;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeDrawingPadding$;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeGesturesPadding$;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemBarsPadding$;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemGesturesPadding$;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$waterfallPadding$;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WindowInsetsPadding_androidKt {
    @NotNull
    public static final Modifier captionBarPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$captionBarPadding$.inlined.debugInspectorInfo.1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$captionBarPadding$.inlined.windowInsetsPadding.1());
    }

    @NotNull
    public static final Modifier displayCutoutPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$debugInspectorInfo$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("displayCutoutPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$windowInsetsPadding$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier(current.getDisplayCutout(), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }

    @NotNull
    public static final Modifier imePadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$imePadding$.inlined.debugInspectorInfo.1() : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$imePadding$$inlined$windowInsetsPadding$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier(current.getIme(), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }

    @NotNull
    public static final Modifier mandatorySystemGesturesPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$.inlined.debugInspectorInfo.1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$.inlined.windowInsetsPadding.1());
    }

    @NotNull
    public static final Modifier navigationBarsPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$debugInspectorInfo$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("navigationBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$windowInsetsPadding$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier(current.getNavigationBars(), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }

    @NotNull
    public static final Modifier safeContentPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeContentPadding$.inlined.debugInspectorInfo.1() : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeContentPadding$$inlined$windowInsetsPadding$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier(current.getSafeContent(), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }

    @NotNull
    public static final Modifier safeDrawingPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$debugInspectorInfo$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("safeDrawingPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeDrawingPadding$.inlined.windowInsetsPadding.1());
    }

    @NotNull
    public static final Modifier safeGesturesPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeGesturesPadding$.inlined.debugInspectorInfo.1() : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$windowInsetsPadding$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier(current.getSafeGestures(), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }

    @NotNull
    public static final Modifier statusBarsPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$debugInspectorInfo$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("statusBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$windowInsetsPadding$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier(current.getStatusBars(), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }

    @NotNull
    public static final Modifier systemBarsPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$debugInspectorInfo$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("systemBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$systemBarsPadding$.inlined.windowInsetsPadding.1());
    }

    @NotNull
    public static final Modifier systemGesturesPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$systemGesturesPadding$.inlined.debugInspectorInfo.1() : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$windowInsetsPadding$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier(current.getSystemGestures(), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }

    @NotNull
    public static final Modifier waterfallPadding(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$waterfallPadding$.inlined.debugInspectorInfo.1() : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$waterfallPadding$$inlined$windowInsetsPadding$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier(current.getWaterfall(), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }

    @Stable
    private static final Modifier windowInsetsPadding(Modifier modifier, Function1<? super InspectorInfo, Unit> function1, final Function1<? super WindowInsetsHolder, ? extends WindowInsets> function12) {
        return ComposedModifierKt.composed(modifier, function1, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$windowInsetsPadding$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                composer.startReplaceableGroup(359872873);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:248)");
                }
                WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
                Function1<WindowInsetsHolder, WindowInsets> function13 = function12;
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(current);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new InsetsPaddingModifier((WindowInsets) function13.invoke(current), (Function1) null, 2, (DefaultConstructorMarker) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return insetsPaddingModifier;
            }
        });
    }
}
