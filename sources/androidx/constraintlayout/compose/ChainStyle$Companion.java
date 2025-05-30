package androidx.constraintlayout.compose;

import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.state.State$Chain;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\"\u0010\f\u001a\u00020\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/constraintlayout/compose/ChainStyle$Companion;", "", "", "bias", "Landroidx/constraintlayout/compose/ChainStyle;", "Packed", "Spread", "Landroidx/constraintlayout/compose/ChainStyle;", "getSpread", "()Landroidx/constraintlayout/compose/ChainStyle;", "getSpread$annotations", "()V", "SpreadInside", "getSpreadInside", "getSpreadInside$annotations", "getPacked", "getPacked$annotations", "<init>", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ChainStyle$Companion {
    private ChainStyle$Companion() {
    }

    public /* synthetic */ ChainStyle$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Stable
    public static /* synthetic */ void getPacked$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpread$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpreadInside$annotations() {
    }

    @Stable
    @NotNull
    public final ChainStyle Packed(float bias) {
        return new ChainStyle(State$Chain.PACKED, Float.valueOf(bias));
    }

    @NotNull
    public final ChainStyle getPacked() {
        return ChainStyle.access$getPacked$cp();
    }

    @NotNull
    public final ChainStyle getSpread() {
        return ChainStyle.access$getSpread$cp();
    }

    @NotNull
    public final ChainStyle getSpreadInside() {
        return ChainStyle.access$getSpreadInside$cp();
    }
}
