package androidx.compose.ui.node;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MergedViewAdapter implements ViewAdapter {

    @NotNull
    private final List<ViewAdapter> adapters = new ArrayList();
    private final int id;

    public void didInsert(@NotNull View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).didInsert(view, viewGroup);
        }
    }

    public void didUpdate(@NotNull View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).didUpdate(view, viewGroup);
        }
    }

    @NotNull
    public final <T extends ViewAdapter> T get(int i, @NotNull Function0<? extends T> function0) {
        ViewAdapter viewAdapter;
        Intrinsics.checkNotNullParameter(function0, "factory");
        List<ViewAdapter> adapters = getAdapters();
        int size = adapters.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewAdapter = null;
                break;
            }
            viewAdapter = adapters.get(i2);
            if (viewAdapter.getId() == i) {
                break;
            }
            i2++;
        }
        T t = viewAdapter instanceof ViewAdapter ? (T) viewAdapter : null;
        if (t != null) {
            return t;
        }
        T t2 = (T) function0.invoke();
        getAdapters().add(t2);
        return t2;
    }

    @NotNull
    public final List<ViewAdapter> getAdapters() {
        return this.adapters;
    }

    public int getId() {
        return this.id;
    }

    public void willInsert(@NotNull View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).willInsert(view, viewGroup);
        }
    }
}
