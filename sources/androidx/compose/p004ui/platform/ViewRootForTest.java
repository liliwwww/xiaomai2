package androidx.compose.p004ui.platform;

import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p004ui.node.RootForTest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@VisibleForTesting
/* loaded from: classes.dex */
public interface ViewRootForTest extends RootForTest {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Nullable
        private static Function1<? super ViewRootForTest, Unit> onViewCreatedCallback;

        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getOnViewCreatedCallback$annotations() {
        }

        @Nullable
        public final Function1<ViewRootForTest, Unit> getOnViewCreatedCallback() {
            return onViewCreatedCallback;
        }

        public final void setOnViewCreatedCallback(@Nullable Function1<? super ViewRootForTest, Unit> function1) {
            onViewCreatedCallback = function1;
        }
    }

    boolean getHasPendingMeasureOrLayout();

    @NotNull
    View getView();

    void invalidateDescendants();

    boolean isLifecycleInResumedState();
}
