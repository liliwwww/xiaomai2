package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = 0;
    static final int UNKNOWN = -1;
    public final ConstraintReference mParent;
    private int numHelpers;
    protected HashMap<Object, Reference> mReferences = new HashMap<>();
    protected HashMap<Object, HelperReference> mHelperReferences = new HashMap<>();
    HashMap<String, ArrayList<String>> mTags = new HashMap<>();

    /* compiled from: Taobao */
    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public State() {
        Reference constraintReference = new ConstraintReference(this);
        this.mParent = constraintReference;
        this.numHelpers = 0;
        this.mReferences.put(PARENT, constraintReference);
    }

    private String createHelperKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i = this.numHelpers;
        this.numHelpers = i + 1;
        sb.append(i);
        sb.append("__");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void apply(ConstraintWidgetContainer constraintWidgetContainer) {
        HelperReference helperReference;
        HelperWidget helperWidget;
        ConstraintWidget helperWidget2;
        constraintWidgetContainer.removeAllChildren();
        this.mParent.getWidth().apply(this, constraintWidgetContainer, 0);
        this.mParent.getHeight().apply(this, constraintWidgetContainer, 1);
        for (Object obj : this.mHelperReferences.keySet()) {
            ConstraintWidget helperWidget3 = this.mHelperReferences.get(obj).getHelperWidget();
            if (helperWidget3 != null) {
                ConstraintReference constraintReference = (Reference) this.mReferences.get(obj);
                if (constraintReference == null) {
                    constraintReference = constraints(obj);
                }
                constraintReference.setConstraintWidget(helperWidget3);
            }
        }
        for (Object obj2 : this.mReferences.keySet()) {
            ConstraintReference constraintReference2 = (Reference) this.mReferences.get(obj2);
            if (constraintReference2 != this.mParent && (constraintReference2.getFacade() instanceof HelperReference) && (helperWidget2 = ((HelperReference) constraintReference2.getFacade()).getHelperWidget()) != null) {
                ConstraintReference constraintReference3 = (Reference) this.mReferences.get(obj2);
                if (constraintReference3 == null) {
                    constraintReference3 = constraints(obj2);
                }
                constraintReference3.setConstraintWidget(helperWidget2);
            }
        }
        Iterator<Object> it = this.mReferences.keySet().iterator();
        while (it.hasNext()) {
            ConstraintReference constraintReference4 = (Reference) this.mReferences.get(it.next());
            if (constraintReference4 != this.mParent) {
                ConstraintWidget constraintWidget = constraintReference4.getConstraintWidget();
                constraintWidget.setDebugName(constraintReference4.getKey().toString());
                constraintWidget.setParent(null);
                if (constraintReference4.getFacade() instanceof GuidelineReference) {
                    constraintReference4.apply();
                }
                constraintWidgetContainer.add(constraintWidget);
            } else {
                constraintReference4.setConstraintWidget(constraintWidgetContainer);
            }
        }
        Iterator<Object> it2 = this.mHelperReferences.keySet().iterator();
        while (it2.hasNext()) {
            HelperReference helperReference2 = this.mHelperReferences.get(it2.next());
            if (helperReference2.getHelperWidget() != null) {
                Iterator<Object> it3 = helperReference2.mReferences.iterator();
                while (it3.hasNext()) {
                    helperReference2.getHelperWidget().add(this.mReferences.get(it3.next()).getConstraintWidget());
                }
                helperReference2.apply();
            } else {
                helperReference2.apply();
            }
        }
        Iterator<Object> it4 = this.mReferences.keySet().iterator();
        while (it4.hasNext()) {
            ConstraintReference constraintReference5 = (Reference) this.mReferences.get(it4.next());
            if (constraintReference5 != this.mParent && (constraintReference5.getFacade() instanceof HelperReference) && (helperWidget = (helperReference = (HelperReference) constraintReference5.getFacade()).getHelperWidget()) != null) {
                Iterator<Object> it5 = helperReference.mReferences.iterator();
                while (it5.hasNext()) {
                    Object next = it5.next();
                    Reference reference = this.mReferences.get(next);
                    if (reference != null) {
                        helperWidget.add(reference.getConstraintWidget());
                    } else if (next instanceof Reference) {
                        helperWidget.add(((Reference) next).getConstraintWidget());
                    } else {
                        System.out.println("couldn't find reference for " + next);
                    }
                }
                constraintReference5.apply();
            }
        }
        for (Object obj3 : this.mReferences.keySet()) {
            Reference reference2 = this.mReferences.get(obj3);
            reference2.apply();
            ConstraintWidget constraintWidget2 = reference2.getConstraintWidget();
            if (constraintWidget2 != null && obj3 != null) {
                constraintWidget2.stringId = obj3.toString();
            }
        }
    }

    public BarrierReference barrier(Object obj, Direction direction) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof BarrierReference)) {
            BarrierReference barrierReference = new BarrierReference(this);
            barrierReference.setBarrierDirection(direction);
            constraints.setFacade(barrierReference);
        }
        return constraints.getFacade();
    }

    public AlignHorizontallyReference centerHorizontally(Object... objArr) {
        AlignHorizontallyReference helper = helper(null, Helper.ALIGN_HORIZONTALLY);
        helper.add(objArr);
        return helper;
    }

    public AlignVerticallyReference centerVertically(Object... objArr) {
        AlignVerticallyReference helper = helper(null, Helper.ALIGN_VERTICALLY);
        helper.add(objArr);
        return helper;
    }

    public ConstraintReference constraints(Object obj) {
        Reference reference = this.mReferences.get(obj);
        if (reference == null) {
            reference = createConstraintReference(obj);
            this.mReferences.put(obj, reference);
            reference.setKey(obj);
        }
        if (reference instanceof ConstraintReference) {
            return (ConstraintReference) reference;
        }
        return null;
    }

    public int convertDimension(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object obj) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        for (Object obj : this.mReferences.keySet()) {
            ConstraintReference constraints = constraints(obj);
            if (constraints instanceof ConstraintReference) {
                constraints.setView(obj);
            }
        }
    }

    public ArrayList<String> getIdsForTag(String str) {
        if (this.mTags.containsKey(str)) {
            return this.mTags.get(str);
        }
        return null;
    }

    public GuidelineReference guideline(Object obj, int i) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GuidelineReference)) {
            GuidelineReference guidelineReference = new GuidelineReference(this);
            guidelineReference.setOrientation(i);
            guidelineReference.setKey(obj);
            constraints.setFacade(guidelineReference);
        }
        return constraints.getFacade();
    }

    public State height(Dimension dimension) {
        return setHeight(dimension);
    }

    public HelperReference helper(Object obj, Helper helper) {
        BarrierReference horizontalChainReference;
        if (obj == null) {
            obj = createHelperKey();
        }
        BarrierReference barrierReference = (HelperReference) this.mHelperReferences.get(obj);
        if (barrierReference == null) {
            int i = 1.$SwitchMap$androidx$constraintlayout$core$state$State$Helper[helper.ordinal()];
            if (i == 1) {
                horizontalChainReference = new HorizontalChainReference(this);
            } else if (i == 2) {
                horizontalChainReference = new VerticalChainReference(this);
            } else if (i == 3) {
                horizontalChainReference = new AlignHorizontallyReference(this);
            } else if (i == 4) {
                horizontalChainReference = new AlignVerticallyReference(this);
            } else if (i != 5) {
                barrierReference = new HelperReference(this, helper);
                barrierReference.setKey(obj);
                this.mHelperReferences.put(obj, barrierReference);
            } else {
                horizontalChainReference = new BarrierReference(this);
            }
            barrierReference = horizontalChainReference;
            barrierReference.setKey(obj);
            this.mHelperReferences.put(obj, barrierReference);
        }
        return barrierReference;
    }

    public HorizontalChainReference horizontalChain() {
        return helper(null, Helper.HORIZONTAL_CHAIN);
    }

    public GuidelineReference horizontalGuideline(Object obj) {
        return guideline(obj, 0);
    }

    public void map(Object obj, Object obj2) {
        ConstraintReference constraints = constraints(obj);
        if (constraints instanceof ConstraintReference) {
            constraints.setView(obj2);
        }
    }

    Reference reference(Object obj) {
        return this.mReferences.get(obj);
    }

    public void reset() {
        this.mHelperReferences.clear();
        this.mTags.clear();
    }

    public boolean sameFixedHeight(int i) {
        return this.mParent.getHeight().equalsFixedValue(i);
    }

    public boolean sameFixedWidth(int i) {
        return this.mParent.getWidth().equalsFixedValue(i);
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    public void setTag(String str, String str2) {
        ArrayList<String> arrayList;
        ConstraintReference constraints = constraints(str);
        if (constraints instanceof ConstraintReference) {
            constraints.setTag(str2);
            if (this.mTags.containsKey(str2)) {
                arrayList = this.mTags.get(str2);
            } else {
                arrayList = new ArrayList<>();
                this.mTags.put(str2, arrayList);
            }
            arrayList.add(str);
        }
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
    }

    public GuidelineReference verticalGuideline(Object obj) {
        return guideline(obj, 1);
    }

    public State width(Dimension dimension) {
        return setWidth(dimension);
    }

    public HorizontalChainReference horizontalChain(Object... objArr) {
        HorizontalChainReference helper = helper(null, Helper.HORIZONTAL_CHAIN);
        helper.add(objArr);
        return helper;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.helpers.VerticalChainReference] */
    public VerticalChainReference verticalChain(Object... objArr) {
        ?? r0 = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
        r0.add(objArr);
        return r0;
    }
}
