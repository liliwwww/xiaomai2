package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.TempListUtilsKt;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TypefaceCompatApi26 {

    @NotNull
    public static final TypefaceCompatApi26 INSTANCE = new TypefaceCompatApi26();

    @NotNull
    private static ThreadLocal<Paint> threadLocalPaint = new ThreadLocal<>();

    private TypefaceCompatApi26() {
    }

    @ExperimentalTextApi
    private final String toAndroidString(FontVariation$Settings fontVariation$Settings, Context context) {
        return TempListUtilsKt.fastJoinToString$default(fontVariation$Settings.getSettings(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new toAndroidString.1(AndroidDensity_androidKt.Density(context)), 31, (Object) null);
    }

    @ExperimentalTextApi
    @Nullable
    public final Typeface setFontVariationSettings(@Nullable Typeface typeface, @NotNull FontVariation$Settings fontVariation$Settings, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(fontVariation$Settings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (typeface == null) {
            return null;
        }
        if (fontVariation$Settings.getSettings().isEmpty()) {
            return typeface;
        }
        Paint paint = threadLocalPaint.get();
        if (paint == null) {
            paint = new Paint();
            threadLocalPaint.set(paint);
        }
        paint.setTypeface(typeface);
        paint.setFontVariationSettings(toAndroidString(fontVariation$Settings, context));
        return paint.getTypeface();
    }
}
