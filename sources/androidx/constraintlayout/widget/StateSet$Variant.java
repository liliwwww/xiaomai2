package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class StateSet$Variant {
    int mConstraintID;
    int mId;
    boolean mIsLayout;
    float mMaxHeight;
    float mMaxWidth;
    float mMinHeight;
    float mMinWidth;

    public StateSet$Variant(Context context, XmlPullParser xmlPullParser) {
        this.mMinWidth = Float.NaN;
        this.mMinHeight = Float.NaN;
        this.mMaxWidth = Float.NaN;
        this.mMaxHeight = Float.NaN;
        this.mConstraintID = -1;
        this.mIsLayout = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R$styleable.Variant_constraints) {
                this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                context.getResources().getResourceName(this.mConstraintID);
                if ("layout".equals(resourceTypeName)) {
                    this.mIsLayout = true;
                }
            } else if (index == R$styleable.Variant_region_heightLessThan) {
                this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
            } else if (index == R$styleable.Variant_region_heightMoreThan) {
                this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
            } else if (index == R$styleable.Variant_region_widthLessThan) {
                this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
            } else if (index == R$styleable.Variant_region_widthMoreThan) {
                this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
            } else {
                Log.v(ConstraintLayoutStates.TAG, "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }

    boolean match(float f, float f2) {
        if (!Float.isNaN(this.mMinWidth) && f < this.mMinWidth) {
            return false;
        }
        if (!Float.isNaN(this.mMinHeight) && f2 < this.mMinHeight) {
            return false;
        }
        if (Float.isNaN(this.mMaxWidth) || f <= this.mMaxWidth) {
            return Float.isNaN(this.mMaxHeight) || f2 <= this.mMaxHeight;
        }
        return false;
    }
}
