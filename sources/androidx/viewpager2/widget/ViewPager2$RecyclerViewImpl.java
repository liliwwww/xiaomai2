package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ViewPager2$RecyclerViewImpl extends RecyclerView {
    final /* synthetic */ ViewPager2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewPager2$RecyclerViewImpl(@NonNull ViewPager2 viewPager2, Context context) {
        super(context);
        this.this$0 = viewPager2;
    }

    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        return this.this$0.mAccessibilityProvider.handlesRvGetAccessibilityClassName() ? this.this$0.mAccessibilityProvider.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super/*android.view.ViewGroup*/.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setFromIndex(this.this$0.mCurrentItem);
        accessibilityEvent.setToIndex(this.this$0.mCurrentItem);
        this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.this$0.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.this$0.isUserInputEnabled() && super.onTouchEvent(motionEvent);
    }
}
