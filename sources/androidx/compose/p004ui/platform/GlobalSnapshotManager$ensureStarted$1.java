package androidx.compose.p004ui.platform;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$0"})
/* loaded from: classes2.dex */
final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Unit> $channel;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSnapshotManager$ensureStarted$1(Channel<Unit> channel, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.$channel, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: all -> 0x0060, TRY_LEAVE, TryCatch #0 {all -> 0x0060, blocks: (B:10:0x0042, B:12:0x004a), top: B:9:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003b -> B:8:0x0041). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r7.L$0
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L63
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r7
            goto L41
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r3 = r7.$channel
            kotlinx.coroutines.channels.ChannelIterator r8 = r3.iterator()     // Catch: java.lang.Throwable -> L63
            r1 = r8
            r8 = r7
        L2e:
            r8.L$0 = r3     // Catch: java.lang.Throwable -> L63
            r8.L$1 = r1     // Catch: java.lang.Throwable -> L63
            r8.label = r2     // Catch: java.lang.Throwable -> L63
            java.lang.Object r4 = r1.hasNext(r8)     // Catch: java.lang.Throwable -> L63
            if (r4 != r0) goto L3b
            return r0
        L3b:
            r6 = r0
            r0 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r6
        L41:
            r5 = 0
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L60
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L60
            if (r8 == 0) goto L5a
            java.lang.Object r8 = r3.next()     // Catch: java.lang.Throwable -> L60
            kotlin.Unit r8 = (kotlin.Unit) r8     // Catch: java.lang.Throwable -> L60
            androidx.compose.runtime.snapshots.Snapshot$Companion r8 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L60
            r8.sendApplyNotifications()     // Catch: java.lang.Throwable -> L60
            r8 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L2e
        L5a:
            kotlinx.coroutines.channels.b.b(r4, r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L60:
            r8 = move-exception
            r3 = r4
            goto L64
        L63:
            r8 = move-exception
        L64:
            throw r8     // Catch: java.lang.Throwable -> L65
        L65:
            r0 = move-exception
            kotlinx.coroutines.channels.b.b(r3, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.platform.GlobalSnapshotManager$ensureStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
