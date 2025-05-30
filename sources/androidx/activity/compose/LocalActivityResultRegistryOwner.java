package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LocalActivityResultRegistryOwner {
    public static final int $stable = 0;

    @NotNull
    public static final LocalActivityResultRegistryOwner INSTANCE = new LocalActivityResultRegistryOwner();

    @NotNull
    private static final ProvidableCompositionLocal<ActivityResultRegistryOwner> LocalComposition = CompositionLocalKt.compositionLocalOf$default(null, new Function0<ActivityResultRegistryOwner>() { // from class: androidx.activity.compose.LocalActivityResultRegistryOwner$LocalComposition$1
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ActivityResultRegistryOwner m10invoke() {
            return null;
        }
    }, 1, null);

    private LocalActivityResultRegistryOwner() {
    }

    @Composable
    @JvmName(name = "getCurrent")
    @Nullable
    public final ActivityResultRegistryOwner getCurrent(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1418020823);
        ActivityResultRegistryOwner activityResultRegistryOwner = (ActivityResultRegistryOwner) composer.consume(LocalComposition);
        if (activityResultRegistryOwner == null) {
            Object obj = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            while (true) {
                if (!(obj instanceof ContextWrapper)) {
                    obj = null;
                    break;
                }
                if (obj instanceof ActivityResultRegistryOwner) {
                    break;
                }
                obj = ((ContextWrapper) obj).getBaseContext();
                Intrinsics.checkNotNullExpressionValue(obj, "innerContext.baseContext");
            }
            activityResultRegistryOwner = (ActivityResultRegistryOwner) obj;
        }
        composer.endReplaceableGroup();
        return activityResultRegistryOwner;
    }

    @NotNull
    public final ProvidedValue<ActivityResultRegistryOwner> provides(@NotNull ActivityResultRegistryOwner activityResultRegistryOwner) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "registryOwner");
        return LocalComposition.provides(activityResultRegistryOwner);
    }
}
