package androidx.compose.animation;

import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ChangeSize$1 extends Lambda implements Function1<IntSize, IntSize> {
    public static final ChangeSize$1 INSTANCE = new ChangeSize$1();

    ChangeSize$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntSize.m2677boximpl(m39invokemzRDjE0(((IntSize) obj).m2689unboximpl()));
    }

    /* renamed from: invoke-mzRDjE0, reason: not valid java name */
    public final long m39invokemzRDjE0(long j) {
        return IntSizeKt.IntSize(0, 0);
    }
}
