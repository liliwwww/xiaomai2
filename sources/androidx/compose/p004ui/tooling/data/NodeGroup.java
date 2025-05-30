package androidx.compose.p004ui.tooling.data;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.p004ui.layout.ModifierInfo;
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
/* loaded from: classes.dex */
public final class NodeGroup extends Group {
    public static final int $stable = 8;

    @NotNull
    private final List<ModifierInfo> modifierInfo;

    @NotNull
    private final Object node;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NodeGroup(@Nullable Object obj, @NotNull Object obj2, @NotNull IntRect intRect, @NotNull Collection<? extends Object> collection, @NotNull List<ModifierInfo> list, @NotNull Collection<? extends Group> collection2) {
        super(obj, null, null, null, intRect, collection, collection2, null);
        Intrinsics.checkNotNullParameter(obj2, "node");
        Intrinsics.checkNotNullParameter(intRect, "box");
        Intrinsics.checkNotNullParameter(collection, ApiConstants.DATA);
        Intrinsics.checkNotNullParameter(list, "modifierInfo");
        Intrinsics.checkNotNullParameter(collection2, "children");
        this.node = obj2;
        this.modifierInfo = list;
    }

    @Override // androidx.compose.p004ui.tooling.data.Group
    @NotNull
    public List<ModifierInfo> getModifierInfo() {
        return this.modifierInfo;
    }

    @NotNull
    public final Object getNode() {
        return this.node;
    }
}
