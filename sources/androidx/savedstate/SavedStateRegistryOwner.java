package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @NotNull
    SavedStateRegistry getSavedStateRegistry();
}
