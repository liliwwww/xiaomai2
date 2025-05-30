package androidx.compose.ui.text.font;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FontFamilyResolverImpl$preload$2 extends Lambda implements Function1<TypefaceRequest, TypefaceResult> {
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontFamilyResolverImpl$preload$2(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
    }

    @NotNull
    public final TypefaceResult invoke(@NotNull TypefaceRequest typefaceRequest) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "typeRequest");
        TypefaceResult resolve = FontFamilyResolverImpl.access$getFontListFontFamilyTypefaceAdapter$p(this.this$0).resolve(typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), 1.INSTANCE, FontFamilyResolverImpl.access$getCreateDefaultTypeface$p(this.this$0));
        if (resolve == null && (resolve = FontFamilyResolverImpl.access$getPlatformFamilyTypefaceAdapter$p(this.this$0).resolve(typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), 2.INSTANCE, FontFamilyResolverImpl.access$getCreateDefaultTypeface$p(this.this$0))) == null) {
            throw new IllegalStateException("Could not load font");
        }
        return resolve;
    }
}
