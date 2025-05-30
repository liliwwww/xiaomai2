package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FontVariation$SettingInt implements FontVariation$Setting {

    @NotNull
    private final String axisName;
    private final boolean needsDensity;
    private final int value;

    public FontVariation$SettingInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "axisName");
        this.axisName = str;
        this.value = i;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FontVariation$SettingInt)) {
            return false;
        }
        FontVariation$SettingInt fontVariation$SettingInt = (FontVariation$SettingInt) obj;
        return Intrinsics.areEqual(getAxisName(), fontVariation$SettingInt.getAxisName()) && this.value == fontVariation$SettingInt.value;
    }

    @Override // androidx.compose.ui.text.font.FontVariation$Setting
    @NotNull
    public String getAxisName() {
        return this.axisName;
    }

    @Override // androidx.compose.ui.text.font.FontVariation$Setting
    public boolean getNeedsDensity() {
        return this.needsDensity;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (getAxisName().hashCode() * 31) + this.value;
    }

    @NotNull
    public String toString() {
        return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
    }

    @Override // androidx.compose.ui.text.font.FontVariation$Setting
    public float toVariationValue(@Nullable Density density) {
        return this.value;
    }
}
