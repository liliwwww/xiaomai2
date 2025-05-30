package androidx.compose.ui.text.font;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FontFamilyResolverImpl$preload$2$1 extends Lambda implements Function1<TypefaceResult$Immutable, Unit> {
    public static final FontFamilyResolverImpl$preload$2$1 INSTANCE = new FontFamilyResolverImpl$preload$2$1();

    FontFamilyResolverImpl$preload$2$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypefaceResult$Immutable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TypefaceResult$Immutable typefaceResult$Immutable) {
        Intrinsics.checkNotNullParameter(typefaceResult$Immutable, "it");
    }
}
