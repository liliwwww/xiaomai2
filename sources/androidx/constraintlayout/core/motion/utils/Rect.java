package androidx.constraintlayout.core.motion.utils;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class Rect {
    public int bottom;
    public int left;
    public int right;
    public int top;

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}
