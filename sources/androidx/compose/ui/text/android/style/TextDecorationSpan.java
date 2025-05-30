package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextDecorationSpan extends CharacterStyle {
    public static final int $stable = 0;
    private final boolean isStrikethroughText;
    private final boolean isUnderlineText;

    public TextDecorationSpan(boolean z, boolean z2) {
        this.isUnderlineText = z;
        this.isStrikethroughText = z2;
    }

    public final boolean isStrikethroughText() {
        return this.isStrikethroughText;
    }

    public final boolean isUnderlineText() {
        return this.isUnderlineText;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setUnderlineText(this.isUnderlineText);
        textPaint.setStrikeThruText(this.isStrikethroughText);
    }
}
