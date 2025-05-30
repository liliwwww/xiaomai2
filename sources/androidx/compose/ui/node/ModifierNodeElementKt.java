package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ModifierNodeElementKt {
    @ExperimentalComposeUiApi
    public static final /* synthetic */ <T extends Modifier.Node> Modifier modifierElementOf(final Object obj, final Function0<? extends T> function0, final Function1<? super T, Unit> function1, Function1<? super InspectorInfo, Unit> function12) {
        Intrinsics.checkNotNullParameter(function0, "create");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function12, "definitions");
        final InspectableValueKt.debugInspectorInfo.1 r0 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new InspectableValueKt.debugInspectorInfo.1(function12) : InspectableValueKt.getNoInspectorInfo();
        Intrinsics.needClassReification();
        return new ModifierNodeElement<T>(obj, r0) { // from class: androidx.compose.ui.node.ModifierNodeElementKt$modifierElementOf$1
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @NotNull
            public Modifier.Node create() {
                return (Modifier.Node) function0.invoke();
            }

            /* JADX WARN: Incorrect return type in method signature: (TT;)TT; */
            @NotNull
            public Modifier.Node update(@NotNull Modifier.Node node) {
                Intrinsics.checkNotNullParameter(node, "node");
                function1.invoke(node);
                return node;
            }
        };
    }

    @ExperimentalComposeUiApi
    public static final /* synthetic */ <T extends Modifier.Node> Modifier modifierElementOf(final Function0<? extends T> function0, Function1<? super InspectorInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "create");
        Intrinsics.checkNotNullParameter(function1, "definitions");
        final InspectableValueKt.debugInspectorInfo.1 r0 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new InspectableValueKt.debugInspectorInfo.1(function1) : InspectableValueKt.getNoInspectorInfo();
        Intrinsics.needClassReification();
        return new ModifierNodeElement<T>(r0) { // from class: androidx.compose.ui.node.ModifierNodeElementKt$modifierElementOf$2
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @NotNull
            public Modifier.Node create() {
                return (Modifier.Node) function0.invoke();
            }

            /* JADX WARN: Incorrect return type in method signature: (TT;)TT; */
            @NotNull
            public Modifier.Node update(@NotNull Modifier.Node node) {
                Intrinsics.checkNotNullParameter(node, "node");
                return node;
            }
        };
    }
}
