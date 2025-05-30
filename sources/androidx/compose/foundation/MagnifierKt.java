package androidx.compose.foundation;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.MagnifierKt$magnifier$;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MagnifierKt {

    @NotNull
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", (Function2) null, 2, (DefaultConstructorMarker) null);

    @NotNull
    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean isPlatformMagnifierSupported(int i) {
        return i >= 28;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    @RequiresApi(28)
    @SuppressLint({"ModifierInspectorInfo"})
    @NotNull
    public static final Modifier magnifier(@NotNull Modifier modifier, @NotNull Function1<? super Density, Offset> function1, @NotNull Function1<? super Density, Offset> function12, float f, @NotNull MagnifierStyle magnifierStyle, @Nullable Function1<? super DpSize, Unit> function13, @NotNull PlatformMagnifierFactory platformMagnifierFactory) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "sourceCenter");
        Intrinsics.checkNotNullParameter(function12, "magnifierCenter");
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        Intrinsics.checkNotNullParameter(platformMagnifierFactory, "platformMagnifierFactory");
        return ComposedModifierKt.composed$default(modifier, null, new magnifier.4(function1, function12, f, function13, platformMagnifierFactory, magnifierStyle), 1, null);
    }

    public static /* synthetic */ Modifier magnifier$default(Modifier modifier, Function1 function1, Function1 function12, float f, MagnifierStyle magnifierStyle, Function1 function13, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = magnifier.1.INSTANCE;
        }
        Function1 function14 = function12;
        float f2 = (i & 4) != 0 ? Float.NaN : f;
        if ((i & 8) != 0) {
            magnifierStyle = MagnifierStyle.Companion.getDefault();
        }
        MagnifierStyle magnifierStyle2 = magnifierStyle;
        if ((i & 16) != 0) {
            function13 = null;
        }
        return magnifier(modifier, function1, function14, f2, magnifierStyle2, function13);
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier magnifier(@NotNull Modifier modifier, @NotNull Function1<? super Density, Offset> function1, @NotNull Function1<? super Density, Offset> function12, float f, @NotNull MagnifierStyle magnifierStyle, @Nullable Function1<? super DpSize, Unit> function13) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "sourceCenter");
        Intrinsics.checkNotNullParameter(function12, "magnifierCenter");
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        MagnifierKt$magnifier$.inlined.debugInspectorInfo.1 r0 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new MagnifierKt$magnifier$.inlined.debugInspectorInfo.1(function1, function12, f, magnifierStyle) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            modifier2 = magnifier(modifier2, function1, function12, f, magnifierStyle, function13, PlatformMagnifierFactory.Companion.getForCurrentPlatform());
        }
        return InspectableValueKt.inspectableWrapper(modifier, r0, modifier2);
    }
}
