package androidx.compose.ui.text.font;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FontFamilyResolverImpl$createDefaultTypeface$1 extends Lambda implements Function1<TypefaceRequest, Object> {
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontFamilyResolverImpl$createDefaultTypeface$1(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
    }

    @NotNull
    public final Object invoke(@NotNull TypefaceRequest typefaceRequest) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "it");
        return FontFamilyResolverImpl.access$resolve(this.this$0, TypefaceRequest.m1936copye1PVR60$default(typefaceRequest, null, null, 0, 0, null, 30, null)).getValue();
    }
}
