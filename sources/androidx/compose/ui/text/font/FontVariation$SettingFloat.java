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
public final class FontVariation$SettingFloat implements FontVariation$Setting {

    @NotNull
    private final String axisName;
    private final boolean needsDensity;
    private final float value;

    public FontVariation$SettingFloat(@NotNull String str, float f) {
        Intrinsics.checkNotNullParameter(str, "axisName");
        this.axisName = str;
        this.value = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FontVariation$SettingFloat)) {
            return false;
        }
        FontVariation$SettingFloat fontVariation$SettingFloat = (FontVariation$SettingFloat) obj;
        if (Intrinsics.areEqual(getAxisName(), fontVariation$SettingFloat.getAxisName())) {
            return (this.value > fontVariation$SettingFloat.value ? 1 : (this.value == fontVariation$SettingFloat.value ? 0 : -1)) == 0;
        }
        return false;
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

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return (getAxisName().hashCode() * 31) + Float.floatToIntBits(this.value);
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
