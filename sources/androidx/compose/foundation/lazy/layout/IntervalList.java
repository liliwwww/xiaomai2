package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface IntervalList<T> {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 1)
    public static final class Interval<T> {
        public static final int $stable = 0;
        private final int size;
        private final int startIndex;
        private final T value;

        public Interval(int i, int i2, T t) {
            this.startIndex = i;
            this.size = i2;
            this.value = t;
            if (!(i >= 0)) {
                throw new IllegalArgumentException(("startIndex should be >= 0, but was " + i).toString());
            }
            if (i2 > 0) {
                return;
            }
            throw new IllegalArgumentException(("size should be >0, but was " + i2).toString());
        }

        public final int getSize() {
            return this.size;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final T getValue() {
            return this.value;
        }
    }

    void forEach(int i, int i2, @NotNull Function1<? super Interval<? extends T>, Unit> function1);

    @NotNull
    Interval<T> get(int i);

    int getSize();
}
