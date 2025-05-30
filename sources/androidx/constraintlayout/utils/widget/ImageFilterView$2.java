package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ImageFilterView$2 extends ViewOutlineProvider {
    final /* synthetic */ ImageFilterView this$0;

    ImageFilterView$2(ImageFilterView imageFilterView) {
        this.this$0 = imageFilterView;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), ImageFilterView.access$100(this.this$0));
    }
}
