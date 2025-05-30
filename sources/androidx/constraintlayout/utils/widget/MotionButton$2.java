package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MotionButton$2 extends ViewOutlineProvider {
    final /* synthetic */ MotionButton this$0;

    MotionButton$2(MotionButton motionButton) {
        this.this$0 = motionButton;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), MotionButton.access$100(this.this$0));
    }
}
