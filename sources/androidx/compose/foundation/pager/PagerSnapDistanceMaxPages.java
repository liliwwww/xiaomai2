package androidx.compose.foundation.pager;

import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PagerSnapDistanceMaxPages implements PagerSnapDistance {
    private final int pagesLimit;

    public PagerSnapDistanceMaxPages(int i) {
        this.pagesLimit = i;
    }

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public int calculateTargetPage(int i, int i2, float f, int i3, int i4) {
        int i5 = this.pagesLimit;
        return RangesKt.coerceIn(i2, i - i5, i + i5);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof PagerSnapDistanceMaxPages) && this.pagesLimit == ((PagerSnapDistanceMaxPages) obj).pagesLimit;
    }

    public int hashCode() {
        return this.pagesLimit;
    }
}
