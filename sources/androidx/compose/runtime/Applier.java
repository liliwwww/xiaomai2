package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import tb.ka;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Applier<N> {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static <N> void onBeginChanges(@NotNull Applier<N> applier) {
            ka.c(applier);
        }

        @Deprecated
        public static <N> void onEndChanges(@NotNull Applier<N> applier) {
            ka.d(applier);
        }
    }

    void clear();

    void down(N n);

    N getCurrent();

    void insertBottomUp(int i, N n);

    void insertTopDown(int i, N n);

    void move(int i, int i2, int i3);

    void onBeginChanges();

    void onEndChanges();

    void remove(int i, int i2);

    void up();
}
