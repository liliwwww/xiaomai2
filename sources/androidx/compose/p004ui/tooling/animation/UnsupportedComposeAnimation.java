package androidx.compose.p004ui.tooling.animation;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class UnsupportedComposeAnimation implements ComposeAnimation {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static boolean apiAvailable;

    @NotNull
    private final Object animationObject;

    @Nullable
    private final String label;

    @NotNull
    private final Set<Integer> states;

    @NotNull
    private final ComposeAnimationType type;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final UnsupportedComposeAnimation create(@Nullable String str) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (getApiAvailable()) {
                return new UnsupportedComposeAnimation(str, defaultConstructorMarker);
            }
            return null;
        }

        public final boolean getApiAvailable() {
            return UnsupportedComposeAnimation.apiAvailable;
        }

        public final void testOverrideAvailability(boolean z) {
            UnsupportedComposeAnimation.apiAvailable = z;
        }
    }

    static {
        ComposeAnimationType[] values = ComposeAnimationType.values();
        int length = values.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (Intrinsics.areEqual(values[i].name(), "UNSUPPORTED")) {
                z = true;
                break;
            }
            i++;
        }
        apiAvailable = z;
    }

    private UnsupportedComposeAnimation(String str) {
        this.label = str;
        this.type = ComposeAnimationType.UNSUPPORTED;
        this.animationObject = 0;
        this.states = SetsKt.emptySet();
    }

    public /* synthetic */ UnsupportedComposeAnimation(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @NotNull
    public Object getAnimationObject() {
        return this.animationObject;
    }

    @Nullable
    public String getLabel() {
        return this.label;
    }

    @NotNull
    public Set<Integer> getStates() {
        return this.states;
    }

    @NotNull
    public ComposeAnimationType getType() {
        return this.type;
    }
}
