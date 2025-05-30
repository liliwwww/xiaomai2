package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SemanticsProperties$TestTag$1 extends Lambda implements Function2<String, String, String> {
    public static final SemanticsProperties$TestTag$1 INSTANCE = new SemanticsProperties$TestTag$1();

    SemanticsProperties$TestTag$1() {
        super(2);
    }

    @Nullable
    public final String invoke(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
        return str;
    }
}
