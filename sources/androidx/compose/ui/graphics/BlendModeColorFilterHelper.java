package androidx.compose.ui.graphics;

import android.graphics.BlendModeColorFilter;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BlendModeColorFilterHelper {

    @NotNull
    public static final BlendModeColorFilterHelper INSTANCE = new BlendModeColorFilterHelper();

    private BlendModeColorFilterHelper() {
    }

    @DoNotInline
    @NotNull
    /* renamed from: BlendModeColorFilter-xETnrds, reason: not valid java name */
    public final BlendModeColorFilter m1043BlendModeColorFilterxETnrds(long j, int i) {
        return new BlendModeColorFilter(ColorKt.toArgb-8_81llA(j), AndroidBlendMode_androidKt.toAndroidBlendMode-s9anfk8(i));
    }
}
