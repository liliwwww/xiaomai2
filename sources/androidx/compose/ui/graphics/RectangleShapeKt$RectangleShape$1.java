package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RectangleShapeKt$RectangleShape$1 implements Shape {
    RectangleShapeKt$RectangleShape$1() {
    }

    @NotNull
    public String toString() {
        return "RectangleShape";
    }

    @Override // androidx.compose.ui.graphics.Shape
    @NotNull
    /* renamed from: createOutline-Pq9zytI, reason: not valid java name and merged with bridge method [inline-methods] */
    public Outline.Rectangle mo130createOutlinePq9zytI(long j, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        return new Outline.Rectangle(SizeKt.m924toRectuvyYCjk(j));
    }
}
