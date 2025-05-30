package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$ShadowSaver$2 extends Lambda implements Function1<Object, Shadow> {
    public static final SaversKt$ShadowSaver$2 INSTANCE = new SaversKt$ShadowSaver$2();

    SaversKt$ShadowSaver$2() {
        super(1);
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Shadow m1877invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver saver = SaversKt.getSaver(Color.Companion);
        Boolean bool = Boolean.FALSE;
        Color color = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : (Color) saver.restore(obj2);
        Intrinsics.checkNotNull(color);
        long m1060unboximpl = color.m1060unboximpl();
        Object obj3 = list.get(1);
        Offset offset = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : (Offset) SaversKt.getSaver(Offset.Companion).restore(obj3);
        Intrinsics.checkNotNull(offset);
        long m858unboximpl = offset.m858unboximpl();
        Object obj4 = list.get(2);
        Float f = obj4 != null ? (Float) obj4 : null;
        Intrinsics.checkNotNull(f);
        return new Shadow(m1060unboximpl, m858unboximpl, f.floatValue(), null);
    }
}
