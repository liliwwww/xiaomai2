package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.LocaleList;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AnnotatedStringKt$toLowerCase$1 extends Lambda implements Function3<String, Integer, Integer, String> {
    final /* synthetic */ LocaleList $localeList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnnotatedStringKt$toLowerCase$1(LocaleList localeList) {
        super(3);
        this.$localeList = localeList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
    }

    @NotNull
    public final String invoke(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "str");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringKt.toLowerCase(substring, this.$localeList);
    }
}
