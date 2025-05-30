package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 $attachStateChangeListener;
    final /* synthetic */ View.OnLayoutChangeListener $layoutChangeListener;
    final /* synthetic */ ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
    final /* synthetic */ View $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PipHintTrackerKt$trackPipAnimationHintView$flow$1$1(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1) {
        super(0);
        this.$view = view;
        this.$scrollChangeListener = onScrollChangedListener;
        this.$layoutChangeListener = onLayoutChangeListener;
        this.$attachStateChangeListener = pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2invoke() {
        this.$view.getViewTreeObserver().removeOnScrollChangedListener(this.$scrollChangeListener);
        this.$view.removeOnLayoutChangeListener(this.$layoutChangeListener);
        this.$view.removeOnAttachStateChangeListener(this.$attachStateChangeListener);
    }
}
