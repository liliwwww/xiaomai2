package androidx.compose.ui.semantics;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SemanticsProperties$ContentDescription$1 extends Lambda implements Function2<List<? extends String>, List<? extends String>, List<? extends String>> {
    public static final SemanticsProperties$ContentDescription$1 INSTANCE = new SemanticsProperties$ContentDescription$1();

    SemanticsProperties$ContentDescription$1() {
        super(2);
    }

    @Nullable
    public final List<String> invoke(@Nullable List<String> list, @NotNull List<String> list2) {
        List<String> mutableList;
        Intrinsics.checkNotNullParameter(list2, "childValue");
        if (list == null || (mutableList = CollectionsKt.toMutableList(list)) == null) {
            return list2;
        }
        mutableList.addAll(list2);
        return mutableList;
    }
}
