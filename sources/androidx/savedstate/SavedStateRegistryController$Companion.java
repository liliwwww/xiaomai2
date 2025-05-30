package androidx.savedstate;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SavedStateRegistryController$Companion {
    private SavedStateRegistryController$Companion() {
    }

    public /* synthetic */ SavedStateRegistryController$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public final SavedStateRegistryController create(@NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        return new SavedStateRegistryController(savedStateRegistryOwner, (DefaultConstructorMarker) null);
    }
}
