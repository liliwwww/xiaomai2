package androidx.compose.runtime.livedata;

import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LiveDataAdapterKt {
    @Composable
    @NotNull
    public static final <T> State<T> observeAsState(@NotNull LiveData<T> liveData, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        composer.startReplaceableGroup(-2027206144);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2027206144, i, -1, "androidx.compose.runtime.livedata.observeAsState (LiveDataAdapter.kt:40)");
        }
        State<T> observeAsState = observeAsState(liveData, liveData.getValue(), composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return observeAsState;
    }

    @Composable
    @NotNull
    public static final <R, T extends R> State<R> observeAsState(@NotNull LiveData<T> liveData, R r, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        composer.startReplaceableGroup(411178300);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(411178300, i, -1, "androidx.compose.runtime.livedata.observeAsState (LiveDataAdapter.kt:53)");
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.DisposableEffect(liveData, lifecycleOwner, new LiveDataAdapterKt$observeAsState$1(liveData, lifecycleOwner, mutableState), composer, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
