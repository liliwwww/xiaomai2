package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$AnnotatedStringSaver$1 extends Lambda implements Function2<SaverScope, AnnotatedString, Object> {
    public static final SaversKt$AnnotatedStringSaver$1 INSTANCE = new SaversKt$AnnotatedStringSaver$1();

    SaversKt$AnnotatedStringSaver$1() {
        super(2);
    }

    @Nullable
    public final Object invoke(@NotNull SaverScope saverScope, @NotNull AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(annotatedString, "it");
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(annotatedString.getText()), SaversKt.save(annotatedString.getSpanStyles(), SaversKt.access$getAnnotationRangeListSaver$p(), saverScope), SaversKt.save(annotatedString.getParagraphStyles(), SaversKt.access$getAnnotationRangeListSaver$p(), saverScope), SaversKt.save(annotatedString.getAnnotations$ui_text_release(), SaversKt.access$getAnnotationRangeListSaver$p(), saverScope)});
    }
}
