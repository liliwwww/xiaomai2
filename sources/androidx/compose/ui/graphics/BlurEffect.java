package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BlurEffect extends RenderEffect {
    private final int edgeTreatment;
    private final float radiusX;
    private final float radiusY;

    @Nullable
    private final RenderEffect renderEffect;

    private BlurEffect(RenderEffect renderEffect, float f, float f2, int i) {
        super((DefaultConstructorMarker) null);
        this.renderEffect = renderEffect;
        this.radiusX = f;
        this.radiusY = f2;
        this.edgeTreatment = i;
    }

    public /* synthetic */ BlurEffect(RenderEffect renderEffect, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderEffect, f, f2, i);
    }

    @RequiresApi(31)
    @NotNull
    protected RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.createBlurEffect-8A-3gB4(this.renderEffect, this.radiusX, this.radiusY, this.edgeTreatment);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlurEffect)) {
            return false;
        }
        BlurEffect blurEffect = (BlurEffect) obj;
        if (this.radiusX == blurEffect.radiusX) {
            return ((this.radiusY > blurEffect.radiusY ? 1 : (this.radiusY == blurEffect.radiusY ? 0 : -1)) == 0) && TileMode.equals-impl0(this.edgeTreatment, blurEffect.edgeTreatment) && Intrinsics.areEqual(this.renderEffect, blurEffect.renderEffect);
        }
        return false;
    }

    public int hashCode() {
        RenderEffect renderEffect = this.renderEffect;
        return ((((((renderEffect != null ? renderEffect.hashCode() : 0) * 31) + Float.floatToIntBits(this.radiusX)) * 31) + Float.floatToIntBits(this.radiusY)) * 31) + TileMode.hashCode-impl(this.edgeTreatment);
    }

    @NotNull
    public String toString() {
        return "BlurEffect(renderEffect=" + this.renderEffect + ", radiusX=" + this.radiusX + ", radiusY=" + this.radiusY + ", edgeTreatment=" + ((Object) TileMode.toString-impl(this.edgeTreatment)) + ')';
    }

    public /* synthetic */ BlurEffect(RenderEffect renderEffect, float f, float f2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderEffect, f, (i2 & 4) != 0 ? f : f2, (i2 & 8) != 0 ? TileMode.Companion.m1258getClamp3opZhB0() : i, null);
    }
}
