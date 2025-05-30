package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ObserverNodeKt {
    @ExperimentalComposeUiApi
    public static final <T extends Modifier.Node & ObserverNode> void observeReads(@NotNull T t, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        DelegatableNodeKt.requireOwner(t).getSnapshotObserver().observeReads$ui_release(t, ObserverNode.Companion.getOnObserveReadsChanged$ui_release(), function0);
    }
}
