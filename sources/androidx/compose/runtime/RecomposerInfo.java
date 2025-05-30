package androidx.compose.runtime;

import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface RecomposerInfo {
    long getChangeCount();

    boolean getHasPendingWork();

    @NotNull
    Flow<Recomposer$State> getState();
}
