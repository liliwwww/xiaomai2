package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class WindowInsetsNestedScrollConnection$fling$2$1$1 extends Lambda implements Function2<Float, Float, Unit> {
    final /* synthetic */ WindowInsetsAnimationController $animationController;
    final /* synthetic */ Ref.FloatRef $endVelocity;
    final /* synthetic */ int $hidden;
    final /* synthetic */ int $shown;
    final /* synthetic */ boolean $targetShown;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInsetsNestedScrollConnection$fling$2$1$1(int i, int i2, WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z) {
        super(2);
        this.$hidden = i;
        this.$shown = i2;
        this.this$0 = windowInsetsNestedScrollConnection;
        this.$endVelocity = floatRef;
        this.$animationController = windowInsetsAnimationController;
        this.$targetShown = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2) {
        Job job;
        float f3 = this.$hidden;
        boolean z = false;
        if (f <= this.$shown && f3 <= f) {
            z = true;
        }
        if (z) {
            this.this$0.adjustInsets(f);
            return;
        }
        this.$endVelocity.element = f2;
        this.$animationController.finish(this.$targetShown);
        this.this$0.animationController = null;
        job = this.this$0.animationJob;
        if (job != null) {
            Job.a.b(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
