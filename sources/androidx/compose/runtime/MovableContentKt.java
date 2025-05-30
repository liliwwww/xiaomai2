package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MovableContentKt {
    public static final int movableContentKey = 126665345;

    @NotNull
    public static final Function2<Composer, Integer, Unit> movableContentOf(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        return ComposableLambdaKt.composableLambdaInstance(-642339857, true, new movableContentOf.1(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1079330685, true, new movableContentOf.movableContent.1(function2)))));
    }

    @ComposableInferredTarget(scheme = "[0[0]:[_]]")
    @NotNull
    public static final <R> Function3<R, Composer, Integer, Unit> movableContentWithReceiverOf(@NotNull Function3<? super R, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        return ComposableLambdaKt.composableLambdaInstance(506997506, true, new movableContentWithReceiverOf.1(new MovableContent(ComposableLambdaKt.composableLambdaInstance(250838178, true, new movableContentWithReceiverOf.movableContent.1(function3)))));
    }

    @NotNull
    public static final <P> Function3<P, Composer, Integer, Unit> movableContentOf(@NotNull Function3<? super P, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        return ComposableLambdaKt.composableLambdaInstance(-434707029, true, new movableContentOf.2(new MovableContent(function3)));
    }

    @NotNull
    public static final <R, P> Function4<R, P, Composer, Integer, Unit> movableContentWithReceiverOf(@NotNull Function4<? super R, ? super P, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "content");
        return ComposableLambdaKt.composableLambdaInstance(627354118, true, new movableContentWithReceiverOf.2(new MovableContent(ComposableLambdaKt.composableLambdaInstance(812082854, true, new movableContentWithReceiverOf.movableContent.2(function4)))));
    }

    @NotNull
    public static final <P1, P2> Function4<P1, P2, Composer, Integer, Unit> movableContentOf(@NotNull Function4<? super P1, ? super P2, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "content");
        return ComposableLambdaKt.composableLambdaInstance(-1200019734, true, new movableContentOf.3(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1849814513, true, new movableContentOf.movableContent.2(function4)))));
    }

    @NotNull
    public static final <R, P1, P2> Function5<R, P1, P2, Composer, Integer, Unit> movableContentWithReceiverOf(@NotNull Function5<? super R, ? super P1, ? super P2, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(function5, "content");
        return ComposableLambdaKt.composableLambdaInstance(583402949, true, new movableContentWithReceiverOf.3(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1322148760, true, new movableContentWithReceiverOf.movableContent.3(function5)))));
    }

    @NotNull
    public static final <P1, P2, P3> Function5<P1, P2, P3, Composer, Integer, Unit> movableContentOf(@NotNull Function5<? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(function5, "content");
        return ComposableLambdaKt.composableLambdaInstance(-1083870185, true, new movableContentOf.4(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-284417101, true, new movableContentOf.movableContent.3(function5)))));
    }

    @NotNull
    public static final <R, P1, P2, P3> Function6<R, P1, P2, P3, Composer, Integer, Unit> movableContentWithReceiverOf(@NotNull Function6<? super R, ? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function6) {
        Intrinsics.checkNotNullParameter(function6, "content");
        return ComposableLambdaKt.composableLambdaInstance(1468683306, true, new movableContentWithReceiverOf.4(new MovableContent(ComposableLambdaKt.composableLambdaInstance(838586922, true, new movableContentWithReceiverOf.movableContent.4(function6)))));
    }

    @NotNull
    public static final <P1, P2, P3, P4> Function6<P1, P2, P3, P4, Composer, Integer, Unit> movableContentOf(@NotNull Function6<? super P1, ? super P2, ? super P3, ? super P4, ? super Composer, ? super Integer, Unit> function6) {
        Intrinsics.checkNotNullParameter(function6, "content");
        return ComposableLambdaKt.composableLambdaInstance(-1741877681, true, new movableContentOf.5(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1876318581, true, new movableContentOf.movableContent.4(function6)))));
    }
}
