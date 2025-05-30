package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class Invalidation {

    @Nullable
    private IdentityArraySet<Object> instances;
    private final int location;

    @NotNull
    private final RecomposeScopeImpl scope;

    public Invalidation(@NotNull RecomposeScopeImpl recomposeScopeImpl, int i, @Nullable IdentityArraySet<Object> identityArraySet) {
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        this.scope = recomposeScopeImpl;
        this.location = i;
        this.instances = identityArraySet;
    }

    @Nullable
    public final IdentityArraySet<Object> getInstances() {
        return this.instances;
    }

    public final int getLocation() {
        return this.location;
    }

    @NotNull
    public final RecomposeScopeImpl getScope() {
        return this.scope;
    }

    public final boolean isInvalid() {
        return this.scope.isInvalidFor(this.instances);
    }

    public final void setInstances(@Nullable IdentityArraySet<Object> identityArraySet) {
        this.instances = identityArraySet;
    }
}
