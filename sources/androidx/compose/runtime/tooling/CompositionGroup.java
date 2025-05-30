package androidx.compose.runtime.tooling;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h50;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface CompositionGroup extends CompositionData {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
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

    @NotNull
    Iterable<Object> getData();

    int getGroupSize();

    @Nullable
    Object getIdentity();

    @NotNull
    Object getKey();

    @Nullable
    Object getNode();

    int getSlotsSize();

    @Nullable
    String getSourceInfo();
}
