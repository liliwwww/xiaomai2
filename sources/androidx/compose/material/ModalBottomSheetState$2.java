package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ModalBottomSheetState$2 extends Lambda implements Function1<ModalBottomSheetValue, Boolean> {
    public static final ModalBottomSheetState$2 INSTANCE = new ModalBottomSheetState$2();

    ModalBottomSheetState$2() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull ModalBottomSheetValue modalBottomSheetValue) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "it");
        return Boolean.TRUE;
    }
}
