package androidx.compose.runtime;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class HotReloader {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void loadStateAndCompose(Object obj) {
            Recomposer.Companion.loadStateAndComposeForHotReload$runtime_release(obj);
        }

        private final Object saveStateAndDispose(Object obj) {
            return Recomposer.Companion.saveStateAndDisposeForHotReload$runtime_release();
        }

        public final void clearErrors$runtime_release() {
            Recomposer.Companion.clearErrors$runtime_release();
        }

        @NotNull
        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            return Recomposer.Companion.getCurrentErrors$runtime_release();
        }

        public final void invalidateGroupsWithKey$runtime_release(int i) {
            Recomposer.Companion.invalidateGroupsWithKey$runtime_release(i);
        }

        public final void simulateHotReload$runtime_release(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "context");
            loadStateAndCompose(saveStateAndDispose(obj));
        }
    }
}
