package androidx.compose.p004ui.graphics.drawscope;

import androidx.compose.p004ui.graphics.Path;
import org.jetbrains.annotations.NotNull;
import tb.y51;

/* compiled from: Taobao */
@DrawScopeMarker
/* loaded from: classes.dex */
public interface DrawTransform {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m3285getCenterF1C5BW0(@NotNull DrawTransform drawTransform) {
            return y51.b(drawTransform);
        }
    }

    /* renamed from: clipPath-mtrdD-E */
    void mo3213clipPathmtrdDE(@NotNull Path path, int i);

    /* renamed from: clipRect-N_I0leg */
    void mo3214clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* renamed from: getCenter-F1C5BW0 */
    long mo3215getCenterF1C5BW0();

    /* renamed from: getSize-NH-jbRc */
    long mo3216getSizeNHjbRc();

    void inset(float f, float f2, float f3, float f4);

    /* renamed from: rotate-Uv8p0NA */
    void mo3217rotateUv8p0NA(float f, long j);

    /* renamed from: scale-0AR0LA0 */
    void mo3218scale0AR0LA0(float f, float f2, long j);

    /* renamed from: transform-58bKbWc */
    void mo3219transform58bKbWc(@NotNull float[] fArr);

    void translate(float f, float f2);
}
