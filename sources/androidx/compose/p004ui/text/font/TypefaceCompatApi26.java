package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
import androidx.compose.p004ui.text.ExperimentalTextApi;
import androidx.compose.p004ui.text.TempListUtilsKt;
import androidx.compose.p004ui.text.font.FontVariation;
import androidx.compose.p004ui.unit.AndroidDensity_androidKt;
import androidx.compose.p004ui.unit.Density;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: classes.dex */
final class TypefaceCompatApi26 {

    @NotNull
    public static final TypefaceCompatApi26 INSTANCE = new TypefaceCompatApi26();

    @NotNull
    private static ThreadLocal<Paint> threadLocalPaint = new ThreadLocal<>();

    private TypefaceCompatApi26() {
    }

    @ExperimentalTextApi
    private final String toAndroidString(FontVariation.Settings settings, Context context) {
        final Density Density = AndroidDensity_androidKt.Density(context);
        return TempListUtilsKt.fastJoinToString$default(settings.getSettings(), null, null, null, 0, null, new Function1<FontVariation.Setting, CharSequence>() { // from class: androidx.compose.ui.text.font.TypefaceCompatApi26$toAndroidString$1
            {
                super(1);
            }

            @NotNull
            public final CharSequence invoke(@NotNull FontVariation.Setting setting) {
                Intrinsics.checkNotNullParameter(setting, "setting");
                return '\'' + setting.getAxisName() + "' " + setting.toVariationValue(Density.this);
            }
        }, 31, null);
    }

    @ExperimentalTextApi
    @Nullable
    public final Typeface setFontVariationSettings(@Nullable Typeface typeface, @NotNull FontVariation.Settings settings, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (typeface == null) {
            return null;
        }
        if (settings.getSettings().isEmpty()) {
            return typeface;
        }
        Paint paint = threadLocalPaint.get();
        if (paint == null) {
            paint = new Paint();
            threadLocalPaint.set(paint);
        }
        paint.setTypeface(typeface);
        paint.setFontVariationSettings(toAndroidString(settings, context));
        return paint.getTypeface();
    }
}
