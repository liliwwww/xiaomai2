package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.Immutable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
final class ArrowValues {
    private final float alpha;
    private final float endAngle;
    private final float rotation;
    private final float scale;
    private final float startAngle;

    public ArrowValues(float f, float f2, float f3, float f4, float f5) {
        this.alpha = f;
        this.rotation = f2;
        this.startAngle = f3;
        this.endAngle = f4;
        this.scale = f5;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getEndAngle() {
        return this.endAngle;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getStartAngle() {
        return this.startAngle;
    }
}
