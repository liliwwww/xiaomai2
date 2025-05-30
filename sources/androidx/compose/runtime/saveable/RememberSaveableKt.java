package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new mutableStateSaver.1.1(saver), new mutableStateSaver.1.2(saver));
    }

    @Composable
    @NotNull
    /* renamed from: rememberSaveable, reason: collision with other method in class */
    public static final <T> T m795rememberSaveable(@NotNull Object[] objArr, @Nullable Saver<T, ? extends Object> saver, @Nullable String str, @NotNull Function0<? extends T> function0, @Nullable Composer composer, int i, int i2) {
        Object consumeRestored;
        Intrinsics.checkNotNullParameter(objArr, "inputs");
        Intrinsics.checkNotNullParameter(function0, "init");
        composer.startReplaceableGroup(441892779);
        if ((i2 & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        Object obj = null;
        if ((i2 & 4) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441892779, i, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:65)");
        }
        composer.startReplaceableGroup(1059366469);
        if (str == null || str.length() == 0) {
            str = Integer.toString(ComposablesKt.getCurrentCompositeKeyHash(composer, 0), CharsKt.checkRadix(MaxSupportedRadix));
            Intrinsics.checkNotNullExpressionValue(str, "toString(this, checkRadix(radix))");
        }
        composer.endReplaceableGroup();
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (Object obj2 : copyOf) {
            z |= composer.changed(obj2);
        }
        Object obj3 = (T) composer.rememberedValue();
        if (z || obj3 == Composer.Companion.getEmpty()) {
            if (saveableStateRegistry != null && (consumeRestored = saveableStateRegistry.consumeRestored(str)) != null) {
                obj = saver.restore(consumeRestored);
            }
            obj3 = obj == null ? (T) function0.invoke() : obj;
            composer.updateRememberedValue(obj3);
        }
        composer.endReplaceableGroup();
        if (saveableStateRegistry != null) {
            EffectsKt.DisposableEffect(saveableStateRegistry, str, new rememberSaveable.1(saveableStateRegistry, str, SnapshotStateKt.rememberUpdatedState(saver, composer, 0), SnapshotStateKt.rememberUpdatedState(obj3, composer, 0)), composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return (T) obj3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry saveableStateRegistry, Object obj) {
        String str;
        if (obj == null || saveableStateRegistry.canBeSaved(obj)) {
            return;
        }
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.getPolicy() == SnapshotStateKt.neverEqualPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.structuralEqualityPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                str = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
            } else {
                str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
            }
        } else {
            str = obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
        }
        throw new IllegalArgumentException(str);
    }

    @Composable
    @NotNull
    public static final <T> MutableState<T> rememberSaveable(@NotNull Object[] objArr, @NotNull Saver<T, ? extends Object> saver, @Nullable String str, @NotNull Function0<? extends MutableState<T>> function0, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(objArr, "inputs");
        Intrinsics.checkNotNullParameter(saver, "stateSaver");
        Intrinsics.checkNotNullParameter(function0, "init");
        composer.startReplaceableGroup(-202053668);
        if ((i2 & 4) != 0) {
            str = null;
        }
        String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-202053668, i, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:136)");
        }
        MutableState<T> mutableState = (MutableState) m795rememberSaveable(Arrays.copyOf(objArr, objArr.length), mutableStateSaver(saver), str2, (Function0) function0, composer, (i & 896) | 8 | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
