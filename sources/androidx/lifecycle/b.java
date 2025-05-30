package androidx.lifecycle;

import androidx.lifecycle.FlowLiveDataConversions;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class b implements Observer {
    public final /* synthetic */ ProducerScope a;

    public final void onChanged(Object obj) {
        FlowLiveDataConversions.asFlow.1.a(this.a, obj);
    }
}
