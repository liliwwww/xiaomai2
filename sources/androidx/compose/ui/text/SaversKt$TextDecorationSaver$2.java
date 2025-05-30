package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDecoration;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$TextDecorationSaver$2 extends Lambda implements Function1<Object, TextDecoration> {
    public static final SaversKt$TextDecorationSaver$2 INSTANCE = new SaversKt$TextDecorationSaver$2();

    SaversKt$TextDecorationSaver$2() {
        super(1);
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final TextDecoration m1879invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return new TextDecoration(((Integer) obj).intValue());
    }
}
