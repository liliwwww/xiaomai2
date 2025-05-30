package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ConstraintLayoutStates$State {
    int mConstraintID;
    ConstraintSet mConstraintSet;
    int mId;
    ArrayList<ConstraintLayoutStates.Variant> mVariants = new ArrayList<>();

    public ConstraintLayoutStates$State(Context context, XmlPullParser xmlPullParser) {
        this.mConstraintID = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.State_android_id) {
                this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
            } else if (index == R.styleable.State_constraints) {
                this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                context.getResources().getResourceName(this.mConstraintID);
                if ("layout".equals(resourceTypeName)) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    this.mConstraintSet = constraintSet;
                    constraintSet.clone(context, this.mConstraintID);
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    void add(ConstraintLayoutStates.Variant variant) {
        this.mVariants.add(variant);
    }

    public int findMatch(float f, float f2) {
        for (int i = 0; i < this.mVariants.size(); i++) {
            if (this.mVariants.get(i).match(f, f2)) {
                return i;
            }
        }
        return -1;
    }
}
