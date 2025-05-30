package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    private void load(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.StateSet_defaultState) {
                this.mDefaultState = obtainStyledAttributes.getResourceId(index, this.mDefaultState);
            }
        }
        obtainStyledAttributes.recycle();
        State state = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            c = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c == 2) {
                        state = new State(context, xmlPullParser);
                        this.mStateList.put(state.mId, state);
                    } else if (c == 3) {
                        Variant variant = new Variant(context, xmlPullParser);
                        if (state != null) {
                            state.add(variant);
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        State state = this.mStateList.get(i2);
        if (state == null) {
            return i2;
        }
        if (f == -1.0f || f2 == -1.0f) {
            if (state.mConstraintID == i) {
                return i;
            }
            Iterator it = state.mVariants.iterator();
            while (it.hasNext()) {
                if (i == ((Variant) it.next()).mConstraintID) {
                    return i;
                }
            }
            return state.mConstraintID;
        }
        Variant variant = null;
        Iterator it2 = state.mVariants.iterator();
        while (it2.hasNext()) {
            Variant variant2 = (Variant) it2.next();
            if (variant2.match(f, f2)) {
                if (i == variant2.mConstraintID) {
                    return i;
                }
                variant = variant2;
            }
        }
        return variant != null ? variant.mConstraintID : state.mConstraintID;
    }

    public boolean needsToChange(int i, float f, float f2) {
        int i2 = this.mCurrentStateId;
        if (i2 != i) {
            return true;
        }
        State valueAt = i == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i2);
        int i3 = this.mCurrentConstraintNumber;
        return (i3 == -1 || !((Variant) valueAt.mVariants.get(i3)).match(f, f2)) && this.mCurrentConstraintNumber != valueAt.findMatch(f, f2);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        return updateConstraints(-1, i, i2, i3);
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        int findMatch;
        if (i == i2) {
            State valueAt = i2 == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(this.mCurrentStateId);
            if (valueAt == null) {
                return -1;
            }
            return ((this.mCurrentConstraintNumber == -1 || !((Variant) valueAt.mVariants.get(i)).match(f, f2)) && i != (findMatch = valueAt.findMatch(f, f2))) ? findMatch == -1 ? valueAt.mConstraintID : ((Variant) valueAt.mVariants.get(findMatch)).mConstraintID : i;
        }
        State state = this.mStateList.get(i2);
        if (state == null) {
            return -1;
        }
        int findMatch2 = state.findMatch(f, f2);
        return findMatch2 == -1 ? state.mConstraintID : ((Variant) state.mVariants.get(findMatch2)).mConstraintID;
    }
}
