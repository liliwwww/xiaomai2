package androidx.compose.ui.text.android;

import android.text.TextPaint;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LayoutIntrinsics$minIntrinsicWidth$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ CharSequence $charSequence;
    final /* synthetic */ TextPaint $textPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutIntrinsics$minIntrinsicWidth$2(CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.$charSequence = charSequence;
        this.$textPaint = textPaint;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Float m2355invoke() {
        return Float.valueOf(LayoutIntrinsicsKt.minIntrinsicWidth(this.$charSequence, this.$textPaint));
    }
}
