package androidx.compose.ui.tooling;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
/* synthetic */ class ComposeViewAdapter$findAndTrackAnimations$animatedVisibilitySearch$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    ComposeViewAdapter$findAndTrackAnimations$animatedVisibilitySearch$1$1(Object obj) {
        super(0, obj, ComposeViewAdapter.class, "requestLayout", "requestLayout()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2541invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2541invoke() {
        ((ComposeViewAdapter) ((CallableReference) this).receiver).requestLayout();
    }
}
