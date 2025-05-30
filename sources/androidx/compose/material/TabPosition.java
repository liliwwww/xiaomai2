package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TabPosition {
    private final float left;
    private final float width;

    private TabPosition(float f, float f2) {
        this.left = f;
        this.width = f2;
    }

    public /* synthetic */ TabPosition(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabPosition)) {
            return false;
        }
        TabPosition tabPosition = (TabPosition) obj;
        return Dp.equals-impl0(this.left, tabPosition.left) && Dp.equals-impl0(this.width, tabPosition.width);
    }

    /* renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m842getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m843getRightD9Ej5fM() {
        return Dp.constructor-impl(this.left + this.width);
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m844getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.left) * 31) + Dp.hashCode-impl(this.width);
    }

    @NotNull
    public String toString() {
        return "TabPosition(left=" + ((Object) Dp.toString-impl(this.left)) + ", right=" + ((Object) Dp.toString-impl(m843getRightD9Ej5fM())) + ", width=" + ((Object) Dp.toString-impl(this.width)) + ')';
    }
}
