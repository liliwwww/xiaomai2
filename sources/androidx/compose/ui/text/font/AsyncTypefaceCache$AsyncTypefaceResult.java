package androidx.compose.ui.text.font;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AsyncTypefaceCache$AsyncTypefaceResult {

    @Nullable
    private final Object result;

    private /* synthetic */ AsyncTypefaceCache$AsyncTypefaceResult(Object obj) {
        this.result = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AsyncTypefaceCache$AsyncTypefaceResult m2358boximpl(Object obj) {
        return new AsyncTypefaceCache$AsyncTypefaceResult(obj);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m2359constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2360equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof AsyncTypefaceCache$AsyncTypefaceResult) && Intrinsics.areEqual(obj, ((AsyncTypefaceCache$AsyncTypefaceResult) obj2).m2365unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2361equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2362hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isPermanentFailure-impl, reason: not valid java name */
    public static final boolean m2363isPermanentFailureimpl(Object obj) {
        return obj == null;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2364toStringimpl(Object obj) {
        return "AsyncTypefaceResult(result=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m2360equalsimpl(this.result, obj);
    }

    @Nullable
    public final Object getResult() {
        return this.result;
    }

    public int hashCode() {
        return m2362hashCodeimpl(this.result);
    }

    public String toString() {
        return m2364toStringimpl(this.result);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m2365unboximpl() {
        return this.result;
    }
}
