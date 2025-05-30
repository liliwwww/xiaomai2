package androidx.compose.foundation;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ClickableKt$genericClickableWithoutGesture$clickSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Function0<Unit> $onLongClick;
    final /* synthetic */ String $onLongClickLabel;
    final /* synthetic */ Role $role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$genericClickableWithoutGesture$clickSemantics$1(Role role, String str, Function0<Unit> function0, String str2, boolean z, Function0<Unit> function02) {
        super(1);
        this.$role = role;
        this.$onClickLabel = str;
        this.$onLongClick = function0;
        this.$onLongClickLabel = str2;
        this.$enabled = z;
        this.$onClick = function02;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        Role role = this.$role;
        if (role != null) {
            SemanticsPropertiesKt.m1822setRolekuIjeqM(semanticsPropertyReceiver, role.m1812unboximpl());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.$onClickLabel, new 1(this.$onClick));
        Function0<Unit> function0 = this.$onLongClick;
        if (function0 != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.$onLongClickLabel, new 2(function0));
        }
        if (this.$enabled) {
            return;
        }
        SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
    }
}
