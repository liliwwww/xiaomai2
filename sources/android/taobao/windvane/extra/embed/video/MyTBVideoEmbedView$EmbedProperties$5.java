package android.taobao.windvane.extra.embed.video;

import android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
enum MyTBVideoEmbedView$EmbedProperties$5 extends MyTBVideoEmbedView.EmbedProperties {
    MyTBVideoEmbedView$EmbedProperties$5(String str, int i) {
        super(str, i, (MyTBVideoEmbedView.1) null);
    }

    public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
        if (!super.setValue(myTBVideoEmbedView, obj, z)) {
            return true;
        }
        myTBVideoEmbedView.setAutoPlay(toBoolean(obj), z);
        return true;
    }
}
