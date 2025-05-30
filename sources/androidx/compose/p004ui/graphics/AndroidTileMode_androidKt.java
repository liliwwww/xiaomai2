package androidx.compose.p004ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import androidx.compose.p004ui.graphics.TileMode;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidTileMode_androidKt {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shader.TileMode.values().length];
            try {
                iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Shader.TileMode.MIRROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Shader.TileMode.REPEAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: isSupported-0vamqd0, reason: not valid java name */
    public static final boolean m2699isSupported0vamqd0(int i) {
        return Build.VERSION.SDK_INT >= 31 || !TileMode.m3108equalsimpl0(i, TileMode.Companion.m3113getDecal3opZhB0());
    }

    @NotNull
    /* renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m2700toAndroidTileMode0vamqd0(int i) {
        TileMode.Companion companion = TileMode.Companion;
        return TileMode.m3108equalsimpl0(i, companion.m3112getClamp3opZhB0()) ? Shader.TileMode.CLAMP : TileMode.m3108equalsimpl0(i, companion.m3115getRepeated3opZhB0()) ? Shader.TileMode.REPEAT : TileMode.m3108equalsimpl0(i, companion.m3114getMirror3opZhB0()) ? Shader.TileMode.MIRROR : TileMode.m3108equalsimpl0(i, companion.m3113getDecal3opZhB0()) ? Build.VERSION.SDK_INT >= 31 ? TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal() : Shader.TileMode.CLAMP : Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(@NotNull Shader.TileMode tileMode) {
        Intrinsics.checkNotNullParameter(tileMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[tileMode.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? (Build.VERSION.SDK_INT < 31 || tileMode != Shader.TileMode.DECAL) ? TileMode.Companion.m3112getClamp3opZhB0() : TileModeVerificationHelper.INSTANCE.m3116getComposeTileModeDecal3opZhB0() : TileMode.Companion.m3115getRepeated3opZhB0() : TileMode.Companion.m3114getMirror3opZhB0() : TileMode.Companion.m3112getClamp3opZhB0();
    }
}
