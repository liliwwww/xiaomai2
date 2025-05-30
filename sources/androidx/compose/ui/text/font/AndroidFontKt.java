package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Stable;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidFontKt {
    @Stable
    @NotNull
    /* renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m1899FontEj4NQ78(@NotNull File file, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation$Settings fontVariation$Settings) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(fontVariation$Settings, "variationSettings");
        return new AndroidFileFont(file, fontWeight, i, fontVariation$Settings, null);
    }

    /* renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m1901FontEj4NQ78$default(File file, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if ((i2 & 8) != 0) {
            fontVariation$Settings = FontVariation.INSTANCE.Settings-6EWAqTQ(fontWeight, i, new FontVariation$Setting[0]);
        }
        return m1899FontEj4NQ78(file, fontWeight, i, fontVariation$Settings);
    }

    @Stable
    @NotNull
    /* renamed from: Font-MuC2MFs, reason: not valid java name */
    public static final Font m1902FontMuC2MFs(@NotNull String str, @NotNull AssetManager assetManager, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation$Settings fontVariation$Settings) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(fontVariation$Settings, "variationSettings");
        return new AndroidAssetFont(assetManager, str, fontWeight, i, fontVariation$Settings, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-MuC2MFs$default, reason: not valid java name */
    public static /* synthetic */ Font m1903FontMuC2MFs$default(String str, AssetManager assetManager, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if ((i2 & 16) != 0) {
            fontVariation$Settings = FontVariation.INSTANCE.Settings-6EWAqTQ(fontWeight, i, new FontVariation$Setting[0]);
        }
        return m1902FontMuC2MFs(str, assetManager, fontWeight, i, fontVariation$Settings);
    }

    private static final void generateAndroidFontKtForApiCompatibility() {
    }

    @Stable
    @RequiresApi(26)
    @NotNull
    /* renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m1898FontEj4NQ78(@NotNull ParcelFileDescriptor parcelFileDescriptor, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation$Settings fontVariation$Settings) {
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "fileDescriptor");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(fontVariation$Settings, "variationSettings");
        return new AndroidFileDescriptorFont(parcelFileDescriptor, fontWeight, i, fontVariation$Settings, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m1900FontEj4NQ78$default(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if ((i2 & 8) != 0) {
            fontVariation$Settings = FontVariation.INSTANCE.Settings-6EWAqTQ(fontWeight, i, new FontVariation$Setting[0]);
        }
        return m1898FontEj4NQ78(parcelFileDescriptor, fontWeight, i, fontVariation$Settings);
    }
}
