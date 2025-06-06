package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class OverscrollConfiguration {

    @NotNull
    private final PaddingValues drawPadding;
    private final long glowColor;

    private OverscrollConfiguration(long j, PaddingValues paddingValues) {
        this.glowColor = j;
        this.drawPadding = paddingValues;
    }

    public /* synthetic */ OverscrollConfiguration(long j, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, paddingValues);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(OverscrollConfiguration.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) obj;
        return Color.m1051equalsimpl0(this.glowColor, overscrollConfiguration.glowColor) && Intrinsics.areEqual(this.drawPadding, overscrollConfiguration.drawPadding);
    }

    @NotNull
    public final PaddingValues getDrawPadding() {
        return this.drawPadding;
    }

    /* renamed from: getGlowColor-0d7_KjU, reason: not valid java name */
    public final long m148getGlowColor0d7_KjU() {
        return this.glowColor;
    }

    public int hashCode() {
        return (Color.m1057hashCodeimpl(this.glowColor) * 31) + this.drawPadding.hashCode();
    }

    @NotNull
    public String toString() {
        return "OverscrollConfiguration(glowColor=" + ((Object) Color.m1058toStringimpl(this.glowColor)) + ", drawPadding=" + this.drawPadding + ')';
    }

    public /* synthetic */ OverscrollConfiguration(long j, PaddingValues paddingValues, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ColorKt.Color(4284900966L) : j, (i & 2) != 0 ? PaddingKt.PaddingValues-YgX7TsA$default(0.0f, 0.0f, 3, (Object) null) : paddingValues, null);
    }
}
