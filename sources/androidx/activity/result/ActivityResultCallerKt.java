package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.j3;
import tb.k3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ActivityResultCallerKt {
    @NotNull
    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> activityResultContract, I i, @NotNull ActivityResultRegistry activityResultRegistry, @NotNull Function1<? super O, Unit> function1) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "<this>");
        Intrinsics.checkNotNullParameter(activityResultContract, "contract");
        Intrinsics.checkNotNullParameter(activityResultRegistry, "registry");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ActivityResultLauncher registerForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new k3(function1));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult, activityResultContract, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerForActivityResult$lambda-0, reason: not valid java name */
    public static final void m5registerForActivityResult$lambda0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$callback");
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerForActivityResult$lambda-1, reason: not valid java name */
    public static final void m6registerForActivityResult$lambda1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$callback");
        function1.invoke(obj);
    }

    @NotNull
    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> activityResultContract, I i, @NotNull Function1<? super O, Unit> function1) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "<this>");
        Intrinsics.checkNotNullParameter(activityResultContract, "contract");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ActivityResultLauncher registerForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, new j3(function1));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult, activityResultContract, i);
    }
}
