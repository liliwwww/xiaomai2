package androidx.compose.foundation;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ClickableKt$genericClickableWithoutGesture$clickSemantics$1$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Function0<Unit> $onLongClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$genericClickableWithoutGesture$clickSemantics$1$2(Function0<Unit> function0) {
        super(0);
        this.$onLongClick = function0;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m149invoke() {
        this.$onLongClick.invoke();
        return Boolean.TRUE;
    }
}
