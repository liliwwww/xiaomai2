package androidx.constraintlayout.compose;

import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.ConstraintReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\u0007\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003RB\u0010\u000e\u001a+\u0012'\u0012%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0002\b\r0\u000b0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R<\u0010\u0013\u001a%\u0012!\u0012\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\u0002\b\r0\u000b0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R0\u0010\u0017\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\u0002\b\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Landroidx/constraintlayout/compose/AnchorFunctions;", "", "Landroidx/constraintlayout/core/state/ConstraintReference;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "", "clearLeft", "clearRight", "", "index", "verticalAnchorIndexToFunctionIndex", "", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "verticalAnchorFunctions", "[[Lkotlin/jvm/functions/Function3;", "getVerticalAnchorFunctions", "()[[Lkotlin/jvm/functions/Function3;", "Lkotlin/Function2;", "horizontalAnchorFunctions", "[[Lkotlin/jvm/functions/Function2;", "getHorizontalAnchorFunctions", "()[[Lkotlin/jvm/functions/Function2;", "baselineAnchorFunction", "Lkotlin/jvm/functions/Function2;", "getBaselineAnchorFunction", "()Lkotlin/jvm/functions/Function2;", "<init>", "()V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AnchorFunctions {

    @NotNull
    public static final AnchorFunctions INSTANCE = new AnchorFunctions();

    @NotNull
    private static final Function3<ConstraintReference, Object, LayoutDirection, ConstraintReference>[][] verticalAnchorFunctions = {new Function3[]{new Function3<ConstraintReference, Object, LayoutDirection, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$verticalAnchorFunctions$1
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj, @NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
            Intrinsics.checkNotNullParameter(obj, "other");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            AnchorFunctions.INSTANCE.clearLeft(constraintReference, layoutDirection);
            ConstraintReference leftToLeft = constraintReference.leftToLeft(obj);
            Intrinsics.checkNotNullExpressionValue(leftToLeft, "leftToLeft(other)");
            return leftToLeft;
        }
    }, new Function3<ConstraintReference, Object, LayoutDirection, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$verticalAnchorFunctions$2
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj, @NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
            Intrinsics.checkNotNullParameter(obj, "other");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            AnchorFunctions.INSTANCE.clearLeft(constraintReference, layoutDirection);
            ConstraintReference leftToRight = constraintReference.leftToRight(obj);
            Intrinsics.checkNotNullExpressionValue(leftToRight, "leftToRight(other)");
            return leftToRight;
        }
    }}, new Function3[]{new Function3<ConstraintReference, Object, LayoutDirection, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$verticalAnchorFunctions$3
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj, @NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
            Intrinsics.checkNotNullParameter(obj, "other");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            AnchorFunctions.INSTANCE.clearRight(constraintReference, layoutDirection);
            ConstraintReference rightToLeft = constraintReference.rightToLeft(obj);
            Intrinsics.checkNotNullExpressionValue(rightToLeft, "rightToLeft(other)");
            return rightToLeft;
        }
    }, new Function3<ConstraintReference, Object, LayoutDirection, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$verticalAnchorFunctions$4
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj, @NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
            Intrinsics.checkNotNullParameter(obj, "other");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            AnchorFunctions.INSTANCE.clearRight(constraintReference, layoutDirection);
            ConstraintReference rightToRight = constraintReference.rightToRight(obj);
            Intrinsics.checkNotNullExpressionValue(rightToRight, "rightToRight(other)");
            return rightToRight;
        }
    }}};

    @NotNull
    private static final Function2<ConstraintReference, Object, ConstraintReference>[][] horizontalAnchorFunctions = {new Function2[]{new Function2<ConstraintReference, Object, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$horizontalAnchorFunctions$1
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
            Intrinsics.checkNotNullParameter(obj, "other");
            constraintReference.topToBottom(null);
            constraintReference.baselineToBaseline(null);
            ConstraintReference constraintReference2 = constraintReference.topToTop(obj);
            Intrinsics.checkNotNullExpressionValue(constraintReference2, "topToTop(other)");
            return constraintReference2;
        }
    }, new Function2<ConstraintReference, Object, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$horizontalAnchorFunctions$2
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
            Intrinsics.checkNotNullParameter(obj, "other");
            constraintReference.topToTop(null);
            constraintReference.baselineToBaseline(null);
            ConstraintReference constraintReference2 = constraintReference.topToBottom(obj);
            Intrinsics.checkNotNullExpressionValue(constraintReference2, "topToBottom(other)");
            return constraintReference2;
        }
    }}, new Function2[]{new Function2<ConstraintReference, Object, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$horizontalAnchorFunctions$3
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
            Intrinsics.checkNotNullParameter(obj, "other");
            constraintReference.bottomToBottom(null);
            constraintReference.baselineToBaseline(null);
            ConstraintReference bottomToTop = constraintReference.bottomToTop(obj);
            Intrinsics.checkNotNullExpressionValue(bottomToTop, "bottomToTop(other)");
            return bottomToTop;
        }
    }, new Function2<ConstraintReference, Object, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$horizontalAnchorFunctions$4
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
            Intrinsics.checkNotNullParameter(obj, "other");
            constraintReference.bottomToTop(null);
            constraintReference.baselineToBaseline(null);
            ConstraintReference bottomToBottom = constraintReference.bottomToBottom(obj);
            Intrinsics.checkNotNullExpressionValue(bottomToBottom, "bottomToBottom(other)");
            return bottomToBottom;
        }
    }}};

    @NotNull
    private static final Function2<ConstraintReference, Object, ConstraintReference> baselineAnchorFunction = new Function2<ConstraintReference, Object, ConstraintReference>() { // from class: androidx.constraintlayout.compose.AnchorFunctions$baselineAnchorFunction$1
        public final ConstraintReference invoke(@NotNull ConstraintReference constraintReference, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(constraintReference, "$this$null");
            Intrinsics.checkNotNullParameter(obj, "other");
            constraintReference.topToTop(null);
            constraintReference.topToBottom(null);
            constraintReference.bottomToTop(null);
            constraintReference.bottomToBottom(null);
            ConstraintReference baselineToBaseline = constraintReference.baselineToBaseline(obj);
            Intrinsics.checkNotNullExpressionValue(baselineToBaseline, "baselineToBaseline(other)");
            return baselineToBaseline;
        }
    };

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AnchorFunctions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearLeft(ConstraintReference constraintReference, LayoutDirection layoutDirection) {
        constraintReference.leftToLeft(null);
        constraintReference.leftToRight(null);
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i == 1) {
            constraintReference.startToStart(null);
            constraintReference.startToEnd(null);
        } else {
            if (i != 2) {
                return;
            }
            constraintReference.endToStart(null);
            constraintReference.endToEnd(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearRight(ConstraintReference constraintReference, LayoutDirection layoutDirection) {
        constraintReference.rightToLeft(null);
        constraintReference.rightToRight(null);
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i == 1) {
            constraintReference.endToStart(null);
            constraintReference.endToEnd(null);
        } else {
            if (i != 2) {
                return;
            }
            constraintReference.startToStart(null);
            constraintReference.startToEnd(null);
        }
    }

    @NotNull
    public final Function2<ConstraintReference, Object, ConstraintReference> getBaselineAnchorFunction() {
        return baselineAnchorFunction;
    }

    @NotNull
    public final Function2<ConstraintReference, Object, ConstraintReference>[][] getHorizontalAnchorFunctions() {
        return horizontalAnchorFunctions;
    }

    @NotNull
    public final Function3<ConstraintReference, Object, LayoutDirection, ConstraintReference>[][] getVerticalAnchorFunctions() {
        return verticalAnchorFunctions;
    }

    public final int verticalAnchorIndexToFunctionIndex(int index, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return index >= 0 ? index : layoutDirection == LayoutDirection.Ltr ? index + 2 : (-index) - 1;
    }
}
