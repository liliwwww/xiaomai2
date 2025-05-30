package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class ActivityResultContract<I, O> {
    @NotNull
    public abstract Intent createIntent(@NotNull Context context, I i);

    @Nullable
    public SynchronousResult<O> getSynchronousResult(@NotNull Context context, I i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    public abstract O parseResult(int i, @Nullable Intent intent);
}
