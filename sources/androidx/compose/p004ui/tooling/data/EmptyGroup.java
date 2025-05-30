package androidx.compose.p004ui.tooling.data;

import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@UiToolingDataApi
/* loaded from: classes2.dex */
final class EmptyGroup extends Group {

    @NotNull
    public static final EmptyGroup INSTANCE = new EmptyGroup();

    private EmptyGroup() {
        super(null, null, null, null, SlotTreeKt.getEmptyBox(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null);
    }
}
