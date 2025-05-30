package androidx.compose.ui;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0013\b'\u0018\u00002\u00020\u0001:\u0003PQRB\u0007¢\u0006\u0004\bO\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0004H\u0016J'\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u000fJ'\u0010\u0011\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00122\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u000fJ\u001b\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001cJ\u001b\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0018J\u001b\u0010!\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0018J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001cJ\u001b\u0010%\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u000e\u0010%\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001cJ\u001b\u0010'\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010$J\u000e\u0010'\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001cJ1\u0010.\u001a\u00020\u00162\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J1\u00100\u001a\u00020\u00162\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010-J1\u00103\u001a\u00020\"2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J1\u00105\u001a\u00020\u00162\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u0010-J1\u00107\u001a\u00020\u00162\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u0010-J1\u00109\u001a\u00020\"2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00102J+\u0010<\u001a\u00020\u000b2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)2\b\b\u0002\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J+\u0010>\u001a\u00020\u00122\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(\"\u00020)2\b\b\u0002\u0010;\u001a\u00020:¢\u0006\u0004\b>\u0010?R.\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\r0@8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR(\u0010E\u001a\u00020\u00028\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bE\u0010F\u0012\u0004\bK\u0010L\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bM\u0010FR\u0016\u0010N\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010F\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006S"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "", "", "value", "", "updateHelpersHashCode", "createHelperId", "Landroidx/constraintlayout/compose/State;", "state", "applyTo", "reset", "Landroidx/constraintlayout/compose/HorizontalChainReference;", "ref", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/HorizontalChainScope;", "Lkotlin/ExtensionFunctionType;", "constrainBlock", "constrain", "Landroidx/constraintlayout/compose/VerticalChainReference;", "Landroidx/constraintlayout/compose/VerticalChainScope;", "Landroidx/compose/ui/unit/Dp;", "offset", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "createGuidelineFromStart-0680j_4", "(F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "createGuidelineFromStart", "createGuidelineFromAbsoluteLeft-0680j_4", "createGuidelineFromAbsoluteLeft", "", "fraction", "createGuidelineFromEnd-0680j_4", "createGuidelineFromEnd", "createGuidelineFromAbsoluteRight-0680j_4", "createGuidelineFromAbsoluteRight", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createGuidelineFromTop-0680j_4", "(F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createGuidelineFromTop", "createGuidelineFromBottom-0680j_4", "createGuidelineFromBottom", "", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "elements", "margin", "createStartBarrier-3ABfNKs", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "createStartBarrier", "createAbsoluteLeftBarrier-3ABfNKs", "createAbsoluteLeftBarrier", "createTopBarrier-3ABfNKs", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createTopBarrier", "createEndBarrier-3ABfNKs", "createEndBarrier", "createAbsoluteRightBarrier-3ABfNKs", "createAbsoluteRightBarrier", "createBottomBarrier-3ABfNKs", "createBottomBarrier", "Landroidx/constraintlayout/compose/ChainStyle;", "chainStyle", "createHorizontalChain", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Landroidx/constraintlayout/compose/ChainStyle;)Landroidx/constraintlayout/compose/HorizontalChainReference;", "createVerticalChain", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Landroidx/constraintlayout/compose/ChainStyle;)Landroidx/constraintlayout/compose/VerticalChainReference;", "", "tasks", "Ljava/util/List;", "getTasks", "()Ljava/util/List;", "helpersHashCode", "I", "getHelpersHashCode", "()I", "setHelpersHashCode", "(I)V", "getHelpersHashCode$annotations", "()V", "HelpersStartId", "helperId", "<init>", "BaselineAnchor", "HorizontalAnchor", "VerticalAnchor", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class ConstraintLayoutBaseScope {
    public static final int $stable = 8;
    private int helpersHashCode;

    @NotNull
    private final List<Function1<State, Unit>> tasks = new ArrayList();
    private final int HelpersStartId = WVURLRuleConstants.LOGIN;
    private int helperId = WVURLRuleConstants.LOGIN;

    /* compiled from: Taobao */
    @Stable
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u0001HÀ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0001HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0005\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0003¨\u0006\u0012"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "", "component1$compose_release", "()Ljava/lang/Object;", "component1", "id", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "getId$compose_release", "<init>", "(Ljava/lang/Object;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
    public static final /* data */ class BaselineAnchor {

        @NotNull
        private final Object id;

        public BaselineAnchor(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "id");
            this.id = obj;
        }

        public static /* synthetic */ BaselineAnchor copy$default(BaselineAnchor baselineAnchor, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = baselineAnchor.id;
            }
            return baselineAnchor.copy(obj);
        }

        @NotNull
        /* renamed from: component1$compose_release, reason: from getter */
        public final Object getId() {
            return this.id;
        }

        @NotNull
        public final BaselineAnchor copy(@NotNull Object id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new BaselineAnchor(id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BaselineAnchor) && Intrinsics.areEqual(this.id, ((BaselineAnchor) other).id);
        }

        @NotNull
        public final Object getId$compose_release() {
            return this.id;
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "BaselineAnchor(id=" + this.id + ')';
        }
    }

    /* compiled from: Taobao */
    @Stable
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0001HÀ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u0005HÀ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\t\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0003R\u001c\u0010\n\u001a\u00020\u00058\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "", "component1$compose_release", "()Ljava/lang/Object;", "component1", "", "component2$compose_release", "()I", "component2", "id", "index", "copy", "", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "getId$compose_release", "I", "getIndex$compose_release", "<init>", "(Ljava/lang/Object;I)V", "compose_release"}, k = 1, mv = {1, 5, 1})
    public static final /* data */ class HorizontalAnchor {

        @NotNull
        private final Object id;
        private final int index;

        public HorizontalAnchor(@NotNull Object obj, int i) {
            Intrinsics.checkNotNullParameter(obj, "id");
            this.id = obj;
            this.index = i;
        }

        public static /* synthetic */ HorizontalAnchor copy$default(HorizontalAnchor horizontalAnchor, Object obj, int i, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = horizontalAnchor.id;
            }
            if ((i2 & 2) != 0) {
                i = horizontalAnchor.index;
            }
            return horizontalAnchor.copy(obj, i);
        }

        @NotNull
        /* renamed from: component1$compose_release, reason: from getter */
        public final Object getId() {
            return this.id;
        }

        /* renamed from: component2$compose_release, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        @NotNull
        public final HorizontalAnchor copy(@NotNull Object id, int index) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new HorizontalAnchor(id, index);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HorizontalAnchor)) {
                return false;
            }
            HorizontalAnchor horizontalAnchor = (HorizontalAnchor) other;
            return Intrinsics.areEqual(this.id, horizontalAnchor.id) && this.index == horizontalAnchor.index;
        }

        @NotNull
        public final Object getId$compose_release() {
            return this.id;
        }

        public final int getIndex$compose_release() {
            return this.index;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.index;
        }

        @NotNull
        public String toString() {
            return "HorizontalAnchor(id=" + this.id + ", index=" + this.index + ')';
        }
    }

    /* renamed from: createAbsoluteLeftBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m2257createAbsoluteLeftBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, ConstrainedLayoutReference[] constrainedLayoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAbsoluteLeftBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m2142constructorimpl(0);
        }
        return constraintLayoutBaseScope.m2263createAbsoluteLeftBarrier3ABfNKs(constrainedLayoutReferenceArr, f);
    }

    /* renamed from: createAbsoluteRightBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m2258createAbsoluteRightBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, ConstrainedLayoutReference[] constrainedLayoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAbsoluteRightBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m2142constructorimpl(0);
        }
        return constraintLayoutBaseScope.m2264createAbsoluteRightBarrier3ABfNKs(constrainedLayoutReferenceArr, f);
    }

    /* renamed from: createBottomBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ HorizontalAnchor m2259createBottomBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, ConstrainedLayoutReference[] constrainedLayoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBottomBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m2142constructorimpl(0);
        }
        return constraintLayoutBaseScope.m2265createBottomBarrier3ABfNKs(constrainedLayoutReferenceArr, f);
    }

    /* renamed from: createEndBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m2260createEndBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, ConstrainedLayoutReference[] constrainedLayoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createEndBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m2142constructorimpl(0);
        }
        return constraintLayoutBaseScope.m2266createEndBarrier3ABfNKs(constrainedLayoutReferenceArr, f);
    }

    private final int createHelperId() {
        int i = this.helperId;
        this.helperId = i + 1;
        return i;
    }

    public static /* synthetic */ HorizontalChainReference createHorizontalChain$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, ConstrainedLayoutReference[] constrainedLayoutReferenceArr, ChainStyle chainStyle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createHorizontalChain");
        }
        if ((i & 2) != 0) {
            chainStyle = ChainStyle.Companion.getSpread();
        }
        return constraintLayoutBaseScope.createHorizontalChain(constrainedLayoutReferenceArr, chainStyle);
    }

    /* renamed from: createStartBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m2261createStartBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, ConstrainedLayoutReference[] constrainedLayoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createStartBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m2142constructorimpl(0);
        }
        return constraintLayoutBaseScope.m2273createStartBarrier3ABfNKs(constrainedLayoutReferenceArr, f);
    }

    /* renamed from: createTopBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ HorizontalAnchor m2262createTopBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, ConstrainedLayoutReference[] constrainedLayoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTopBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m2142constructorimpl(0);
        }
        return constraintLayoutBaseScope.m2274createTopBarrier3ABfNKs(constrainedLayoutReferenceArr, f);
    }

    public static /* synthetic */ VerticalChainReference createVerticalChain$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, ConstrainedLayoutReference[] constrainedLayoutReferenceArr, ChainStyle chainStyle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createVerticalChain");
        }
        if ((i & 2) != 0) {
            chainStyle = ChainStyle.Companion.getSpread();
        }
        return constraintLayoutBaseScope.createVerticalChain(constrainedLayoutReferenceArr, chainStyle);
    }

    @PublishedApi
    public static /* synthetic */ void getHelpersHashCode$annotations() {
    }

    private final void updateHelpersHashCode(int value) {
        this.helpersHashCode = ((this.helpersHashCode * 1009) + value) % 1000000007;
    }

    public final void applyTo(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Iterator<T> it = this.tasks.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(state);
        }
    }

    @NotNull
    public final HorizontalChainScope constrain(@NotNull HorizontalChainReference ref, @NotNull Function1<? super HorizontalChainScope, Unit> constrainBlock) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        Intrinsics.checkNotNullParameter(constrainBlock, "constrainBlock");
        HorizontalChainScope horizontalChainScope = new HorizontalChainScope(ref.getId$compose_release());
        constrainBlock.invoke(horizontalChainScope);
        getTasks().addAll(horizontalChainScope.getTasks$compose_release());
        return horizontalChainScope;
    }

    @NotNull
    /* renamed from: createAbsoluteLeftBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m2263createAbsoluteLeftBarrier3ABfNKs(@NotNull ConstrainedLayoutReference[] elements, float margin) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int createHelperId = createHelperId();
        this.tasks.add(new createAbsoluteLeftBarrier.1(createHelperId, margin, elements));
        updateHelpersHashCode(11);
        for (ConstrainedLayoutReference constrainedLayoutReference : elements) {
            updateHelpersHashCode(constrainedLayoutReference.hashCode());
        }
        updateHelpersHashCode(Dp.m2148hashCodeimpl(margin));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    /* renamed from: createAbsoluteRightBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m2264createAbsoluteRightBarrier3ABfNKs(@NotNull ConstrainedLayoutReference[] elements, float margin) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int createHelperId = createHelperId();
        this.tasks.add(new createAbsoluteRightBarrier.1(createHelperId, margin, elements));
        updateHelpersHashCode(14);
        for (ConstrainedLayoutReference constrainedLayoutReference : elements) {
            updateHelpersHashCode(constrainedLayoutReference.hashCode());
        }
        updateHelpersHashCode(Dp.m2148hashCodeimpl(margin));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    /* renamed from: createBottomBarrier-3ABfNKs, reason: not valid java name */
    public final HorizontalAnchor m2265createBottomBarrier3ABfNKs(@NotNull ConstrainedLayoutReference[] elements, float margin) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int createHelperId = createHelperId();
        this.tasks.add(new createBottomBarrier.1(createHelperId, margin, elements));
        updateHelpersHashCode(15);
        for (ConstrainedLayoutReference constrainedLayoutReference : elements) {
            updateHelpersHashCode(constrainedLayoutReference.hashCode());
        }
        updateHelpersHashCode(Dp.m2148hashCodeimpl(margin));
        return new HorizontalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    /* renamed from: createEndBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m2266createEndBarrier3ABfNKs(@NotNull ConstrainedLayoutReference[] elements, float margin) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int createHelperId = createHelperId();
        this.tasks.add(new createEndBarrier.1(createHelperId, margin, elements));
        updateHelpersHashCode(13);
        for (ConstrainedLayoutReference constrainedLayoutReference : elements) {
            updateHelpersHashCode(constrainedLayoutReference.hashCode());
        }
        updateHelpersHashCode(Dp.m2148hashCodeimpl(margin));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    public final VerticalAnchor createGuidelineFromAbsoluteLeft(final float fraction) {
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGuidelineFromAbsoluteLeft$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.verticalGuideline(Integer.valueOf(createHelperId)).percent(fraction);
            }
        });
        updateHelpersHashCode(4);
        updateHelpersHashCode(Float.floatToIntBits(fraction));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    /* renamed from: createGuidelineFromAbsoluteLeft-0680j_4, reason: not valid java name */
    public final VerticalAnchor m2267createGuidelineFromAbsoluteLeft0680j_4(final float offset) {
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGuidelineFromAbsoluteLeft$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.verticalGuideline(Integer.valueOf(createHelperId)).start(Dp.m2140boximpl(offset));
            }
        });
        updateHelpersHashCode(2);
        updateHelpersHashCode(Dp.m2148hashCodeimpl(offset));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    public final VerticalAnchor createGuidelineFromAbsoluteRight(float fraction) {
        return createGuidelineFromAbsoluteLeft(1.0f - fraction);
    }

    @NotNull
    /* renamed from: createGuidelineFromAbsoluteRight-0680j_4, reason: not valid java name */
    public final VerticalAnchor m2268createGuidelineFromAbsoluteRight0680j_4(float offset) {
        int createHelperId = createHelperId();
        this.tasks.add(new createGuidelineFromAbsoluteRight.1(createHelperId, offset));
        updateHelpersHashCode(6);
        updateHelpersHashCode(Dp.m2148hashCodeimpl(offset));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    public final HorizontalAnchor createGuidelineFromBottom(float fraction) {
        return createGuidelineFromTop(1.0f - fraction);
    }

    @NotNull
    /* renamed from: createGuidelineFromBottom-0680j_4, reason: not valid java name */
    public final HorizontalAnchor m2269createGuidelineFromBottom0680j_4(final float offset) {
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGuidelineFromBottom$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.horizontalGuideline(Integer.valueOf(createHelperId)).end(Dp.m2140boximpl(offset));
            }
        });
        updateHelpersHashCode(9);
        updateHelpersHashCode(Dp.m2148hashCodeimpl(offset));
        return new HorizontalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    public final VerticalAnchor createGuidelineFromEnd(float fraction) {
        return createGuidelineFromStart(1.0f - fraction);
    }

    @NotNull
    /* renamed from: createGuidelineFromEnd-0680j_4, reason: not valid java name */
    public final VerticalAnchor m2270createGuidelineFromEnd0680j_4(final float offset) {
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGuidelineFromEnd$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                GuidelineReference verticalGuideline = state.verticalGuideline(Integer.valueOf(createHelperId));
                float f = offset;
                if (state.getLayoutDirection() == LayoutDirection.Ltr) {
                    verticalGuideline.end(Dp.m2140boximpl(f));
                } else {
                    verticalGuideline.start(Dp.m2140boximpl(f));
                }
            }
        });
        updateHelpersHashCode(5);
        updateHelpersHashCode(Dp.m2148hashCodeimpl(offset));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    public final VerticalAnchor createGuidelineFromStart(float fraction) {
        int createHelperId = createHelperId();
        this.tasks.add(new createGuidelineFromStart.2(createHelperId, fraction));
        updateHelpersHashCode(3);
        updateHelpersHashCode(Float.floatToIntBits(fraction));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    /* renamed from: createGuidelineFromStart-0680j_4, reason: not valid java name */
    public final VerticalAnchor m2271createGuidelineFromStart0680j_4(float offset) {
        int createHelperId = createHelperId();
        this.tasks.add(new createGuidelineFromStart.1(createHelperId, offset));
        updateHelpersHashCode(1);
        updateHelpersHashCode(Dp.m2148hashCodeimpl(offset));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    public final HorizontalAnchor createGuidelineFromTop(final float fraction) {
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGuidelineFromTop$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.horizontalGuideline(Integer.valueOf(createHelperId)).percent(fraction);
            }
        });
        updateHelpersHashCode(8);
        updateHelpersHashCode(Float.floatToIntBits(fraction));
        return new HorizontalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    /* renamed from: createGuidelineFromTop-0680j_4, reason: not valid java name */
    public final HorizontalAnchor m2272createGuidelineFromTop0680j_4(final float offset) {
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGuidelineFromTop$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.horizontalGuideline(Integer.valueOf(createHelperId)).start(Dp.m2140boximpl(offset));
            }
        });
        updateHelpersHashCode(7);
        updateHelpersHashCode(Dp.m2148hashCodeimpl(offset));
        return new HorizontalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    public final HorizontalChainReference createHorizontalChain(@NotNull final ConstrainedLayoutReference[] elements, @NotNull final ChainStyle chainStyle) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(chainStyle, "chainStyle");
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createHorizontalChain$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                HorizontalChainReference helper = state.helper(Integer.valueOf(createHelperId), State.Helper.HORIZONTAL_CHAIN);
                Objects.requireNonNull(helper, "null cannot be cast to non-null type androidx.constraintlayout.core.state.helpers.HorizontalChainReference");
                HorizontalChainReference horizontalChainReference = helper;
                ConstrainedLayoutReference[] constrainedLayoutReferenceArr = elements;
                ArrayList arrayList = new ArrayList(constrainedLayoutReferenceArr.length);
                for (ConstrainedLayoutReference constrainedLayoutReference : constrainedLayoutReferenceArr) {
                    arrayList.add(constrainedLayoutReference.getId());
                }
                Object[] array = arrayList.toArray(new Object[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                horizontalChainReference.add(Arrays.copyOf(array, array.length));
                horizontalChainReference.style(chainStyle.getStyle());
                horizontalChainReference.apply();
                if (chainStyle.getBias() != null) {
                    state.constraints(elements[0].getId()).horizontalBias(chainStyle.getBias().floatValue());
                }
            }
        });
        updateHelpersHashCode(16);
        for (ConstrainedLayoutReference constrainedLayoutReference : elements) {
            updateHelpersHashCode(constrainedLayoutReference.hashCode());
        }
        updateHelpersHashCode(chainStyle.hashCode());
        return new HorizontalChainReference(Integer.valueOf(createHelperId));
    }

    @NotNull
    /* renamed from: createStartBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m2273createStartBarrier3ABfNKs(@NotNull final ConstrainedLayoutReference[] elements, final float margin) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createStartBarrier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                BarrierReference barrier = state.barrier(Integer.valueOf(createHelperId), state.getLayoutDirection() == LayoutDirection.Ltr ? State.Direction.LEFT : State.Direction.RIGHT);
                ConstrainedLayoutReference[] constrainedLayoutReferenceArr = elements;
                ArrayList arrayList = new ArrayList(constrainedLayoutReferenceArr.length);
                for (ConstrainedLayoutReference constrainedLayoutReference : constrainedLayoutReferenceArr) {
                    arrayList.add(constrainedLayoutReference.getId());
                }
                Object[] array = arrayList.toArray(new Object[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                barrier.add(Arrays.copyOf(array, array.length));
                barrier.margin(state.convertDimension(Dp.m2140boximpl(margin)));
            }
        });
        updateHelpersHashCode(10);
        for (ConstrainedLayoutReference constrainedLayoutReference : elements) {
            updateHelpersHashCode(constrainedLayoutReference.hashCode());
        }
        updateHelpersHashCode(Dp.m2148hashCodeimpl(margin));
        return new VerticalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    /* renamed from: createTopBarrier-3ABfNKs, reason: not valid java name */
    public final HorizontalAnchor m2274createTopBarrier3ABfNKs(@NotNull final ConstrainedLayoutReference[] elements, final float margin) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createTopBarrier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                BarrierReference barrier = state.barrier(Integer.valueOf(createHelperId), State.Direction.TOP);
                ConstrainedLayoutReference[] constrainedLayoutReferenceArr = elements;
                ArrayList arrayList = new ArrayList(constrainedLayoutReferenceArr.length);
                for (ConstrainedLayoutReference constrainedLayoutReference : constrainedLayoutReferenceArr) {
                    arrayList.add(constrainedLayoutReference.getId());
                }
                Object[] array = arrayList.toArray(new Object[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                barrier.add(Arrays.copyOf(array, array.length));
                barrier.margin(state.convertDimension(Dp.m2140boximpl(margin)));
            }
        });
        updateHelpersHashCode(12);
        for (ConstrainedLayoutReference constrainedLayoutReference : elements) {
            updateHelpersHashCode(constrainedLayoutReference.hashCode());
        }
        updateHelpersHashCode(Dp.m2148hashCodeimpl(margin));
        return new HorizontalAnchor(Integer.valueOf(createHelperId), 0);
    }

    @NotNull
    public final VerticalChainReference createVerticalChain(@NotNull final ConstrainedLayoutReference[] elements, @NotNull final ChainStyle chainStyle) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(chainStyle, "chainStyle");
        final int createHelperId = createHelperId();
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createVerticalChain$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.helpers.ChainReference, androidx.constraintlayout.core.state.helpers.VerticalChainReference] */
            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Facade helper = state.helper(Integer.valueOf(createHelperId), State.Helper.VERTICAL_CHAIN);
                Objects.requireNonNull(helper, "null cannot be cast to non-null type androidx.constraintlayout.core.state.helpers.VerticalChainReference");
                ?? r0 = (VerticalChainReference) helper;
                ConstrainedLayoutReference[] constrainedLayoutReferenceArr = elements;
                ArrayList arrayList = new ArrayList(constrainedLayoutReferenceArr.length);
                for (ConstrainedLayoutReference constrainedLayoutReference : constrainedLayoutReferenceArr) {
                    arrayList.add(constrainedLayoutReference.getId());
                }
                Object[] array = arrayList.toArray(new Object[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                r0.add(Arrays.copyOf(array, array.length));
                r0.style(chainStyle.getStyle());
                r0.apply();
                if (chainStyle.getBias() != null) {
                    state.constraints(elements[0].getId()).verticalBias(chainStyle.getBias().floatValue());
                }
            }
        });
        updateHelpersHashCode(17);
        for (ConstrainedLayoutReference constrainedLayoutReference : elements) {
            updateHelpersHashCode(constrainedLayoutReference.hashCode());
        }
        updateHelpersHashCode(chainStyle.hashCode());
        return new VerticalChainReference(Integer.valueOf(createHelperId));
    }

    public final int getHelpersHashCode() {
        return this.helpersHashCode;
    }

    @NotNull
    protected final List<Function1<State, Unit>> getTasks() {
        return this.tasks;
    }

    public void reset() {
        this.tasks.clear();
        this.helperId = this.HelpersStartId;
        this.helpersHashCode = 0;
    }

    public final void setHelpersHashCode(int i) {
        this.helpersHashCode = i;
    }

    @NotNull
    public final VerticalChainScope constrain(@NotNull VerticalChainReference ref, @NotNull Function1<? super VerticalChainScope, Unit> constrainBlock) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        Intrinsics.checkNotNullParameter(constrainBlock, "constrainBlock");
        VerticalChainScope verticalChainScope = new VerticalChainScope(ref.getId$compose_release());
        constrainBlock.invoke(verticalChainScope);
        getTasks().addAll(verticalChainScope.getTasks$compose_release());
        return verticalChainScope;
    }
}
