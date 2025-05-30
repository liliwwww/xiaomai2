package androidx.compose.p004ui.tooling.preview;

import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import tb.iy3;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface PreviewParameterProvider<T> {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> int getCount(@NotNull PreviewParameterProvider<T> previewParameterProvider) {
            return iy3.b(previewParameterProvider);
        }
    }

    int getCount();

    @NotNull
    Sequence<T> getValues();
}
