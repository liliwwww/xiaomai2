package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FontVariation {
    public static final int $stable = 0;

    @NotNull
    public static final FontVariation INSTANCE = new FontVariation();

    /* compiled from: Taobao */
    @Immutable
    private static final class SettingTextUnit implements Setting {

        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final long value;

        private SettingTextUnit(String str, long j) {
            this.axisName = str;
            this.value = j;
            this.needsDensity = true;
        }

        public /* synthetic */ SettingTextUnit(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingTextUnit)) {
                return false;
            }
            SettingTextUnit settingTextUnit = (SettingTextUnit) obj;
            return Intrinsics.areEqual(getAxisName(), settingTextUnit.getAxisName()) && TextUnit.equals-impl0(this.value, settingTextUnit.value);
        }

        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        /* renamed from: getValue-XSAIIZE, reason: not valid java name */
        public final long m2401getValueXSAIIZE() {
            return this.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + TextUnit.hashCode-impl(this.value);
        }

        @NotNull
        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + ((Object) TextUnit.toString-impl(this.value)) + ')';
        }

        public float toVariationValue(@Nullable Density density) {
            if (density != null) {
                return TextUnit.getValue-impl(this.value) * density.getFontScale();
            }
            throw new IllegalArgumentException("density must not be null".toString());
        }
    }

    private FontVariation() {
    }

    @NotNull
    public final Setting Setting(@NotNull String str, float f) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (str.length() == 4) {
            return new SettingFloat(str, f);
        }
        throw new IllegalArgumentException(("Name must be exactly four characters. Actual: '" + str + '\'').toString());
    }

    @NotNull
    /* renamed from: Settings-6EWAqTQ, reason: not valid java name */
    public final Settings m2399Settings6EWAqTQ(@NotNull FontWeight fontWeight, int i, @NotNull Setting... settingArr) {
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settingArr, "settings");
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(weight(fontWeight.getWeight()));
        spreadBuilder.add(italic(i));
        spreadBuilder.addSpread(settingArr);
        return new Settings((Setting[]) spreadBuilder.toArray(new Setting[spreadBuilder.size()]));
    }

    @NotNull
    public final Setting grade(int i) {
        boolean z = false;
        if (-1000 <= i && i < 1001) {
            z = true;
        }
        if (z) {
            return new SettingInt("GRAD", i);
        }
        throw new IllegalArgumentException("'GRAD' must be in -1000..1000".toString());
    }

    @NotNull
    public final Setting italic(float f) {
        boolean z = false;
        if (0.0f <= f && f <= 1.0f) {
            z = true;
        }
        if (z) {
            return new SettingFloat("ital", f);
        }
        throw new IllegalArgumentException(("'ital' must be in 0.0f..1.0f. Actual: " + f).toString());
    }

    @NotNull
    /* renamed from: opticalSizing--R2X_6o, reason: not valid java name */
    public final Setting m2400opticalSizingR2X_6o(long j) {
        if (!TextUnit.isSp-impl(j)) {
            throw new IllegalArgumentException("'opsz' must be provided in sp units".toString());
        }
        return new SettingTextUnit("opsz", j, null);
    }

    @NotNull
    public final Setting slant(float f) {
        boolean z = false;
        if (-90.0f <= f && f <= 90.0f) {
            z = true;
        }
        if (z) {
            return new SettingFloat("slnt", f);
        }
        throw new IllegalArgumentException(("'slnt' must be in -90f..90f. Actual: " + f).toString());
    }

    @NotNull
    public final Setting weight(int i) {
        boolean z = false;
        if (1 <= i && i < 1001) {
            z = true;
        }
        if (z) {
            return new SettingInt("wght", i);
        }
        throw new IllegalArgumentException(("'wght' value must be in [1, 1000]. Actual: " + i).toString());
    }

    @NotNull
    public final Setting width(float f) {
        if (f > 0.0f) {
            return new SettingFloat("wdth", f);
        }
        throw new IllegalArgumentException(("'wdth' must be strictly > 0.0f. Actual: " + f).toString());
    }
}
