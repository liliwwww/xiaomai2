package androidx.compose.foundation.gestures;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DefaultScrollableState$scrollScope$1 implements ScrollScope {
    final /* synthetic */ DefaultScrollableState this$0;

    DefaultScrollableState$scrollScope$1(DefaultScrollableState defaultScrollableState) {
        this.this$0 = defaultScrollableState;
    }

    public float scrollBy(float f) {
        return ((Number) this.this$0.getOnDelta().invoke(Float.valueOf(f))).floatValue();
    }
}
