package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyGridSpanLayoutProvider$Bucket {
    private final int firstItemIndex;
    private final int firstItemKnownSpan;

    public LazyGridSpanLayoutProvider$Bucket(int i, int i2) {
        this.firstItemIndex = i;
        this.firstItemKnownSpan = i2;
    }

    public final int getFirstItemIndex() {
        return this.firstItemIndex;
    }

    public final int getFirstItemKnownSpan() {
        return this.firstItemKnownSpan;
    }

    public /* synthetic */ LazyGridSpanLayoutProvider$Bucket(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }
}
