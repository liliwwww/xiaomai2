package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: classes.dex */
public interface LazyGridItemProvider extends LazyLayoutItemProvider {
    boolean getHasCustomSpans();

    /* renamed from: getSpan-_-orMbw, reason: not valid java name */
    long mo1570getSpan_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i);

    @NotNull
    LazyGridSpanLayoutProvider getSpanLayoutProvider();
}
