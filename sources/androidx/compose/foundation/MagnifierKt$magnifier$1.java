package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MagnifierKt$magnifier$1 extends Lambda implements Function1<Density, Offset> {
    public static final MagnifierKt$magnifier$1 INSTANCE = new MagnifierKt$magnifier$1();

    MagnifierKt$magnifier$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m837boximpl(m132invoketuRUvjQ((Density) obj));
    }

    /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
    public final long m132invoketuRUvjQ(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$null");
        return Offset.Companion.getUnspecified-F1C5BW0();
    }
}
