package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class WindowRecomposerFactory$Companion$LifecycleAware$1 implements WindowRecomposerFactory {
    public static final WindowRecomposerFactory$Companion$LifecycleAware$1 INSTANCE = new WindowRecomposerFactory$Companion$LifecycleAware$1();

    WindowRecomposerFactory$Companion$LifecycleAware$1() {
    }

    @Override // androidx.compose.ui.platform.WindowRecomposerFactory
    @NotNull
    public final Recomposer createRecomposer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(view, null, null, 3, null);
    }
}
