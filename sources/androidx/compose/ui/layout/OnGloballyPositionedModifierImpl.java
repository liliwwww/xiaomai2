package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class OnGloballyPositionedModifierImpl extends InspectorValueInfo implements OnGloballyPositionedModifier {

    @NotNull
    private final Function1<LayoutCoordinates, Unit> callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnGloballyPositionedModifierImpl(@NotNull Function1<? super LayoutCoordinates, Unit> function1, @NotNull Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "callback");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        this.callback = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnGloballyPositionedModifierImpl) {
            return Intrinsics.areEqual(this.callback, ((OnGloballyPositionedModifierImpl) obj).callback);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    public void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.callback.invoke(layoutCoordinates);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
