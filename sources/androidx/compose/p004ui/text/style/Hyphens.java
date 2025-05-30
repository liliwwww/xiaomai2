package androidx.compose.p004ui.text.style;

import androidx.compose.p004ui.text.ExperimentalTextApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalTextApi
/* loaded from: classes.dex */
public final class Hyphens {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Hyphens None = new Hyphens();

    @NotNull
    private static final Hyphens Auto = new Hyphens();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Hyphens getAuto() {
            return Hyphens.Auto;
        }

        @NotNull
        public final Hyphens getNone() {
            return Hyphens.None;
        }
    }

    private Hyphens() {
    }

    @NotNull
    public String toString() {
        return Intrinsics.areEqual(this, None) ? "Hyphens.None" : Intrinsics.areEqual(this, Auto) ? "Hyphens.Auto" : "Invalid";
    }
}
