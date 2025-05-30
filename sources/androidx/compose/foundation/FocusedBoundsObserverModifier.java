package androidx.compose.foundation;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.modifier.ModifierLocalConsumer;
import androidx.compose.p004ui.modifier.ModifierLocalProvider;
import androidx.compose.p004ui.modifier.ModifierLocalReadScope;
import androidx.compose.p004ui.modifier.ProvidableModifierLocal;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class FocusedBoundsObserverModifier implements ModifierLocalConsumer, ModifierLocalProvider<Function1<? super LayoutCoordinates, ? extends Unit>>, Function1<LayoutCoordinates, Unit> {

    @NotNull
    private final Function1<LayoutCoordinates, Unit> handler;

    @Nullable
    private LayoutCoordinates lastBounds;

    @Nullable
    private Function1<? super LayoutCoordinates, Unit> parent;

    /* JADX WARN: Multi-variable type inference failed */
    public FocusedBoundsObserverModifier(@NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "handler");
        this.handler = function1;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<Function1<? super LayoutCoordinates, ? extends Unit>> getKey() {
        return FocusedBoundsKt.getModifierLocalFocusedBoundsObserver();
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalProvider
    @NotNull
    public Function1<? super LayoutCoordinates, ? extends Unit> getValue() {
        return this;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        Function1<? super LayoutCoordinates, Unit> function1 = (Function1) modifierLocalReadScope.getCurrent(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver());
        if (Intrinsics.areEqual(function1, this.parent)) {
            return;
        }
        this.parent = function1;
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    public void invoke(@Nullable LayoutCoordinates layoutCoordinates) {
        this.lastBounds = layoutCoordinates;
        this.handler.invoke(layoutCoordinates);
        Function1<? super LayoutCoordinates, Unit> function1 = this.parent;
        if (function1 != null) {
            function1.invoke(layoutCoordinates);
        }
    }
}
