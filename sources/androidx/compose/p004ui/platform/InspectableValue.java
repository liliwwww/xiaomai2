package androidx.compose.p004ui.platform;

import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h82;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface InspectableValue {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static Sequence<ValueElement> getInspectableElements(@NotNull InspectableValue inspectableValue) {
            return h82.d(inspectableValue);
        }

        @Deprecated
        @Nullable
        public static String getNameFallback(@NotNull InspectableValue inspectableValue) {
            return h82.e(inspectableValue);
        }

        @Deprecated
        @Nullable
        public static Object getValueOverride(@NotNull InspectableValue inspectableValue) {
            return h82.f(inspectableValue);
        }
    }

    @NotNull
    Sequence<ValueElement> getInspectableElements();

    @Nullable
    String getNameFallback();

    @Nullable
    Object getValueOverride();
}
