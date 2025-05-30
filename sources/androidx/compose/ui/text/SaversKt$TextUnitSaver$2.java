package androidx.compose.ui.text;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$TextUnitSaver$2 extends Lambda implements Function1<Object, TextUnit> {
    public static final SaversKt$TextUnitSaver$2 INSTANCE = new SaversKt$TextUnitSaver$2();

    SaversKt$TextUnitSaver$2() {
        super(1);
    }

    @Nullable
    /* renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
    public final TextUnit invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f = obj2 != null ? (Float) obj2 : null;
        Intrinsics.checkNotNull(f);
        float floatValue = f.floatValue();
        Object obj3 = list.get(1);
        TextUnitType textUnitType = obj3 != null ? (TextUnitType) obj3 : null;
        Intrinsics.checkNotNull(textUnitType);
        return TextUnit.m2203boximpl(TextUnitKt.m2225TextUnitanM5pPY(floatValue, textUnitType.unbox-impl()));
    }
}
