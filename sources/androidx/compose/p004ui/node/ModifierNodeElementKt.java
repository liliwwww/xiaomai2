package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectableValueKt$debugInspectorInfo$1;
import androidx.compose.p004ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ModifierNodeElementKt {
    @ExperimentalComposeUiApi
    public static final /* synthetic */ <T extends Modifier.Node> Modifier modifierElementOf(final Object obj, final Function0<? extends T> function0, final Function1<? super T, Unit> function1, Function1<? super InspectorInfo, Unit> function12) {
        Intrinsics.checkNotNullParameter(function0, "create");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function12, "definitions");
        final Function1 inspectableValueKt$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new InspectableValueKt$debugInspectorInfo$1(function12) : InspectableValueKt.getNoInspectorInfo();
        Intrinsics.needClassReification();
        return new ModifierNodeElement<T>(obj, inspectableValueKt$debugInspectorInfo$1) { // from class: androidx.compose.ui.node.ModifierNodeElementKt$modifierElementOf$1
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public Modifier.Node create() {
                return (Modifier.Node) function0.invoke();
            }

            /* JADX WARN: Incorrect return type in method signature: (TT;)TT; */
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
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
        final Function1 inspectableValueKt$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new InspectableValueKt$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo();
        Intrinsics.needClassReification();
        return new ModifierNodeElement<T>(inspectableValueKt$debugInspectorInfo$1) { // from class: androidx.compose.ui.node.ModifierNodeElementKt$modifierElementOf$2
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public Modifier.Node create() {
                return (Modifier.Node) function0.invoke();
            }

            /* JADX WARN: Incorrect return type in method signature: (TT;)TT; */
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public Modifier.Node update(@NotNull Modifier.Node node) {
                Intrinsics.checkNotNullParameter(node, "node");
                return node;
            }
        };
    }
}
