package androidx.compose.material.pullrefresh;

import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PullRefreshKt {
    @ExperimentalMaterialApi
    @NotNull
    public static final Modifier pullRefresh(@NotNull Modifier modifier, @NotNull final PullRefreshState pullRefreshState, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(pullRefreshState, "state");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshKt$pullRefresh$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("pullRefresh");
                inspectorInfo.getProperties().set("state", pullRefreshState);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo(), pullRefresh(Modifier.Companion, new PullRefreshKt$pullRefresh$2$1(pullRefreshState), new PullRefreshKt$pullRefresh$2$2(pullRefreshState, null), z));
    }

    public static /* synthetic */ Modifier pullRefresh$default(Modifier modifier, PullRefreshState pullRefreshState, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return pullRefresh(modifier, pullRefreshState, z);
    }

    public static /* synthetic */ Modifier pullRefresh$default(Modifier modifier, Function1 function1, Function2 function2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pullRefresh(modifier, function1, function2, z);
    }

    @ExperimentalMaterialApi
    @NotNull
    public static final Modifier pullRefresh(@NotNull Modifier modifier, @NotNull final Function1<? super Float, Float> function1, @NotNull final Function2<? super Float, ? super Continuation<? super Unit>, ? extends Object> function2, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onPull");
        Intrinsics.checkNotNullParameter(function2, "onRelease");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshKt$pullRefresh$$inlined$debugInspectorInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("pullRefresh");
                inspectorInfo.getProperties().set("onPull", function1);
                inspectorInfo.getProperties().set("onRelease", function2);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo(), NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, new PullRefreshNestedScrollConnection(function1, function2, z), (NestedScrollDispatcher) null, 2, (Object) null));
    }
}
