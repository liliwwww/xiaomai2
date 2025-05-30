package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.ka;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class AbstractApplier<T> implements Applier<T> {
    public static final int $stable = 8;
    private T current;
    private final T root;

    @NotNull
    private final List<T> stack = new ArrayList();

    public AbstractApplier(T t) {
        this.root = t;
        this.current = t;
    }

    public final void clear() {
        this.stack.clear();
        setCurrent(this.root);
        onClear();
    }

    public void down(T t) {
        this.stack.add(getCurrent());
        setCurrent(t);
    }

    public T getCurrent() {
        return this.current;
    }

    public final T getRoot() {
        return this.root;
    }

    protected final void move(@NotNull List<T> list, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int i4 = i > i2 ? i2 : i2 - i3;
        if (i3 != 1) {
            List<T> subList = list.subList(i, i3 + i);
            List mutableList = CollectionsKt.toMutableList(subList);
            subList.clear();
            list.addAll(i4, mutableList);
            return;
        }
        if (i == i2 + 1 || i == i2 - 1) {
            list.set(i, list.set(i2, list.get(i)));
        } else {
            list.add(i4, list.remove(i));
        }
    }

    public /* synthetic */ void onBeginChanges() {
        ka.a(this);
    }

    protected abstract void onClear();

    public /* synthetic */ void onEndChanges() {
        ka.b(this);
    }

    protected final void remove(@NotNull List<T> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i2 == 1) {
            list.remove(i);
        } else {
            list.subList(i, i2 + i).clear();
        }
    }

    protected void setCurrent(T t) {
        this.current = t;
    }

    public void up() {
        if (!(!this.stack.isEmpty())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        setCurrent(this.stack.remove(r0.size() - 1));
    }
}
