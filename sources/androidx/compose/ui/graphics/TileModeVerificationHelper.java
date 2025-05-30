package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(31)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TileModeVerificationHelper {

    @NotNull
    public static final TileModeVerificationHelper INSTANCE = new TileModeVerificationHelper();

    private TileModeVerificationHelper() {
    }

    @DoNotInline
    /* renamed from: getComposeTileModeDecal-3opZhB0, reason: not valid java name */
    public final int m1222getComposeTileModeDecal3opZhB0() {
        return TileMode.Companion.getDecal-3opZhB0();
    }

    @DoNotInline
    @NotNull
    public final Shader.TileMode getFrameworkTileModeDecal() {
        return Shader.TileMode.DECAL;
    }
}
