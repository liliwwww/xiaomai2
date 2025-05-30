package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultDelegatingLazyLayoutItemProvider implements LazyLayoutItemProvider {

    @NotNull
    private final State<LazyLayoutItemProvider> delegate;

    public DefaultDelegatingLazyLayoutItemProvider(@NotNull State<? extends LazyLayoutItemProvider> state) {
        Intrinsics.checkNotNullParameter(state, "delegate");
        this.delegate = state;
    }

    @Composable
    public void Item(int i, @Nullable Composer composer, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1633511187);
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i3 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1633511187, i3, -1, "androidx.compose.foundation.lazy.layout.DefaultDelegatingLazyLayoutItemProvider.Item (LazyLayoutItemProvider.kt:194)");
            }
            this.delegate.getValue().Item(i, startRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Item.1(this, i, i2));
    }

    @Nullable
    public Object getContentType(int i) {
        return this.delegate.getValue().getContentType(i);
    }

    public int getItemCount() {
        return this.delegate.getValue().getItemCount();
    }

    @NotNull
    public Object getKey(int i) {
        return this.delegate.getValue().getKey(i);
    }

    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.delegate.getValue().getKeyToIndexMap();
    }
}
