package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Stable;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface InteractionSource {
    @NotNull
    Flow<Interaction> getInteractions();
}
