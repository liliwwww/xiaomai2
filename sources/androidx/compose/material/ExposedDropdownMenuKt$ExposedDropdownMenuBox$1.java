package androidx.compose.material;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
    final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
    final /* synthetic */ int $verticalMarginInPx;
    final /* synthetic */ View $view;
    final /* synthetic */ MutableState<Integer> $width$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$1(Ref<LayoutCoordinates> ref, View view, int i, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
        super(1);
        this.$coordinates = ref;
        this.$view = view;
        this.$verticalMarginInPx = i;
        this.$width$delegate = mutableState;
        this.$menuHeight$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        ExposedDropdownMenuKt.access$ExposedDropdownMenuBox$lambda-2(this.$width$delegate, IntSize.getWidth-impl(layoutCoordinates.mo1522getSizeYbymL2g()));
        this.$coordinates.setValue(layoutCoordinates);
        View rootView = this.$view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
        LayoutCoordinates layoutCoordinates2 = (LayoutCoordinates) this.$coordinates.getValue();
        int i = this.$verticalMarginInPx;
        final MutableState<Integer> mutableState = this.$menuHeight$delegate;
        ExposedDropdownMenuKt.access$updateHeight(rootView, layoutCoordinates2, i, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                ExposedDropdownMenuKt.access$ExposedDropdownMenuBox$lambda-5(mutableState, i2);
            }
        });
    }
}
