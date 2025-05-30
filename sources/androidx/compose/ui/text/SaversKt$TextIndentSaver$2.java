package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$TextIndentSaver$2 extends Lambda implements Function1<Object, TextIndent> {
    public static final SaversKt$TextIndentSaver$2 INSTANCE = new SaversKt$TextIndentSaver$2();

    SaversKt$TextIndentSaver$2() {
        super(1);
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final TextIndent m1880invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextUnit.Companion companion = TextUnit.Companion;
        Saver saver = SaversKt.getSaver(companion);
        Boolean bool = Boolean.FALSE;
        TextUnit textUnit = null;
        TextUnit textUnit2 = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : (TextUnit) saver.restore(obj2);
        Intrinsics.checkNotNull(textUnit2);
        long m2222unboximpl = textUnit2.m2222unboximpl();
        Object obj3 = list.get(1);
        Saver saver2 = SaversKt.getSaver(companion);
        if (!Intrinsics.areEqual(obj3, bool) && obj3 != null) {
            textUnit = (TextUnit) saver2.restore(obj3);
        }
        Intrinsics.checkNotNull(textUnit);
        return new TextIndent(m2222unboximpl, textUnit.m2222unboximpl(), (DefaultConstructorMarker) null);
    }
}
