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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SwipeableState$Companion {
    private SwipeableState$Companion() {
    }

    public /* synthetic */ SwipeableState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final <T> Saver<SwipeableState<T>, T> Saver(@NotNull final AnimationSpec<Float> animationSpec, @NotNull final Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        return SaverKt.Saver(new Function2<SaverScope, SwipeableState<T>, T>() { // from class: androidx.compose.material.SwipeableState$Companion$Saver$1
            @Nullable
            public final T invoke(@NotNull SaverScope saverScope, @NotNull SwipeableState<T> swipeableState) {
                Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
                Intrinsics.checkNotNullParameter(swipeableState, "it");
                return (T) swipeableState.getCurrentValue();
            }
        }, new Function1<T, SwipeableState<T>>() { // from class: androidx.compose.material.SwipeableState$Companion$Saver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m828invoke(Object obj) {
                return invoke((SwipeableState$Companion$Saver$2<T>) obj);
            }

            @Nullable
            public final SwipeableState<T> invoke(@NotNull T t) {
                Intrinsics.checkNotNullParameter(t, "it");
                return new SwipeableState<>(t, animationSpec, function1);
            }
        });
    }
}
