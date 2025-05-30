package androidx.core.location;

import android.location.Location;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LocationKt {
    public static final double component1(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "<this>");
        return com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location);
    }

    public static final double component2(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "<this>");
        return com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location);
    }
}
