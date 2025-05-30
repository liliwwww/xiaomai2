package androidx.compose.material;

import androidx.compose.runtime.RecomposeScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class FadeInFadeOutState<T> {

    @Nullable
    private Object current = new Object();

    @NotNull
    private List<FadeInFadeOutAnimationItem<T>> items = new ArrayList();

    @Nullable
    private RecomposeScope scope;

    @Nullable
    public final Object getCurrent() {
        return this.current;
    }

    @NotNull
    public final List<FadeInFadeOutAnimationItem<T>> getItems() {
        return this.items;
    }

    @Nullable
    public final RecomposeScope getScope() {
        return this.scope;
    }

    public final void setCurrent(@Nullable Object obj) {
        this.current = obj;
    }

    public final void setItems(@NotNull List<FadeInFadeOutAnimationItem<T>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public final void setScope(@Nullable RecomposeScope recomposeScope) {
        this.scope = recomposeScope;
    }
}
