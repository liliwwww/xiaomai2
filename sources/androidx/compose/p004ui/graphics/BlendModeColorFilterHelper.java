package androidx.compose.p004ui.graphics;

import android.graphics.BlendModeColorFilter;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: classes2.dex */
final class BlendModeColorFilterHelper {

    @NotNull
    public static final BlendModeColorFilterHelper INSTANCE = new BlendModeColorFilterHelper();

    private BlendModeColorFilterHelper() {
    }

    @DoNotInline
    @NotNull
    /* renamed from: BlendModeColorFilter-xETnrds, reason: not valid java name */
    public final BlendModeColorFilter m2739BlendModeColorFilterxETnrds(long j, int i) {
        return new BlendModeColorFilter(ColorKt.m2841toArgb8_81llA(j), AndroidBlendMode_androidKt.m2648toAndroidBlendModes9anfk8(i));
    }
}
