package androidx.compose.material;

import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
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
        return C0856Dp.m5221equalsimpl0(this.left, tabPosition.left) && C0856Dp.m5221equalsimpl0(this.width, tabPosition.width);
    }

    /* renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m2286getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m2287getRightD9Ej5fM() {
        return C0856Dp.m5216constructorimpl(this.left + this.width);
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m2288getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (C0856Dp.m5222hashCodeimpl(this.left) * 31) + C0856Dp.m5222hashCodeimpl(this.width);
    }

    @NotNull
    public String toString() {
        return "TabPosition(left=" + ((Object) C0856Dp.m5227toStringimpl(this.left)) + ", right=" + ((Object) C0856Dp.m5227toStringimpl(m2287getRightD9Ej5fM())) + ", width=" + ((Object) C0856Dp.m5227toStringimpl(this.width)) + ')';
    }
}
