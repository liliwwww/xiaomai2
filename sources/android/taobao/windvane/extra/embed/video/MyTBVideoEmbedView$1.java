package android.taobao.windvane.extra.embed.video;

import android.content.Context;
import android.widget.FrameLayout;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MyTBVideoEmbedView$1 extends FrameLayout {
    final /* synthetic */ MyTBVideoEmbedView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MyTBVideoEmbedView$1(MyTBVideoEmbedView myTBVideoEmbedView, Context context) {
        super(context);
        this.this$0 = myTBVideoEmbedView;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i4 == i3 && i4 == 0) {
            return;
        }
        if (MyTBVideoEmbedView.access$000(this.this$0) == i2 && MyTBVideoEmbedView.access$100(this.this$0) == i) {
            return;
        }
        MyTBVideoEmbedView.access$002(this.this$0, i2);
        MyTBVideoEmbedView.access$102(this.this$0, i);
        if (MyTBVideoEmbedView.access$200(this.this$0) != null) {
            MyTBVideoEmbedView.access$200(this.this$0).setFrame(i, i2);
        } else if (MyTBVideoEmbedView.access$300(this.this$0) != null) {
            MyTBVideoEmbedView.access$300(this.this$0).setFrame(i, i2);
        }
    }
}
