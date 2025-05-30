package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class IntrinsicMeasureBlocks {

    @NotNull
    public static final IntrinsicMeasureBlocks INSTANCE = new IntrinsicMeasureBlocks();

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMinWidth = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinWidth$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "measurables");
            AnonymousClass1 anonymousClass1 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinWidth$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i3));
                }
            };
            AnonymousClass2 anonymousClass2 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinWidth$1.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                }
            };
            LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(list, anonymousClass1, anonymousClass2, i, i2, layoutOrientation, layoutOrientation));
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMinWidth = VerticalMinWidth.1.INSTANCE;

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMinHeight = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "measurables");
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(list, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i3));
                }
            }, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                }
            }, i, i2, LayoutOrientation.Horizontal, LayoutOrientation.Vertical));
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMinHeight = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinHeight$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "measurables");
            1 r2 = 1.INSTANCE;
            2 r3 = 2.INSTANCE;
            LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(list, r2, r3, i, i2, layoutOrientation, layoutOrientation));
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMaxWidth = HorizontalMaxWidth.1.INSTANCE;

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMaxWidth = VerticalMaxWidth.1.INSTANCE;

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMaxHeight = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "measurables");
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(list, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                }
            }, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                }
            }, i, i2, LayoutOrientation.Horizontal, LayoutOrientation.Vertical));
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMaxHeight = VerticalMaxHeight.1.INSTANCE;

    private IntrinsicMeasureBlocks() {
    }

    @NotNull
    public final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getHorizontalMaxHeight() {
        return HorizontalMaxHeight;
    }

    @NotNull
    public final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getHorizontalMaxWidth() {
        return HorizontalMaxWidth;
    }

    @NotNull
    public final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getHorizontalMinHeight() {
        return HorizontalMinHeight;
    }

    @NotNull
    public final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getHorizontalMinWidth() {
        return HorizontalMinWidth;
    }

    @NotNull
    public final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getVerticalMaxHeight() {
        return VerticalMaxHeight;
    }

    @NotNull
    public final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getVerticalMaxWidth() {
        return VerticalMaxWidth;
    }

    @NotNull
    public final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getVerticalMinHeight() {
        return VerticalMinHeight;
    }

    @NotNull
    public final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> getVerticalMinWidth() {
        return VerticalMinWidth;
    }
}
