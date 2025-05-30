package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface RecomposerInfo {
    long getChangeCount();

    boolean getHasPendingWork();

    @NotNull
    Flow<Recomposer.State> getState();
}
