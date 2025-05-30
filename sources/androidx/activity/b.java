package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.activity.PipHintTrackerKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class b implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ ProducerScope a;
    public final /* synthetic */ View b;

    public /* synthetic */ b(ProducerScope producerScope, View view) {
        this.a = producerScope;
        this.b = view;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        PipHintTrackerKt.trackPipAnimationHintView.flow.1.b(this.a, this.b);
    }
}
