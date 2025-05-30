package androidx.compose.p004ui.text.font;

import android.graphics.Typeface;
import androidx.compose.p004ui.text.font.TypefaceResult;
import androidx.compose.p004ui.text.platform.AndroidTypeface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PlatformFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {

    @NotNull
    private final PlatformTypefaces platformTypefaceResolver = PlatformTypefacesKt.PlatformTypefaces();

    @Override // androidx.compose.p004ui.text.font.FontFamilyTypefaceAdapter
    @Nullable
    public TypefaceResult resolve(@NotNull TypefaceRequest typefaceRequest, @NotNull PlatformFontLoader platformFontLoader, @NotNull Function1<? super TypefaceResult.Immutable, Unit> function1, @NotNull Function1<? super TypefaceRequest, ? extends Object> function12) {
        Typeface mo4961getNativeTypefacePYhJU0U;
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Intrinsics.checkNotNullParameter(function1, "onAsyncCompletion");
        Intrinsics.checkNotNullParameter(function12, "createDefaultTypeface");
        FontFamily fontFamily = typefaceRequest.getFontFamily();
        if (fontFamily == null ? true : fontFamily instanceof DefaultFontFamily) {
            mo4961getNativeTypefacePYhJU0U = this.platformTypefaceResolver.mo4857createDefaultFO1MlWM(typefaceRequest.getFontWeight(), typefaceRequest.m4875getFontStyle_LCdwA());
        } else if (fontFamily instanceof GenericFontFamily) {
            mo4961getNativeTypefacePYhJU0U = this.platformTypefaceResolver.mo4858createNamedRetOiIg((GenericFontFamily) typefaceRequest.getFontFamily(), typefaceRequest.getFontWeight(), typefaceRequest.m4875getFontStyle_LCdwA());
        } else {
            if (!(fontFamily instanceof LoadedFontFamily)) {
                return null;
            }
            Typeface typeface = ((LoadedFontFamily) typefaceRequest.getFontFamily()).getTypeface();
            Intrinsics.checkNotNull(typeface, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            mo4961getNativeTypefacePYhJU0U = ((AndroidTypeface) typeface).mo4961getNativeTypefacePYhJU0U(typefaceRequest.getFontWeight(), typefaceRequest.m4875getFontStyle_LCdwA(), typefaceRequest.m4876getFontSynthesisGVVA2EU());
        }
        return new TypefaceResult.Immutable(mo4961getNativeTypefacePYhJU0U, false, 2, null);
    }
}
