package androidx.fragment.app.strictmode;

import android.annotation.SuppressLint;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FragmentStrictMode$Policy$Builder {

    @Nullable
    private FragmentStrictMode$OnViolationListener listener;

    @NotNull
    private final Set<FragmentStrictMode.Flag> flags = new LinkedHashSet();

    @NotNull
    private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations = new LinkedHashMap();

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder allowViolation(@NotNull Class<? extends Fragment> cls, @NotNull Class<? extends Violation> cls2) {
        Intrinsics.checkNotNullParameter(cls, "fragmentClass");
        Intrinsics.checkNotNullParameter(cls2, "violationClass");
        String name = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name, "fragmentClassString");
        return allowViolation(name, cls2);
    }

    @NotNull
    public final FragmentStrictMode.Policy build() {
        if (this.listener == null && !this.flags.contains(FragmentStrictMode.Flag.PENALTY_DEATH)) {
            penaltyLog();
        }
        return new FragmentStrictMode.Policy(this.flags, this.listener, this.mAllowedViolations);
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder detectFragmentReuse() {
        this.flags.add(FragmentStrictMode.Flag.DETECT_FRAGMENT_REUSE);
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder detectFragmentTagUsage() {
        this.flags.add(FragmentStrictMode.Flag.DETECT_FRAGMENT_TAG_USAGE);
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder detectRetainInstanceUsage() {
        this.flags.add(FragmentStrictMode.Flag.DETECT_RETAIN_INSTANCE_USAGE);
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder detectSetUserVisibleHint() {
        this.flags.add(FragmentStrictMode.Flag.DETECT_SET_USER_VISIBLE_HINT);
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder detectTargetFragmentUsage() {
        this.flags.add(FragmentStrictMode.Flag.DETECT_TARGET_FRAGMENT_USAGE);
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder detectWrongFragmentContainer() {
        this.flags.add(FragmentStrictMode.Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder penaltyDeath() {
        this.flags.add(FragmentStrictMode.Flag.PENALTY_DEATH);
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder penaltyListener(@NotNull FragmentStrictMode$OnViolationListener fragmentStrictMode$OnViolationListener) {
        Intrinsics.checkNotNullParameter(fragmentStrictMode$OnViolationListener, "listener");
        this.listener = fragmentStrictMode$OnViolationListener;
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder penaltyLog() {
        this.flags.add(FragmentStrictMode.Flag.PENALTY_LOG);
        return this;
    }

    @SuppressLint({"BuilderSetStyle"})
    @NotNull
    public final FragmentStrictMode$Policy$Builder allowViolation(@NotNull String str, @NotNull Class<? extends Violation> cls) {
        Intrinsics.checkNotNullParameter(str, "fragmentClass");
        Intrinsics.checkNotNullParameter(cls, "violationClass");
        Set<Class<? extends Violation>> set = this.mAllowedViolations.get(str);
        if (set == null) {
            set = new LinkedHashSet<>();
        }
        set.add(cls);
        this.mAllowedViolations.put(str, set);
        return this;
    }
}
