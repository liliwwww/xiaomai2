package androidx.compose.foundation;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MagnifierKt$magnifier$4$4$1$1 extends Lambda implements Function0<Offset> {
    final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$4$1$1(State<Offset> state) {
        super(0);
        this.$sourceCenterInRoot$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.box-impl(m156invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0, reason: not valid java name */
    public final long m156invokeF1C5BW0() {
        return MagnifierKt.magnifier.4.access$invoke$lambda$8(this.$sourceCenterInRoot$delegate);
    }
}
