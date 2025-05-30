package androidx.compose.foundation.text;

import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.input.OffsetMapping;
import androidx.compose.p004ui.text.input.TransformedText;
import androidx.compose.p004ui.text.input.VisualTransformation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ValidatingOffsetMappingKt {

    @NotNull
    private static final OffsetMapping ValidatingEmptyOffsetMappingIdentity = new ValidatingOffsetMapping(OffsetMapping.Companion.getIdentity(), 0, 0);

    @NotNull
    public static final TransformedText filterWithValidation(@NotNull VisualTransformation visualTransformation, @NotNull AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(visualTransformation, "<this>");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        TransformedText filter = visualTransformation.filter(annotatedString);
        return new TransformedText(filter.getText(), new ValidatingOffsetMapping(filter.getOffsetMapping(), annotatedString.length(), filter.getText().length()));
    }

    @NotNull
    public static final OffsetMapping getValidatingEmptyOffsetMappingIdentity() {
        return ValidatingEmptyOffsetMappingIdentity;
    }
}
