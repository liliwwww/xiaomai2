package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface RememberManager {
    void forgetting(@NotNull RememberObserver rememberObserver);

    void remembering(@NotNull RememberObserver rememberObserver);

    void sideEffect(@NotNull Function0<Unit> function0);
}
