package androidx.compose.p004ui.node;

import android.taobao.windvane.connect.api.ApiConstants;
import java.util.Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
final class CenteredArray {

    @NotNull
    private final int[] data;

    private /* synthetic */ CenteredArray(int[] iArr) {
        this.data = iArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CenteredArray m4271boximpl(int[] iArr) {
        return new CenteredArray(iArr);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m4272constructorimpl(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, ApiConstants.DATA);
        return iArr;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4273equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof CenteredArray) && Intrinsics.areEqual(iArr, ((CenteredArray) obj).m4280unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4274equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: get-impl, reason: not valid java name */
    public static final int m4275getimpl(int[] iArr, int i) {
        return iArr[i + m4276getMidimpl(iArr)];
    }

    /* renamed from: getMid-impl, reason: not valid java name */
    private static final int m4276getMidimpl(int[] iArr) {
        return iArr.length / 2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4277hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m4278setimpl(int[] iArr, int i, int i2) {
        iArr[i + m4276getMidimpl(iArr)] = i2;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4279toStringimpl(int[] iArr) {
        return "CenteredArray(data=" + Arrays.toString(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return m4273equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m4277hashCodeimpl(this.data);
    }

    public String toString() {
        return m4279toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m4280unboximpl() {
        return this.data;
    }
}
