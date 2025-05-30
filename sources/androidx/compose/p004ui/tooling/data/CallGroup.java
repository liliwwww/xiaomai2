package androidx.compose.p004ui.tooling.data;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.p004ui.unit.IntRect;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@UiToolingDataApi
/* loaded from: classes2.dex */
public final class CallGroup extends Group {
    public static final int $stable = 8;

    @NotNull
    private final List<ParameterInformation> parameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallGroup(@Nullable Object obj, @Nullable String str, @NotNull IntRect intRect, @Nullable SourceLocation sourceLocation, @Nullable Object obj2, @NotNull List<ParameterInformation> list, @NotNull Collection<? extends Object> collection, @NotNull Collection<? extends Group> collection2) {
        super(obj, str, sourceLocation, obj2, intRect, collection, collection2, null);
        Intrinsics.checkNotNullParameter(intRect, "box");
        Intrinsics.checkNotNullParameter(list, "parameters");
        Intrinsics.checkNotNullParameter(collection, ApiConstants.DATA);
        Intrinsics.checkNotNullParameter(collection2, "children");
        this.parameters = list;
    }

    @Override // androidx.compose.p004ui.tooling.data.Group
    @NotNull
    public List<ParameterInformation> getParameters() {
        return this.parameters;
    }
}
