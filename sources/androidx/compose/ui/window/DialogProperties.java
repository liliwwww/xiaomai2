package androidx.compose.ui.window;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DialogProperties {
    private final boolean decorFitsSystemWindows;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;

    @NotNull
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;

    @ExperimentalComposeUiApi
    public DialogProperties() {
        this(false, false, null, false, false, 31, null);
    }

    @ExperimentalComposeUiApi
    public DialogProperties(boolean z, boolean z2, @NotNull SecureFlagPolicy secureFlagPolicy, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(secureFlagPolicy, "securePolicy");
        this.dismissOnBackPress = z;
        this.dismissOnClickOutside = z2;
        this.securePolicy = secureFlagPolicy;
        this.usePlatformDefaultWidth = z3;
        this.decorFitsSystemWindows = z4;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getDecorFitsSystemWindows$annotations() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogProperties)) {
            return false;
        }
        DialogProperties dialogProperties = (DialogProperties) obj;
        return this.dismissOnBackPress == dialogProperties.dismissOnBackPress && this.dismissOnClickOutside == dialogProperties.dismissOnClickOutside && this.securePolicy == dialogProperties.securePolicy && this.usePlatformDefaultWidth == dialogProperties.usePlatformDefaultWidth && this.decorFitsSystemWindows == dialogProperties.decorFitsSystemWindows;
    }

    @ExperimentalComposeUiApi
    public final boolean getDecorFitsSystemWindows() {
        return this.decorFitsSystemWindows;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    @NotNull
    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return (((((((l3.a(this.dismissOnBackPress) * 31) + l3.a(this.dismissOnClickOutside)) * 31) + this.securePolicy.hashCode()) * 31) + l3.a(this.usePlatformDefaultWidth)) * 31) + l3.a(this.decorFitsSystemWindows);
    }

    public /* synthetic */ DialogProperties(boolean z, boolean z2, SecureFlagPolicy secureFlagPolicy, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4);
    }

    public /* synthetic */ DialogProperties(boolean z, boolean z2, SecureFlagPolicy secureFlagPolicy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialogProperties(boolean z, boolean z2, @NotNull SecureFlagPolicy secureFlagPolicy) {
        this(z, z2, secureFlagPolicy, true, true);
        Intrinsics.checkNotNullParameter(secureFlagPolicy, "securePolicy");
    }
}
