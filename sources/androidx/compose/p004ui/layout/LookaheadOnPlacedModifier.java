package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LookaheadOnPlacedModifier implements Modifier.Element {

    @NotNull
    private final Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> callback;

    @NotNull
    private final Function0<LookaheadLayoutCoordinates> rootCoordinates;

    /* JADX WARN: Multi-variable type inference failed */
    public LookaheadOnPlacedModifier(@NotNull Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> function2, @NotNull Function0<? extends LookaheadLayoutCoordinates> function0) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        Intrinsics.checkNotNullParameter(function0, "rootCoordinates");
        this.callback = function2;
        this.rootCoordinates = function0;
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

    @NotNull
    public final Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> getCallback() {
        return this.callback;
    }

    @NotNull
    public final Function0<LookaheadLayoutCoordinates> getRootCoordinates() {
        return this.rootCoordinates;
    }

    public final void onPlaced(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "coordinates");
        this.callback.invoke(this.rootCoordinates.invoke(), lookaheadLayoutCoordinates);
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
