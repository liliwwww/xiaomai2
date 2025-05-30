package androidx.compose.foundation;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MagnifierKt$magnifier$4$isMagnifierShown$2$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$isMagnifierShown$2$1(State<Offset> state) {
        super(0);
        this.$sourceCenterInRoot$delegate = state;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m157invoke() {
        return Boolean.valueOf(OffsetKt.m1027isSpecifiedk4lQ0M(MagnifierKt.magnifier.4.access$invoke$lambda$8(this.$sourceCenterInRoot$delegate)));
    }
}
