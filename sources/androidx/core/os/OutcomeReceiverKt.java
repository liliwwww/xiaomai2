package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(31)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    @NotNull
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(@NotNull Continuation<? super R> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        return new ContinuationOutcomeReceiver(continuation);
    }
}
