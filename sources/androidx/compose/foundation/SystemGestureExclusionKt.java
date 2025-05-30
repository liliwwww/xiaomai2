package androidx.compose.foundation;

import android.os.Build;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.SystemGestureExclusionKt$systemGestureExclusion$;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SystemGestureExclusionKt {
    @Composable
    @RequiresApi(29)
    private static final Modifier excludeFromSystemGestureQ(Function1<? super LayoutCoordinates, Rect> function1, Composer composer, int i) {
        composer.startReplaceableGroup(1687674107);
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(view) | composer.changed(function1);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ExcludeFromSystemGestureModifier(view, function1);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final ExcludeFromSystemGestureModifier excludeFromSystemGestureModifier = (ExcludeFromSystemGestureModifier) rememberedValue;
        EffectsKt.DisposableEffect((Object) excludeFromSystemGestureModifier, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.SystemGestureExclusionKt$excludeFromSystemGestureQ$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                final ExcludeFromSystemGestureModifier excludeFromSystemGestureModifier2 = excludeFromSystemGestureModifier;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.SystemGestureExclusionKt$excludeFromSystemGestureQ$1$invoke$$inlined$onDispose$1
                    public void dispose() {
                        excludeFromSystemGestureModifier2.removeRect();
                    }
                };
            }
        }, composer, 0);
        composer.endReplaceableGroup();
        return excludeFromSystemGestureModifier;
    }

    @NotNull
    public static final Modifier systemGestureExclusion(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (Build.VERSION.SDK_INT < 29) {
            return modifier;
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.SystemGestureExclusionKt$systemGestureExclusion$$inlined$debugInspectorInfo$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("systemGestureExclusion");
            }
        } : InspectableValueKt.getNoInspectorInfo(), systemGestureExclusion.2.INSTANCE);
    }

    @NotNull
    public static final Modifier systemGestureExclusion(@NotNull Modifier modifier, @NotNull Function1<? super LayoutCoordinates, Rect> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "exclusion");
        if (Build.VERSION.SDK_INT < 29) {
            return modifier;
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SystemGestureExclusionKt$systemGestureExclusion$.inlined.debugInspectorInfo.2(function1) : InspectableValueKt.getNoInspectorInfo(), new systemGestureExclusion.4(function1));
    }
}
