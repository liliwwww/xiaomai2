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
public final class SwipeableV2State$Companion {
    private SwipeableV2State$Companion() {
    }

    public /* synthetic */ SwipeableV2State$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final <T> Saver<SwipeableV2State<T>, T> Saver(@NotNull final AnimationSpec<Float> animationSpec, @NotNull final Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        return SaverKt.Saver(new Function2<SaverScope, SwipeableV2State<T>, T>() { // from class: androidx.compose.material.SwipeableV2State$Companion$Saver$1
            @Nullable
            public final T invoke(@NotNull SaverScope saverScope, @NotNull SwipeableV2State<T> swipeableV2State) {
                Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
                Intrinsics.checkNotNullParameter(swipeableV2State, "it");
                return (T) swipeableV2State.getCurrentState();
            }
        }, new Function1<T, SwipeableV2State<T>>() { // from class: androidx.compose.material.SwipeableV2State$Companion$Saver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m831invoke(Object obj) {
                return invoke((SwipeableV2State$Companion$Saver$2<T>) obj);
            }

            @Nullable
            public final SwipeableV2State<T> invoke(@NotNull T t) {
                Intrinsics.checkNotNullParameter(t, "it");
                return new SwipeableV2State<>(t, animationSpec, function1);
            }
        });
    }
}
