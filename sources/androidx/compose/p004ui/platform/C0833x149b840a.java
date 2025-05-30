package androidx.compose.p004ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", i = {0}, l = {392}, m = "invokeSuspend", n = {"durationScaleJob"}, s = {"L$0"})
/* renamed from: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 */
/* loaded from: classes2.dex */
final class C0833x149b840a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ C0832xff837ba9 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0833x149b840a(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, C0832xff837ba9 c0832xff837ba9, View view, Continuation<? super C0833x149b840a> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = c0832xff837ba9;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C0833x149b840a c0833x149b840a = new C0833x149b840a(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        c0833x149b840a.L$0 = obj;
        return c0833x149b840a;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0087  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r11.L$0
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L14
            goto L6b
        L14:
            r12 = move-exception
            goto L85
        L16:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1e:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r4 = r12
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.platform.MotionDurationScaleImpl> r12 = r11.$systemDurationScaleSettingConsumer     // Catch: java.lang.Throwable -> L83
            java.lang.Object r12 = r12.element     // Catch: java.lang.Throwable -> L83
            androidx.compose.ui.platform.MotionDurationScaleImpl r12 = (androidx.compose.p004ui.platform.MotionDurationScaleImpl) r12     // Catch: java.lang.Throwable -> L83
            if (r12 == 0) goto L5c
            android.view.View r1 = r11.$this_createLifecycleAwareWindowRecomposer     // Catch: java.lang.Throwable -> L83
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L83
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch: java.lang.Throwable -> L83
            kotlinx.coroutines.flow.StateFlow r1 = androidx.compose.p004ui.platform.WindowRecomposer_androidKt.access$getAnimationScaleFlowFor(r1)     // Catch: java.lang.Throwable -> L83
            java.lang.Object r5 = r1.getValue()     // Catch: java.lang.Throwable -> L83
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L83
            float r5 = r5.floatValue()     // Catch: java.lang.Throwable -> L83
            r12.setScaleFactor(r5)     // Catch: java.lang.Throwable -> L83
            r5 = 0
            r6 = 0
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r7 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch: java.lang.Throwable -> L83
            r7.<init>(r1, r12, r3)     // Catch: java.lang.Throwable -> L83
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Job r12 = kotlinx.coroutines.d.d(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L83
            goto L5d
        L5c:
            r12 = r3
        L5d:
            androidx.compose.runtime.Recomposer r1 = r11.$recomposer     // Catch: java.lang.Throwable -> L7e
            r11.L$0 = r12     // Catch: java.lang.Throwable -> L7e
            r11.label = r2     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r1 = r1.runRecomposeAndApplyChanges(r11)     // Catch: java.lang.Throwable -> L7e
            if (r1 != r0) goto L6a
            return r0
        L6a:
            r0 = r12
        L6b:
            if (r0 == 0) goto L70
            kotlinx.coroutines.Job.a.b(r0, r3, r2, r3)
        L70:
            androidx.lifecycle.LifecycleOwner r12 = r11.$source
            androidx.lifecycle.Lifecycle r12 = r12.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r0 = r11.$self
            r12.removeObserver(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L7e:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L85
        L83:
            r12 = move-exception
            r0 = r3
        L85:
            if (r0 == 0) goto L8a
            kotlinx.coroutines.Job.a.b(r0, r3, r2, r3)
        L8a:
            androidx.lifecycle.LifecycleOwner r0 = r11.$source
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r1 = r11.$self
            r0.removeObserver(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.platform.C0833x149b840a.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
