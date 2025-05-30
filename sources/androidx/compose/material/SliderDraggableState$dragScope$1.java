package androidx.compose.material;

import androidx.compose.foundation.gestures.DragScope;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SliderDraggableState$dragScope$1 implements DragScope {
    final /* synthetic */ SliderDraggableState this$0;

    SliderDraggableState$dragScope$1(SliderDraggableState sliderDraggableState) {
        this.this$0 = sliderDraggableState;
    }

    public void dragBy(float f) {
        this.this$0.getOnDelta().invoke(Float.valueOf(f));
    }
}
