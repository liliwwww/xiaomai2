package androidx.activity.result;

import androidx.activity.result.ActivityResultCallerLauncher$resultContract$2;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {

    @NotNull
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;

    @NotNull
    private final ActivityResultLauncher<I> launcher;

    @NotNull
    private final Lazy resultContract$delegate;

    public ActivityResultCallerLauncher(@NotNull ActivityResultLauncher<I> activityResultLauncher, @NotNull ActivityResultContract<I, O> activityResultContract, I i) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "launcher");
        Intrinsics.checkNotNullParameter(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.callerInput = i;
        this.resultContract$delegate = LazyKt.lazy(new Function0<ActivityResultCallerLauncher$resultContract$2.1>(this) { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final 1 m7invoke() {
                return new 1(this.this$0);
            }
        });
    }

    @NotNull
    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @NotNull
    public ActivityResultContract<Unit, ?> getContract() {
        return getResultContract();
    }

    @NotNull
    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    @NotNull
    public final ActivityResultContract<Unit, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(@NotNull Unit unit, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics.checkNotNullParameter(unit, "input");
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
