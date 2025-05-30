package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CanvasDrawScope$drawContext$1 implements DrawContext {
    final /* synthetic */ CanvasDrawScope this$0;

    @NotNull
    private final DrawTransform transform = CanvasDrawScopeKt.access$asDrawTransform(this);

    CanvasDrawScope$drawContext$1(CanvasDrawScope canvasDrawScope) {
        this.this$0 = canvasDrawScope;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawContext
    @NotNull
    public Canvas getCanvas() {
        return this.this$0.getDrawParams().getCanvas();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawContext
    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public long mo1254getSizeNHjbRc() {
        return this.this$0.getDrawParams().getSize-NH-jbRc();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawContext
    @NotNull
    public DrawTransform getTransform() {
        return this.transform;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawContext
    /* renamed from: setSize-uvyYCjk, reason: not valid java name */
    public void mo1255setSizeuvyYCjk(long j) {
        this.this$0.getDrawParams().setSize-uvyYCjk(j);
    }
}
