package androidx.compose.foundation.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BasicTextKt$selectionIdSaver$2 extends Lambda implements Function1<Long, Long> {
    public static final BasicTextKt$selectionIdSaver$2 INSTANCE = new BasicTextKt$selectionIdSaver$2();

    BasicTextKt$selectionIdSaver$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    @Nullable
    public final Long invoke(long j) {
        return Long.valueOf(j);
    }
}
