package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FocusPropertiesImpl$exit$1 extends Lambda implements Function1<FocusDirection, FocusRequester> {
    public static final FocusPropertiesImpl$exit$1 INSTANCE = new FocusPropertiesImpl$exit$1();

    FocusPropertiesImpl$exit$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m828invoke3ESFkO8(((FocusDirection) obj).unbox-impl());
    }

    @NotNull
    /* renamed from: invoke-3ESFkO8, reason: not valid java name */
    public final FocusRequester m828invoke3ESFkO8(int i) {
        return FocusRequester.Companion.getDefault();
    }
}
