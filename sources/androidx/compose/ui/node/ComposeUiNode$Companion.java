package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ComposeUiNode$Companion {
    static final /* synthetic */ ComposeUiNode$Companion $$INSTANCE = new ComposeUiNode$Companion();

    @NotNull
    private static final Function0<ComposeUiNode> Constructor = LayoutNode.Companion.getConstructor$ui_release();

    @NotNull
    private static final Function0<ComposeUiNode> VirtualConstructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$VirtualConstructor$1
        @NotNull
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LayoutNode m1593invoke() {
            return new LayoutNode(true, 0, 2, (DefaultConstructorMarker) null);
        }
    };

    @NotNull
    private static final Function2<ComposeUiNode, Modifier, Unit> SetModifier = new Function2<ComposeUiNode, Modifier, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((ComposeUiNode) obj, (Modifier) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull ComposeUiNode composeUiNode, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
            Intrinsics.checkNotNullParameter(modifier, "it");
            composeUiNode.setModifier(modifier);
        }
    };

    @NotNull
    private static final Function2<ComposeUiNode, Density, Unit> SetDensity = SetDensity.1.INSTANCE;

    @NotNull
    private static final Function2<ComposeUiNode, MeasurePolicy, Unit> SetMeasurePolicy = SetMeasurePolicy.1.INSTANCE;

    @NotNull
    private static final Function2<ComposeUiNode, LayoutDirection, Unit> SetLayoutDirection = SetLayoutDirection.1.INSTANCE;

    @NotNull
    private static final Function2<ComposeUiNode, ViewConfiguration, Unit> SetViewConfiguration = SetViewConfiguration.1.INSTANCE;

    private ComposeUiNode$Companion() {
    }

    @NotNull
    public final Function0<ComposeUiNode> getConstructor() {
        return Constructor;
    }

    @NotNull
    public final Function2<ComposeUiNode, Density, Unit> getSetDensity() {
        return SetDensity;
    }

    @NotNull
    public final Function2<ComposeUiNode, LayoutDirection, Unit> getSetLayoutDirection() {
        return SetLayoutDirection;
    }

    @NotNull
    public final Function2<ComposeUiNode, MeasurePolicy, Unit> getSetMeasurePolicy() {
        return SetMeasurePolicy;
    }

    @NotNull
    public final Function2<ComposeUiNode, Modifier, Unit> getSetModifier() {
        return SetModifier;
    }

    @NotNull
    public final Function2<ComposeUiNode, ViewConfiguration, Unit> getSetViewConfiguration() {
        return SetViewConfiguration;
    }

    @NotNull
    public final Function0<ComposeUiNode> getVirtualConstructor() {
        return VirtualConstructor;
    }
}
