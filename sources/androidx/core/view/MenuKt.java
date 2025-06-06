package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MenuKt {
    public static final boolean contains(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu menu, @NotNull Function1<? super MenuItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(index)");
            function1.invoke(item);
        }
    }

    public static final void forEachIndexed(@NotNull Menu menu, @NotNull Function2<? super Integer, ? super MenuItem, Unit> function2) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            Integer valueOf = Integer.valueOf(i);
            MenuItem item = menu.getItem(i);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(index)");
            function2.invoke(valueOf, item);
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu menu, int i) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        MenuItem item = menu.getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(index)");
        return item;
    }

    @NotNull
    public static final Sequence<MenuItem> getChildren(@NotNull final Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        return new Sequence<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @NotNull
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        return menu.size();
    }

    public static final boolean isEmpty(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        return menu.size() != 0;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        Intrinsics.checkNotNullParameter(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(@NotNull Menu menu, int i) {
        Unit unit;
        Intrinsics.checkNotNullParameter(menu, "<this>");
        MenuItem item = menu.getItem(i);
        if (item != null) {
            menu.removeItem(item.getItemId());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
