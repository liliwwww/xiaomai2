package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class InspectorValueInfo implements InspectableValue {
    public static final int $stable = 8;

    @Nullable
    private InspectorInfo _values;

    @NotNull
    private final Function1<InspectorInfo, Unit> info;

    /* JADX WARN: Multi-variable type inference failed */
    public InspectorValueInfo(@NotNull Function1<? super InspectorInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "info");
        this.info = function1;
    }

    private final InspectorInfo getValues() {
        InspectorInfo inspectorInfo = this._values;
        if (inspectorInfo == null) {
            inspectorInfo = new InspectorInfo();
            this.info.invoke(inspectorInfo);
        }
        this._values = inspectorInfo;
        return inspectorInfo;
    }

    @NotNull
    public Sequence<ValueElement> getInspectableElements() {
        return getValues().getProperties();
    }

    @Nullable
    public String getNameFallback() {
        return getValues().getName();
    }

    @Nullable
    public Object getValueOverride() {
        return getValues().getValue();
    }
}
