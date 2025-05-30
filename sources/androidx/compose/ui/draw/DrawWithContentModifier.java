package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DrawWithContentModifier extends InspectorValueInfo implements DrawModifier {

    @NotNull
    private final Function1<ContentDrawScope, Unit> onDraw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawWithContentModifier(@NotNull Function1<? super ContentDrawScope, Unit> function1, @NotNull Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "onDraw");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        this.onDraw = function1;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        this.onDraw.invoke(contentDrawScope);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawWithContentModifier) {
            return Intrinsics.areEqual(this.onDraw, ((DrawWithContentModifier) obj).onDraw);
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
    public final Function1<ContentDrawScope, Unit> getOnDraw() {
        return this.onDraw;
    }

    public int hashCode() {
        return this.onDraw.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
