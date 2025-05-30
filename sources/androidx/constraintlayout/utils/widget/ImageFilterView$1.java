package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ImageFilterView$1 extends ViewOutlineProvider {
    final /* synthetic */ ImageFilterView this$0;

    ImageFilterView$1(ImageFilterView imageFilterView) {
        this.this$0 = imageFilterView;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), (Math.min(r3, r4) * ImageFilterView.access$000(this.this$0)) / 2.0f);
    }
}
