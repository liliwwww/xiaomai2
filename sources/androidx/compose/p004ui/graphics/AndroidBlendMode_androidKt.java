package androidx.compose.p004ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.p004ui.graphics.BlendMode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m2647isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m2706equalsimpl0(i, BlendMode.Companion.m2737getSrcOver0nO6VwU()) || m2649toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    @RequiresApi(29)
    @NotNull
    /* renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final BlendMode m2648toAndroidBlendModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.Companion;
        return BlendMode.m2706equalsimpl0(i, companion.m2710getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m2706equalsimpl0(i, companion.m2733getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m2706equalsimpl0(i, companion.m2716getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m2706equalsimpl0(i, companion.m2737getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m2706equalsimpl0(i, companion.m2720getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m2706equalsimpl0(i, companion.m2735getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m2706equalsimpl0(i, companion.m2718getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m2706equalsimpl0(i, companion.m2736getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m2706equalsimpl0(i, companion.m2719getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m2706equalsimpl0(i, companion.m2734getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m2706equalsimpl0(i, companion.m2717getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m2706equalsimpl0(i, companion.m2738getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m2706equalsimpl0(i, companion.m2729getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m2706equalsimpl0(i, companion.m2726getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m2706equalsimpl0(i, companion.m2731getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m2706equalsimpl0(i, companion.m2728getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m2706equalsimpl0(i, companion.m2714getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m2706equalsimpl0(i, companion.m2724getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m2706equalsimpl0(i, companion.m2713getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m2706equalsimpl0(i, companion.m2712getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m2706equalsimpl0(i, companion.m2722getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m2706equalsimpl0(i, companion.m2732getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m2706equalsimpl0(i, companion.m2715getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m2706equalsimpl0(i, companion.m2721getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m2706equalsimpl0(i, companion.m2727getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m2706equalsimpl0(i, companion.m2723getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m2706equalsimpl0(i, companion.m2730getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m2706equalsimpl0(i, companion.m2711getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m2706equalsimpl0(i, companion.m2725getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    @NotNull
    /* renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m2649toPorterDuffModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.Companion;
        return BlendMode.m2706equalsimpl0(i, companion.m2710getClear0nO6VwU()) ? PorterDuff.Mode.CLEAR : BlendMode.m2706equalsimpl0(i, companion.m2733getSrc0nO6VwU()) ? PorterDuff.Mode.SRC : BlendMode.m2706equalsimpl0(i, companion.m2716getDst0nO6VwU()) ? PorterDuff.Mode.DST : BlendMode.m2706equalsimpl0(i, companion.m2737getSrcOver0nO6VwU()) ? PorterDuff.Mode.SRC_OVER : BlendMode.m2706equalsimpl0(i, companion.m2720getDstOver0nO6VwU()) ? PorterDuff.Mode.DST_OVER : BlendMode.m2706equalsimpl0(i, companion.m2735getSrcIn0nO6VwU()) ? PorterDuff.Mode.SRC_IN : BlendMode.m2706equalsimpl0(i, companion.m2718getDstIn0nO6VwU()) ? PorterDuff.Mode.DST_IN : BlendMode.m2706equalsimpl0(i, companion.m2736getSrcOut0nO6VwU()) ? PorterDuff.Mode.SRC_OUT : BlendMode.m2706equalsimpl0(i, companion.m2719getDstOut0nO6VwU()) ? PorterDuff.Mode.DST_OUT : BlendMode.m2706equalsimpl0(i, companion.m2734getSrcAtop0nO6VwU()) ? PorterDuff.Mode.SRC_ATOP : BlendMode.m2706equalsimpl0(i, companion.m2717getDstAtop0nO6VwU()) ? PorterDuff.Mode.DST_ATOP : BlendMode.m2706equalsimpl0(i, companion.m2738getXor0nO6VwU()) ? PorterDuff.Mode.XOR : BlendMode.m2706equalsimpl0(i, companion.m2729getPlus0nO6VwU()) ? PorterDuff.Mode.ADD : BlendMode.m2706equalsimpl0(i, companion.m2731getScreen0nO6VwU()) ? PorterDuff.Mode.SCREEN : BlendMode.m2706equalsimpl0(i, companion.m2728getOverlay0nO6VwU()) ? PorterDuff.Mode.OVERLAY : BlendMode.m2706equalsimpl0(i, companion.m2714getDarken0nO6VwU()) ? PorterDuff.Mode.DARKEN : BlendMode.m2706equalsimpl0(i, companion.m2724getLighten0nO6VwU()) ? PorterDuff.Mode.LIGHTEN : BlendMode.m2706equalsimpl0(i, companion.m2726getModulate0nO6VwU()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
