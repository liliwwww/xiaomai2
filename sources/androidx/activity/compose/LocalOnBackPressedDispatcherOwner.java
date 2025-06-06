package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LocalOnBackPressedDispatcherOwner {
    public static final int $stable = 0;

    @NotNull
    public static final LocalOnBackPressedDispatcherOwner INSTANCE = new LocalOnBackPressedDispatcherOwner();

    @NotNull
    private static final ProvidableCompositionLocal<OnBackPressedDispatcherOwner> LocalOnBackPressedDispatcherOwner = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, LocalOnBackPressedDispatcherOwner.1.INSTANCE, 1, (Object) null);

    private LocalOnBackPressedDispatcherOwner() {
    }

    @Composable
    @JvmName(name = "getCurrent")
    @Nullable
    public final OnBackPressedDispatcherOwner getCurrent(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-2068013981);
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) composer.consume(LocalOnBackPressedDispatcherOwner);
        composer.startReplaceableGroup(1680121597);
        if (onBackPressedDispatcherOwner == null) {
            onBackPressedDispatcherOwner = ViewTreeOnBackPressedDispatcherOwner.get((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView()));
        }
        composer.endReplaceableGroup();
        if (onBackPressedDispatcherOwner == null) {
            Object obj = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            while (true) {
                if (!(obj instanceof ContextWrapper)) {
                    obj = null;
                    break;
                }
                if (obj instanceof OnBackPressedDispatcherOwner) {
                    break;
                }
                obj = ((ContextWrapper) obj).getBaseContext();
                Intrinsics.checkNotNullExpressionValue(obj, "innerContext.baseContext");
            }
            onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) obj;
        }
        composer.endReplaceableGroup();
        return onBackPressedDispatcherOwner;
    }

    @NotNull
    public final ProvidedValue<OnBackPressedDispatcherOwner> provides(@NotNull OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcherOwner, "dispatcherOwner");
        return LocalOnBackPressedDispatcherOwner.provides(onBackPressedDispatcherOwner);
    }
}
