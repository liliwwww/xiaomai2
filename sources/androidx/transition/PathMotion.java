package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    public abstract Path getPath(float f, float f2, float f3, float f4);

    public PathMotion(Context context, AttributeSet attributeSet) {
    }
}
