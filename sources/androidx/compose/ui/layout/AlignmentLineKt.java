package androidx.compose.ui.layout;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AlignmentLineKt {

    @NotNull
    private static final HorizontalAlignmentLine FirstBaseline = new HorizontalAlignmentLine(AlignmentLineKt$FirstBaseline$1.INSTANCE);

    @NotNull
    private static final HorizontalAlignmentLine LastBaseline = new HorizontalAlignmentLine(LastBaseline.1.INSTANCE);

    @NotNull
    public static final HorizontalAlignmentLine getFirstBaseline() {
        return FirstBaseline;
    }

    @NotNull
    public static final HorizontalAlignmentLine getLastBaseline() {
        return LastBaseline;
    }

    public static final int merge(@NotNull AlignmentLine alignmentLine, int i, int i2) {
        Intrinsics.checkNotNullParameter(alignmentLine, "<this>");
        return ((Number) alignmentLine.getMerger$ui_release().invoke(Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }
}
