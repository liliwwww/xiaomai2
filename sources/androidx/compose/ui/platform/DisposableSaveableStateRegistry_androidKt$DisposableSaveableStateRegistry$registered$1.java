package androidx.compose.ui.platform;

import android.os.Bundle;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.savedstate.SavedStateRegistry;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1 implements SavedStateRegistry.SavedStateProvider {
    final /* synthetic */ SaveableStateRegistry $saveableStateRegistry;

    DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1(SaveableStateRegistry saveableStateRegistry) {
        this.$saveableStateRegistry = saveableStateRegistry;
    }

    @NotNull
    public final Bundle saveState() {
        return DisposableSaveableStateRegistry_androidKt.access$toBundle(this.$saveableStateRegistry.performSave());
    }
}
