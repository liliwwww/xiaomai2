package androidx.compose.ui.text.font;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FontFamilyResolverImpl$resolve$result$1 extends Lambda implements Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult> {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontFamilyResolverImpl$resolve$result$1(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
        this.$typefaceRequest = typefaceRequest;
    }

    @NotNull
    public final TypefaceResult invoke(@NotNull Function1<? super TypefaceResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onAsyncCompletion");
        TypefaceResult resolve = FontFamilyResolverImpl.access$getFontListFontFamilyTypefaceAdapter$p(this.this$0).resolve(this.$typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), function1, FontFamilyResolverImpl.access$getCreateDefaultTypeface$p(this.this$0));
        if (resolve == null && (resolve = FontFamilyResolverImpl.access$getPlatformFamilyTypefaceAdapter$p(this.this$0).resolve(this.$typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), function1, FontFamilyResolverImpl.access$getCreateDefaultTypeface$p(this.this$0))) == null) {
            throw new IllegalStateException("Could not load font");
        }
        return resolve;
    }
}
