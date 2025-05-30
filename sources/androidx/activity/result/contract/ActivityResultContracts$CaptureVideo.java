package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ActivityResultContracts$CaptureVideo extends ActivityResultContract<Uri, Boolean> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "input");
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @CallSuper
    @NotNull
    public Intent createIntent(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "input");
        Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
        return putExtra;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NotNull
    public final Boolean parseResult(int i, @Nullable Intent intent) {
        return Boolean.valueOf(i == -1);
    }
}
