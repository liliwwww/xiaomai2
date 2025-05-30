package androidx.compose.p004ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: classes.dex */
public final class AutofillApi26Helper {

    @NotNull
    public static final AutofillApi26Helper INSTANCE = new AutofillApi26Helper();

    private AutofillApi26Helper() {
    }

    @DoNotInline
    @RequiresApi(26)
    @Nullable
    public final AutofillId getAutofillId(@NotNull ViewStructure viewStructure) {
        Intrinsics.checkNotNullParameter(viewStructure, "structure");
        return viewStructure.getAutofillId();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isDate(@NotNull AutofillValue autofillValue) {
        Intrinsics.checkNotNullParameter(autofillValue, "value");
        return autofillValue.isDate();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isList(@NotNull AutofillValue autofillValue) {
        Intrinsics.checkNotNullParameter(autofillValue, "value");
        return autofillValue.isList();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isText(@NotNull AutofillValue autofillValue) {
        Intrinsics.checkNotNullParameter(autofillValue, "value");
        return autofillValue.isText();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isToggle(@NotNull AutofillValue autofillValue) {
        Intrinsics.checkNotNullParameter(autofillValue, "value");
        return autofillValue.isToggle();
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillHints(@NotNull ViewStructure viewStructure, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(viewStructure, "structure");
        Intrinsics.checkNotNullParameter(strArr, "hints");
        viewStructure.setAutofillHints(strArr);
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillId(@NotNull ViewStructure viewStructure, @NotNull AutofillId autofillId, int i) {
        Intrinsics.checkNotNullParameter(viewStructure, "structure");
        Intrinsics.checkNotNullParameter(autofillId, "parent");
        viewStructure.setAutofillId(autofillId, i);
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillType(@NotNull ViewStructure viewStructure, int i) {
        Intrinsics.checkNotNullParameter(viewStructure, "structure");
        viewStructure.setAutofillType(i);
    }

    @DoNotInline
    @RequiresApi(26)
    @NotNull
    public final CharSequence textValue(@NotNull AutofillValue autofillValue) {
        Intrinsics.checkNotNullParameter(autofillValue, "value");
        CharSequence textValue = autofillValue.getTextValue();
        Intrinsics.checkNotNullExpressionValue(textValue, "value.textValue");
        return textValue;
    }
}
