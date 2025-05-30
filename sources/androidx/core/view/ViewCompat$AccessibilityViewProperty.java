package androidx.core.view;

import android.os.Build;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
abstract class ViewCompat$AccessibilityViewProperty<T> {
    private final int mContentChangeType;
    private final int mFrameworkMinimumSdk;
    private final int mTagKey;
    private final Class<T> mType;

    ViewCompat$AccessibilityViewProperty(int i, Class<T> cls, int i2) {
        this(i, cls, 0, i2);
    }

    private boolean extrasAvailable() {
        return Build.VERSION.SDK_INT >= 19;
    }

    private boolean frameworkAvailable() {
        return Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
    }

    boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
        return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
    }

    abstract T frameworkGet(View view);

    abstract void frameworkSet(View view, T t);

    T get(View view) {
        if (frameworkAvailable()) {
            return frameworkGet(view);
        }
        if (!extrasAvailable()) {
            return null;
        }
        T t = (T) view.getTag(this.mTagKey);
        if (this.mType.isInstance(t)) {
            return t;
        }
        return null;
    }

    void set(View view, T t) {
        if (frameworkAvailable()) {
            frameworkSet(view, t);
        } else if (extrasAvailable() && shouldUpdate(get(view), t)) {
            ViewCompat.ensureAccessibilityDelegateCompat(view);
            view.setTag(this.mTagKey, t);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
        }
    }

    boolean shouldUpdate(T t, T t2) {
        return !t2.equals(t);
    }

    ViewCompat$AccessibilityViewProperty(int i, Class<T> cls, int i2, int i3) {
        this.mTagKey = i;
        this.mType = cls;
        this.mContentChangeType = i2;
        this.mFrameworkMinimumSdk = i3;
    }
}
