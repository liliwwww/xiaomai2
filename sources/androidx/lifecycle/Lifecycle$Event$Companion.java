package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Lifecycle$Event$Companion {
    private Lifecycle$Event$Companion() {
    }

    public /* synthetic */ Lifecycle$Event$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @Nullable
    public final Lifecycle.Event downFrom(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return Lifecycle.Event.ON_DESTROY;
        }
        if (i == 2) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i != 3) {
            return null;
        }
        return Lifecycle.Event.ON_PAUSE;
    }

    @JvmStatic
    @Nullable
    public final Lifecycle.Event downTo(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i == 2) {
            return Lifecycle.Event.ON_PAUSE;
        }
        if (i != 4) {
            return null;
        }
        return Lifecycle.Event.ON_DESTROY;
    }

    @JvmStatic
    @Nullable
    public final Lifecycle.Event upFrom(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return Lifecycle.Event.ON_START;
        }
        if (i == 2) {
            return Lifecycle.Event.ON_RESUME;
        }
        if (i != 5) {
            return null;
        }
        return Lifecycle.Event.ON_CREATE;
    }

    @JvmStatic
    @Nullable
    public final Lifecycle.Event upTo(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return Lifecycle.Event.ON_CREATE;
        }
        if (i == 2) {
            return Lifecycle.Event.ON_START;
        }
        if (i != 3) {
            return null;
        }
        return Lifecycle.Event.ON_RESUME;
    }
}
