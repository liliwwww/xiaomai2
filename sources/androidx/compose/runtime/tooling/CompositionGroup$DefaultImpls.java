package androidx.compose.runtime.tooling;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h50;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CompositionGroup$DefaultImpls {
    @Deprecated
    @Nullable
    public static CompositionGroup find(@NotNull CompositionGroup compositionGroup, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "identityToFind");
        return h50.d(compositionGroup, obj);
    }

    @Deprecated
    public static int getGroupSize(@NotNull CompositionGroup compositionGroup) {
        return h50.e(compositionGroup);
    }

    @Deprecated
    @Nullable
    public static Object getIdentity(@NotNull CompositionGroup compositionGroup) {
        return h50.f(compositionGroup);
    }

    @Deprecated
    public static int getSlotsSize(@NotNull CompositionGroup compositionGroup) {
        return h50.g(compositionGroup);
    }
}
