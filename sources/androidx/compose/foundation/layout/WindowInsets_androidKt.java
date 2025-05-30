package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R$id;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class WindowInsets_androidKt {
    @NotNull
    public static final ValueInsets ValueInsets(@NotNull Insets insets, @NotNull String str) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(str, "name");
        return new ValueInsets(toInsetsValues(insets), str);
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "getAreNavigationBarsVisible")
    public static final boolean getAreNavigationBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(710310464);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(710310464, i, -1, "androidx.compose.foundation.layout.<get-areNavigationBarsVisible> (WindowInsets.android.kt:349)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreNavigationBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "getAreStatusBarsVisible")
    public static final boolean getAreStatusBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1613283456);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613283456, i, -1, "androidx.compose.foundation.layout.<get-areStatusBarsVisible> (WindowInsets.android.kt:337)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getStatusBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreStatusBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "getAreSystemBarsVisible")
    public static final boolean getAreSystemBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1985490720);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1985490720, i, -1, "androidx.compose.foundation.layout.<get-areSystemBarsVisible> (WindowInsets.android.kt:361)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getSystemBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreSystemBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @JvmName(name = "getCaptionBar")
    @NotNull
    public static final WindowInsets getCaptionBar(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1832025528);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1832025528, i, -1, "androidx.compose.foundation.layout.<get-captionBar> (WindowInsets.android.kt:125)");
        }
        AndroidWindowInsets captionBar = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBar();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return captionBar;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getCaptionBarIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getCaptionBarIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1731251574);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1731251574, i, -1, "androidx.compose.foundation.layout.<get-captionBarIgnoringVisibility> (WindowInsets.android.kt:249)");
        }
        ValueInsets captionBarIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBarIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return captionBarIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getCaptionBarIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static final boolean getConsumeWindowInsets(@NotNull ComposeView composeView) {
        Intrinsics.checkNotNullParameter(composeView, "<this>");
        Object tag = composeView.getTag(R$id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Composable
    @JvmName(name = "getDisplayCutout")
    @NotNull
    public static final WindowInsets getDisplayCutout(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1324817724);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1324817724, i, -1, "androidx.compose.foundation.layout.<get-displayCutout> (WindowInsets.android.kt:134)");
        }
        AndroidWindowInsets displayCutout = WindowInsetsHolder.Companion.current(composer, 8).getDisplayCutout();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return displayCutout;
    }

    @Composable
    @JvmName(name = "getIme")
    @NotNull
    public static final WindowInsets getIme(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1466917860);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1466917860, i, -1, "androidx.compose.foundation.layout.<get-ime> (WindowInsets.android.kt:148)");
        }
        AndroidWindowInsets ime = WindowInsetsHolder.Companion.current(composer, 8).getIme();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return ime;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getImeAnimationSource")
    @NotNull
    @Composable
    public static final WindowInsets getImeAnimationSource(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1126064918);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1126064918, i, -1, "androidx.compose.foundation.layout.<get-imeAnimationSource> (WindowInsets.android.kt:387)");
        }
        ValueInsets imeAnimationSource = WindowInsetsHolder.Companion.current(composer, 8).getImeAnimationSource();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imeAnimationSource;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getImeAnimationSource$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getImeAnimationTarget")
    @NotNull
    @Composable
    public static final WindowInsets getImeAnimationTarget(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-466319786);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-466319786, i, -1, "androidx.compose.foundation.layout.<get-imeAnimationTarget> (WindowInsets.android.kt:402)");
        }
        ValueInsets imeAnimationTarget = WindowInsetsHolder.Companion.current(composer, 8).getImeAnimationTarget();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imeAnimationTarget;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getImeAnimationTarget$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @JvmName(name = "getMandatorySystemGestures")
    @NotNull
    public static final WindowInsets getMandatorySystemGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1369492988);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1369492988, i, -1, "androidx.compose.foundation.layout.<get-mandatorySystemGestures> (WindowInsets.android.kt:157)");
        }
        AndroidWindowInsets mandatorySystemGestures = WindowInsetsHolder.Companion.current(composer, 8).getMandatorySystemGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mandatorySystemGestures;
    }

    @Composable
    @JvmName(name = "getNavigationBars")
    @NotNull
    public static final WindowInsets getNavigationBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1596175702);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1596175702, i, -1, "androidx.compose.foundation.layout.<get-navigationBars> (WindowInsets.android.kt:167)");
        }
        AndroidWindowInsets navigationBars = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return navigationBars;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getNavigationBarsIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getNavigationBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1990981160);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1990981160, i, -1, "androidx.compose.foundation.layout.<get-navigationBarsIgnoringVisibility> (WindowInsets.android.kt:263)");
        }
        ValueInsets navigationBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return navigationBarsIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getNavigationBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @JvmName(name = "getSafeContent")
    @NotNull
    public static final WindowInsets getSafeContent(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-2026663876);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026663876, i, -1, "androidx.compose.foundation.layout.<get-safeContent> (WindowInsets.android.kt:237)");
        }
        WindowInsets safeContent = WindowInsetsHolder.Companion.current(composer, 8).getSafeContent();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return safeContent;
    }

    @Composable
    @JvmName(name = "getSafeDrawing")
    @NotNull
    public static final WindowInsets getSafeDrawing(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-49441252);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-49441252, i, -1, "androidx.compose.foundation.layout.<get-safeDrawing> (WindowInsets.android.kt:217)");
        }
        WindowInsets safeDrawing = WindowInsetsHolder.Companion.current(composer, 8).getSafeDrawing();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return safeDrawing;
    }

    @Composable
    @JvmName(name = "getSafeGestures")
    @NotNull
    public static final WindowInsets getSafeGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1594247780);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1594247780, i, -1, "androidx.compose.foundation.layout.<get-safeGestures> (WindowInsets.android.kt:228)");
        }
        WindowInsets safeGestures = WindowInsetsHolder.Companion.current(composer, 8).getSafeGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return safeGestures;
    }

    @Composable
    @JvmName(name = "getStatusBars")
    @NotNull
    public static final WindowInsets getStatusBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-675090670);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-675090670, i, -1, "androidx.compose.foundation.layout.<get-statusBars> (WindowInsets.android.kt:175)");
        }
        AndroidWindowInsets statusBars = WindowInsetsHolder.Companion.current(composer, 8).getStatusBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return statusBars;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getStatusBarsIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getStatusBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(594020756);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(594020756, i, -1, "androidx.compose.foundation.layout.<get-statusBarsIgnoringVisibility> (WindowInsets.android.kt:275)");
        }
        ValueInsets statusBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getStatusBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return statusBarsIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getStatusBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @JvmName(name = "getSystemBars")
    @NotNull
    public static final WindowInsets getSystemBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-282936756);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-282936756, i, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:183)");
        }
        AndroidWindowInsets systemBars = WindowInsetsHolder.Companion.current(composer, 8).getSystemBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return systemBars;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getSystemBarsIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getSystemBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1564566798);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1564566798, i, -1, "androidx.compose.foundation.layout.<get-systemBarsIgnoringVisibility> (WindowInsets.android.kt:288)");
        }
        ValueInsets systemBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getSystemBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return systemBarsIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getSystemBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @JvmName(name = "getSystemGestures")
    @NotNull
    public static final WindowInsets getSystemGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(989216224);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(989216224, i, -1, "androidx.compose.foundation.layout.<get-systemGestures> (WindowInsets.android.kt:191)");
        }
        AndroidWindowInsets systemGestures = WindowInsetsHolder.Companion.current(composer, 8).getSystemGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return systemGestures;
    }

    @Composable
    @JvmName(name = "getTappableElement")
    @NotNull
    public static final WindowInsets getTappableElement(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1994205284);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994205284, i, -1, "androidx.compose.foundation.layout.<get-tappableElement> (WindowInsets.android.kt:199)");
        }
        AndroidWindowInsets tappableElement = WindowInsetsHolder.Companion.current(composer, 8).getTappableElement();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tappableElement;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getTappableElementIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getTappableElementIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1488788292);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1488788292, i, -1, "androidx.compose.foundation.layout.<get-tappableElementIgnoringVisibility> (WindowInsets.android.kt:301)");
        }
        ValueInsets tappableElementIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getTappableElementIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tappableElementIgnoringVisibility;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getTappableElementIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @JvmName(name = "getWaterfall")
    @NotNull
    public static final WindowInsets getWaterfall(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(1943241020);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1943241020, i, -1, "androidx.compose.foundation.layout.<get-waterfall> (WindowInsets.android.kt:207)");
        }
        ValueInsets waterfall = WindowInsetsHolder.Companion.current(composer, 8).getWaterfall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return waterfall;
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "isCaptionBarVisible")
    public static final boolean isCaptionBarVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-501076620);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-501076620, i, -1, "androidx.compose.foundation.layout.<get-isCaptionBarVisible> (WindowInsets.android.kt:313)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBar().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isCaptionBarVisible$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "isImeVisible")
    public static final boolean isImeVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1873571424);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1873571424, i, -1, "androidx.compose.foundation.layout.<get-isImeVisible> (WindowInsets.android.kt:325)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getIme().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isImeVisible$annotations(WindowInsets.Companion companion) {
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "isTappableElementVisible")
    public static final boolean isTappableElementVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(-1737201120);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1737201120, i, -1, "androidx.compose.foundation.layout.<get-isTappableElementVisible> (WindowInsets.android.kt:372)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getTappableElement().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isTappableElementVisible$annotations(WindowInsets.Companion companion) {
    }

    public static final void setConsumeWindowInsets(@NotNull ComposeView composeView, boolean z) {
        Intrinsics.checkNotNullParameter(composeView, "<this>");
        composeView.setTag(R$id.consume_window_insets_tag, Boolean.valueOf(z));
    }

    @NotNull
    public static final InsetsValues toInsetsValues(@NotNull Insets insets) {
        Intrinsics.checkNotNullParameter(insets, "<this>");
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }
}
