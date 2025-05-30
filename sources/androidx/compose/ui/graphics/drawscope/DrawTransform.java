package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Path;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@DrawScopeMarker
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface DrawTransform {
    /* renamed from: clipPath-mtrdD-E */
    void mo1327clipPathmtrdDE(@NotNull Path path, int i);

    /* renamed from: clipRect-N_I0leg */
    void mo1328clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* renamed from: getCenter-F1C5BW0 */
    long mo1329getCenterF1C5BW0();

    /* renamed from: getSize-NH-jbRc */
    long mo1330getSizeNHjbRc();

    void inset(float f, float f2, float f3, float f4);

    /* renamed from: rotate-Uv8p0NA */
    void mo1331rotateUv8p0NA(float f, long j);

    /* renamed from: scale-0AR0LA0 */
    void mo1332scale0AR0LA0(float f, float f2, long j);

    /* renamed from: transform-58bKbWc */
    void mo1333transform58bKbWc(@NotNull float[] fArr);

    void translate(float f, float f2);
}
