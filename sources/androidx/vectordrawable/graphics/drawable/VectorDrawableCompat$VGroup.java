package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.TypedArrayUtils;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class VectorDrawableCompat$VGroup extends VectorDrawableCompat.VObject {
    int mChangingConfigurations;
    final ArrayList<VectorDrawableCompat.VObject> mChildren;
    private String mGroupName;
    final Matrix mLocalMatrix;
    private float mPivotX;
    private float mPivotY;
    float mRotate;
    private float mScaleX;
    private float mScaleY;
    final Matrix mStackedMatrix;
    private int[] mThemeAttrs;
    private float mTranslateX;
    private float mTranslateY;

    public VectorDrawableCompat$VGroup(VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, ArrayMap<String, Object> arrayMap) {
        super((VectorDrawableCompat$1) null);
        VectorDrawableCompat.VFullPath vectorDrawableCompat$VClipPath;
        this.mStackedMatrix = new Matrix();
        this.mChildren = new ArrayList<>();
        this.mRotate = 0.0f;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTranslateX = 0.0f;
        this.mTranslateY = 0.0f;
        Matrix matrix = new Matrix();
        this.mLocalMatrix = matrix;
        this.mGroupName = null;
        this.mRotate = vectorDrawableCompat$VGroup.mRotate;
        this.mPivotX = vectorDrawableCompat$VGroup.mPivotX;
        this.mPivotY = vectorDrawableCompat$VGroup.mPivotY;
        this.mScaleX = vectorDrawableCompat$VGroup.mScaleX;
        this.mScaleY = vectorDrawableCompat$VGroup.mScaleY;
        this.mTranslateX = vectorDrawableCompat$VGroup.mTranslateX;
        this.mTranslateY = vectorDrawableCompat$VGroup.mTranslateY;
        this.mThemeAttrs = vectorDrawableCompat$VGroup.mThemeAttrs;
        String str = vectorDrawableCompat$VGroup.mGroupName;
        this.mGroupName = str;
        this.mChangingConfigurations = vectorDrawableCompat$VGroup.mChangingConfigurations;
        if (str != null) {
            arrayMap.put(str, this);
        }
        matrix.set(vectorDrawableCompat$VGroup.mLocalMatrix);
        ArrayList<VectorDrawableCompat.VObject> arrayList = vectorDrawableCompat$VGroup.mChildren;
        for (int i = 0; i < arrayList.size(); i++) {
            VectorDrawableCompat.VFullPath vFullPath = arrayList.get(i);
            if (vFullPath instanceof VectorDrawableCompat$VGroup) {
                this.mChildren.add(new VectorDrawableCompat$VGroup((VectorDrawableCompat$VGroup) vFullPath, arrayMap));
            } else {
                if (vFullPath instanceof VectorDrawableCompat.VFullPath) {
                    vectorDrawableCompat$VClipPath = new VectorDrawableCompat.VFullPath(vFullPath);
                } else {
                    if (!(vFullPath instanceof VectorDrawableCompat$VClipPath)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    vectorDrawableCompat$VClipPath = new VectorDrawableCompat$VClipPath((VectorDrawableCompat$VClipPath) vFullPath);
                }
                this.mChildren.add(vectorDrawableCompat$VClipPath);
                String str2 = vectorDrawableCompat$VClipPath.mPathName;
                if (str2 != null) {
                    arrayMap.put(str2, vectorDrawableCompat$VClipPath);
                }
            }
        }
    }

    private void updateLocalMatrix() {
        this.mLocalMatrix.reset();
        this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
        this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
        this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
        this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.mThemeAttrs = null;
        this.mRotate = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, Key.ROTATION, 5, this.mRotate);
        this.mPivotX = typedArray.getFloat(1, this.mPivotX);
        this.mPivotY = typedArray.getFloat(2, this.mPivotY);
        this.mScaleX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
        this.mScaleY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
        this.mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.mTranslateX);
        this.mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.mTranslateY);
        String string = typedArray.getString(0);
        if (string != null) {
            this.mGroupName = string;
        }
        updateLocalMatrix();
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public Matrix getLocalMatrix() {
        return this.mLocalMatrix;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotate;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
        updateStateFromTypedArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }

    public boolean isStateful() {
        for (int i = 0; i < this.mChildren.size(); i++) {
            if (this.mChildren.get(i).isStateful()) {
                return true;
            }
        }
        return false;
    }

    public boolean onStateChanged(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.mChildren.size(); i++) {
            z |= this.mChildren.get(i).onStateChanged(iArr);
        }
        return z;
    }

    public void setPivotX(float f) {
        if (f != this.mPivotX) {
            this.mPivotX = f;
            updateLocalMatrix();
        }
    }

    public void setPivotY(float f) {
        if (f != this.mPivotY) {
            this.mPivotY = f;
            updateLocalMatrix();
        }
    }

    public void setRotation(float f) {
        if (f != this.mRotate) {
            this.mRotate = f;
            updateLocalMatrix();
        }
    }

    public void setScaleX(float f) {
        if (f != this.mScaleX) {
            this.mScaleX = f;
            updateLocalMatrix();
        }
    }

    public void setScaleY(float f) {
        if (f != this.mScaleY) {
            this.mScaleY = f;
            updateLocalMatrix();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.mTranslateX) {
            this.mTranslateX = f;
            updateLocalMatrix();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.mTranslateY) {
            this.mTranslateY = f;
            updateLocalMatrix();
        }
    }

    public VectorDrawableCompat$VGroup() {
        super((VectorDrawableCompat$1) null);
        this.mStackedMatrix = new Matrix();
        this.mChildren = new ArrayList<>();
        this.mRotate = 0.0f;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTranslateX = 0.0f;
        this.mTranslateY = 0.0f;
        this.mLocalMatrix = new Matrix();
        this.mGroupName = null;
    }
}
