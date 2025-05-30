package androidx.compose.p004ui.graphics.drawscope;

import androidx.compose.p004ui.graphics.Canvas;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface DrawContext {
    @NotNull
    Canvas getCanvas();

    /* renamed from: getSize-NH-jbRc */
    long mo3211getSizeNHjbRc();

    @NotNull
    DrawTransform getTransform();

    /* renamed from: setSize-uvyYCjk */
    void mo3212setSizeuvyYCjk(long j);
}
