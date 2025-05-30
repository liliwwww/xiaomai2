package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class InspectableModifier extends InspectorValueInfo implements Modifier$Element {
    public static final int $stable = 0;

    @NotNull
    private final End end;

    /* compiled from: Taobao */
    public final class End implements Modifier$Element {
        public End() {
        }

        @Override // androidx.compose.ui.Modifier$Element
        public /* synthetic */ boolean all(Function1 function1) {
            return nt2.a(this, function1);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public /* synthetic */ boolean any(Function1 function1) {
            return nt2.b(this, function1);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
            return nt2.c(this, obj, function2);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
            return nt2.d(this, obj, function2);
        }

        public /* synthetic */ Modifier then(Modifier modifier) {
            return mt2.a(this, modifier);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InspectableModifier(@NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.end = new End();
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
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
    public final End getEnd() {
        return this.end;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
