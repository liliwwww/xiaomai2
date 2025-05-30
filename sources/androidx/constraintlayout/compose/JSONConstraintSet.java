package androidx.constraintlayout.compose;

import androidx.compose.p004ui.layout.Measurable;
import androidx.constraintlayout.compose.DerivedConstraintSet;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010!¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0014\u0010\u0017\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001fH\u0016R\u001e\u0010#\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001f0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Landroidx/constraintlayout/compose/JSONConstraintSet;", "Landroidx/constraintlayout/compose/EditableJSONLayout;", "Landroidx/constraintlayout/compose/DerivedConstraintSet;", "Landroidx/constraintlayout/compose/LayoutVariables;", "layoutVariables", "", "applyLayoutVariables", "", "other", "", "equals", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "isDirty", "Landroidx/constraintlayout/core/state/Transition;", "transition", "", "type", "applyTo", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/compose/DesignElement;", "designElements", "emitDesignElements", "Landroidx/constraintlayout/compose/State;", "state", "applyToState", "", "content", "onNewContent", "name", "", "value", "Landroidx/constraintlayout/compose/ConstraintSet;", "override", "extendFrom", "Landroidx/constraintlayout/compose/ConstraintSet;", "getExtendFrom", "()Landroidx/constraintlayout/compose/ConstraintSet;", "Ljava/util/HashMap;", "overridedVariables", "Ljava/util/HashMap;", "overrideVariables", "Ljava/lang/String;", "_isDirty", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/constraintlayout/compose/ConstraintSet;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class JSONConstraintSet extends EditableJSONLayout implements DerivedConstraintSet {
    private boolean _isDirty;

    @Nullable
    private final ConstraintSet extendFrom;

    @Nullable
    private final String overrideVariables;

    @NotNull
    private final HashMap<String, Float> overridedVariables;

    public /* synthetic */ JSONConstraintSet(String str, String str2, ConstraintSet constraintSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : constraintSet);
    }

    private final void applyLayoutVariables(LayoutVariables layoutVariables) {
        String str = this.overrideVariables;
        if (str != null) {
            try {
                CLObject parse = CLParser.parse(str);
                int i = 0;
                int size = parse.size();
                if (size > 0) {
                    while (true) {
                        int i2 = i + 1;
                        CLElement cLElement = parse.get(i);
                        if (cLElement == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLKey");
                        }
                        CLKey cLKey = (CLKey) cLElement;
                        float f = cLKey.getValue().getFloat();
                        String content = cLKey.content();
                        Intrinsics.checkNotNullExpressionValue(content, "key.content()");
                        layoutVariables.putOverride(content, f);
                        if (i2 >= size) {
                            break;
                        } else {
                            i = i2;
                        }
                    }
                }
            } catch (CLParsingException e) {
                System.err.println(Intrinsics.stringPlus("exception: ", e));
            }
        }
        for (String str2 : this.overridedVariables.keySet()) {
            Intrinsics.checkNotNullExpressionValue(str2, "name");
            Float f2 = this.overridedVariables.get(str2);
            Intrinsics.checkNotNull(f2);
            layoutVariables.putOverride(str2, f2.floatValue());
        }
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet, androidx.constraintlayout.compose.ConstraintSet
    public void applyTo(@NotNull State state, @NotNull List<? extends Measurable> list) {
        DerivedConstraintSet.DefaultImpls.applyTo(this, state, list);
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet
    public void applyToState(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        LayoutVariables layoutVariables = new LayoutVariables();
        applyLayoutVariables(layoutVariables);
        try {
            ConstraintSetParserKt.parseJSON(getCurrentContent(), state, layoutVariables);
            this._isDirty = false;
        } catch (Exception unused) {
            this._isDirty = true;
        }
    }

    public final void emitDesignElements(@NotNull ArrayList<DesignElement> designElements) {
        Intrinsics.checkNotNullParameter(designElements, "designElements");
        try {
            designElements.clear();
            ConstraintSetParserKt.parseDesignElementsJSON(getCurrentContent(), designElements);
        } catch (Exception unused) {
        }
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof JSONConstraintSet) {
            return Intrinsics.areEqual(getCurrentContent(), ((JSONConstraintSet) other).getCurrentContent());
        }
        return false;
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet
    @Nullable
    public ConstraintSet getExtendFrom() {
        return this.extendFrom;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public boolean isDirty(@NotNull List<? extends Measurable> measurables) {
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return this._isDirty;
    }

    @Override // androidx.constraintlayout.compose.EditableJSONLayout
    protected void onNewContent(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        super.onNewContent(content);
        this._isDirty = true;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    @NotNull
    public ConstraintSet override(@NotNull String name, float value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.overridedVariables.put(name, Float.valueOf(value));
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSONConstraintSet(@Language("json5") @NotNull String str, @Language("json5") @Nullable String str2, @Nullable ConstraintSet constraintSet) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "content");
        this.extendFrom = constraintSet;
        this.overridedVariables = new HashMap<>();
        this.overrideVariables = str2;
        this._isDirty = true;
        initialization();
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void applyTo(@NotNull androidx.constraintlayout.core.state.Transition transition, int type) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        applyLayoutVariables(new LayoutVariables());
        ConstraintSetParserKt.parseJSON(getCurrentContent(), transition, type);
    }
}
