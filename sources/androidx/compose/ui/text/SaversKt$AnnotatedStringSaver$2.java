package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$AnnotatedStringSaver$2 extends Lambda implements Function1<Object, AnnotatedString> {
    public static final SaversKt$AnnotatedStringSaver$2 INSTANCE = new SaversKt$AnnotatedStringSaver$2();

    SaversKt$AnnotatedStringSaver$2() {
        super(1);
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final AnnotatedString m1872invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        List list2 = null;
        String str = obj2 != null ? (String) obj2 : null;
        Intrinsics.checkNotNull(str);
        Object obj3 = list.get(1);
        Saver access$getAnnotationRangeListSaver$p = SaversKt.access$getAnnotationRangeListSaver$p();
        Boolean bool = Boolean.FALSE;
        List list3 = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : (List) access$getAnnotationRangeListSaver$p.restore(obj3);
        Intrinsics.checkNotNull(list3);
        Object obj4 = list.get(2);
        List list4 = (Intrinsics.areEqual(obj4, bool) || obj4 == null) ? null : (List) SaversKt.access$getAnnotationRangeListSaver$p().restore(obj4);
        Intrinsics.checkNotNull(list4);
        Object obj5 = list.get(3);
        Saver access$getAnnotationRangeListSaver$p2 = SaversKt.access$getAnnotationRangeListSaver$p();
        if (!Intrinsics.areEqual(obj5, bool) && obj5 != null) {
            list2 = (List) access$getAnnotationRangeListSaver$p2.restore(obj5);
        }
        Intrinsics.checkNotNull(list2);
        return new AnnotatedString(str, list3, list4, list2);
    }
}
