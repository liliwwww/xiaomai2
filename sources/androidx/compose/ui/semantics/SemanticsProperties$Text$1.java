package androidx.compose.ui.semantics;

import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SemanticsProperties$Text$1 extends Lambda implements Function2<List<? extends AnnotatedString>, List<? extends AnnotatedString>, List<? extends AnnotatedString>> {
    public static final SemanticsProperties$Text$1 INSTANCE = new SemanticsProperties$Text$1();

    SemanticsProperties$Text$1() {
        super(2);
    }

    @Nullable
    public final List<AnnotatedString> invoke(@Nullable List<AnnotatedString> list, @NotNull List<AnnotatedString> list2) {
        List<AnnotatedString> mutableList;
        Intrinsics.checkNotNullParameter(list2, "childValue");
        if (list == null || (mutableList = CollectionsKt.toMutableList(list)) == null) {
            return list2;
        }
        mutableList.addAll(list2);
        return mutableList;
    }
}
