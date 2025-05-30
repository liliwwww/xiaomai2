package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1$invoke$;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class WindowInsetsConnection_androidKt {
    private static final double DecelMinusOne;
    private static final double DecelerationRate;
    private static final float EndTension = 1.0f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
    private static final float StartTension = 0.5f;

    static {
        double log = Math.log(0.78d) / Math.log(0.9d);
        DecelerationRate = log;
        DecelMinusOne = log - 1.0d;
    }

    @ExperimentalLayoutApi
    @NotNull
    public static final Modifier imeNestedScroll(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (Build.VERSION.SDK_INT < 30) {
            return modifier;
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$imeNestedScroll$$inlined$debugInspectorInfo$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("imeNestedScroll");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$imeNestedScroll$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(-369978792);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-369978792, i, -1, "androidx.compose.foundation.layout.imeNestedScroll.<anonymous> (WindowInsetsConnection.android.kt:78)");
                }
                Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifier2, WindowInsetsConnection_androidKt.m386rememberWindowInsetsConnectionVRgvIgI(WindowInsetsHolder.Companion.current(composer, 8).getIme(), WindowInsetsSides.Companion.m407getBottomJoeWqyM(), composer, 48), null, 2, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return nestedScroll$default;
            }
        });
    }

    @Composable
    @ExperimentalLayoutApi
    @NotNull
    /* renamed from: rememberWindowInsetsConnection-VRgvIgI, reason: not valid java name */
    public static final NestedScrollConnection m386rememberWindowInsetsConnectionVRgvIgI(@NotNull AndroidWindowInsets androidWindowInsets, int i, @Nullable Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(androidWindowInsets, "windowInsets");
        composer.startReplaceableGroup(-1011341039);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1011341039, i2, -1, "androidx.compose.foundation.layout.rememberWindowInsetsConnection (WindowInsetsConnection.android.kt:104)");
        }
        if (Build.VERSION.SDK_INT < 30) {
            DoNothingNestedScrollConnection doNothingNestedScrollConnection = DoNothingNestedScrollConnection.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return doNothingNestedScrollConnection;
        }
        SideCalculator m351chooseCalculatorni1skBw = SideCalculator.Companion.m351chooseCalculatorni1skBw(i, (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection()));
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object[] objArr = {androidWindowInsets, view, m351chooseCalculatorni1skBw, density};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 4; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new WindowInsetsNestedScrollConnection(androidWindowInsets, view, m351chooseCalculatorni1skBw, density);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = (WindowInsetsNestedScrollConnection) rememberedValue;
        EffectsKt.DisposableEffect((Object) windowInsetsNestedScrollConnection, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1
            {
                super(1);
            }

            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                return new WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1$invoke$.inlined.onDispose.1(WindowInsetsNestedScrollConnection.this);
            }
        }, composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return windowInsetsNestedScrollConnection;
    }
}
