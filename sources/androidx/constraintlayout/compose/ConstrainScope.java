package androidx.constraintlayout.compose;

import androidx.annotation.FloatRange;
import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.core.state.ConstraintReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LayoutScopeMarker
@Stable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b3\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\u0006\u0010=\u001a\u00020\u0001¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J!\u0010\b\u001a\u00020\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0002J<\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013JU\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0003\u0010\u001c\u001a\u00020\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJU\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\t2\b\b\u0003\u0010\u001c\u001a\u00020\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010'J\u0097\u0001\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020 2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\t2\b\b\u0003\u0010(\u001a\u00020\f2\b\b\u0003\u0010)\u001a\u00020\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\b\b\u0003\u0010\u001c\u001a\u00020\fJ\u0018\u00100\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\b\b\u0003\u0010\u001c\u001a\u00020\fJ\u000e\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0015J\u000e\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020 J+\u00107\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0004J\u0006\u0010:\u001a\u00020\u0004J\u0006\u0010;\u001a\u00020\u0004J\u0006\u0010<\u001a\u00020\u0004R\u001c\u0010=\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R.\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u00020A8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010F\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0019\u0010\u0016\u001a\u00020J8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010N\u001a\u00020J8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010K\u001a\u0004\bO\u0010MR\u0019\u0010!\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010Q\u001a\u0004\bR\u0010SR\u0019\u0010\u0017\u001a\u00020J8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010K\u001a\u0004\bT\u0010MR\u0019\u0010U\u001a\u00020J8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010K\u001a\u0004\bV\u0010MR\u0019\u0010\"\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010Q\u001a\u0004\bW\u0010SR\u0019\u0010Y\u001a\u00020X8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R*\u0010_\u001a\u00020]2\u0006\u0010^\u001a\u00020]8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR*\u0010e\u001a\u00020]2\u0006\u0010^\u001a\u00020]8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010`\u001a\u0004\bf\u0010b\"\u0004\bg\u0010dR*\u0010i\u001a\u00020h2\u0006\u0010^\u001a\u00020h8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR*\u0010o\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR*\u0010u\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010p\u001a\u0004\bv\u0010r\"\u0004\bw\u0010tR*\u0010x\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010p\u001a\u0004\by\u0010r\"\u0004\bz\u0010tR*\u0010{\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010p\u001a\u0004\b|\u0010r\"\u0004\b}\u0010tR+\u0010~\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010p\u001a\u0004\b\u007f\u0010r\"\u0005\b\u0080\u0001\u0010tR.\u0010\u0081\u0001\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010p\u001a\u0005\b\u0082\u0001\u0010r\"\u0005\b\u0083\u0001\u0010tR7\u0010\u0084\u0001\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t8\u0006@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010p\u001a\u0005\b\u0085\u0001\u0010r\"\u0005\b\u0086\u0001\u0010tR7\u0010\u0087\u0001\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t8\u0006@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010p\u001a\u0005\b\u0088\u0001\u0010r\"\u0005\b\u0089\u0001\u0010tR7\u0010\u008a\u0001\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t8\u0006@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010p\u001a\u0005\b\u008b\u0001\u0010r\"\u0005\b\u008c\u0001\u0010tR.\u0010\u008d\u0001\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010p\u001a\u0005\b\u008e\u0001\u0010r\"\u0005\b\u008f\u0001\u0010tR.\u0010\u0090\u0001\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010p\u001a\u0005\b\u0091\u0001\u0010r\"\u0005\b\u0092\u0001\u0010tR.\u0010\u0093\u0001\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010p\u001a\u0005\b\u0094\u0001\u0010r\"\u0005\b\u0095\u0001\u0010tR.\u0010\u0096\u0001\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010p\u001a\u0005\b\u0097\u0001\u0010r\"\u0005\b\u0098\u0001\u0010t\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009b\u0001"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope;", "", "Lkotlin/Function1;", "Landroidx/constraintlayout/core/state/ConstraintReference;", "", "Lkotlin/ExtensionFunctionType;", "change", "", "addTransform", "Landroidx/compose/ui/unit/Dp;", "dpValue", "Lkotlin/Function2;", "", "addFloatTransformFromDp-D5KLDUw", "(FLkotlin/jvm/functions/Function2;)Z", "addFloatTransformFromDp", "Landroidx/constraintlayout/compose/State;", "state", "applyTo$compose_release", "(Landroidx/constraintlayout/compose/State;)V", "applyTo", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "start", "end", "startMargin", "endMargin", "startGoneMargin", "endGoneMargin", "bias", "linkTo-8ZKsbrE", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;FFFFF)V", "linkTo", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "top", "bottom", "topMargin", "bottomMargin", "topGoneMargin", "bottomGoneMargin", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FFFFF)V", "horizontalBias", "verticalBias", "linkTo-R7zmacU", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FFFFFFFFFF)V", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "other", "centerTo", "centerHorizontallyTo", "centerVerticallyTo", "anchor", "centerAround", "angle", "distance", "circular-wH6b6FI", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;FF)V", "circular", "clearHorizontal", "clearVertical", "clearConstraints", "resetDimensions", "resetTransforms", "id", "Ljava/lang/Object;", "getId$compose_release", "()Ljava/lang/Object;", "", "tasks", "Ljava/util/List;", "getTasks$compose_release", "()Ljava/util/List;", "parent", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getParent", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "Landroidx/constraintlayout/compose/VerticalAnchorable;", "Landroidx/constraintlayout/compose/VerticalAnchorable;", "getStart", "()Landroidx/constraintlayout/compose/VerticalAnchorable;", "absoluteLeft", "getAbsoluteLeft", "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getTop", "()Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getEnd", "absoluteRight", "getAbsoluteRight", "getBottom", "Landroidx/constraintlayout/compose/BaselineAnchorable;", "baseline", "Landroidx/constraintlayout/compose/BaselineAnchorable;", "getBaseline", "()Landroidx/constraintlayout/compose/BaselineAnchorable;", "Landroidx/constraintlayout/compose/Dimension;", "value", "width", "Landroidx/constraintlayout/compose/Dimension;", "getWidth", "()Landroidx/constraintlayout/compose/Dimension;", "setWidth", "(Landroidx/constraintlayout/compose/Dimension;)V", "height", "getHeight", "setHeight", "Landroidx/constraintlayout/compose/Visibility;", "visibility", "Landroidx/constraintlayout/compose/Visibility;", "getVisibility", "()Landroidx/constraintlayout/compose/Visibility;", "setVisibility", "(Landroidx/constraintlayout/compose/Visibility;)V", "alpha", "F", "getAlpha", "()F", "setAlpha", "(F)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "translationX", "getTranslationX-D9Ej5fM", "setTranslationX-0680j_4", "translationY", "getTranslationY-D9Ej5fM", "setTranslationY-0680j_4", "translationZ", "getTranslationZ-D9Ej5fM", "setTranslationZ-0680j_4", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "horizontalChainWeight", "getHorizontalChainWeight", "setHorizontalChainWeight", "verticalChainWeight", "getVerticalChainWeight", "setVerticalChainWeight", "<init>", "(Ljava/lang/Object;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ConstrainScope {

    @NotNull
    private final VerticalAnchorable absoluteLeft;

    @NotNull
    private final VerticalAnchorable absoluteRight;

    @FloatRange(from = 0.0d, m42to = 1.0d)
    private float alpha;

    @NotNull
    private final BaselineAnchorable baseline;

    @NotNull
    private final HorizontalAnchorable bottom;

    @NotNull
    private final VerticalAnchorable end;

    @NotNull
    private Dimension height;
    private float horizontalChainWeight;

    @NotNull
    private final Object id;

    @NotNull
    private final ConstrainedLayoutReference parent;
    private float pivotX;
    private float pivotY;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;

    @NotNull
    private final VerticalAnchorable start;

    @NotNull
    private final List<Function1<State, Unit>> tasks;

    @NotNull
    private final HorizontalAnchorable top;
    private float translationX;
    private float translationY;
    private float translationZ;
    private float verticalChainWeight;

    @NotNull
    private Visibility visibility;

    @NotNull
    private Dimension width;

    public ConstrainScope(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "id");
        this.id = obj;
        ArrayList arrayList = new ArrayList();
        this.tasks = arrayList;
        Integer num = androidx.constraintlayout.core.state.State.PARENT;
        Intrinsics.checkNotNullExpressionValue(num, "PARENT");
        this.parent = new ConstrainedLayoutReference(num);
        this.start = new ConstraintVerticalAnchorable(obj, -2, arrayList);
        this.absoluteLeft = new ConstraintVerticalAnchorable(obj, 0, arrayList);
        this.top = new ConstraintHorizontalAnchorable(obj, 0, arrayList);
        this.end = new ConstraintVerticalAnchorable(obj, -1, arrayList);
        this.absoluteRight = new ConstraintVerticalAnchorable(obj, 1, arrayList);
        this.bottom = new ConstraintHorizontalAnchorable(obj, 1, arrayList);
        this.baseline = new ConstraintBaselineAnchorable(obj, arrayList);
        Dimension.Companion companion = Dimension.INSTANCE;
        this.width = companion.getWrapContent();
        this.height = companion.getWrapContent();
        this.visibility = Visibility.INSTANCE.getVisible();
        this.alpha = 1.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        float f = 0;
        this.translationX = C0856Dp.m5216constructorimpl(f);
        this.translationY = C0856Dp.m5216constructorimpl(f);
        this.translationZ = C0856Dp.m5216constructorimpl(f);
        this.pivotX = 0.5f;
        this.pivotY = 0.5f;
        this.horizontalChainWeight = Float.NaN;
        this.verticalChainWeight = Float.NaN;
    }

    /* renamed from: addFloatTransformFromDp-D5KLDUw, reason: not valid java name */
    private final boolean m5477addFloatTransformFromDpD5KLDUw(final float dpValue, final Function2<? super ConstraintReference, ? super Float, Unit> change) {
        return this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$addFloatTransformFromDp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (state == null) {
                    return;
                }
                Function2<ConstraintReference, Float, Unit> function2 = change;
                ConstrainScope constrainScope = this;
                float f = dpValue;
                ConstraintReference constraints = state.constraints(constrainScope.getId());
                Intrinsics.checkNotNullExpressionValue(constraints, "state.constraints(id)");
                function2.invoke(constraints, Float.valueOf(state.convertDimension(C0856Dp.m5214boximpl(f))));
            }
        });
    }

    private final boolean addTransform(final Function1<? super ConstraintReference, Unit> change) {
        return this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$addTransform$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Function1<ConstraintReference, Unit> function1 = change;
                ConstraintReference constraints = state.constraints(this.getId());
                Intrinsics.checkNotNullExpressionValue(constraints, "state.constraints(id)");
                function1.invoke(constraints);
            }
        });
    }

    public static /* synthetic */ void centerHorizontallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerHorizontallyTo(constrainedLayoutReference, f);
    }

    public static /* synthetic */ void centerVerticallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerVerticallyTo(constrainedLayoutReference, f);
    }

    /* renamed from: linkTo-8ZKsbrE$default, reason: not valid java name */
    public static /* synthetic */ void m5479linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        constrainScope.m5486linkTo8ZKsbrE(verticalAnchor, verticalAnchor2, (i & 4) != 0 ? C0856Dp.m5216constructorimpl(0) : f, (i & 8) != 0 ? C0856Dp.m5216constructorimpl(0) : f2, (i & 16) != 0 ? C0856Dp.m5216constructorimpl(0) : f3, (i & 32) != 0 ? C0856Dp.m5216constructorimpl(0) : f4, (i & 64) != 0 ? 0.5f : f5);
    }

    /* renamed from: linkTo-R7zmacU$default, reason: not valid java name */
    public static /* synthetic */ void m5480linkToR7zmacU$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i, Object obj) {
        constrainScope.m5487linkToR7zmacU(verticalAnchor, horizontalAnchor, verticalAnchor2, horizontalAnchor2, (i & 16) != 0 ? C0856Dp.m5216constructorimpl(0) : f, (i & 32) != 0 ? C0856Dp.m5216constructorimpl(0) : f2, (i & 64) != 0 ? C0856Dp.m5216constructorimpl(0) : f3, (i & 128) != 0 ? C0856Dp.m5216constructorimpl(0) : f4, (i & 256) != 0 ? C0856Dp.m5216constructorimpl(0) : f5, (i & 512) != 0 ? C0856Dp.m5216constructorimpl(0) : f6, (i & 1024) != 0 ? C0856Dp.m5216constructorimpl(0) : f7, (i & 2048) != 0 ? C0856Dp.m5216constructorimpl(0) : f8, (i & 4096) != 0 ? 0.5f : f9, (i & 8192) != 0 ? 0.5f : f10);
    }

    public final void applyTo$compose_release(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Iterator<T> it = this.tasks.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(state);
        }
    }

    public final void centerAround(@NotNull ConstraintLayoutBaseScope.VerticalAnchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        m5479linkTo8ZKsbrE$default(this, anchor, anchor, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 124, (Object) null);
    }

    public final void centerHorizontallyTo(@NotNull ConstrainedLayoutReference other, @FloatRange(from = 0.0d, m42to = 1.0d) float bias) {
        Intrinsics.checkNotNullParameter(other, "other");
        m5479linkTo8ZKsbrE$default(this, other.getStart(), other.getEnd(), 0.0f, 0.0f, 0.0f, 0.0f, bias, 60, (Object) null);
    }

    public final void centerTo(@NotNull ConstrainedLayoutReference other) {
        Intrinsics.checkNotNullParameter(other, "other");
        m5480linkToR7zmacU$default(this, other.getStart(), other.getTop(), other.getEnd(), other.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16368, null);
    }

    public final void centerVerticallyTo(@NotNull ConstrainedLayoutReference other, @FloatRange(from = 0.0d, m42to = 1.0d) float bias) {
        Intrinsics.checkNotNullParameter(other, "other");
        m5478linkTo8ZKsbrE$default(this, other.getTop(), other.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, bias, 60, (Object) null);
    }

    /* renamed from: circular-wH6b6FI, reason: not valid java name */
    public final void m5481circularwH6b6FI(@NotNull final ConstrainedLayoutReference other, final float angle, final float distance) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$circular$1
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
                state.constraints(ConstrainScope.this.getId()).circularConstraint(other.getId(), angle, state.convertDimension(C0856Dp.m5214boximpl(distance)));
            }
        });
    }

    public final void clearConstraints() {
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$clearConstraints$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.constraints(ConstrainScope.this.getId()).clear();
            }
        });
    }

    public final void clearHorizontal() {
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$clearHorizontal$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.constraints(ConstrainScope.this.getId()).clearHorizontal();
            }
        });
    }

    public final void clearVertical() {
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$clearVertical$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.constraints(ConstrainScope.this.getId()).clearVertical();
            }
        });
    }

    @NotNull
    public final VerticalAnchorable getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    @NotNull
    public final VerticalAnchorable getAbsoluteRight() {
        return this.absoluteRight;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    public final BaselineAnchorable getBaseline() {
        return this.baseline;
    }

    @NotNull
    public final HorizontalAnchorable getBottom() {
        return this.bottom;
    }

    @NotNull
    public final VerticalAnchorable getEnd() {
        return this.end;
    }

    @NotNull
    public final Dimension getHeight() {
        return this.height;
    }

    public final float getHorizontalChainWeight() {
        return this.horizontalChainWeight;
    }

    @NotNull
    /* renamed from: getId$compose_release, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    @NotNull
    public final ConstrainedLayoutReference getParent() {
        return this.parent;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    @NotNull
    public final VerticalAnchorable getStart() {
        return this.start;
    }

    @NotNull
    public final List<Function1<State, Unit>> getTasks$compose_release() {
        return this.tasks;
    }

    @NotNull
    public final HorizontalAnchorable getTop() {
        return this.top;
    }

    /* renamed from: getTranslationX-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTranslationX() {
        return this.translationX;
    }

    /* renamed from: getTranslationY-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTranslationY() {
        return this.translationY;
    }

    /* renamed from: getTranslationZ-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTranslationZ() {
        return this.translationZ;
    }

    public final float getVerticalChainWeight() {
        return this.verticalChainWeight;
    }

    @NotNull
    public final Visibility getVisibility() {
        return this.visibility;
    }

    @NotNull
    public final Dimension getWidth() {
        return this.width;
    }

    /* renamed from: linkTo-8ZKsbrE, reason: not valid java name */
    public final void m5486linkTo8ZKsbrE(@NotNull ConstraintLayoutBaseScope.VerticalAnchor start, @NotNull ConstraintLayoutBaseScope.VerticalAnchor end, float startMargin, float endMargin, float startGoneMargin, float endGoneMargin, @FloatRange(from = 0.0d, m42to = 1.0d) final float bias) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.start.mo5474linkToVpY3zN4(start, startMargin, startGoneMargin);
        this.end.mo5474linkToVpY3zN4(end, endMargin, endGoneMargin);
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$linkTo$1
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
                state.constraints(this.getId()).horizontalBias(state.getLayoutDirection() == LayoutDirection.Rtl ? 1 - bias : bias);
            }
        });
    }

    /* renamed from: linkTo-R7zmacU, reason: not valid java name */
    public final void m5487linkToR7zmacU(@NotNull ConstraintLayoutBaseScope.VerticalAnchor start, @NotNull ConstraintLayoutBaseScope.HorizontalAnchor top, @NotNull ConstraintLayoutBaseScope.VerticalAnchor end, @NotNull ConstraintLayoutBaseScope.HorizontalAnchor bottom, float startMargin, float topMargin, float endMargin, float bottomMargin, float startGoneMargin, float topGoneMargin, float endGoneMargin, float bottomGoneMargin, @FloatRange(from = 0.0d, m42to = 1.0d) float horizontalBias, @FloatRange(from = 0.0d, m42to = 1.0d) float verticalBias) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        m5486linkTo8ZKsbrE(start, end, startMargin, endMargin, startGoneMargin, endGoneMargin, horizontalBias);
        m5485linkTo8ZKsbrE(top, bottom, topMargin, bottomMargin, topGoneMargin, bottomGoneMargin, verticalBias);
    }

    public final void resetDimensions() {
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$resetDimensions$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                androidx.constraintlayout.core.state.Dimension solverDimension$compose_release = ((DimensionDescription) Dimension.INSTANCE.getWrapContent()).toSolverDimension$compose_release(state);
                state.constraints(ConstrainScope.this.getId()).width(solverDimension$compose_release).height(solverDimension$compose_release);
            }
        });
    }

    public final void resetTransforms() {
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$resetTransforms$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                state.constraints(ConstrainScope.this.getId()).alpha(Float.NaN).scaleX(Float.NaN).scaleY(Float.NaN).rotationX(Float.NaN).rotationY(Float.NaN).rotationZ(Float.NaN).translationX(Float.NaN).translationY(Float.NaN).translationZ(Float.NaN).pivotX(Float.NaN).pivotY(Float.NaN);
            }
        });
    }

    public final void setAlpha(final float f) {
        this.alpha = f;
        addTransform(new Function1<ConstraintReference, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$alpha$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConstraintReference) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
                if (Intrinsics.areEqual(ConstrainScope.this.getVisibility(), Visibility.INSTANCE.getInvisible())) {
                    return;
                }
                constraintReference.alpha(f);
            }
        });
    }

    public final void setHeight(@NotNull final Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "value");
        this.height = dimension;
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$height$1
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
                state.constraints(ConstrainScope.this.getId()).height(((DimensionDescription) dimension).toSolverDimension$compose_release(state));
            }
        });
    }

    public final void setHorizontalChainWeight(final float f) {
        this.horizontalChainWeight = f;
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$horizontalChainWeight$1
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
                state.constraints(ConstrainScope.this.getId()).setHorizontalChainWeight(f);
            }
        });
    }

    public final void setPivotX(final float f) {
        this.pivotX = f;
        addTransform(new Function1<ConstraintReference, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$pivotX$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConstraintReference) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
                constraintReference.pivotX(f);
            }
        });
    }

    public final void setPivotY(final float f) {
        this.pivotY = f;
        addTransform(new Function1<ConstraintReference, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$pivotY$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConstraintReference) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
                constraintReference.pivotY(f);
            }
        });
    }

    public final void setRotationX(final float f) {
        this.rotationX = f;
        addTransform(new Function1<ConstraintReference, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$rotationX$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConstraintReference) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
                constraintReference.rotationX(f);
            }
        });
    }

    public final void setRotationY(final float f) {
        this.rotationY = f;
        addTransform(new Function1<ConstraintReference, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$rotationY$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConstraintReference) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
                constraintReference.rotationY(f);
            }
        });
    }

    public final void setRotationZ(final float f) {
        this.rotationZ = f;
        addTransform(new Function1<ConstraintReference, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$rotationZ$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConstraintReference) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
                constraintReference.rotationZ(f);
            }
        });
    }

    public final void setScaleX(final float f) {
        this.scaleX = f;
        addTransform(new Function1<ConstraintReference, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$scaleX$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConstraintReference) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
                constraintReference.scaleX(f);
            }
        });
    }

    public final void setScaleY(final float f) {
        this.scaleY = f;
        addTransform(new Function1<ConstraintReference, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$scaleY$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ConstraintReference) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addTransform");
                constraintReference.scaleY(f);
            }
        });
    }

    /* renamed from: setTranslationX-0680j_4, reason: not valid java name */
    public final void m5488setTranslationX0680j_4(float f) {
        this.translationX = f;
        m5477addFloatTransformFromDpD5KLDUw(f, new Function2<ConstraintReference, Float, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$translationX$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ConstraintReference) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference, float f2) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addFloatTransformFromDp");
                constraintReference.translationX(f2);
            }
        });
    }

    /* renamed from: setTranslationY-0680j_4, reason: not valid java name */
    public final void m5489setTranslationY0680j_4(float f) {
        this.translationY = f;
        m5477addFloatTransformFromDpD5KLDUw(f, new Function2<ConstraintReference, Float, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$translationY$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ConstraintReference) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference, float f2) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addFloatTransformFromDp");
                constraintReference.translationY(f2);
            }
        });
    }

    /* renamed from: setTranslationZ-0680j_4, reason: not valid java name */
    public final void m5490setTranslationZ0680j_4(float f) {
        this.translationZ = f;
        m5477addFloatTransformFromDpD5KLDUw(f, new Function2<ConstraintReference, Float, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$translationZ$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ConstraintReference) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ConstraintReference constraintReference, float f2) {
                Intrinsics.checkNotNullParameter(constraintReference, "$this$addFloatTransformFromDp");
                constraintReference.translationZ(f2);
            }
        });
    }

    public final void setVerticalChainWeight(final float f) {
        this.verticalChainWeight = f;
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$verticalChainWeight$1
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
                state.constraints(ConstrainScope.this.getId()).setVerticalChainWeight(f);
            }
        });
    }

    public final void setVisibility(@NotNull final Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "value");
        this.visibility = visibility;
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$visibility$1
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
                ConstraintReference constraints = state.constraints(ConstrainScope.this.getId());
                Visibility visibility2 = visibility;
                constraints.visibility(visibility2.getSolverValue());
                if (Intrinsics.areEqual(visibility2, Visibility.INSTANCE.getInvisible())) {
                    constraints.alpha(0.0f);
                }
            }
        });
    }

    public final void setWidth(@NotNull final Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "value");
        this.width = dimension;
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$width$1
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
                state.constraints(ConstrainScope.this.getId()).width(((DimensionDescription) dimension).toSolverDimension$compose_release(state));
            }
        });
    }

    public final void centerAround(@NotNull ConstraintLayoutBaseScope.HorizontalAnchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        m5478linkTo8ZKsbrE$default(this, anchor, anchor, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 124, (Object) null);
    }

    /* renamed from: linkTo-8ZKsbrE, reason: not valid java name */
    public final void m5485linkTo8ZKsbrE(@NotNull ConstraintLayoutBaseScope.HorizontalAnchor top, @NotNull ConstraintLayoutBaseScope.HorizontalAnchor bottom, float topMargin, float bottomMargin, float topGoneMargin, float bottomGoneMargin, @FloatRange(from = 0.0d, m42to = 1.0d) final float bias) {
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        this.top.mo5473linkToVpY3zN4(top, topMargin, topGoneMargin);
        this.bottom.mo5473linkToVpY3zN4(bottom, bottomMargin, bottomGoneMargin);
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstrainScope$linkTo$2
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
                state.constraints(ConstrainScope.this.getId()).verticalBias(bias);
            }
        });
    }

    /* renamed from: linkTo-8ZKsbrE$default, reason: not valid java name */
    public static /* synthetic */ void m5478linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        constrainScope.m5485linkTo8ZKsbrE(horizontalAnchor, horizontalAnchor2, (i & 4) != 0 ? C0856Dp.m5216constructorimpl(0) : f, (i & 8) != 0 ? C0856Dp.m5216constructorimpl(0) : f2, (i & 16) != 0 ? C0856Dp.m5216constructorimpl(0) : f3, (i & 32) != 0 ? C0856Dp.m5216constructorimpl(0) : f4, (i & 64) != 0 ? 0.5f : f5);
    }
}
