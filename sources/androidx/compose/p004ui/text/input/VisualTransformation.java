package androidx.compose.p004ui.text.input;

import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public interface VisualTransformation {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final VisualTransformation None = new VisualTransformation() { // from class: androidx.compose.ui.text.input.VisualTransformation$Companion$None$1
            @Override // androidx.compose.p004ui.text.input.VisualTransformation
            @NotNull
            public final TransformedText filter(@NotNull AnnotatedString annotatedString) {
                Intrinsics.checkNotNullParameter(annotatedString, "text");
                return new TransformedText(annotatedString, OffsetMapping.Companion.getIdentity());
            }
        };

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        @NotNull
        public final VisualTransformation getNone() {
            return None;
        }
    }

    @NotNull
    TransformedText filter(@NotNull AnnotatedString annotatedString);
}
