package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
abstract class DrawableContainerCompat$DrawableContainerState extends Drawable.ConstantState {
    boolean mAutoMirrored;
    boolean mCanConstantState;
    int mChangingConfigurations;
    boolean mCheckedConstantSize;
    boolean mCheckedConstantState;
    boolean mCheckedOpacity;
    boolean mCheckedPadding;
    boolean mCheckedStateful;
    int mChildrenChangingConfigurations;
    ColorFilter mColorFilter;
    int mConstantHeight;
    int mConstantMinimumHeight;
    int mConstantMinimumWidth;
    Rect mConstantPadding;
    boolean mConstantSize;
    int mConstantWidth;
    int mDensity;
    boolean mDither;
    SparseArray<Drawable.ConstantState> mDrawableFutures;
    Drawable[] mDrawables;
    int mEnterFadeDuration;
    int mExitFadeDuration;
    boolean mHasColorFilter;
    boolean mHasTintList;
    boolean mHasTintMode;
    int mLayoutDirection;
    boolean mMutated;
    int mNumChildren;
    int mOpacity;
    final DrawableContainerCompat mOwner;
    Resources mSourceRes;
    boolean mStateful;
    ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    boolean mVariablePadding;

    DrawableContainerCompat$DrawableContainerState(DrawableContainerCompat$DrawableContainerState drawableContainerCompat$DrawableContainerState, DrawableContainerCompat drawableContainerCompat, Resources resources) {
        this.mVariablePadding = false;
        this.mConstantSize = false;
        this.mDither = true;
        this.mEnterFadeDuration = 0;
        this.mExitFadeDuration = 0;
        this.mOwner = drawableContainerCompat;
        this.mSourceRes = resources != null ? resources : drawableContainerCompat$DrawableContainerState != null ? drawableContainerCompat$DrawableContainerState.mSourceRes : null;
        int resolveDensity = DrawableContainerCompat.resolveDensity(resources, drawableContainerCompat$DrawableContainerState != null ? drawableContainerCompat$DrawableContainerState.mDensity : 0);
        this.mDensity = resolveDensity;
        if (drawableContainerCompat$DrawableContainerState == null) {
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
            return;
        }
        this.mChangingConfigurations = drawableContainerCompat$DrawableContainerState.mChangingConfigurations;
        this.mChildrenChangingConfigurations = drawableContainerCompat$DrawableContainerState.mChildrenChangingConfigurations;
        this.mCheckedConstantState = true;
        this.mCanConstantState = true;
        this.mVariablePadding = drawableContainerCompat$DrawableContainerState.mVariablePadding;
        this.mConstantSize = drawableContainerCompat$DrawableContainerState.mConstantSize;
        this.mDither = drawableContainerCompat$DrawableContainerState.mDither;
        this.mMutated = drawableContainerCompat$DrawableContainerState.mMutated;
        this.mLayoutDirection = drawableContainerCompat$DrawableContainerState.mLayoutDirection;
        this.mEnterFadeDuration = drawableContainerCompat$DrawableContainerState.mEnterFadeDuration;
        this.mExitFadeDuration = drawableContainerCompat$DrawableContainerState.mExitFadeDuration;
        this.mAutoMirrored = drawableContainerCompat$DrawableContainerState.mAutoMirrored;
        this.mColorFilter = drawableContainerCompat$DrawableContainerState.mColorFilter;
        this.mHasColorFilter = drawableContainerCompat$DrawableContainerState.mHasColorFilter;
        this.mTintList = drawableContainerCompat$DrawableContainerState.mTintList;
        this.mTintMode = drawableContainerCompat$DrawableContainerState.mTintMode;
        this.mHasTintList = drawableContainerCompat$DrawableContainerState.mHasTintList;
        this.mHasTintMode = drawableContainerCompat$DrawableContainerState.mHasTintMode;
        if (drawableContainerCompat$DrawableContainerState.mDensity == resolveDensity) {
            if (drawableContainerCompat$DrawableContainerState.mCheckedPadding) {
                this.mConstantPadding = drawableContainerCompat$DrawableContainerState.mConstantPadding != null ? new Rect(drawableContainerCompat$DrawableContainerState.mConstantPadding) : null;
                this.mCheckedPadding = true;
            }
            if (drawableContainerCompat$DrawableContainerState.mCheckedConstantSize) {
                this.mConstantWidth = drawableContainerCompat$DrawableContainerState.mConstantWidth;
                this.mConstantHeight = drawableContainerCompat$DrawableContainerState.mConstantHeight;
                this.mConstantMinimumWidth = drawableContainerCompat$DrawableContainerState.mConstantMinimumWidth;
                this.mConstantMinimumHeight = drawableContainerCompat$DrawableContainerState.mConstantMinimumHeight;
                this.mCheckedConstantSize = true;
            }
        }
        if (drawableContainerCompat$DrawableContainerState.mCheckedOpacity) {
            this.mOpacity = drawableContainerCompat$DrawableContainerState.mOpacity;
            this.mCheckedOpacity = true;
        }
        if (drawableContainerCompat$DrawableContainerState.mCheckedStateful) {
            this.mStateful = drawableContainerCompat$DrawableContainerState.mStateful;
            this.mCheckedStateful = true;
        }
        Drawable[] drawableArr = drawableContainerCompat$DrawableContainerState.mDrawables;
        this.mDrawables = new Drawable[drawableArr.length];
        this.mNumChildren = drawableContainerCompat$DrawableContainerState.mNumChildren;
        SparseArray<Drawable.ConstantState> sparseArray = drawableContainerCompat$DrawableContainerState.mDrawableFutures;
        if (sparseArray != null) {
            this.mDrawableFutures = sparseArray.clone();
        } else {
            this.mDrawableFutures = new SparseArray<>(this.mNumChildren);
        }
        int i = this.mNumChildren;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2] != null) {
                Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                if (constantState != null) {
                    this.mDrawableFutures.put(i2, constantState);
                } else {
                    this.mDrawables[i2] = drawableArr[i2];
                }
            }
        }
    }

    private void createAllFutures() {
        SparseArray<Drawable.ConstantState> sparseArray = this.mDrawableFutures;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                this.mDrawables[this.mDrawableFutures.keyAt(i)] = prepareDrawable(this.mDrawableFutures.valueAt(i).newDrawable(this.mSourceRes));
            }
            this.mDrawableFutures = null;
        }
    }

    private Drawable prepareDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            DrawableCompat.setLayoutDirection(drawable, this.mLayoutDirection);
        }
        Drawable mutate = drawable.mutate();
        mutate.setCallback(this.mOwner);
        return mutate;
    }

    public final int addChild(Drawable drawable) {
        int i = this.mNumChildren;
        if (i >= this.mDrawables.length) {
            growArray(i, i + 10);
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.mOwner);
        this.mDrawables[i] = drawable;
        this.mNumChildren++;
        this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | this.mChildrenChangingConfigurations;
        invalidateCache();
        this.mConstantPadding = null;
        this.mCheckedPadding = false;
        this.mCheckedConstantSize = false;
        this.mCheckedConstantState = false;
        return i;
    }

    @RequiresApi(21)
    final void applyTheme(Resources.Theme theme) {
        if (theme != null) {
            createAllFutures();
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null && DrawableCompat.canApplyTheme(drawableArr[i2])) {
                    DrawableCompat.applyTheme(drawableArr[i2], theme);
                    this.mChildrenChangingConfigurations |= drawableArr[i2].getChangingConfigurations();
                }
            }
            updateDensity(DrawableContainerCompat$Api21Impl.getResources(theme));
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @RequiresApi(21)
    public boolean canApplyTheme() {
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable == null) {
                Drawable.ConstantState constantState = this.mDrawableFutures.get(i2);
                if (constantState != null && DrawableContainerCompat$Api21Impl.canApplyTheme(constantState)) {
                    return true;
                }
            } else if (DrawableCompat.canApplyTheme(drawable)) {
                return true;
            }
        }
        return false;
    }

    public boolean canConstantState() {
        if (this.mCheckedConstantState) {
            return this.mCanConstantState;
        }
        createAllFutures();
        this.mCheckedConstantState = true;
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2].getConstantState() == null) {
                this.mCanConstantState = false;
                return false;
            }
        }
        this.mCanConstantState = true;
        return true;
    }

    final void clearMutated() {
        this.mMutated = false;
    }

    protected void computeConstantSize() {
        this.mCheckedConstantSize = true;
        createAllFutures();
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        this.mConstantHeight = -1;
        this.mConstantWidth = -1;
        this.mConstantMinimumHeight = 0;
        this.mConstantMinimumWidth = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.mConstantWidth) {
                this.mConstantWidth = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.mConstantHeight) {
                this.mConstantHeight = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.mConstantMinimumWidth) {
                this.mConstantMinimumWidth = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.mConstantMinimumHeight) {
                this.mConstantMinimumHeight = minimumHeight;
            }
        }
    }

    final int getCapacity() {
        return this.mDrawables.length;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
    }

    public final Drawable getChild(int i) {
        int indexOfKey;
        Drawable drawable = this.mDrawables[i];
        if (drawable != null) {
            return drawable;
        }
        SparseArray<Drawable.ConstantState> sparseArray = this.mDrawableFutures;
        if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
            return null;
        }
        Drawable prepareDrawable = prepareDrawable(this.mDrawableFutures.valueAt(indexOfKey).newDrawable(this.mSourceRes));
        this.mDrawables[i] = prepareDrawable;
        this.mDrawableFutures.removeAt(indexOfKey);
        if (this.mDrawableFutures.size() == 0) {
            this.mDrawableFutures = null;
        }
        return prepareDrawable;
    }

    public final int getChildCount() {
        return this.mNumChildren;
    }

    public final int getConstantHeight() {
        if (!this.mCheckedConstantSize) {
            computeConstantSize();
        }
        return this.mConstantHeight;
    }

    public final int getConstantMinimumHeight() {
        if (!this.mCheckedConstantSize) {
            computeConstantSize();
        }
        return this.mConstantMinimumHeight;
    }

    public final int getConstantMinimumWidth() {
        if (!this.mCheckedConstantSize) {
            computeConstantSize();
        }
        return this.mConstantMinimumWidth;
    }

    public final Rect getConstantPadding() {
        Rect rect = null;
        if (this.mVariablePadding) {
            return null;
        }
        Rect rect2 = this.mConstantPadding;
        if (rect2 != null || this.mCheckedPadding) {
            return rect2;
        }
        createAllFutures();
        Rect rect3 = new Rect();
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2].getPadding(rect3)) {
                if (rect == null) {
                    rect = new Rect(0, 0, 0, 0);
                }
                int i3 = rect3.left;
                if (i3 > rect.left) {
                    rect.left = i3;
                }
                int i4 = rect3.top;
                if (i4 > rect.top) {
                    rect.top = i4;
                }
                int i5 = rect3.right;
                if (i5 > rect.right) {
                    rect.right = i5;
                }
                int i6 = rect3.bottom;
                if (i6 > rect.bottom) {
                    rect.bottom = i6;
                }
            }
        }
        this.mCheckedPadding = true;
        this.mConstantPadding = rect;
        return rect;
    }

    public final int getConstantWidth() {
        if (!this.mCheckedConstantSize) {
            computeConstantSize();
        }
        return this.mConstantWidth;
    }

    public final int getEnterFadeDuration() {
        return this.mEnterFadeDuration;
    }

    public final int getExitFadeDuration() {
        return this.mExitFadeDuration;
    }

    public final int getOpacity() {
        if (this.mCheckedOpacity) {
            return this.mOpacity;
        }
        createAllFutures();
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
        for (int i2 = 1; i2 < i; i2++) {
            opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
        }
        this.mOpacity = opacity;
        this.mCheckedOpacity = true;
        return opacity;
    }

    public void growArray(int i, int i2) {
        Drawable[] drawableArr = new Drawable[i2];
        Drawable[] drawableArr2 = this.mDrawables;
        if (drawableArr2 != null) {
            System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
        }
        this.mDrawables = drawableArr;
    }

    void invalidateCache() {
        this.mCheckedOpacity = false;
        this.mCheckedStateful = false;
    }

    public final boolean isConstantSize() {
        return this.mConstantSize;
    }

    public final boolean isStateful() {
        if (this.mCheckedStateful) {
            return this.mStateful;
        }
        createAllFutures();
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            if (drawableArr[i2].isStateful()) {
                z = true;
                break;
            }
            i2++;
        }
        this.mStateful = z;
        this.mCheckedStateful = true;
        return z;
    }

    void mutate() {
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2] != null) {
                drawableArr[i2].mutate();
            }
        }
        this.mMutated = true;
    }

    public final void setConstantSize(boolean z) {
        this.mConstantSize = z;
    }

    public final void setEnterFadeDuration(int i) {
        this.mEnterFadeDuration = i;
    }

    public final void setExitFadeDuration(int i) {
        this.mExitFadeDuration = i;
    }

    final boolean setLayoutDirection(int i, int i2) {
        int i3 = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            if (drawableArr[i4] != null) {
                boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? DrawableCompat.setLayoutDirection(drawableArr[i4], i) : false;
                if (i4 == i2) {
                    z = layoutDirection;
                }
            }
        }
        this.mLayoutDirection = i;
        return z;
    }

    public final void setVariablePadding(boolean z) {
        this.mVariablePadding = z;
    }

    final void updateDensity(Resources resources) {
        if (resources != null) {
            this.mSourceRes = resources;
            int resolveDensity = DrawableContainerCompat.resolveDensity(resources, this.mDensity);
            int i = this.mDensity;
            this.mDensity = resolveDensity;
            if (i != resolveDensity) {
                this.mCheckedConstantSize = false;
                this.mCheckedPadding = false;
            }
        }
    }
}
