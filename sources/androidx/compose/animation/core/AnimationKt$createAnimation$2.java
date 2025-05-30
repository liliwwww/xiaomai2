package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AnimationKt$createAnimation$2<V> extends Lambda implements Function1<V, V> {
    public static final AnimationKt$createAnimation$2 INSTANCE = new AnimationKt$createAnimation$2();

    AnimationKt$createAnimation$2() {
        super(1);
    }

    /* JADX WARN: Incorrect return type in method signature: (TV;)TV; */
    @NotNull
    public final AnimationVector invoke(@NotNull AnimationVector animationVector) {
        Intrinsics.checkNotNullParameter(animationVector, "it");
        return animationVector;
    }
}
