package androidx.compose.ui.viewinterop;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidViewHolder$runUpdate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$runUpdate$1(AndroidViewHolder androidViewHolder) {
        super(0);
        this.this$0 = androidViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2720invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2720invoke() {
        if (AndroidViewHolder.access$getHasUpdateBlock$p(this.this$0)) {
            SnapshotStateObserver access$getSnapshotObserver$p = AndroidViewHolder.access$getSnapshotObserver$p(this.this$0);
            AndroidViewHolder androidViewHolder = this.this$0;
            access$getSnapshotObserver$p.observeReads(androidViewHolder, AndroidViewHolder.access$getOnCommitAffectingUpdate$p(androidViewHolder), this.this$0.getUpdate());
        }
    }
}
