package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class HapticFeedbackType$Companion {
    private HapticFeedbackType$Companion() {
    }

    public /* synthetic */ HapticFeedbackType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: getLongPress-5zf0vsI, reason: not valid java name */
    public final int m1349getLongPress5zf0vsI() {
        return PlatformHapticFeedbackType.INSTANCE.getLongPress-5zf0vsI();
    }

    /* renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
    public final int m1350getTextHandleMove5zf0vsI() {
        return PlatformHapticFeedbackType.INSTANCE.getTextHandleMove-5zf0vsI();
    }

    @NotNull
    public final List<HapticFeedbackType> values() {
        return CollectionsKt.listOf(new HapticFeedbackType[]{HapticFeedbackType.box-impl(m1349getLongPress5zf0vsI()), HapticFeedbackType.box-impl(m1350getTextHandleMove5zf0vsI())});
    }
}
