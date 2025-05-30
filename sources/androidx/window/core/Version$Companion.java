package androidx.window.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0019\u0010\u0006\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u0019\u0010\u000e\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/window/core/Version$Companion;", "", "", "versionString", "Landroidx/window/core/Version;", "parse", "UNKNOWN", "Landroidx/window/core/Version;", "getUNKNOWN", "()Landroidx/window/core/Version;", "VERSION_0_1", "getVERSION_0_1", "VERSION_1_0", "getVERSION_1_0", "CURRENT", "getCURRENT", "VERSION_PATTERN_STRING", "Ljava/lang/String;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Version$Companion {
    private Version$Companion() {
    }

    public /* synthetic */ Version$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Version getCURRENT() {
        return Version.access$getCURRENT$cp();
    }

    @NotNull
    public final Version getUNKNOWN() {
        return Version.access$getUNKNOWN$cp();
    }

    @NotNull
    public final Version getVERSION_0_1() {
        return Version.access$getVERSION_0_1$cp();
    }

    @NotNull
    public final Version getVERSION_1_0() {
        return Version.access$getVERSION_1_0$cp();
    }

    @JvmStatic
    @Nullable
    public final Version parse(@Nullable String versionString) {
        if (versionString == null || StringsKt.isBlank(versionString)) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(versionString);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        Integer valueOf = group == null ? null : Integer.valueOf(Integer.parseInt(group));
        if (valueOf == null) {
            return null;
        }
        int intValue = valueOf.intValue();
        String group2 = matcher.group(2);
        Integer valueOf2 = group2 == null ? null : Integer.valueOf(Integer.parseInt(group2));
        if (valueOf2 == null) {
            return null;
        }
        int intValue2 = valueOf2.intValue();
        String group3 = matcher.group(3);
        Integer valueOf3 = group3 == null ? null : Integer.valueOf(Integer.parseInt(group3));
        if (valueOf3 == null) {
            return null;
        }
        int intValue3 = valueOf3.intValue();
        String group4 = matcher.group(4) != null ? matcher.group(4) : "";
        Intrinsics.checkNotNullExpressionValue(group4, "description");
        return new Version(intValue, intValue2, intValue3, group4, (DefaultConstructorMarker) null);
    }
}
