package androidx.compose.ui.tooling.data;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@UiToolingDataApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class EmptyGroup extends Group {

    @NotNull
    public static final EmptyGroup INSTANCE = new EmptyGroup();

    private EmptyGroup() {
        super((Object) null, (String) null, (SourceLocation) null, (Object) null, SlotTreeKt.getEmptyBox(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), (DefaultConstructorMarker) null);
    }
}
