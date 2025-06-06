package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;

    public static WidgetGroup findDependents(ConstraintWidget constraintWidget, int i, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        int findGroupInDependents;
        int i2 = i == 0 ? constraintWidget.horizontalGroup : constraintWidget.verticalGroup;
        if (i2 != -1 && (widgetGroup == null || i2 != widgetGroup.id)) {
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = arrayList.get(i3);
                if (widgetGroup2.getId() == i2) {
                    if (widgetGroup != null) {
                        widgetGroup.moveTo(i, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i3++;
                }
            }
        } else if (i2 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if ((constraintWidget instanceof HelperWidget) && (findGroupInDependents = ((HelperWidget) constraintWidget).findGroupInDependents(i)) != -1) {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    WidgetGroup widgetGroup3 = arrayList.get(i4);
                    if (widgetGroup3.getId() == findGroupInDependents) {
                        widgetGroup = widgetGroup3;
                        break;
                    }
                    i4++;
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.add(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                guideline.getAnchor().findDependents(guideline.getOrientation() == 0 ? 1 : 0, arrayList, widgetGroup);
            }
            if (i == 0) {
                constraintWidget.horizontalGroup = widgetGroup.getId();
                constraintWidget.mLeft.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mRight.findDependents(i, arrayList, widgetGroup);
            } else {
                constraintWidget.verticalGroup = widgetGroup.getId();
                constraintWidget.mTop.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mBaseline.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mBottom.findDependents(i, arrayList, widgetGroup);
            }
            constraintWidget.mCenter.findDependents(i, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            WidgetGroup widgetGroup = arrayList.get(i2);
            if (i == widgetGroup.id) {
                return widgetGroup;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x039b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean simpleSolvingPass(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r16, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r17) {
        /*
            Method dump skipped, instructions count: 935
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.simpleSolvingPass(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):boolean");
    }

    public static boolean validInGroup(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7 = ConstraintWidget$DimensionBehaviour.FIXED;
        return (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour7 || constraintWidget$DimensionBehaviour3 == (constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || (constraintWidget$DimensionBehaviour3 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT && constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour6)) || (constraintWidget$DimensionBehaviour4 == constraintWidget$DimensionBehaviour7 || constraintWidget$DimensionBehaviour4 == (constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || (constraintWidget$DimensionBehaviour4 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT && constraintWidget$DimensionBehaviour2 != constraintWidget$DimensionBehaviour5));
    }
}
