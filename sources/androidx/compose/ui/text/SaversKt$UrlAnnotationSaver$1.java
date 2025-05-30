package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$UrlAnnotationSaver$1 extends Lambda implements Function2<SaverScope, UrlAnnotation, Object> {
    public static final SaversKt$UrlAnnotationSaver$1 INSTANCE = new SaversKt$UrlAnnotationSaver$1();

    SaversKt$UrlAnnotationSaver$1() {
        super(2);
    }

    @Nullable
    public final Object invoke(@NotNull SaverScope saverScope, @NotNull UrlAnnotation urlAnnotation) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(urlAnnotation, "it");
        return SaversKt.save(urlAnnotation.getUrl());
    }
}
