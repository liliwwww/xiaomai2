package androidx.compose.ui;

import androidx.compose.runtime.Immutable;
import androidx.constraintlayout.core.state.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/constraintlayout/compose/ChainStyle;", "", "Landroidx/constraintlayout/core/state/State$Chain;", "Landroidx/constraintlayout/compose/SolverChain;", "style", "Landroidx/constraintlayout/core/state/State$Chain;", "getStyle$compose_release", "()Landroidx/constraintlayout/core/state/State$Chain;", "", "bias", "Ljava/lang/Float;", "getBias$compose_release", "()Ljava/lang/Float;", "<init>", "(Landroidx/constraintlayout/core/state/State$Chain;Ljava/lang/Float;)V", "Companion", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ChainStyle {

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final ChainStyle Packed;

    @NotNull
    private static final ChainStyle Spread;

    @NotNull
    private static final ChainStyle SpreadInside;

    @Nullable
    private final Float bias;

    @NotNull
    private final State.Chain style;

    static {
        Float f = null;
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        int i = 2;
        Spread = new ChainStyle(State.Chain.SPREAD, f, i, f);
        SpreadInside = new ChainStyle(State.Chain.SPREAD_INSIDE, f, i, f);
        Packed = companion.Packed(0.5f);
    }

    public ChainStyle(@NotNull State.Chain chain, @Nullable Float f) {
        Intrinsics.checkNotNullParameter(chain, "style");
        this.style = chain;
        this.bias = f;
    }

    @Nullable
    /* renamed from: getBias$compose_release, reason: from getter */
    public final Float getBias() {
        return this.bias;
    }

    @NotNull
    /* renamed from: getStyle$compose_release, reason: from getter */
    public final State.Chain getStyle() {
        return this.style;
    }

    public /* synthetic */ ChainStyle(State.Chain chain, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chain, (i & 2) != 0 ? null : f);
    }
}
