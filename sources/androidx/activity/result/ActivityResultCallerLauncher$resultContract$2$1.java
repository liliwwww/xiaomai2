package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [O] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ActivityResultCallerLauncher$resultContract$2$1<O> extends ActivityResultContract<Unit, O> {
    final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

    ActivityResultCallerLauncher$resultContract$2$1(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
        this.this$0 = activityResultCallerLauncher;
    }

    public O parseResult(int i, @Nullable Intent intent) {
        return (O) this.this$0.getCallerContract().parseResult(i, intent);
    }

    @NotNull
    public Intent createIntent(@NotNull Context context, @NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(unit, "input");
        return this.this$0.getCallerContract().createIntent(context, this.this$0.getCallerInput());
    }
}
