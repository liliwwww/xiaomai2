package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ViewGroupKt$children$1 implements Sequence<View> {
    final /* synthetic */ ViewGroup $this_children;

    ViewGroupKt$children$1(ViewGroup viewGroup) {
        this.$this_children = viewGroup;
    }

    @NotNull
    public Iterator<View> iterator() {
        return ViewGroupKt.iterator(this.$this_children);
    }
}
