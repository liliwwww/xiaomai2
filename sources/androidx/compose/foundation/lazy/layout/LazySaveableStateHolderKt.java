package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazySaveableStateHolderKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void LazySaveableStateHolderProvider(@NotNull Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer startRestartGroup = composer.startRestartGroup(674185128);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(674185128, i2, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:41)");
            }
            final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) startRestartGroup.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
            LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) RememberSaveableKt.m795rememberSaveable(new Object[]{saveableStateRegistry}, LazySaveableStateHolder.Companion.saver(saveableStateRegistry), (String) null, (Function0) new Function0<LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final LazySaveableStateHolder m323invoke() {
                    return new LazySaveableStateHolder(saveableStateRegistry, MapsKt.emptyMap());
                }
            }, startRestartGroup, 72, 4);
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(lazySaveableStateHolder)}, ComposableLambdaKt.composableLambda(startRestartGroup, 1863926504, true, new LazySaveableStateHolderProvider.1(lazySaveableStateHolder, function3, i2)), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new LazySaveableStateHolderProvider.2(function3, i));
    }
}
