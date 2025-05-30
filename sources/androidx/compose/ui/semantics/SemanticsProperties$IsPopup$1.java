package androidx.compose.ui.semantics;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SemanticsProperties$IsPopup$1 extends Lambda implements Function2<Unit, Unit, Unit> {
    public static final SemanticsProperties$IsPopup$1 INSTANCE = new SemanticsProperties$IsPopup$1();

    SemanticsProperties$IsPopup$1() {
        super(2);
    }

    @Nullable
    public final Unit invoke(@Nullable Unit unit, @NotNull Unit unit2) {
        Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
        throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
    }
}
