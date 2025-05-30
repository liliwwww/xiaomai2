package androidx.compose.foundation.layout;

import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
            int intrinsicSize;
            Intrinsics.checkNotNullParameter(list, "measurables");
            C04521 c04521 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinWidth$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i3));
                }
            };
            C04532 c04532 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinWidth$1.2
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
            intrinsicSize = RowColumnImplKt.intrinsicSize(list, c04521, c04532, i, i2, layoutOrientation, layoutOrientation);
            return Integer.valueOf(intrinsicSize);
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMinWidth = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinWidth$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            int intrinsicSize;
            Intrinsics.checkNotNullParameter(list, "measurables");
            intrinsicSize = RowColumnImplKt.intrinsicSize(list, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinWidth$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i3));
                }
            }, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinWidth$1.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                }
            }, i, i2, LayoutOrientation.Vertical, LayoutOrientation.Horizontal);
            return Integer.valueOf(intrinsicSize);
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMinHeight = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            int intrinsicSize;
            Intrinsics.checkNotNullParameter(list, "measurables");
            intrinsicSize = RowColumnImplKt.intrinsicSize(list, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1.1
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
            }, i, i2, LayoutOrientation.Horizontal, LayoutOrientation.Vertical);
            return Integer.valueOf(intrinsicSize);
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMinHeight = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinHeight$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            int intrinsicSize;
            Intrinsics.checkNotNullParameter(list, "measurables");
            C04581 c04581 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinHeight$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i3));
                }
            };
            C04592 c04592 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinHeight$1.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                }
            };
            LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
            intrinsicSize = RowColumnImplKt.intrinsicSize(list, c04581, c04592, i, i2, layoutOrientation, layoutOrientation);
            return Integer.valueOf(intrinsicSize);
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMaxWidth = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxWidth$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            int intrinsicSize;
            Intrinsics.checkNotNullParameter(list, "measurables");
            C04481 c04481 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxWidth$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                }
            };
            C04492 c04492 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxWidth$1.2
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
            intrinsicSize = RowColumnImplKt.intrinsicSize(list, c04481, c04492, i, i2, layoutOrientation, layoutOrientation);
            return Integer.valueOf(intrinsicSize);
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMaxWidth = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxWidth$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            int intrinsicSize;
            Intrinsics.checkNotNullParameter(list, "measurables");
            intrinsicSize = RowColumnImplKt.intrinsicSize(list, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxWidth$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                }
            }, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxWidth$1.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                }
            }, i, i2, LayoutOrientation.Vertical, LayoutOrientation.Horizontal);
            return Integer.valueOf(intrinsicSize);
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> HorizontalMaxHeight = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            int intrinsicSize;
            Intrinsics.checkNotNullParameter(list, "measurables");
            intrinsicSize = RowColumnImplKt.intrinsicSize(list, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1.1
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
            }, i, i2, LayoutOrientation.Horizontal, LayoutOrientation.Vertical);
            return Integer.valueOf(intrinsicSize);
        }
    };

    @NotNull
    private static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> VerticalMaxHeight = new Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxHeight$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
            int intrinsicSize;
            Intrinsics.checkNotNullParameter(list, "measurables");
            C04541 c04541 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxHeight$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                }
            };
            C04552 c04552 = new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxHeight$1.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                @NotNull
                public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                }
            };
            LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
            intrinsicSize = RowColumnImplKt.intrinsicSize(list, c04541, c04552, i, i2, layoutOrientation, layoutOrientation);
            return Integer.valueOf(intrinsicSize);
        }
    };

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
