package androidx.compose.p004ui.semantics;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.SemanticsModifierNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SemanticsNode$fakeSemanticsNode$fakeNode$1 extends Modifier.Node implements SemanticsModifierNode {

    @NotNull
    private final SemanticsConfiguration semanticsConfiguration;

    SemanticsNode$fakeSemanticsNode$fakeNode$1(Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.setMergingSemanticsOfDescendants(false);
        semanticsConfiguration.setClearingSemantics(false);
        function1.invoke(semanticsConfiguration);
        this.semanticsConfiguration = semanticsConfiguration;
    }

    @Override // androidx.compose.p004ui.node.SemanticsModifierNode
    @NotNull
    public SemanticsConfiguration getSemanticsConfiguration() {
        return this.semanticsConfiguration;
    }
}
