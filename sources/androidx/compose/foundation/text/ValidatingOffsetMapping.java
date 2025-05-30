package androidx.compose.foundation.text;

import androidx.compose.p004ui.text.input.OffsetMapping;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class ValidatingOffsetMapping implements OffsetMapping {

    @NotNull
    private final OffsetMapping delegate;
    private final int originalLength;
    private final int transformedLength;

    public ValidatingOffsetMapping(@NotNull OffsetMapping offsetMapping, int i, int i2) {
        Intrinsics.checkNotNullParameter(offsetMapping, "delegate");
        this.delegate = offsetMapping;
        this.originalLength = i;
        this.transformedLength = i2;
    }

    @Override // androidx.compose.p004ui.text.input.OffsetMapping
    public int originalToTransformed(int i) {
        int originalToTransformed = this.delegate.originalToTransformed(i);
        boolean z = false;
        if (originalToTransformed >= 0 && originalToTransformed <= this.transformedLength) {
            z = true;
        }
        if (z) {
            return originalToTransformed;
        }
        throw new IllegalStateException(("OffsetMapping.originalToTransformed returned invalid mapping: " + i + " -> " + originalToTransformed + " is not in range of transformed text [0, " + this.transformedLength + ']').toString());
    }

    @Override // androidx.compose.p004ui.text.input.OffsetMapping
    public int transformedToOriginal(int i) {
        int transformedToOriginal = this.delegate.transformedToOriginal(i);
        boolean z = false;
        if (transformedToOriginal >= 0 && transformedToOriginal <= this.originalLength) {
            z = true;
        }
        if (z) {
            return transformedToOriginal;
        }
        throw new IllegalStateException(("OffsetMapping.transformedToOriginal returned invalid mapping: " + i + " -> " + transformedToOriginal + " is not in range of original text [0, " + this.originalLength + ']').toString());
    }
}
