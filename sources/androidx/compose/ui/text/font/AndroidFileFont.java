package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidFileFont extends AndroidPreloadedFont {

    @Nullable
    private final String cacheKey;

    @NotNull
    private final File file;

    public /* synthetic */ AndroidFileFont(File file, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i2 & 4) != 0 ? FontStyle.Companion.getNormal-_-LCdwA() : i, fontVariation$Settings, null);
    }

    public /* synthetic */ AndroidFileFont(File file, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, fontWeight, i, fontVariation$Settings);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public Typeface doLoad$ui_text_release(@Nullable Context context) {
        return Build.VERSION.SDK_INT >= 26 ? TypefaceBuilderCompat.INSTANCE.createFromFile(this.file, context, getVariationSettings()) : Typeface.createFromFile(this.file);
    }

    @Nullable
    public String getCacheKey() {
        return this.cacheKey;
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public String toString() {
        return "Font(file=" + this.file + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m1929toStringimpl(getStyle-_-LCdwA())) + ')';
    }

    private AndroidFileFont(File file, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings) {
        super(fontWeight, i, fontVariation$Settings, (DefaultConstructorMarker) null);
        this.file = file;
        setTypeface$ui_text_release(doLoad$ui_text_release(null));
    }
}
