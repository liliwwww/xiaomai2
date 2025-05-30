package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidTileMode_androidKt {
    /* renamed from: isSupported-0vamqd0, reason: not valid java name */
    public static final boolean m969isSupported0vamqd0(int i) {
        return Build.VERSION.SDK_INT >= 31 || !TileMode.equals-impl0(i, TileMode.Companion.m1259getDecal3opZhB0());
    }

    @NotNull
    /* renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m970toAndroidTileMode0vamqd0(int i) {
        TileMode$Companion tileMode$Companion = TileMode.Companion;
        return TileMode.equals-impl0(i, tileMode$Companion.m1258getClamp3opZhB0()) ? Shader.TileMode.CLAMP : TileMode.equals-impl0(i, tileMode$Companion.m1261getRepeated3opZhB0()) ? Shader.TileMode.REPEAT : TileMode.equals-impl0(i, tileMode$Companion.m1260getMirror3opZhB0()) ? Shader.TileMode.MIRROR : TileMode.equals-impl0(i, tileMode$Companion.m1259getDecal3opZhB0()) ? Build.VERSION.SDK_INT >= 31 ? TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal() : Shader.TileMode.CLAMP : Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(@NotNull Shader.TileMode tileMode) {
        Intrinsics.checkNotNullParameter(tileMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[tileMode.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? (Build.VERSION.SDK_INT < 31 || tileMode != Shader.TileMode.DECAL) ? TileMode.Companion.m1258getClamp3opZhB0() : TileModeVerificationHelper.INSTANCE.getComposeTileModeDecal-3opZhB0() : TileMode.Companion.m1261getRepeated3opZhB0() : TileMode.Companion.m1260getMirror3opZhB0() : TileMode.Companion.m1258getClamp3opZhB0();
    }
}
