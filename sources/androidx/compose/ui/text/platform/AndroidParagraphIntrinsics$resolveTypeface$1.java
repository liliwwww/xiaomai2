package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidParagraphIntrinsics$resolveTypeface$1 extends Lambda implements Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> {
    final /* synthetic */ AndroidParagraphIntrinsics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidParagraphIntrinsics$resolveTypeface$1(AndroidParagraphIntrinsics androidParagraphIntrinsics) {
        super(4);
        this.this$0 = androidParagraphIntrinsics;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return m2463invokeDPcqOEQ((FontFamily) obj, (FontWeight) obj2, ((FontStyle) obj3).unbox-impl(), ((FontSynthesis) obj4).m2393unboximpl());
    }

    @NotNull
    /* renamed from: invoke-DPcqOEQ, reason: not valid java name */
    public final Typeface m2463invokeDPcqOEQ(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        TypefaceDirtyTracker typefaceDirtyTracker = new TypefaceDirtyTracker(this.this$0.getFontFamilyResolver().resolve-DPcqOEQ(fontFamily, fontWeight, i, i2));
        AndroidParagraphIntrinsics.access$getResolvedTypefaces$p(this.this$0).add(typefaceDirtyTracker);
        return typefaceDirtyTracker.getTypeface();
    }
}
