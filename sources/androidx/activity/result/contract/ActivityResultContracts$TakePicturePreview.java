package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ActivityResultContracts$TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@NotNull Context context, @Nullable Void r2) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @CallSuper
    @NotNull
    public Intent createIntent(@NotNull Context context, @Nullable Void r2) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Intent("android.media.action.IMAGE_CAPTURE");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public final Bitmap parseResult(int i, @Nullable Intent intent) {
        if (!(i == -1)) {
            intent = null;
        }
        if (intent != null) {
            return (Bitmap) intent.getParcelableExtra("data");
        }
        return null;
    }
}
