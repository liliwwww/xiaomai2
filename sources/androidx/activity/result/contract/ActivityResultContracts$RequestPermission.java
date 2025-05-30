package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ActivityResultContracts$RequestPermission extends ActivityResultContract<String, Boolean> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NotNull
    public Intent createIntent(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "input");
        return ActivityResultContracts.RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{str});
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "input");
        if (ContextCompat.checkSelfPermission(context, str) == 0) {
            return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        if (r5 == true) goto L21;
     */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Boolean parseResult(int r5, @org.jetbrains.annotations.Nullable android.content.Intent r6) {
        /*
            r4 = this;
            if (r6 == 0) goto L2c
            r0 = -1
            if (r5 == r0) goto L6
            goto L2c
        L6:
            java.lang.String r5 = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS"
            int[] r5 = r6.getIntArrayExtra(r5)
            r6 = 1
            r0 = 0
            if (r5 == 0) goto L26
            int r1 = r5.length
            r2 = 0
        L12:
            if (r2 >= r1) goto L22
            r3 = r5[r2]
            if (r3 != 0) goto L1a
            r3 = 1
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 == 0) goto L1f
            r5 = 1
            goto L23
        L1f:
            int r2 = r2 + 1
            goto L12
        L22:
            r5 = 0
        L23:
            if (r5 != r6) goto L26
            goto L27
        L26:
            r6 = 0
        L27:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
            return r5
        L2c:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts$RequestPermission.parseResult(int, android.content.Intent):java.lang.Boolean");
    }
}
