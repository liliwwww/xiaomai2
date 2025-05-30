package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1 extends Lambda implements Function0<Offset> {
    final /* synthetic */ State<Offset> $targetValue$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1(State<Offset> state) {
        super(0);
        this.$targetValue$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m837boximpl(m467invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0, reason: not valid java name */
    public final long m467invokeF1C5BW0() {
        return SelectionMagnifierKt.access$rememberAnimatedMagnifierPosition$lambda$1(this.$targetValue$delegate);
    }
}
