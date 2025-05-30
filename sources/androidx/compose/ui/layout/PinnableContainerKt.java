package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PinnableContainerKt {

    @NotNull
    private static final ProvidableCompositionLocal<PinnableContainer> LocalPinnableContainer = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0<PinnableContainer>() { // from class: androidx.compose.ui.layout.PinnableContainerKt$LocalPinnableContainer$1
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PinnableContainer m1560invoke() {
            return null;
        }
    }, 1, (Object) null);

    @NotNull
    public static final ProvidableCompositionLocal<PinnableContainer> getLocalPinnableContainer() {
        return LocalPinnableContainer;
    }
}
