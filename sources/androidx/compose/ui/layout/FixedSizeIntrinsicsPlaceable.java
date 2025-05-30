package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FixedSizeIntrinsicsPlaceable extends Placeable {
    public FixedSizeIntrinsicsPlaceable(int i, int i2) {
        setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(i, i2));
    }

    public int get(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return Integer.MIN_VALUE;
    }

    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    protected void m2052placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
    }
}
