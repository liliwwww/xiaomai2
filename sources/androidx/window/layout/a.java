package androidx.window.layout;

import androidx.core.util.Consumer;
import androidx.window.layout.WindowInfoTrackerImpl;
import kotlinx.coroutines.channels.Channel;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ Channel a;

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        WindowInfoTrackerImpl.windowLayoutInfo.1.a(this.a, (WindowLayoutInfo) obj);
    }
}
