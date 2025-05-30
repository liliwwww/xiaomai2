package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BottomNavigationKt$BottomNavigationItem$styledLabel$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomNavigationKt$BottomNavigationItem$styledLabel$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$label = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        TextStyle m2339copyHL5avdY;
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1343298261, i, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:159)");
        }
        m2339copyHL5avdY = r3.m2339copyHL5avdY((r42 & 1) != 0 ? r3.spanStyle.m2299getColor0d7_KjU() : 0L, (r42 & 2) != 0 ? r3.spanStyle.m2300getFontSizeXSAIIZE() : 0L, (r42 & 4) != 0 ? r3.spanStyle.getFontWeight() : null, (r42 & 8) != 0 ? r3.spanStyle.m2301getFontStyle4Lr2A7w() : null, (r42 & 16) != 0 ? r3.spanStyle.m2302getFontSynthesisZQGJjVo() : null, (r42 & 32) != 0 ? r3.spanStyle.getFontFamily() : null, (r42 & 64) != 0 ? r3.spanStyle.getFontFeatureSettings() : null, (r42 & 128) != 0 ? r3.spanStyle.m2303getLetterSpacingXSAIIZE() : 0L, (r42 & 256) != 0 ? r3.spanStyle.m2298getBaselineShift5SSeXJ0() : null, (r42 & 512) != 0 ? r3.spanStyle.getTextGeometricTransform() : null, (r42 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? r3.spanStyle.getLocaleList() : null, (r42 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? r3.spanStyle.m2297getBackground0d7_KjU() : 0L, (r42 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? r3.spanStyle.getTextDecoration() : null, (r42 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? r3.spanStyle.getShadow() : null, (r42 & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? r3.paragraphStyle.m2274getTextAlignbuA522U() : TextAlign.m2499boximpl(TextAlign.Companion.m2506getCentere0LSkKk()), (r42 & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0 ? r3.paragraphStyle.m2275getTextDirectionmmuk1to() : null, (r42 & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0 ? r3.paragraphStyle.m2273getLineHeightXSAIIZE() : 0L, (r42 & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) != 0 ? MaterialTheme.INSTANCE.getTypography(composer, 6).getCaption().paragraphStyle.getTextIndent() : null);
        TextKt.ProvideTextStyle(m2339copyHL5avdY, this.$label, composer, (this.$$dirty >> 15) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
