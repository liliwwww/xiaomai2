package androidx.activity;

import android.view.View;
import androidx.activity.PipHintTrackerKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class a implements View.OnLayoutChangeListener {
    public final /* synthetic */ ProducerScope a;

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        PipHintTrackerKt.trackPipAnimationHintView.flow.1.a(this.a, view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
