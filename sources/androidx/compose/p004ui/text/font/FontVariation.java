package androidx.compose.p004ui.text.font;

import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class FontVariation {
    public static final int $stable = 0;

    @NotNull
    public static final FontVariation INSTANCE = new FontVariation();

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes.dex */
    public interface Setting {
        @NotNull
        String getAxisName();

        boolean getNeedsDensity();

        float toVariationValue(@Nullable Density density);
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes.dex */
    private static final class SettingFloat implements Setting {

        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final float value;

        public SettingFloat(@NotNull String str, float f) {
            Intrinsics.checkNotNullParameter(str, "axisName");
            this.axisName = str;
            this.value = f;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingFloat)) {
                return false;
            }
            SettingFloat settingFloat = (SettingFloat) obj;
            if (Intrinsics.areEqual(getAxisName(), settingFloat.getAxisName())) {
                return (this.value > settingFloat.value ? 1 : (this.value == settingFloat.value ? 0 : -1)) == 0;
            }
            return false;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
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

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes.dex */
    private static final class SettingInt implements Setting {

        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final int value;

        public SettingInt(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "axisName");
            this.axisName = str;
            this.value = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingInt)) {
                return false;
            }
            SettingInt settingInt = (SettingInt) obj;
            return Intrinsics.areEqual(getAxisName(), settingInt.getAxisName()) && this.value == settingInt.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
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

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            return this.value;
        }
    }

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
            return Intrinsics.areEqual(getAxisName(), settingTextUnit.getAxisName()) && TextUnit.m5394equalsimpl0(this.value, settingTextUnit.value);
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        /* renamed from: getValue-XSAIIZE, reason: not valid java name */
        public final long m4856getValueXSAIIZE() {
            return this.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + TextUnit.m5398hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + ((Object) TextUnit.m5404toStringimpl(this.value)) + ')';
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            if (density != null) {
                return TextUnit.m5397getValueimpl(this.value) * density.getFontScale();
            }
            throw new IllegalArgumentException("density must not be null".toString());
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes.dex */
    public static final class Settings {
        private final boolean needsDensity;

        @NotNull
        private final List<Setting> settings;

        public Settings(@NotNull Setting... settingArr) {
            Intrinsics.checkNotNullParameter(settingArr, "settings");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z = false;
            for (Setting setting : settingArr) {
                String axisName = setting.getAxisName();
                Object obj = linkedHashMap.get(axisName);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(axisName, obj);
                }
                ((List) obj).add(setting);
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    this.settings = arrayList2;
                    int size = arrayList2.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (((Setting) arrayList2.get(i)).getNeedsDensity()) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    this.needsDensity = z;
                    return;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (!(list.size() == 1)) {
                    throw new IllegalArgumentException(('\'' + str + "' must be unique. Actual [ [" + CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ']').toString());
                }
                CollectionsKt.addAll(arrayList, list);
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Settings) && Intrinsics.areEqual(this.settings, ((Settings) obj).settings);
        }

        public final boolean getNeedsDensity$ui_text_release() {
            return this.needsDensity;
        }

        @NotNull
        public final List<Setting> getSettings() {
            return this.settings;
        }

        public int hashCode() {
            return this.settings.hashCode();
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
    public final Settings m4854Settings6EWAqTQ(@NotNull FontWeight fontWeight, int i, @NotNull Setting... settingArr) {
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
    public final Setting m4855opticalSizingR2X_6o(long j) {
        if (!TextUnit.m5400isSpimpl(j)) {
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
