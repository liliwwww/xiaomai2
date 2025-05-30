package android.taobao.windvane.extra.embed.video;

import android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
enum MyTBLiveEmbedView$EmbedProperties$5 extends MyTBLiveEmbedView.EmbedProperties {
    MyTBLiveEmbedView$EmbedProperties$5(String str, int i) {
        super(str, i, (MyTBLiveEmbedView$1) null);
    }

    public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
        if (!super.setValue(myTBLiveEmbedView, obj, z)) {
            return false;
        }
        myTBLiveEmbedView.setObjectFit(String.valueOf(obj));
        return true;
    }
}
