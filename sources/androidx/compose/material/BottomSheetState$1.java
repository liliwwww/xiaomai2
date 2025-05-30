package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BottomSheetState$1 extends Lambda implements Function1<BottomSheetValue, Boolean> {
    public static final BottomSheetState$1 INSTANCE = new BottomSheetState$1();

    BottomSheetState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull BottomSheetValue bottomSheetValue) {
        Intrinsics.checkNotNullParameter(bottomSheetValue, "it");
        return Boolean.TRUE;
    }
}
