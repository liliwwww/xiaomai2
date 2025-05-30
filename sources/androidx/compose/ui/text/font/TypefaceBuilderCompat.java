package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(api = 26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TypefaceBuilderCompat {

    @NotNull
    public static final TypefaceBuilderCompat INSTANCE = new TypefaceBuilderCompat();

    private TypefaceBuilderCompat() {
    }

    @ExperimentalTextApi
    @RequiresApi(26)
    private final FontVariationAxis[] toVariationSettings(FontVariation.Settings settings, Context context) {
        Density Density;
        if (context != null) {
            Density = AndroidDensity_androidKt.Density(context);
        } else {
            if (settings.getNeedsDensity$ui_text_release()) {
                throw new IllegalStateException("Required density, but not provided");
            }
            Density = DensityKt.Density(1.0f, 1.0f);
        }
        List settings2 = settings.getSettings();
        ArrayList arrayList = new ArrayList(settings2.size());
        int size = settings2.size();
        for (int i = 0; i < size; i++) {
            FontVariation.Setting setting = (FontVariation.Setting) settings2.get(i);
            arrayList.add(new FontVariationAxis(setting.getAxisName(), setting.toVariationValue(Density)));
        }
        return (FontVariationAxis[]) arrayList.toArray(new FontVariationAxis[0]);
    }

    @ExperimentalTextApi
    @DoNotInline
    @Nullable
    public final android.graphics.Typeface createFromAssets(@NotNull AssetManager assetManager, @NotNull String str, @Nullable Context context, @NotNull FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        if (context == null) {
            return null;
        }
        return new Typeface.Builder(assetManager, str).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    @ExperimentalTextApi
    @DoNotInline
    @Nullable
    public final android.graphics.Typeface createFromFile(@NotNull File file, @Nullable Context context, @NotNull FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        if (context == null) {
            return null;
        }
        return new Typeface.Builder(file).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    @ExperimentalTextApi
    @DoNotInline
    @Nullable
    public final android.graphics.Typeface createFromFileDescriptor(@NotNull ParcelFileDescriptor parcelFileDescriptor, @Nullable Context context, @NotNull FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "fileDescriptor");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        if (context == null) {
            return null;
        }
        return new Typeface.Builder(parcelFileDescriptor.getFileDescriptor()).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }
}
