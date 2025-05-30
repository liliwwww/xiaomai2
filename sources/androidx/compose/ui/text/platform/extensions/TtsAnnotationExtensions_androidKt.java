package androidx.compose.ui.text.platform.extensions;

import android.text.style.TtsSpan;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.VerbatimTtsAnnotation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TtsAnnotationExtensions_androidKt {
    @NotNull
    public static final TtsSpan toSpan(@NotNull TtsAnnotation ttsAnnotation) {
        Intrinsics.checkNotNullParameter(ttsAnnotation, "<this>");
        if (ttsAnnotation instanceof VerbatimTtsAnnotation) {
            return toSpan((VerbatimTtsAnnotation) ttsAnnotation);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final TtsSpan toSpan(@NotNull VerbatimTtsAnnotation verbatimTtsAnnotation) {
        Intrinsics.checkNotNullParameter(verbatimTtsAnnotation, "<this>");
        TtsSpan build = new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.getVerbatim()).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
