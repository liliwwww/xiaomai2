package androidx.compose.ui.tooling.data;

import java.lang.reflect.Field;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SlotTreeKt$extractParameterInfo$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(((Field) t).getName(), ((Field) t2).getName());
    }
}
