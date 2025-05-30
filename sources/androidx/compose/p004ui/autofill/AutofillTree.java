package androidx.compose.p004ui.autofill;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public final class AutofillTree {
    public static final int $stable = 8;

    @NotNull
    private final Map<Integer, AutofillNode> children = new LinkedHashMap();

    @NotNull
    public final Map<Integer, AutofillNode> getChildren() {
        return this.children;
    }

    @Nullable
    public final Unit performAutofill(int i, @NotNull String str) {
        Function1<String, Unit> onFill;
        Intrinsics.checkNotNullParameter(str, "value");
        AutofillNode autofillNode = this.children.get(Integer.valueOf(i));
        if (autofillNode == null || (onFill = autofillNode.getOnFill()) == null) {
            return null;
        }
        onFill.invoke(str);
        return Unit.INSTANCE;
    }

    public final void plusAssign(@NotNull AutofillNode autofillNode) {
        Intrinsics.checkNotNullParameter(autofillNode, "autofillNode");
        this.children.put(Integer.valueOf(autofillNode.getId()), autofillNode);
    }
}
