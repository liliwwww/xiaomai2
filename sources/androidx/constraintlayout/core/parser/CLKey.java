package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class CLKey extends CLContainer {
    private static ArrayList<String> sections;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        sections = arrayList;
        arrayList.add("ConstraintSets");
        sections.add("Variables");
        sections.add("Generate");
        sections.add("Transitions");
        sections.add("KeyFrames");
        sections.add(TypedValues.AttributesType.NAME);
        sections.add("KeyPositions");
        sections.add("KeyCycles");
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLKey(cArr);
    }

    public String getName() {
        return content();
    }

    public CLElement getValue() {
        if (((CLContainer) this).mElements.size() > 0) {
            return (CLElement) ((CLContainer) this).mElements.get(0);
        }
        return null;
    }

    public void set(CLElement cLElement) {
        if (((CLContainer) this).mElements.size() > 0) {
            ((CLContainer) this).mElements.set(0, cLElement);
        } else {
            ((CLContainer) this).mElements.add(cLElement);
        }
    }

    protected String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder(getDebugName());
        addIndent(sb, i);
        String content = content();
        if (((CLContainer) this).mElements.size() <= 0) {
            return content + ": <> ";
        }
        sb.append(content);
        sb.append(": ");
        if (sections.contains(content)) {
            i2 = 3;
        }
        if (i2 > 0) {
            sb.append(((CLElement) ((CLContainer) this).mElements.get(0)).toFormattedJSON(i, i2 - 1));
        } else {
            String json = ((CLElement) ((CLContainer) this).mElements.get(0)).toJSON();
            if (json.length() + i < CLElement.MAX_LINE) {
                sb.append(json);
            } else {
                sb.append(((CLElement) ((CLContainer) this).mElements.get(0)).toFormattedJSON(i, i2 - 1));
            }
        }
        return sb.toString();
    }

    protected String toJSON() {
        if (((CLContainer) this).mElements.size() <= 0) {
            return getDebugName() + content() + ": <> ";
        }
        return getDebugName() + content() + ": " + ((CLElement) ((CLContainer) this).mElements.get(0)).toJSON();
    }

    public static CLElement allocate(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.setStart(0L);
        cLKey.setEnd(str.length() - 1);
        cLKey.set(cLElement);
        return cLKey;
    }
}
