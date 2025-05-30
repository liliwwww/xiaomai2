package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ObserverNodeKt {
    @ExperimentalComposeUiApi
    public static final <T extends Modifier.Node & ObserverNode> void observeReads(@NotNull T t, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        DelegatableNodeKt.requireOwner(t).getSnapshotObserver().observeReads$ui_release(t, ObserverNode.Companion.getOnObserveReadsChanged$ui_release(), function0);
    }
}
