package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.Strings;
import androidx.compose.p004ui.C0756R;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Strings_androidKt {
    @Composable
    @NotNull
    /* renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m2240getString4foXLRw(int i, @Nullable Composer composer, int i2) {
        String str;
        composer.startReplaceableGroup(-726638443);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726638443, i2, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.Companion;
        if (Strings.m2229equalsimpl0(i, companion.m2237getNavigationMenuUdPEhr4())) {
            str = resources.getString(C0756R.string.navigation_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m2229equalsimpl0(i, companion.m2233getCloseDrawerUdPEhr4())) {
            str = resources.getString(C0756R.string.close_drawer);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m2229equalsimpl0(i, companion.m2234getCloseSheetUdPEhr4())) {
            str = resources.getString(C0756R.string.close_sheet);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m2229equalsimpl0(i, companion.m2235getDefaultErrorMessageUdPEhr4())) {
            str = resources.getString(C0756R.string.default_error_message);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m2229equalsimpl0(i, companion.m2236getExposedDropdownMenuUdPEhr4())) {
            str = resources.getString(C0756R.string.dropdown_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m2229equalsimpl0(i, companion.m2239getSliderRangeStartUdPEhr4())) {
            str = resources.getString(C0756R.string.range_start);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_start)");
        } else if (Strings.m2229equalsimpl0(i, companion.m2238getSliderRangeEndUdPEhr4())) {
            str = resources.getString(C0756R.string.range_end);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_end)");
        } else {
            str = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return str;
    }
}
