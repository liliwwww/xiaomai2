package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.AndroidTypeface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PlatformFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {

    @NotNull
    private final PlatformTypefaces platformTypefaceResolver = PlatformTypefacesKt.PlatformTypefaces();

    @Override // androidx.compose.ui.text.font.FontFamilyTypefaceAdapter
    @Nullable
    public TypefaceResult resolve(@NotNull TypefaceRequest typefaceRequest, @NotNull PlatformFontLoader platformFontLoader, @NotNull Function1<? super TypefaceResult$Immutable, Unit> function1, @NotNull Function1<? super TypefaceRequest, ? extends Object> function12) {
        android.graphics.Typeface typeface;
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Intrinsics.checkNotNullParameter(function1, "onAsyncCompletion");
        Intrinsics.checkNotNullParameter(function12, "createDefaultTypeface");
        FontFamily fontFamily = typefaceRequest.getFontFamily();
        if (fontFamily == null ? true : fontFamily instanceof DefaultFontFamily) {
            typeface = this.platformTypefaceResolver.createDefault-FO1MlWM(typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle-_-LCdwA());
        } else if (fontFamily instanceof GenericFontFamily) {
            typeface = this.platformTypefaceResolver.createNamed-RetOiIg(typefaceRequest.getFontFamily(), typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle-_-LCdwA());
        } else {
            if (!(fontFamily instanceof LoadedFontFamily)) {
                return null;
            }
            AndroidTypeface typeface2 = ((LoadedFontFamily) typefaceRequest.getFontFamily()).getTypeface();
            Intrinsics.checkNotNull(typeface2, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            typeface = typeface2.getNativeTypeface-PYhJU0U(typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle-_-LCdwA(), typefaceRequest.getFontSynthesis-GVVA2EU());
        }
        return new TypefaceResult$Immutable(typeface, false, 2, null);
    }
}
