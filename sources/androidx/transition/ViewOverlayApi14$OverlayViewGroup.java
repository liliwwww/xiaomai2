package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewOverlayApi14$OverlayViewGroup extends ViewGroup {
    static Method sInvalidateChildInParentFastMethod;
    private boolean mDisposed;
    ArrayList<Drawable> mDrawables;
    ViewGroup mHostView;
    View mRequestingView;
    ViewOverlayApi14 mViewOverlay;

    static {
        try {
            Class cls = Integer.TYPE;
            sInvalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    ViewOverlayApi14$OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
        super(context);
        this.mDrawables = null;
        this.mHostView = viewGroup;
        this.mRequestingView = view;
        setRight(viewGroup.getWidth());
        setBottom(viewGroup.getHeight());
        viewGroup.addView(this);
        this.mViewOverlay = viewOverlayApi14;
    }

    private void assertNotDisposed() {
        if (this.mDisposed) {
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }
    }

    private void disposeIfEmpty() {
        if (getChildCount() == 0) {
            ArrayList<Drawable> arrayList = this.mDrawables;
            if (arrayList == null || arrayList.size() == 0) {
                this.mDisposed = true;
                this.mHostView.removeView(this);
            }
        }
    }

    private void getOffset(int[] iArr) {
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        this.mHostView.getLocationOnScreen(iArr2);
        this.mRequestingView.getLocationOnScreen(iArr3);
        iArr[0] = iArr3[0] - iArr2[0];
        iArr[1] = iArr3[1] - iArr2[1];
    }

    public void add(Drawable drawable) {
        assertNotDisposed();
        if (this.mDrawables == null) {
            this.mDrawables = new ArrayList<>();
        }
        if (this.mDrawables.contains(drawable)) {
            return;
        }
        this.mDrawables.add(drawable);
        invalidate(drawable.getBounds());
        drawable.setCallback(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mHostView.getLocationOnScreen(new int[2]);
        this.mRequestingView.getLocationOnScreen(new int[2]);
        canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
        canvas.clipRect(new Rect(0, 0, this.mRequestingView.getWidth(), this.mRequestingView.getHeight()));
        super.dispatchDraw(canvas);
        ArrayList<Drawable> arrayList = this.mDrawables;
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i = 0; i < size; i++) {
            this.mDrawables.get(i).draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if (this.mHostView == null) {
            return null;
        }
        rect.offset(iArr[0], iArr[1]);
        if (!(this.mHostView instanceof ViewGroup)) {
            invalidate(rect);
            return null;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        int[] iArr2 = new int[2];
        getOffset(iArr2);
        rect.offset(iArr2[0], iArr2[1]);
        return super.invalidateChildInParent(iArr, rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected ViewParent invalidateChildInParentFast(int i, int i2, Rect rect) {
        if (!(this.mHostView instanceof ViewGroup) || sInvalidateChildInParentFastMethod == null) {
            return null;
        }
        try {
            getOffset(new int[2]);
            sInvalidateChildInParentFastMethod.invoke(this.mHostView, Integer.valueOf(i), Integer.valueOf(i2), rect);
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidate(drawable.getBounds());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void remove(Drawable drawable) {
        ArrayList<Drawable> arrayList = this.mDrawables;
        if (arrayList != null) {
            arrayList.remove(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(null);
            disposeIfEmpty();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        ArrayList<Drawable> arrayList;
        return super.verifyDrawable(drawable) || ((arrayList = this.mDrawables) != null && arrayList.contains(drawable));
    }

    public void remove(View view) {
        super.removeView(view);
        disposeIfEmpty();
    }

    public void add(View view) {
        assertNotDisposed();
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != this.mHostView && viewGroup.getParent() != null && ViewCompat.isAttachedToWindow(viewGroup)) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr);
                this.mHostView.getLocationOnScreen(iArr2);
                ViewCompat.offsetLeftAndRight(view, iArr[0] - iArr2[0]);
                ViewCompat.offsetTopAndBottom(view, iArr[1] - iArr2[1]);
            }
            viewGroup.removeView(view);
            if (view.getParent() != null) {
                viewGroup.removeView(view);
            }
        }
        super.addView(view);
    }
}
