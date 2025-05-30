package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLString;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ6\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0001J\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00142\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u0014R2\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0017j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR2\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u0017j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aRR\u0010\u001d\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u00140\u0017j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u0014`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001a¨\u0006 "}, d2 = {"Landroidx/constraintlayout/compose/LayoutVariables;", "", "", "elementName", "", "element", "", "put", "", "start", "incrementBy", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "step", "prefix", "postfix", "value", "putOverride", "get", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getList", "elements", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "margins", "Ljava/util/HashMap;", "Landroidx/constraintlayout/compose/GeneratedValue;", "generators", "arrayIds", "<init>", "()V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LayoutVariables {

    @NotNull
    private final HashMap<String, Integer> margins = new HashMap<>();

    @NotNull
    private final HashMap<String, GeneratedValue> generators = new HashMap<>();

    @NotNull
    private final HashMap<String, ArrayList<String>> arrayIds = new HashMap<>();

    public final float get(@NotNull Object elementName) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        if (!(elementName instanceof CLString)) {
            if (elementName instanceof CLNumber) {
                return ((CLNumber) elementName).getFloat();
            }
            return 0.0f;
        }
        String content = ((CLString) elementName).content();
        if (this.generators.containsKey(content)) {
            GeneratedValue generatedValue = this.generators.get(content);
            Intrinsics.checkNotNull(generatedValue);
            return generatedValue.getValue();
        }
        if (!this.margins.containsKey(content)) {
            return 0.0f;
        }
        Intrinsics.checkNotNull(this.margins.get(content));
        return r2.intValue();
    }

    @Nullable
    public final ArrayList<String> getList(@NotNull String elementName) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        if (this.arrayIds.containsKey(elementName)) {
            return this.arrayIds.get(elementName);
        }
        return null;
    }

    public final void put(@NotNull String elementName, int element) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        this.margins.put(elementName, Integer.valueOf(element));
    }

    public final void putOverride(@NotNull String elementName, float value) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        this.generators.put(elementName, new OverrideValue(value));
    }

    public final void put(@NotNull String elementName, float start, float incrementBy) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        if (this.generators.containsKey(elementName) && (this.generators.get(elementName) instanceof OverrideValue)) {
            return;
        }
        this.generators.put(elementName, new Generator(start, incrementBy));
    }

    public final void put(@NotNull String elementName, float from, float to, float step, @NotNull String prefix, @NotNull String postfix) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        if (this.generators.containsKey(elementName) && (this.generators.get(elementName) instanceof OverrideValue)) {
            return;
        }
        FiniteGenerator finiteGenerator = new FiniteGenerator(from, to, step, prefix, postfix);
        this.generators.put(elementName, finiteGenerator);
        this.arrayIds.put(elementName, finiteGenerator.array());
    }

    public final void put(@NotNull String elementName, @NotNull ArrayList<String> elements) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.arrayIds.put(elementName, elements);
    }
}
