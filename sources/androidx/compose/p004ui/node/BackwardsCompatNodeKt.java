package androidx.compose.p004ui.node;

import androidx.compose.p004ui.modifier.ModifierLocal;
import androidx.compose.p004ui.modifier.ModifierLocalReadScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class BackwardsCompatNodeKt {

    @NotNull
    private static final BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 DetachedModifierLocalReadScope = new ModifierLocalReadScope() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1
        @Override // androidx.compose.p004ui.modifier.ModifierLocalReadScope
        public <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal) {
            Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
            return (T) modifierLocal.getDefaultFactory$ui_release().invoke();
        }
    };

    @NotNull
    private static final Function1<BackwardsCompatNode, Unit> onDrawCacheReadsChanged = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$onDrawCacheReadsChanged$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BackwardsCompatNode) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull BackwardsCompatNode backwardsCompatNode) {
            Intrinsics.checkNotNullParameter(backwardsCompatNode, "it");
            backwardsCompatNode.onDrawCacheReadsChanged$ui_release();
        }
    };

    @NotNull
    private static final Function1<BackwardsCompatNode, Unit> updateModifierLocalConsumer = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$updateModifierLocalConsumer$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BackwardsCompatNode) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull BackwardsCompatNode backwardsCompatNode) {
            Intrinsics.checkNotNullParameter(backwardsCompatNode, "it");
            backwardsCompatNode.updateModifierLocalConsumer();
        }
    };
}
