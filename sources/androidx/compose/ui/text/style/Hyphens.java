package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Hyphens {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final Hyphens None = new Hyphens();

    @NotNull
    private static final Hyphens Auto = new Hyphens();

    private Hyphens() {
    }

    @NotNull
    public String toString() {
        return Intrinsics.areEqual(this, None) ? "Hyphens.None" : Intrinsics.areEqual(this, Auto) ? "Hyphens.Auto" : "Invalid";
    }
}
