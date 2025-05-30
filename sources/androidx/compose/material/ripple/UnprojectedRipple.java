package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class UnprojectedRipple extends RippleDrawable {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static boolean setMaxRadiusFetched;

    @Nullable
    private static Method setMaxRadiusMethod;
    private final boolean bounded;
    private boolean projected;

    @Nullable
    private Color rippleColor;

    @Nullable
    private Integer rippleRadius;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UnprojectedRipple(boolean z) {
        super(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK), null, z ? new ColorDrawable(-1) : null);
        this.bounded = z;
    }

    /* renamed from: calculateRippleColor-5vOe2sY, reason: not valid java name */
    private final long m899calculateRippleColor5vOe2sY(long j, float f) {
        if (Build.VERSION.SDK_INT < 28) {
            f *= 2;
        }
        return Color.copy-wmQWz5c$default(j, RangesKt.coerceAtMost(f, 1.0f), 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    @NotNull
    public Rect getDirtyBounds() {
        if (!this.bounded) {
            this.projected = true;
        }
        Rect dirtyBounds = super.getDirtyBounds();
        Intrinsics.checkNotNullExpressionValue(dirtyBounds, "super.getDirtyBounds()");
        this.projected = false;
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return this.projected;
    }

    /* renamed from: setColor-DxMtmZc, reason: not valid java name */
    public final void m900setColorDxMtmZc(long j, float f) {
        long m899calculateRippleColor5vOe2sY = m899calculateRippleColor5vOe2sY(j, f);
        Color color = this.rippleColor;
        if (color == null ? false : Color.equals-impl0(color.unbox-impl(), m899calculateRippleColor5vOe2sY)) {
            return;
        }
        this.rippleColor = Color.box-impl(m899calculateRippleColor5vOe2sY);
        setColor(ColorStateList.valueOf(ColorKt.toArgb-8_81llA(m899calculateRippleColor5vOe2sY)));
    }

    public final void trySetRadius(int i) {
        Integer num = this.rippleRadius;
        if (num != null && num.intValue() == i) {
            return;
        }
        this.rippleRadius = Integer.valueOf(i);
        if (Build.VERSION.SDK_INT >= 23) {
            MRadiusHelper.INSTANCE.setRadius(this, i);
            return;
        }
        try {
            if (!setMaxRadiusFetched) {
                setMaxRadiusFetched = true;
                setMaxRadiusMethod = RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE);
            }
            Method method = setMaxRadiusMethod;
            if (method != null) {
                method.invoke(this, Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }
}
