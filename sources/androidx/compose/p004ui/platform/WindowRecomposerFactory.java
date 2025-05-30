package androidx.compose.p004ui.platform;

import android.view.View;
import androidx.compose.p004ui.InternalComposeUiApi;
import androidx.compose.runtime.Recomposer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@InternalComposeUiApi
/* loaded from: classes2.dex */
public interface WindowRecomposerFactory {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final WindowRecomposerFactory LifecycleAware = new WindowRecomposerFactory() { // from class: androidx.compose.ui.platform.WindowRecomposerFactory$Companion$LifecycleAware$1
            @Override // androidx.compose.p004ui.platform.WindowRecomposerFactory
            @NotNull
            public final Recomposer createRecomposer(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "rootView");
                return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(view, null, null, 3, null);
            }
        };

        private Companion() {
        }

        public static /* synthetic */ void getLifecycleAware$annotations() {
        }

        @NotNull
        public final WindowRecomposerFactory getLifecycleAware() {
            return LifecycleAware;
        }
    }

    @NotNull
    Recomposer createRecomposer(@NotNull View view);
}
