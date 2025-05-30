package androidx.compose.foundation.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class KeyboardOptions {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final KeyboardOptions Default = new KeyboardOptions(0, false, 0, 0, 15, null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }

        @NotNull
        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3) {
        this.capitalization = i;
        this.autoCorrect = z;
        this.keyboardType = i2;
        this.imeAction = i3;
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3);
    }

    /* renamed from: copy-3m2b7yw$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m559copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.autoCorrect;
        }
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m560copy3m2b7yw(i, z, i2, i3);
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ImeOptions.Companion.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z);
    }

    @NotNull
    /* renamed from: copy-3m2b7yw, reason: not valid java name */
    public final KeyboardOptions m560copy3m2b7yw(int i, boolean z, int i2, int i3) {
        return new KeyboardOptions(i, z, i2, i3, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        return KeyboardCapitalization.m2429equalsimpl0(this.capitalization, keyboardOptions.capitalization) && this.autoCorrect == keyboardOptions.autoCorrect && KeyboardType.equals-impl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.equals-impl0(this.imeAction, keyboardOptions.imeAction);
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getCapitalization-IUNYP9k, reason: not valid java name */
    public final int m561getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getImeAction-eUduSuo, reason: not valid java name */
    public final int m562getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* renamed from: getKeyboardType-PjHm6EE, reason: not valid java name */
    public final int m563getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public int hashCode() {
        return (((((KeyboardCapitalization.m2430hashCodeimpl(this.capitalization) * 31) + l3.a(this.autoCorrect)) * 31) + KeyboardType.hashCode-impl(this.keyboardType)) * 31) + ImeAction.hashCode-impl(this.imeAction);
    }

    @NotNull
    public final ImeOptions toImeOptions$foundation_release(boolean z) {
        return new ImeOptions(z, this.capitalization, this.autoCorrect, this.keyboardType, this.imeAction, (DefaultConstructorMarker) null);
    }

    @NotNull
    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m2431toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.toString-impl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.toString-impl(this.imeAction)) + ')';
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.Companion.m2438getNoneIUNYP9k() : i, (i4 & 2) != 0 ? true : z, (i4 & 4) != 0 ? KeyboardType.Companion.m2457getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.Companion.getDefault-eUduSuo() : i3, null);
    }
}
