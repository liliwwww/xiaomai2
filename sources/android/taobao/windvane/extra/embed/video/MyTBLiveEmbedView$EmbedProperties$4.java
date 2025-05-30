package android.taobao.windvane.extra.embed.video;

import android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
enum MyTBLiveEmbedView$EmbedProperties$4 extends MyTBLiveEmbedView.EmbedProperties {
    MyTBLiveEmbedView$EmbedProperties$4(String str, int i) {
        super(str, i, (MyTBLiveEmbedView$1) null);
    }

    public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
        int i = 0;
        if (!super.setValue(myTBLiveEmbedView, obj, z)) {
            return false;
        }
        try {
            i = Integer.valueOf(String.valueOf(obj)).intValue();
        } catch (Throwable unused) {
        }
        myTBLiveEmbedView.setScenarioType(i);
        return true;
    }
}
