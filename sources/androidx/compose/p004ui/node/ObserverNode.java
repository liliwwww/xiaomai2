package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
public interface ObserverNode extends DelegatableNode {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    @ExperimentalComposeUiApi
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final Function1<ObserverNode, Unit> OnObserveReadsChanged = new Function1<ObserverNode, Unit>() { // from class: androidx.compose.ui.node.ObserverNode$Companion$OnObserveReadsChanged$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverNode observerNode) {
                Intrinsics.checkNotNullParameter(observerNode, "it");
                if (observerNode.getNode().isAttached()) {
                    observerNode.onObservedReadsChanged();
                }
            }
        };

        private Companion() {
        }

        @NotNull
        public final Function1<ObserverNode, Unit> getOnObserveReadsChanged$ui_release() {
            return OnObserveReadsChanged;
        }
    }

    void onObservedReadsChanged();
}
