package androidx.core.animation;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AnimatorKt$addPauseListener$1 extends Lambda implements Function1<Animator, Unit> {
    public static final AnimatorKt$addPauseListener$1 INSTANCE = new AnimatorKt$addPauseListener$1();

    AnimatorKt$addPauseListener$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Animator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "it");
    }
}
