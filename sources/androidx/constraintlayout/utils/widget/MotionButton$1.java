package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MotionButton$1 extends ViewOutlineProvider {
    final /* synthetic */ MotionButton this$0;

    MotionButton$1(MotionButton motionButton) {
        this.this$0 = motionButton;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), (Math.min(r3, r4) * MotionButton.access$000(this.this$0)) / 2.0f);
    }
}
