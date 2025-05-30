package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LookaheadScope {

    @Nullable
    private MutableSnapshot disposableSnapshot;

    @NotNull
    private final LayoutNode root;

    public LookaheadScope(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        this.root = layoutNode;
    }

    @NotNull
    public final LayoutNode getRoot() {
        return this.root;
    }

    public final <T> T withDisposableSnapshot(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!(this.disposableSnapshot == null)) {
            throw new IllegalStateException("Disposable snapshot is already active".toString());
        }
        MutableSnapshot takeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.Companion, null, null, 3, null);
        this.disposableSnapshot = takeMutableSnapshot$default;
        try {
            Snapshot makeCurrent = takeMutableSnapshot$default.makeCurrent();
            try {
                return (T) function0.invoke();
            } finally {
                takeMutableSnapshot$default.restoreCurrent(makeCurrent);
            }
        } finally {
            takeMutableSnapshot$default.dispose();
            this.disposableSnapshot = null;
        }
    }
}
