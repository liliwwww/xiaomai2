package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayout$BeyondBoundsScope;
import androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyListBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {

    @NotNull
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;

    @NotNull
    private final LayoutDirection layoutDirection;

    @NotNull
    private final Orientation orientation;
    private final boolean reverseLayout;

    @NotNull
    private final LazyListState state;

    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyListBeyondBoundsModifierLocal(@NotNull LazyListState lazyListState, @NotNull LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, boolean z, @NotNull LayoutDirection layoutDirection, @NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyListBeyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.state = lazyListState;
        this.beyondBoundsInfo = lazyListBeyondBoundsInfo;
        this.reverseLayout = z;
        this.layoutDirection = layoutDirection;
        this.orientation = orientation;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r5.reverseLayout != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (r5.reverseLayout != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        if (r5.reverseLayout != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
    
        if (r5.reverseLayout != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
    
        if (r5.reverseLayout != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
    
        if (r5.reverseLayout != false) goto L4;
     */
    /* renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval m421addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval r6, int r7) {
        /*
            r5 = this;
            int r0 = r6.getStart()
            int r6 = r6.getEnd()
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion
            int r2 = r1.getBefore-hoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(r7, r2)
            if (r2 == 0) goto L18
        L14:
            int r0 = r0 + (-1)
            goto L8c
        L18:
            int r2 = r1.getAfter-hoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(r7, r2)
            if (r2 == 0) goto L25
        L22:
            int r6 = r6 + 1
            goto L8c
        L25:
            int r2 = r1.getAbove-hoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(r7, r2)
            if (r2 == 0) goto L34
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L14
            goto L22
        L34:
            int r2 = r1.getBelow-hoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(r7, r2)
            if (r2 == 0) goto L43
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L22
            goto L14
        L43:
            int r2 = r1.getLeft-hoxUOeE()
            boolean r2 = androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(r7, r2)
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L68
            androidx.compose.ui.unit.LayoutDirection r7 = r5.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r1[r7]
            if (r7 == r4) goto L63
            if (r7 == r3) goto L5e
            goto L8c
        L5e:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L22
            goto L14
        L63:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L14
            goto L22
        L68:
            int r1 = r1.getRight-hoxUOeE()
            boolean r7 = androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(r7, r1)
            if (r7 == 0) goto L93
            androidx.compose.ui.unit.LayoutDirection r7 = r5.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r1[r7]
            if (r7 == r4) goto L86
            if (r7 == r3) goto L81
            goto L8c
        L81:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L14
            goto L22
        L86:
            boolean r7 = r5.reverseLayout
            if (r7 == 0) goto L22
            goto L14
        L8c:
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r7 = r5.beyondBoundsInfo
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval r6 = r7.addInterval(r0, r6)
            return r6
        L93:
            androidx.compose.foundation.lazy.LazyBeyondBoundsModifierKt.access$unsupportedDirection()
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.m421addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval, int):androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m422hasMoreContentFR3nfPY(LazyListBeyondBoundsInfo.Interval interval, int i) {
        if (m423isOppositeToOrientation4vf7U8o(i)) {
            return false;
        }
        BeyondBoundsLayout$LayoutDirection.Companion companion = BeyondBoundsLayout$LayoutDirection.Companion;
        if (BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getBefore-hoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        if (BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getAfter-hoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getAbove-hoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        if (BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getBelow-hoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getLeft-hoxUOeE())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i2 == 1) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
            }
            if (i2 == 2) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getRight-hoxUOeE())) {
            LazyBeyondBoundsModifierKt.access$unsupportedDirection();
            throw new KotlinNothingValueException();
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
        if (i3 == 1) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (i3 == 2) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsAfter(LazyListBeyondBoundsInfo.Interval interval, LazyListBeyondBoundsModifierLocal lazyListBeyondBoundsModifierLocal) {
        return interval.getEnd() < lazyListBeyondBoundsModifierLocal.state.getLayoutInfo().getTotalItemsCount() - 1;
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsBefore(LazyListBeyondBoundsInfo.Interval interval) {
        return interval.getStart() > 0;
    }

    /* renamed from: isOppositeToOrientation-4vf7U8o, reason: not valid java name */
    private final boolean m423isOppositeToOrientation4vf7U8o(int i) {
        BeyondBoundsLayout$LayoutDirection.Companion companion = BeyondBoundsLayout$LayoutDirection.Companion;
        if (!(BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getAbove-hoxUOeE()) ? true : BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getBelow-hoxUOeE()))) {
            if (!(BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getLeft-hoxUOeE()) ? true : BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getRight-hoxUOeE()))) {
                if (!(BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getBefore-hoxUOeE()) ? true : BeyondBoundsLayout$LayoutDirection.m2043equalsimpl0(i, companion.getAfter-hoxUOeE()))) {
                    LazyBeyondBoundsModifierKt.access$unsupportedDirection();
                    throw new KotlinNothingValueException();
                }
            } else if (this.orientation == Orientation.Vertical) {
                return true;
            }
        } else if (this.orientation == Orientation.Horizontal) {
            return true;
        }
        return false;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @NotNull
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    @NotNull
    /* renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public BeyondBoundsLayout m425getValue() {
        return this;
    }

    @Nullable
    /* renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T m424layouto7g1Pn8(final int i, @NotNull Function1<? super BeyondBoundsLayout$BeyondBoundsScope, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.beyondBoundsInfo.addInterval(this.state.getFirstVisibleItemIndex(), ((LazyListItemInfo) CollectionsKt.last(this.state.getLayoutInfo().getVisibleItemsInfo())).getIndex());
        T t = null;
        while (t == null && m422hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, i)) {
            LazyListBeyondBoundsInfo.Interval m421addNextIntervalFR3nfPY = m421addNextIntervalFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, i);
            this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
            objectRef.element = m421addNextIntervalFR3nfPY;
            Remeasurement remeasurement$foundation_release = this.state.getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            t = (T) function1.invoke(new BeyondBoundsLayout$BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout$BeyondBoundsScope
                public boolean getHasMoreContent() {
                    boolean m422hasMoreContentFR3nfPY;
                    m422hasMoreContentFR3nfPY = LazyListBeyondBoundsModifierLocal.this.m422hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, i);
                    return m422hasMoreContentFR3nfPY;
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
        Remeasurement remeasurement$foundation_release2 = this.state.getRemeasurement$foundation_release();
        if (remeasurement$foundation_release2 != null) {
            remeasurement$foundation_release2.forceRemeasure();
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
