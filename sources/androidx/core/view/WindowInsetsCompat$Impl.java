package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowInsetsCompat$Impl {

    @NonNull
    static final WindowInsetsCompat CONSUMED = new WindowInsetsCompat.Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
    final WindowInsetsCompat mHost;

    WindowInsetsCompat$Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.mHost = windowInsetsCompat;
    }

    @NonNull
    WindowInsetsCompat consumeDisplayCutout() {
        return this.mHost;
    }

    @NonNull
    WindowInsetsCompat consumeStableInsets() {
        return this.mHost;
    }

    @NonNull
    WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mHost;
    }

    void copyRootViewBounds(@NonNull View view) {
    }

    void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat$Impl)) {
            return false;
        }
        WindowInsetsCompat$Impl windowInsetsCompat$Impl = (WindowInsetsCompat$Impl) obj;
        return isRound() == windowInsetsCompat$Impl.isRound() && isConsumed() == windowInsetsCompat$Impl.isConsumed() && ObjectsCompat.equals(getSystemWindowInsets(), windowInsetsCompat$Impl.getSystemWindowInsets()) && ObjectsCompat.equals(getStableInsets(), windowInsetsCompat$Impl.getStableInsets()) && ObjectsCompat.equals(getDisplayCutout(), windowInsetsCompat$Impl.getDisplayCutout());
    }

    @Nullable
    DisplayCutoutCompat getDisplayCutout() {
        return null;
    }

    @NonNull
    Insets getInsets(int i) {
        return Insets.NONE;
    }

    @NonNull
    Insets getInsetsIgnoringVisibility(int i) {
        if ((i & 8) == 0) {
            return Insets.NONE;
        }
        throw new IllegalArgumentException("Unable to query the maximum insets for IME");
    }

    @NonNull
    Insets getMandatorySystemGestureInsets() {
        return getSystemWindowInsets();
    }

    @NonNull
    Insets getStableInsets() {
        return Insets.NONE;
    }

    @NonNull
    Insets getSystemGestureInsets() {
        return getSystemWindowInsets();
    }

    @NonNull
    Insets getSystemWindowInsets() {
        return Insets.NONE;
    }

    @NonNull
    Insets getTappableElementInsets() {
        return getSystemWindowInsets();
    }

    public int hashCode() {
        return ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
    }

    @NonNull
    WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
        return CONSUMED;
    }

    boolean isConsumed() {
        return false;
    }

    boolean isRound() {
        return false;
    }

    boolean isVisible(int i) {
        return true;
    }

    public void setOverriddenInsets(Insets[] insetsArr) {
    }

    void setRootViewData(@NonNull Insets insets) {
    }

    void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
    }

    public void setStableInsets(Insets insets) {
    }
}
