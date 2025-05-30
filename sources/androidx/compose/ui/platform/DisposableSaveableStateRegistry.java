package androidx.compose.ui.platform;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DisposableSaveableStateRegistry implements SaveableStateRegistry {
    private final /* synthetic */ SaveableStateRegistry $$delegate_0;

    @NotNull
    private final Function0<Unit> onDispose;

    public DisposableSaveableStateRegistry(@NotNull SaveableStateRegistry saveableStateRegistry, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(saveableStateRegistry, "saveableStateRegistry");
        Intrinsics.checkNotNullParameter(function0, "onDispose");
        this.onDispose = function0;
        this.$$delegate_0 = saveableStateRegistry;
    }

    public boolean canBeSaved(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        return this.$$delegate_0.canBeSaved(obj);
    }

    @Nullable
    public Object consumeRestored(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.$$delegate_0.consumeRestored(str);
    }

    public final void dispose() {
        this.onDispose.invoke();
    }

    @NotNull
    public Map<String, List<Object>> performSave() {
        return this.$$delegate_0.performSave();
    }

    @NotNull
    public SaveableStateRegistry.Entry registerProvider(@NotNull String str, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(function0, "valueProvider");
        return this.$$delegate_0.registerProvider(str, function0);
    }
}
