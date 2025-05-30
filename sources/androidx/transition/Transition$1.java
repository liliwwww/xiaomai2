package androidx.transition;

import android.graphics.Path;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class Transition$1 extends PathMotion {
    Transition$1() {
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        return path;
    }
}
