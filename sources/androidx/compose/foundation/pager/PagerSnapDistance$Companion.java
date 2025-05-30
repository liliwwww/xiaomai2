package androidx.compose.foundation.pager;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PagerSnapDistance$Companion {
    static final /* synthetic */ PagerSnapDistance$Companion $$INSTANCE = new PagerSnapDistance$Companion();

    private PagerSnapDistance$Companion() {
    }

    @NotNull
    public final PagerSnapDistance atMost(int i) {
        if (i >= 0) {
            return new PagerSnapDistanceMaxPages(i);
        }
        throw new IllegalArgumentException(("pages should be greater than or equal to 0. You have used " + i + '.').toString());
    }
}
