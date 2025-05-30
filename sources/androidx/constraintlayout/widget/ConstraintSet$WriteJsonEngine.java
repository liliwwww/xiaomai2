package androidx.constraintlayout.widget;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintSet;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ConstraintSet$WriteJsonEngine {
    private static final String SPACE = "       ";
    Context context;
    int flags;
    ConstraintLayout layout;
    final /* synthetic */ ConstraintSet this$0;
    Writer writer;
    int unknownCount = 0;
    final String LEFT = "'left'";
    final String RIGHT = "'right'";
    final String BASELINE = "'baseline'";
    final String BOTTOM = "'bottom'";
    final String TOP = "'top'";
    final String START = "'start'";
    final String END = "'end'";
    HashMap<Integer, String> idMap = new HashMap<>();

    ConstraintSet$WriteJsonEngine(ConstraintSet constraintSet, Writer writer, ConstraintLayout constraintLayout, int i) throws IOException {
        this.this$0 = constraintSet;
        this.writer = writer;
        this.layout = constraintLayout;
        this.context = constraintLayout.getContext();
        this.flags = i;
    }

    private void writeDimension(String str, int i, int i2, float f, int i3, int i4, boolean z) throws IOException {
        if (i != 0) {
            if (i == -2) {
                this.writer.write(SPACE + str + ": 'wrap'\n");
                return;
            }
            if (i == -1) {
                this.writer.write(SPACE + str + ": 'parent'\n");
                return;
            }
            this.writer.write(SPACE + str + ": " + i + ",\n");
            return;
        }
        if (i4 == -1 && i3 == -1) {
            if (i2 == 1) {
                this.writer.write(SPACE + str + ": '???????????',\n");
                return;
            }
            if (i2 != 2) {
                return;
            }
            this.writer.write(SPACE + str + ": '" + f + "%',\n");
            return;
        }
        if (i2 == 0) {
            this.writer.write(SPACE + str + ": {'spread' ," + i3 + ", " + i4 + "}\n");
            return;
        }
        if (i2 == 1) {
            this.writer.write(SPACE + str + ": {'wrap' ," + i3 + ", " + i4 + "}\n");
            return;
        }
        if (i2 != 2) {
            return;
        }
        this.writer.write(SPACE + str + ": {'" + f + "'% ," + i3 + ", " + i4 + "}\n");
    }

    private void writeGuideline(int i, int i2, int i3, float f) {
    }

    String getName(int i) {
        if (this.idMap.containsKey(Integer.valueOf(i))) {
            return "'" + this.idMap.get(Integer.valueOf(i)) + "'";
        }
        if (i == 0) {
            return "'parent'";
        }
        String lookup = lookup(i);
        this.idMap.put(Integer.valueOf(i), lookup);
        return "'" + lookup + "'";
    }

    String lookup(int i) {
        try {
            if (i != -1) {
                return this.context.getResources().getResourceEntryName(i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unknown");
            int i2 = this.unknownCount + 1;
            this.unknownCount = i2;
            sb.append(i2);
            return sb.toString();
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unknown");
            int i3 = this.unknownCount + 1;
            this.unknownCount = i3;
            sb2.append(i3);
            return sb2.toString();
        }
    }

    void writeCircle(int i, float f, int i2) throws IOException {
        if (i == -1) {
            return;
        }
        this.writer.write("       circle");
        this.writer.write(":[");
        this.writer.write(getName(i));
        this.writer.write(", " + f);
        this.writer.write(i2 + "]");
    }

    void writeConstraint(String str, int i, String str2, int i2, int i3) throws IOException {
        if (i == -1) {
            return;
        }
        this.writer.write(SPACE + str);
        this.writer.write(":[");
        this.writer.write(getName(i));
        this.writer.write(" , ");
        this.writer.write(str2);
        if (i2 != 0) {
            this.writer.write(" , " + i2);
        }
        this.writer.write("],\n");
    }

    void writeLayout() throws IOException {
        this.writer.write("\n'ConstraintSet':{\n");
        for (Integer num : ConstraintSet.access$1300(this.this$0).keySet()) {
            ConstraintSet.Constraint constraint = (ConstraintSet.Constraint) ConstraintSet.access$1300(this.this$0).get(num);
            String name = getName(num.intValue());
            this.writer.write(name + ":{\n");
            ConstraintSet$Layout constraintSet$Layout = constraint.layout;
            writeDimension("height", constraintSet$Layout.mHeight, constraintSet$Layout.heightDefault, constraintSet$Layout.heightPercent, constraintSet$Layout.heightMin, constraintSet$Layout.heightMax, constraintSet$Layout.constrainedHeight);
            writeDimension("width", constraintSet$Layout.mWidth, constraintSet$Layout.widthDefault, constraintSet$Layout.widthPercent, constraintSet$Layout.widthMin, constraintSet$Layout.widthMax, constraintSet$Layout.constrainedWidth);
            writeConstraint("'left'", constraintSet$Layout.leftToLeft, "'left'", constraintSet$Layout.leftMargin, constraintSet$Layout.goneLeftMargin);
            writeConstraint("'left'", constraintSet$Layout.leftToRight, "'right'", constraintSet$Layout.leftMargin, constraintSet$Layout.goneLeftMargin);
            writeConstraint("'right'", constraintSet$Layout.rightToLeft, "'left'", constraintSet$Layout.rightMargin, constraintSet$Layout.goneRightMargin);
            writeConstraint("'right'", constraintSet$Layout.rightToRight, "'right'", constraintSet$Layout.rightMargin, constraintSet$Layout.goneRightMargin);
            writeConstraint("'baseline'", constraintSet$Layout.baselineToBaseline, "'baseline'", -1, constraintSet$Layout.goneBaselineMargin);
            writeConstraint("'baseline'", constraintSet$Layout.baselineToTop, "'top'", -1, constraintSet$Layout.goneBaselineMargin);
            writeConstraint("'baseline'", constraintSet$Layout.baselineToBottom, "'bottom'", -1, constraintSet$Layout.goneBaselineMargin);
            writeConstraint("'top'", constraintSet$Layout.topToBottom, "'bottom'", constraintSet$Layout.topMargin, constraintSet$Layout.goneTopMargin);
            writeConstraint("'top'", constraintSet$Layout.topToTop, "'top'", constraintSet$Layout.topMargin, constraintSet$Layout.goneTopMargin);
            writeConstraint("'bottom'", constraintSet$Layout.bottomToBottom, "'bottom'", constraintSet$Layout.bottomMargin, constraintSet$Layout.goneBottomMargin);
            writeConstraint("'bottom'", constraintSet$Layout.bottomToTop, "'top'", constraintSet$Layout.bottomMargin, constraintSet$Layout.goneBottomMargin);
            writeConstraint("'start'", constraintSet$Layout.startToStart, "'start'", constraintSet$Layout.startMargin, constraintSet$Layout.goneStartMargin);
            writeConstraint("'start'", constraintSet$Layout.startToEnd, "'end'", constraintSet$Layout.startMargin, constraintSet$Layout.goneStartMargin);
            writeConstraint("'end'", constraintSet$Layout.endToStart, "'start'", constraintSet$Layout.endMargin, constraintSet$Layout.goneEndMargin);
            writeConstraint("'end'", constraintSet$Layout.endToEnd, "'end'", constraintSet$Layout.endMargin, constraintSet$Layout.goneEndMargin);
            writeVariable("'horizontalBias'", constraintSet$Layout.horizontalBias, 0.5f);
            writeVariable("'verticalBias'", constraintSet$Layout.verticalBias, 0.5f);
            writeCircle(constraintSet$Layout.circleConstraint, constraintSet$Layout.circleAngle, constraintSet$Layout.circleRadius);
            writeGuideline(constraintSet$Layout.orientation, constraintSet$Layout.guideBegin, constraintSet$Layout.guideEnd, constraintSet$Layout.guidePercent);
            writeVariable("'dimensionRatio'", constraintSet$Layout.dimensionRatio);
            writeVariable("'barrierMargin'", constraintSet$Layout.mBarrierMargin);
            writeVariable("'type'", constraintSet$Layout.mHelperType);
            writeVariable("'ReferenceId'", constraintSet$Layout.mReferenceIdString);
            writeVariable("'mBarrierAllowsGoneWidgets'", constraintSet$Layout.mBarrierAllowsGoneWidgets, true);
            writeVariable("'WrapBehavior'", constraintSet$Layout.mWrapBehavior);
            writeVariable("'verticalWeight'", constraintSet$Layout.verticalWeight);
            writeVariable("'horizontalWeight'", constraintSet$Layout.horizontalWeight);
            writeVariable("'horizontalChainStyle'", constraintSet$Layout.horizontalChainStyle);
            writeVariable("'verticalChainStyle'", constraintSet$Layout.verticalChainStyle);
            writeVariable("'barrierDirection'", constraintSet$Layout.mBarrierDirection);
            int[] iArr = constraintSet$Layout.mReferenceIds;
            if (iArr != null) {
                writeVariable("'ReferenceIds'", iArr);
            }
            this.writer.write("}\n");
        }
        this.writer.write("}\n");
    }

    void writeVariable(String str, int i) throws IOException {
        if (i == 0 || i == -1) {
            return;
        }
        this.writer.write(SPACE + str);
        this.writer.write(":");
        this.writer.write(", " + i);
        this.writer.write("\n");
    }

    void writeVariable(String str, float f) throws IOException {
        if (f == -1.0f) {
            return;
        }
        this.writer.write(SPACE + str);
        this.writer.write(": " + f);
        this.writer.write(",\n");
    }

    void writeVariable(String str, float f, float f2) throws IOException {
        if (f == f2) {
            return;
        }
        this.writer.write(SPACE + str);
        this.writer.write(": " + f);
        this.writer.write(",\n");
    }

    void writeVariable(String str, boolean z) throws IOException {
        if (z) {
            this.writer.write(SPACE + str);
            this.writer.write(": " + z);
            this.writer.write(",\n");
        }
    }

    void writeVariable(String str, boolean z, boolean z2) throws IOException {
        if (z == z2) {
            return;
        }
        this.writer.write(SPACE + str);
        this.writer.write(": " + z);
        this.writer.write(",\n");
    }

    void writeVariable(String str, int[] iArr) throws IOException {
        if (iArr == null) {
            return;
        }
        this.writer.write(SPACE + str);
        this.writer.write(": ");
        int i = 0;
        while (i < iArr.length) {
            Writer writer = this.writer;
            StringBuilder sb = new StringBuilder();
            sb.append(i == 0 ? "[" : ", ");
            sb.append(getName(iArr[i]));
            writer.write(sb.toString());
            i++;
        }
        this.writer.write("],\n");
    }

    void writeVariable(String str, String str2) throws IOException {
        if (str2 == null) {
            return;
        }
        this.writer.write(SPACE + str);
        this.writer.write(":");
        this.writer.write(", " + str2);
        this.writer.write("\n");
    }
}
