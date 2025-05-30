package androidx.compose.ui.tooling;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ComposeViewAdapter$FakeSavedStateRegistryOwner$1 implements SavedStateRegistryOwner {

    @NotNull
    private final SavedStateRegistryController controller;

    @NotNull
    private final LifecycleRegistry lifecycleRegistry;

    /* JADX WARN: Multi-variable type inference failed */
    ComposeViewAdapter$FakeSavedStateRegistryOwner$1() {
        LifecycleRegistry createUnsafe = LifecycleRegistry.createUnsafe(this);
        Intrinsics.checkNotNullExpressionValue(createUnsafe, "createUnsafe(this)");
        this.lifecycleRegistry = createUnsafe;
        SavedStateRegistryController create = SavedStateRegistryController.Companion.create(this);
        create.performRestore(new Bundle());
        this.controller = create;
        createUnsafe.setCurrentState(Lifecycle.State.RESUMED);
    }

    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @NotNull
    public final LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }

    @NotNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.controller.getSavedStateRegistry();
    }
}
