package androidx.constraintlayout.core.motion.utils;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FloatRect {
    public float bottom;
    public float left;
    public float right;
    public float top;

    public final float centerX() {
        return (this.left + this.right) * 0.5f;
    }

    public final float centerY() {
        return (this.top + this.bottom) * 0.5f;
    }
}
