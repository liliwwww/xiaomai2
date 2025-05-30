package androidx.compose.ui.text.font;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FontListFontFamilyTypefaceAdapter$preload$2$1 extends Lambda implements Function1<TypefaceRequest, Unit> {
    public static final FontListFontFamilyTypefaceAdapter$preload$2$1 INSTANCE = new FontListFontFamilyTypefaceAdapter$preload$2$1();

    FontListFontFamilyTypefaceAdapter$preload$2$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypefaceRequest) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TypefaceRequest typefaceRequest) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "it");
    }
}
