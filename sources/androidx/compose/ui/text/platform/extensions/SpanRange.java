package androidx.compose.ui.text.platform.extensions;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SpanRange {
    private final int end;

    @NotNull
    private final Object span;
    private final int start;

    public SpanRange(@NotNull Object obj, int i, int i2) {
        Intrinsics.checkNotNullParameter(obj, "span");
        this.span = obj;
        this.start = i;
        this.end = i2;
    }

    public static /* synthetic */ SpanRange copy$default(SpanRange spanRange, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = spanRange.span;
        }
        if ((i3 & 2) != 0) {
            i = spanRange.start;
        }
        if ((i3 & 4) != 0) {
            i2 = spanRange.end;
        }
        return spanRange.copy(obj, i, i2);
    }

    @NotNull
    public final Object component1() {
        return this.span;
    }

    public final int component2() {
        return this.start;
    }

    public final int component3() {
        return this.end;
    }

    @NotNull
    public final SpanRange copy(@NotNull Object obj, int i, int i2) {
        Intrinsics.checkNotNullParameter(obj, "span");
        return new SpanRange(obj, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanRange)) {
            return false;
        }
        SpanRange spanRange = (SpanRange) obj;
        return Intrinsics.areEqual(this.span, spanRange.span) && this.start == spanRange.start && this.end == spanRange.end;
    }

    public final int getEnd() {
        return this.end;
    }

    @NotNull
    public final Object getSpan() {
        return this.span;
    }

    public final int getStart() {
        return this.start;
    }

    public int hashCode() {
        return (((this.span.hashCode() * 31) + this.start) * 31) + this.end;
    }

    @NotNull
    public String toString() {
        return "SpanRange(span=" + this.span + ", start=" + this.start + ", end=" + this.end + ')';
    }
}
