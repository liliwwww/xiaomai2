package androidx.activity.result;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ActivityResultKt {
    public static final int component1(@NotNull ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<this>");
        return activityResult.getResultCode();
    }

    @Nullable
    public static final Intent component2(@NotNull ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<this>");
        return activityResult.getData();
    }
}
