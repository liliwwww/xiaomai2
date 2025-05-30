package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.p004ui.text.font.FontVariation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AndroidAssetFont extends AndroidPreloadedFont {

    @NotNull
    private final AssetManager assetManager;

    @NotNull
    private final String cacheKey;

    @NotNull
    private final String path;

    public /* synthetic */ AndroidAssetFont(AssetManager assetManager, String str, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetManager, str, (i2 & 4) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i2 & 8) != 0 ? FontStyle.Companion.m4839getNormal_LCdwA() : i, settings, null);
    }

    public /* synthetic */ AndroidAssetFont(AssetManager assetManager, String str, FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetManager, str, fontWeight, i, settings);
    }

    @Override // androidx.compose.p004ui.text.font.AndroidPreloadedFont
    @Nullable
    public Typeface doLoad$ui_text_release(@Nullable Context context) {
        return Build.VERSION.SDK_INT >= 26 ? TypefaceBuilderCompat.INSTANCE.createFromAssets(this.assetManager, this.path, context, getVariationSettings()) : Typeface.createFromAsset(this.assetManager, this.path);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidAssetFont)) {
            return false;
        }
        AndroidAssetFont androidAssetFont = (AndroidAssetFont) obj;
        return Intrinsics.areEqual(this.path, androidAssetFont.path) && Intrinsics.areEqual(getVariationSettings(), androidAssetFont.getVariationSettings());
    }

    @NotNull
    public final AssetManager getAssetManager() {
        return this.assetManager;
    }

    @Override // androidx.compose.p004ui.text.font.AndroidPreloadedFont
    @NotNull
    public String getCacheKey() {
        return this.cacheKey;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + getVariationSettings().hashCode();
    }

    @NotNull
    public String toString() {
        return "Font(assetManager, path=" + this.path + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m4836toStringimpl(mo4790getStyle_LCdwA())) + ')';
    }

    private AndroidAssetFont(AssetManager assetManager, String str, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(fontWeight, i, settings, null);
        this.assetManager = assetManager;
        this.path = str;
        setTypeface$ui_text_release(doLoad$ui_text_release(null));
        this.cacheKey = "asset:" + str;
    }
}
