package androidx.compose.runtime.livedata;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.lifecycle.Observer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class a implements Observer {
    public final /* synthetic */ MutableState a;

    public final void onChanged(Object obj) {
        LiveDataAdapterKt.observeAsState.1.a(this.a, obj);
    }
}
