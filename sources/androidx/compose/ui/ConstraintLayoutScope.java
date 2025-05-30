package androidx.compose.ui;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.compose.ConstraintLayoutScope$ConstrainAsModifier$special$;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@LayoutScopeMarker
@StabilityInferred(parameters = 0)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\t\b\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0005\u001a\u00060\u0004R\u00020\u0000H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0016J-\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\fH\u0007R\u001c\u0010\u000f\u001a\b\u0018\u00010\u0004R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "createRef", "Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainedLayoutReferences;", "createRefs", "", "reset", "Landroidx/compose/ui/Modifier;", "ref", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstrainScope;", "Lkotlin/ExtensionFunctionType;", "constrainBlock", "constrainAs", "referencesObject", "Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainedLayoutReferences;", "", "ChildrenStartIndex", "I", "childId", "Ljava/util/ArrayList;", "childrenRefs", "Ljava/util/ArrayList;", "<init>", "()V", "ConstrainAsModifier", "ConstrainedLayoutReferences", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ConstraintLayoutScope extends ConstraintLayoutBaseScope {
    public static final int $stable = 8;
    private final int ChildrenStartIndex;
    private int childId = this.ChildrenStartIndex;

    @NotNull
    private final ArrayList<ConstrainedLayoutReference> childrenRefs = new ArrayList<>();

    @Nullable
    private ConstrainedLayoutReferences referencesObject;

    /* compiled from: Taobao */
    @Stable
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B(\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0096\u0002R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR'\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainAsModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/ui/unit/Density;", "", "parentData", "Landroidx/constraintlayout/compose/ConstraintLayoutParentData;", "modifyParentData", "", "hashCode", "other", "", "equals", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "ref", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstrainScope;", "", "Lkotlin/ExtensionFunctionType;", "constrainBlock", "Lkotlin/jvm/functions/Function1;", "<init>", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Lkotlin/jvm/functions/Function1;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
    private static final class ConstrainAsModifier extends InspectorValueInfo implements ParentDataModifier {

        @NotNull
        private final Function1<ConstrainScope, Unit> constrainBlock;

        @NotNull
        private final ConstrainedLayoutReference ref;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConstrainAsModifier(@NotNull ConstrainedLayoutReference constrainedLayoutReference, @NotNull Function1<? super ConstrainScope, Unit> function1) {
            super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new ConstraintLayoutScope$ConstrainAsModifier$special$.inlined.debugInspectorInfo.1(constrainedLayoutReference, function1) : InspectableValueKt.getNoInspectorInfo());
            Intrinsics.checkNotNullParameter(constrainedLayoutReference, "ref");
            Intrinsics.checkNotNullParameter(function1, "constrainBlock");
            this.ref = constrainedLayoutReference;
            this.constrainBlock = function1;
        }

        @Override // androidx.compose.ui.Modifier$Element
        public boolean all(@NotNull Function1<? super Modifier$Element, Boolean> function1) {
            return ParentDataModifier.DefaultImpls.all(this, function1);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public boolean any(@NotNull Function1<? super Modifier$Element, Boolean> function1) {
            return ParentDataModifier.DefaultImpls.any(this, function1);
        }

        public boolean equals(@Nullable Object other) {
            Function1<ConstrainScope, Unit> function1 = this.constrainBlock;
            ConstrainAsModifier constrainAsModifier = other instanceof ConstrainAsModifier ? (ConstrainAsModifier) other : null;
            return Intrinsics.areEqual(function1, constrainAsModifier != null ? constrainAsModifier.constrainBlock : null);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public <R> R foldIn(R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2) {
            return (R) ParentDataModifier.DefaultImpls.foldIn(this, r, function2);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public <R> R foldOut(R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2) {
            return (R) ParentDataModifier.DefaultImpls.foldOut(this, r, function2);
        }

        public int hashCode() {
            return this.constrainBlock.hashCode();
        }

        @NotNull
        public Modifier then(@NotNull Modifier modifier) {
            return ParentDataModifier.DefaultImpls.then(this, modifier);
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        @NotNull
        public ConstraintLayoutParentData modifyParentData(@NotNull Density density, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return new ConstraintLayoutParentData(this.ref, this.constrainBlock);
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0004\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0006\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0086\u0002J\t\u0010\b\u001a\u00020\u0002H\u0086\u0002J\t\u0010\t\u001a\u00020\u0002H\u0086\u0002J\t\u0010\n\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u000b\u001a\u00020\u0002H\u0086\u0002J\t\u0010\f\u001a\u00020\u0002H\u0086\u0002J\t\u0010\r\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u000e\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u000f\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0010\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0011\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainedLayoutReferences;", "", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "<init>", "(Landroidx/constraintlayout/compose/ConstraintLayoutScope;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
    public final class ConstrainedLayoutReferences {
        final /* synthetic */ ConstraintLayoutScope this$0;

        public ConstrainedLayoutReferences(ConstraintLayoutScope constraintLayoutScope) {
            Intrinsics.checkNotNullParameter(constraintLayoutScope, "this$0");
            this.this$0 = constraintLayoutScope;
        }

        @NotNull
        public final ConstrainedLayoutReference component1() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component10() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component11() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component12() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component13() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component14() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component15() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component16() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component2() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component3() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component4() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component5() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component6() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component7() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component8() {
            return this.this$0.createRef();
        }

        @NotNull
        public final ConstrainedLayoutReference component9() {
            return this.this$0.createRef();
        }
    }

    @PublishedApi
    public ConstraintLayoutScope() {
    }

    @Stable
    @NotNull
    public final Modifier constrainAs(@NotNull Modifier modifier, @NotNull ConstrainedLayoutReference constrainedLayoutReference, @NotNull Function1<? super ConstrainScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(constrainedLayoutReference, "ref");
        Intrinsics.checkNotNullParameter(function1, "constrainBlock");
        return modifier.then(new ConstrainAsModifier(constrainedLayoutReference, function1));
    }

    @NotNull
    public final ConstrainedLayoutReference createRef() {
        ArrayList<ConstrainedLayoutReference> arrayList = this.childrenRefs;
        int i = this.childId;
        this.childId = i + 1;
        ConstrainedLayoutReference constrainedLayoutReference = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList, i);
        if (constrainedLayoutReference != null) {
            return constrainedLayoutReference;
        }
        ConstrainedLayoutReference constrainedLayoutReference2 = new ConstrainedLayoutReference(Integer.valueOf(this.childId));
        this.childrenRefs.add(constrainedLayoutReference2);
        return constrainedLayoutReference2;
    }

    @Stable
    @NotNull
    public final ConstrainedLayoutReferences createRefs() {
        ConstrainedLayoutReferences constrainedLayoutReferences = this.referencesObject;
        if (constrainedLayoutReferences != null) {
            return constrainedLayoutReferences;
        }
        ConstrainedLayoutReferences constrainedLayoutReferences2 = new ConstrainedLayoutReferences(this);
        this.referencesObject = constrainedLayoutReferences2;
        return constrainedLayoutReferences2;
    }

    @Override // androidx.compose.ui.ConstraintLayoutBaseScope
    public void reset() {
        super.reset();
        this.childId = this.ChildrenStartIndex;
    }
}
