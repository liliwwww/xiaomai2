package androidx.compose.p004ui.tooling.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@UiToolingDataApi
/* loaded from: classes.dex */
public final class ParameterInformation {
    public static final int $stable = 8;
    private final boolean compared;
    private final boolean fromDefault;

    @Nullable
    private final String inlineClass;

    @NotNull
    private final String name;
    private final boolean stable;

    /* renamed from: static, reason: not valid java name */
    private final boolean f1034static;

    @Nullable
    private final Object value;

    public ParameterInformation(@NotNull String str, @Nullable Object obj, boolean z, boolean z2, boolean z3, @Nullable String str2, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.value = obj;
        this.fromDefault = z;
        this.f1034static = z2;
        this.compared = z3;
        this.inlineClass = str2;
        this.stable = z4;
    }

    public static /* synthetic */ ParameterInformation copy$default(ParameterInformation parameterInformation, String str, Object obj, boolean z, boolean z2, boolean z3, String str2, boolean z4, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = parameterInformation.name;
        }
        if ((i & 2) != 0) {
            obj = parameterInformation.value;
        }
        Object obj3 = obj;
        if ((i & 4) != 0) {
            z = parameterInformation.fromDefault;
        }
        boolean z5 = z;
        if ((i & 8) != 0) {
            z2 = parameterInformation.f1034static;
        }
        boolean z6 = z2;
        if ((i & 16) != 0) {
            z3 = parameterInformation.compared;
        }
        boolean z7 = z3;
        if ((i & 32) != 0) {
            str2 = parameterInformation.inlineClass;
        }
        String str3 = str2;
        if ((i & 64) != 0) {
            z4 = parameterInformation.stable;
        }
        return parameterInformation.copy(str, obj3, z5, z6, z7, str3, z4);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final Object component2() {
        return this.value;
    }

    public final boolean component3() {
        return this.fromDefault;
    }

    public final boolean component4() {
        return this.f1034static;
    }

    public final boolean component5() {
        return this.compared;
    }

    @Nullable
    public final String component6() {
        return this.inlineClass;
    }

    public final boolean component7() {
        return this.stable;
    }

    @NotNull
    public final ParameterInformation copy(@NotNull String str, @Nullable Object obj, boolean z, boolean z2, boolean z3, @Nullable String str2, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ParameterInformation(str, obj, z, z2, z3, str2, z4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParameterInformation)) {
            return false;
        }
        ParameterInformation parameterInformation = (ParameterInformation) obj;
        return Intrinsics.areEqual(this.name, parameterInformation.name) && Intrinsics.areEqual(this.value, parameterInformation.value) && this.fromDefault == parameterInformation.fromDefault && this.f1034static == parameterInformation.f1034static && this.compared == parameterInformation.compared && Intrinsics.areEqual(this.inlineClass, parameterInformation.inlineClass) && this.stable == parameterInformation.stable;
    }

    public final boolean getCompared() {
        return this.compared;
    }

    public final boolean getFromDefault() {
        return this.fromDefault;
    }

    @Nullable
    public final String getInlineClass() {
        return this.inlineClass;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getStable() {
        return this.stable;
    }

    public final boolean getStatic() {
        return this.f1034static;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        Object obj = this.value;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        boolean z = this.fromDefault;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z2 = this.f1034static;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.compared;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        String str = this.inlineClass;
        int hashCode3 = (i6 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z4 = this.stable;
        return hashCode3 + (z4 ? 1 : z4 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "ParameterInformation(name=" + this.name + ", value=" + this.value + ", fromDefault=" + this.fromDefault + ", static=" + this.f1034static + ", compared=" + this.compared + ", inlineClass=" + this.inlineClass + ", stable=" + this.stable + ')';
    }
}
