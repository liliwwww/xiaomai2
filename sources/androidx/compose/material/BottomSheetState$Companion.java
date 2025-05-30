package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BottomSheetState$Companion {
    private BottomSheetState$Companion() {
    }

    public /* synthetic */ BottomSheetState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Saver<BottomSheetState, ?> Saver(@NotNull final AnimationSpec<Float> animationSpec, @NotNull final Function1<? super BottomSheetValue, Boolean> function1) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        return SaverKt.Saver(new Function2<SaverScope, BottomSheetState, BottomSheetValue>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$1
            @Nullable
            public final BottomSheetValue invoke(@NotNull SaverScope saverScope, @NotNull BottomSheetState bottomSheetState) {
                Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
                Intrinsics.checkNotNullParameter(bottomSheetState, "it");
                return (BottomSheetValue) bottomSheetState.getCurrentValue();
            }
        }, new Function1<BottomSheetValue, BottomSheetState>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Nullable
            public final BottomSheetState invoke(@NotNull BottomSheetValue bottomSheetValue) {
                Intrinsics.checkNotNullParameter(bottomSheetValue, "it");
                return new BottomSheetState(bottomSheetValue, animationSpec, function1);
            }
        });
    }
}
