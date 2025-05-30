package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathOperation {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Difference = m1190constructorimpl(0);
    private static final int Intersect = m1190constructorimpl(1);
    private static final int Union = m1190constructorimpl(2);
    private static final int Xor = m1190constructorimpl(3);
    private static final int ReverseDifference = m1190constructorimpl(4);

    private /* synthetic */ PathOperation(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PathOperation m1189boximpl(int i) {
        return new PathOperation(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1190constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1191equalsimpl(int i, Object obj) {
        return (obj instanceof PathOperation) && i == ((PathOperation) obj).m1195unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1192equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1193hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1194toStringimpl(int i) {
        return m1192equalsimpl0(i, Difference) ? "Difference" : m1192equalsimpl0(i, Intersect) ? "Intersect" : m1192equalsimpl0(i, Union) ? "Union" : m1192equalsimpl0(i, Xor) ? "Xor" : m1192equalsimpl0(i, ReverseDifference) ? "ReverseDifference" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1191equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1193hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1194toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1195unboximpl() {
        return this.value;
    }
}
