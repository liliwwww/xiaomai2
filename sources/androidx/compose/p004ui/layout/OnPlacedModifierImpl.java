package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class OnPlacedModifierImpl extends InspectorValueInfo implements OnPlacedModifier {

    @NotNull
    private final Function1<LayoutCoordinates, Unit> callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnPlacedModifierImpl(@NotNull Function1<? super LayoutCoordinates, Unit> function1, @NotNull Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "callback");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        this.callback = function1;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnPlacedModifierImpl) {
            return Intrinsics.areEqual(this.callback, ((OnPlacedModifierImpl) obj).callback);
        }
        return false;
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
    public final Function1<LayoutCoordinates, Unit> getCallback() {
        return this.callback;
    }

    public int hashCode() {
        return this.callback.hashCode();
    }

    @Override // androidx.compose.p004ui.layout.OnPlacedModifier
    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.callback.invoke(layoutCoordinates);
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
