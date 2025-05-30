package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: classes2.dex */
public interface PagerSnapDistance {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final PagerSnapDistance atMost(int i) {
            if (i >= 0) {
                return new PagerSnapDistanceMaxPages(i);
            }
            throw new IllegalArgumentException(("pages should be greater than or equal to 0. You have used " + i + '.').toString());
        }
    }

    int calculateTargetPage(int i, int i2, float f, int i3, int i4);
}
