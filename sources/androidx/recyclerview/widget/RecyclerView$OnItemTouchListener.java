package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface RecyclerView$OnItemTouchListener {
    boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

    void onRequestDisallowInterceptTouchEvent(boolean z);

    void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
}
