package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class OnSizeChangedModifier extends InspectorValueInfo implements OnRemeasuredModifier {

    @NotNull
    private final Function1<IntSize, Unit> onSizeChanged;
    private long previousSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnSizeChangedModifier(@NotNull Function1<? super IntSize, Unit> function1, @NotNull Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "onSizeChanged");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        this.onSizeChanged = function1;
        this.previousSize = IntSizeKt.IntSize(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnSizeChangedModifier) {
            return Intrinsics.areEqual(this.onSizeChanged, ((OnSizeChangedModifier) obj).onSizeChanged);
        }
        return false;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @NotNull
    public final Function1<IntSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public int hashCode() {
        return this.onSizeChanged.hashCode();
    }

    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void m2067onRemeasuredozmzZPI(long j) {
        if (IntSize.m2683equalsimpl0(this.previousSize, j)) {
            return;
        }
        this.onSizeChanged.invoke(IntSize.m2677boximpl(j));
        this.previousSize = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
