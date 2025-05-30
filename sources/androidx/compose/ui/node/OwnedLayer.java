package androidx.compose.ui.node;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface OwnedLayer {
    void destroy();

    void drawLayer(@NotNull Canvas canvas);

    void invalidate();

    /* renamed from: inverseTransform-58bKbWc, reason: not valid java name */
    void m1701inverseTransform58bKbWc(@NotNull float[] fArr);

    /* renamed from: isInLayer-k-4lQ0M, reason: not valid java name */
    boolean m1702isInLayerk4lQ0M(long j);

    void mapBounds(@NotNull MutableRect mutableRect, boolean z);

    /* renamed from: mapOffset-8S9VItk, reason: not valid java name */
    long m1703mapOffset8S9VItk(long j, boolean z);

    /* renamed from: move--gyyYBs, reason: not valid java name */
    void m1704movegyyYBs(long j);

    /* renamed from: resize-ozmzZPI, reason: not valid java name */
    void m1705resizeozmzZPI(long j);

    void reuseLayer(@NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0);

    /* renamed from: transform-58bKbWc, reason: not valid java name */
    void m1706transform58bKbWc(@NotNull float[] fArr);

    void updateDisplayList();

    /* renamed from: updateLayerProperties-dDxr-wY, reason: not valid java name */
    void m1707updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, @NotNull Shape shape, boolean z, @Nullable RenderEffect renderEffect, long j2, long j3, int i, @NotNull LayoutDirection layoutDirection, @NotNull Density density);
}
