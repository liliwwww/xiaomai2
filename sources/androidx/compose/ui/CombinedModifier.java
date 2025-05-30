package androidx.compose.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CombinedModifier implements Modifier {
    public static final int $stable = 0;

    @NotNull
    private final Modifier inner;

    @NotNull
    private final Modifier outer;

    public CombinedModifier(@NotNull Modifier modifier, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "outer");
        Intrinsics.checkNotNullParameter(modifier2, "inner");
        this.outer = modifier;
        this.inner = modifier2;
    }

    @Override // androidx.compose.ui.Modifier
    public boolean all(@NotNull Function1<? super Modifier.Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return this.outer.all(function1) && this.inner.all(function1);
    }

    @Override // androidx.compose.ui.Modifier
    public boolean any(@NotNull Function1<? super Modifier.Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return this.outer.any(function1) || this.inner.any(function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CombinedModifier) {
            CombinedModifier combinedModifier = (CombinedModifier) obj;
            if (Intrinsics.areEqual(this.outer, combinedModifier.outer) && Intrinsics.areEqual(this.inner, combinedModifier.inner)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.Modifier
    public <R> R foldIn(R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) this.inner.foldIn(this.outer.foldIn(r, function2), function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.Modifier
    public <R> R foldOut(R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) this.outer.foldOut(this.inner.foldOut(r, function2), function2);
    }

    @NotNull
    public final Modifier getInner$ui_release() {
        return this.inner;
    }

    @NotNull
    public final Modifier getOuter$ui_release() {
        return this.outer;
    }

    public int hashCode() {
        return this.outer.hashCode() + (this.inner.hashCode() * 31);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return '[' + ((String) foldIn("", new Function2<String, Modifier.Element, String>() { // from class: androidx.compose.ui.CombinedModifier$toString$1
            @NotNull
            public final String invoke(@NotNull String str, @NotNull Modifier.Element element) {
                Intrinsics.checkNotNullParameter(str, "acc");
                Intrinsics.checkNotNullParameter(element, "element");
                if (str.length() == 0) {
                    return element.toString();
                }
                return str + ", " + element;
            }
        })) + ']';
    }
}
