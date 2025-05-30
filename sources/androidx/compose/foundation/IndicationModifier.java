package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class IndicationModifier implements DrawModifier {

    @NotNull
    private final IndicationInstance indicationInstance;

    public IndicationModifier(@NotNull IndicationInstance indicationInstance) {
        Intrinsics.checkNotNullParameter(indicationInstance, "indicationInstance");
        this.indicationInstance = indicationInstance;
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        this.indicationInstance.drawIndication(contentDrawScope);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @NotNull
    public final IndicationInstance getIndicationInstance() {
        return this.indicationInstance;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
