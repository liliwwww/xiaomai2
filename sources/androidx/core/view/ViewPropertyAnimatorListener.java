package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface ViewPropertyAnimatorListener {
    void onAnimationCancel(@NonNull View view);

    void onAnimationEnd(@NonNull View view);

    void onAnimationStart(@NonNull View view);
}
