package androidx.compose.runtime.saveable;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface SaveableStateRegistry {

    /* compiled from: Taobao */
    public interface Entry {
        void unregister();
    }

    boolean canBeSaved(@NotNull Object obj);

    @Nullable
    Object consumeRestored(@NotNull String str);

    @NotNull
    Map<String, List<Object>> performSave();

    @NotNull
    Entry registerProvider(@NotNull String str, @NotNull Function0<? extends Object> function0);
}
