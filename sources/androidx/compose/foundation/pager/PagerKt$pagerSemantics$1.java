package androidx.compose.foundation.pager;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PagerKt$pagerSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ PagerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerKt$pagerSemantics$1(boolean z, PagerState pagerState, CoroutineScope coroutineScope) {
        super(1);
        this.$isVertical = z;
        this.$state = pagerState;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        if (this.$isVertical) {
            final PagerState pagerState = this.$state;
            final CoroutineScope coroutineScope = this.$scope;
            SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m342invoke() {
                    return Boolean.valueOf(PagerKt.access$pagerSemantics$performBackwardPaging(pagerState, coroutineScope));
                }
            }, 1, null);
            final PagerState pagerState2 = this.$state;
            final CoroutineScope coroutineScope2 = this.$scope;
            SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m343invoke() {
                    return Boolean.valueOf(PagerKt.access$pagerSemantics$performForwardPaging(pagerState2, coroutineScope2));
                }
            }, 1, null);
            return;
        }
        final PagerState pagerState3 = this.$state;
        final CoroutineScope coroutineScope3 = this.$scope;
        SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m344invoke() {
                return Boolean.valueOf(PagerKt.access$pagerSemantics$performBackwardPaging(pagerState3, coroutineScope3));
            }
        }, 1, null);
        final PagerState pagerState4 = this.$state;
        final CoroutineScope coroutineScope4 = this.$scope;
        SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m345invoke() {
                return Boolean.valueOf(PagerKt.access$pagerSemantics$performForwardPaging(pagerState4, coroutineScope4));
            }
        }, 1, null);
    }
}
