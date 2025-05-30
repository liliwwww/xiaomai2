package androidx.compose.ui.tooling.animation;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class UnsupportedComposeAnimation$Companion {
    private UnsupportedComposeAnimation$Companion() {
    }

    public /* synthetic */ UnsupportedComposeAnimation$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public final UnsupportedComposeAnimation create(@Nullable String str) {
        if (getApiAvailable()) {
            return new UnsupportedComposeAnimation(str, (DefaultConstructorMarker) null);
        }
        return null;
    }

    public final boolean getApiAvailable() {
        return UnsupportedComposeAnimation.access$getApiAvailable$cp();
    }

    public final void testOverrideAvailability(boolean z) {
        UnsupportedComposeAnimation.access$setApiAvailable$cp(z);
    }
}
