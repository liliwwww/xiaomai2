package androidx.core.util;

import android.util.Range;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RangeKt$toClosedRange$1<T> implements ClosedRange<T> {
    final /* synthetic */ Range<T> $this_toClosedRange;

    RangeKt$toClosedRange$1(Range<T> range) {
        this.$this_toClosedRange = range;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    public boolean contains(@NotNull Comparable comparable) {
        return ClosedRange.DefaultImpls.contains(this, comparable);
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    public Comparable getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    public Comparable getStart() {
        return this.$this_toClosedRange.getLower();
    }

    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }
}
