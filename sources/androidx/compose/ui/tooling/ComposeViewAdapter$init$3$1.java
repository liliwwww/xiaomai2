package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposeViewAdapter$init$3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $animationClockStartTime;
    final /* synthetic */ String $className;
    final /* synthetic */ String $methodName;
    final /* synthetic */ Class<? extends PreviewParameterProvider<?>> $parameterProvider;
    final /* synthetic */ int $parameterProviderIndex;
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeViewAdapter$init$3$1(long j, ComposeViewAdapter composeViewAdapter, String str, String str2, Class<? extends PreviewParameterProvider<?>> cls, int i) {
        super(2);
        this.$animationClockStartTime = j;
        this.this$0 = composeViewAdapter;
        this.$className = str;
        this.$methodName = str2;
        this.$parameterProvider = cls;
        this.$parameterProviderIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1938351266, i, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous>.<anonymous> (ComposeViewAdapter.kt:703)");
        }
        composable.1 r12 = new composable.1(this.$className, this.$methodName, composer, this.$parameterProvider, this.$parameterProviderIndex, this.this$0);
        if (this.$animationClockStartTime >= 0) {
            final ComposeViewAdapter composeViewAdapter = this.this$0;
            composeViewAdapter.setClock$ui_tooling_release(new PreviewAnimationClock(new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1.1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2548invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2548invoke() {
                    ComposeView childAt = ComposeViewAdapter.this.getChildAt(0);
                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
                    ViewRootForTest childAt2 = childAt.getChildAt(0);
                    ViewRootForTest viewRootForTest = childAt2 instanceof ViewRootForTest ? childAt2 : null;
                    if (viewRootForTest != null) {
                        viewRootForTest.invalidateDescendants();
                    }
                    Snapshot.Companion.sendApplyNotifications();
                }
            }));
        }
        r12.invoke();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
