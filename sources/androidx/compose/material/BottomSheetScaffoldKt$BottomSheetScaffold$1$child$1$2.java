package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.BottomSheetScaffoldKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ MutableState<Float> $bottomSheetHeight$delegate;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Modifier $swipeable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1$2(Modifier modifier, float f, MutableState<Float> mutableState, Shape shape, long j, long j2, float f2, int i, int i2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$swipeable = modifier;
        this.$sheetPeekHeight = f;
        this.$bottomSheetHeight$delegate = mutableState;
        this.$sheetShape = shape;
        this.$sheetBackgroundColor = j;
        this.$sheetContentColor = j2;
        this.$sheetElevation = f2;
        this.$$dirty = i;
        this.$$dirty1 = i2;
        this.$sheetContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1113066167, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:334)");
        }
        Modifier m365requiredHeightInVpY3zN4$default = SizeKt.m365requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(this.$swipeable, 0.0f, 1, null), this.$sheetPeekHeight, 0.0f, 2, null);
        final MutableState<Float> mutableState = this.$bottomSheetHeight$delegate;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(mutableState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((LayoutCoordinates) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
                    Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
                    BottomSheetScaffoldKt.BottomSheetScaffold.1.access$invoke$lambda-3(mutableState, IntSize.m2684getHeightimpl(layoutCoordinates.getSize-YbymL2g()));
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(m365requiredHeightInVpY3zN4$default, (Function1) rememberedValue);
        Shape shape = this.$sheetShape;
        long j = this.$sheetBackgroundColor;
        long j2 = this.$sheetContentColor;
        float f = this.$sheetElevation;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 170554245, true, new 2(this.$sheetContent, this.$$dirty));
        int i2 = this.$$dirty;
        int i3 = this.$$dirty1;
        SurfaceKt.Surface-F-jzlyU(onGloballyPositioned, shape, j, j2, (BorderStroke) null, f, composableLambda, composer, 1572864 | ((i2 >> 21) & 112) | ((i3 << 6) & 896) | ((i3 << 6) & 7168) | ((i2 >> 12) & 458752), 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
