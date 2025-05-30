package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowInsetsCompat$BuilderImpl {
    private final WindowInsetsCompat mInsets;
    Insets[] mInsetsTypeMask;

    WindowInsetsCompat$BuilderImpl() {
        this(new WindowInsetsCompat((WindowInsetsCompat) null));
    }

    protected final void applyInsetTypes() {
        Insets[] insetsArr = this.mInsetsTypeMask;
        if (insetsArr != null) {
            Insets insets = insetsArr[WindowInsetsCompat$Type.indexOf(1)];
            Insets insets2 = this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(2)];
            if (insets2 == null) {
                insets2 = this.mInsets.getInsets(2);
            }
            if (insets == null) {
                insets = this.mInsets.getInsets(1);
            }
            setSystemWindowInsets(Insets.max(insets, insets2));
            Insets insets3 = this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(16)];
            if (insets3 != null) {
                setSystemGestureInsets(insets3);
            }
            Insets insets4 = this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(32)];
            if (insets4 != null) {
                setMandatorySystemGestureInsets(insets4);
            }
            Insets insets5 = this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(64)];
            if (insets5 != null) {
                setTappableElementInsets(insets5);
            }
        }
    }

    @NonNull
    WindowInsetsCompat build() {
        applyInsetTypes();
        return this.mInsets;
    }

    void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
    }

    void setInsets(int i, @NonNull Insets insets) {
        if (this.mInsetsTypeMask == null) {
            this.mInsetsTypeMask = new Insets[9];
        }
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(i2)] = insets;
            }
        }
    }

    void setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
        if (i == 8) {
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }
    }

    void setMandatorySystemGestureInsets(@NonNull Insets insets) {
    }

    void setStableInsets(@NonNull Insets insets) {
    }

    void setSystemGestureInsets(@NonNull Insets insets) {
    }

    void setSystemWindowInsets(@NonNull Insets insets) {
    }

    void setTappableElementInsets(@NonNull Insets insets) {
    }

    void setVisible(int i, boolean z) {
    }

    WindowInsetsCompat$BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.mInsets = windowInsetsCompat;
    }
}
