package androidx.compose.ui.node;

import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ViewInterop_androidKt {
    private static final int viewAdaptersKey = tagKey("ViewAdapter");

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @NotNull
    public static final <T extends ViewAdapter> T getOrAddAdapter(@NotNull View view, int i, @NotNull Function0<? extends T> function0) {
        ViewAdapter viewAdapter;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "factory");
        MergedViewAdapter viewAdapter2 = getViewAdapter(view);
        List<ViewAdapter> adapters = viewAdapter2.getAdapters();
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
        viewAdapter2.getAdapters().add(t2);
        return t2;
    }

    @NotNull
    public static final MergedViewAdapter getViewAdapter(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int i = viewAdaptersKey;
        Object tag = view.getTag(i);
        MergedViewAdapter mergedViewAdapter = tag instanceof MergedViewAdapter ? (MergedViewAdapter) tag : null;
        if (mergedViewAdapter != null) {
            return mergedViewAdapter;
        }
        MergedViewAdapter mergedViewAdapter2 = new MergedViewAdapter();
        view.setTag(i, mergedViewAdapter2);
        return mergedViewAdapter2;
    }

    @Nullable
    public static final MergedViewAdapter getViewAdapterIfExists(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(viewAdaptersKey);
        if (tag instanceof MergedViewAdapter) {
            return (MergedViewAdapter) tag;
        }
        return null;
    }

    public static final int tagKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return str.hashCode() | 50331648;
    }
}
