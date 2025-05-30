package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.BlendMode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m925isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m974equalsimpl0(i, BlendMode.Companion.m1005getSrcOver0nO6VwU()) || m927toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    @RequiresApi(29)
    @NotNull
    /* renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m926toAndroidBlendModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.Companion;
        return BlendMode.m974equalsimpl0(i, companion.m978getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m974equalsimpl0(i, companion.m1001getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m974equalsimpl0(i, companion.m984getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m974equalsimpl0(i, companion.m1005getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m974equalsimpl0(i, companion.m988getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m974equalsimpl0(i, companion.m1003getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m974equalsimpl0(i, companion.m986getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m974equalsimpl0(i, companion.m1004getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m974equalsimpl0(i, companion.m987getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m974equalsimpl0(i, companion.m1002getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m974equalsimpl0(i, companion.m985getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m974equalsimpl0(i, companion.m1006getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m974equalsimpl0(i, companion.m997getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m974equalsimpl0(i, companion.m994getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m974equalsimpl0(i, companion.m999getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m974equalsimpl0(i, companion.m996getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m974equalsimpl0(i, companion.m982getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m974equalsimpl0(i, companion.m992getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m974equalsimpl0(i, companion.m981getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m974equalsimpl0(i, companion.m980getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m974equalsimpl0(i, companion.m990getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m974equalsimpl0(i, companion.m1000getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m974equalsimpl0(i, companion.m983getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m974equalsimpl0(i, companion.m989getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m974equalsimpl0(i, companion.m995getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m974equalsimpl0(i, companion.m991getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m974equalsimpl0(i, companion.m998getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m974equalsimpl0(i, companion.m979getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m974equalsimpl0(i, companion.m993getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    @NotNull
    /* renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m927toPorterDuffModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.Companion;
        return BlendMode.m974equalsimpl0(i, companion.m978getClear0nO6VwU()) ? PorterDuff.Mode.CLEAR : BlendMode.m974equalsimpl0(i, companion.m1001getSrc0nO6VwU()) ? PorterDuff.Mode.SRC : BlendMode.m974equalsimpl0(i, companion.m984getDst0nO6VwU()) ? PorterDuff.Mode.DST : BlendMode.m974equalsimpl0(i, companion.m1005getSrcOver0nO6VwU()) ? PorterDuff.Mode.SRC_OVER : BlendMode.m974equalsimpl0(i, companion.m988getDstOver0nO6VwU()) ? PorterDuff.Mode.DST_OVER : BlendMode.m974equalsimpl0(i, companion.m1003getSrcIn0nO6VwU()) ? PorterDuff.Mode.SRC_IN : BlendMode.m974equalsimpl0(i, companion.m986getDstIn0nO6VwU()) ? PorterDuff.Mode.DST_IN : BlendMode.m974equalsimpl0(i, companion.m1004getSrcOut0nO6VwU()) ? PorterDuff.Mode.SRC_OUT : BlendMode.m974equalsimpl0(i, companion.m987getDstOut0nO6VwU()) ? PorterDuff.Mode.DST_OUT : BlendMode.m974equalsimpl0(i, companion.m1002getSrcAtop0nO6VwU()) ? PorterDuff.Mode.SRC_ATOP : BlendMode.m974equalsimpl0(i, companion.m985getDstAtop0nO6VwU()) ? PorterDuff.Mode.DST_ATOP : BlendMode.m974equalsimpl0(i, companion.m1006getXor0nO6VwU()) ? PorterDuff.Mode.XOR : BlendMode.m974equalsimpl0(i, companion.m997getPlus0nO6VwU()) ? PorterDuff.Mode.ADD : BlendMode.m974equalsimpl0(i, companion.m999getScreen0nO6VwU()) ? PorterDuff.Mode.SCREEN : BlendMode.m974equalsimpl0(i, companion.m996getOverlay0nO6VwU()) ? PorterDuff.Mode.OVERLAY : BlendMode.m974equalsimpl0(i, companion.m982getDarken0nO6VwU()) ? PorterDuff.Mode.DARKEN : BlendMode.m974equalsimpl0(i, companion.m992getLighten0nO6VwU()) ? PorterDuff.Mode.LIGHTEN : BlendMode.m974equalsimpl0(i, companion.m994getModulate0nO6VwU()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
