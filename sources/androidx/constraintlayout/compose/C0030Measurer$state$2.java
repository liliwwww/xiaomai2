package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/constraintlayout/compose/State;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: androidx.constraintlayout.compose.Measurer$state$2, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class C0030Measurer$state$2 extends Lambda implements Function0<State> {
    final /* synthetic */ Measurer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0030Measurer$state$2(Measurer measurer) {
        super(0);
        this.this$0 = measurer;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final State m2758invoke() {
        return new State(this.this$0.getDensity());
    }
}
