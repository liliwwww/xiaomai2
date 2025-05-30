package androidx.compose.p004ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class TypefaceDirtyTracker {

    @NotNull
    private final Object initial;

    @NotNull
    private final State<Object> resolveResult;

    public TypefaceDirtyTracker(@NotNull State<? extends Object> state) {
        Intrinsics.checkNotNullParameter(state, "resolveResult");
        this.resolveResult = state;
        this.initial = state.getValue();
    }

    @NotNull
    public final Object getInitial() {
        return this.initial;
    }

    @NotNull
    public final State<Object> getResolveResult() {
        return this.resolveResult;
    }

    @NotNull
    public final Typeface getTypeface() {
        Object obj = this.initial;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) obj;
    }

    public final boolean isStaleResolvedFont() {
        return this.resolveResult.getValue() != this.initial;
    }
}
