package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$TextIndentSaver$1 extends Lambda implements Function2<SaverScope, TextIndent, Object> {
    public static final SaversKt$TextIndentSaver$1 INSTANCE = new SaversKt$TextIndentSaver$1();

    SaversKt$TextIndentSaver$1() {
        super(2);
    }

    @Nullable
    public final Object invoke(@NotNull SaverScope saverScope, @NotNull TextIndent textIndent) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(textIndent, "it");
        TextUnit m2203boximpl = TextUnit.m2203boximpl(textIndent.getFirstLine-XSAIIZE());
        TextUnit.Companion companion = TextUnit.Companion;
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(m2203boximpl, SaversKt.getSaver(companion), saverScope), SaversKt.save(TextUnit.m2203boximpl(textIndent.getRestLine-XSAIIZE()), SaversKt.getSaver(companion), saverScope)});
    }
}
