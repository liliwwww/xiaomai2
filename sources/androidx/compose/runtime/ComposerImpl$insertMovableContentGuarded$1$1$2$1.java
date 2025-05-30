package androidx.compose.runtime;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposerImpl$insertMovableContentGuarded$1$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> $offsetChanges;
    final /* synthetic */ SlotReader $reader;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentGuarded$1$1$2$1(ComposerImpl composerImpl, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.this$0 = composerImpl;
        this.$offsetChanges = list;
        this.$reader = slotReader;
        this.$to = movableContentStateReference;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m902invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m902invoke() {
        ComposerImpl composerImpl = this.this$0;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list = this.$offsetChanges;
        SlotReader slotReader = this.$reader;
        MovableContentStateReference movableContentStateReference = this.$to;
        List access$getChanges$p = ComposerImpl.access$getChanges$p(composerImpl);
        try {
            ComposerImpl.access$setChanges$p(composerImpl, list);
            SlotReader access$getReader$p = ComposerImpl.access$getReader$p(composerImpl);
            int[] access$getNodeCountOverrides$p = ComposerImpl.access$getNodeCountOverrides$p(composerImpl);
            ComposerImpl.access$setNodeCountOverrides$p(composerImpl, (int[]) null);
            try {
                ComposerImpl.access$setReader$p(composerImpl, slotReader);
                ComposerImpl.access$invokeMovableContentLambda(composerImpl, movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals$runtime_release(), movableContentStateReference.getParameter$runtime_release(), true);
                Unit unit = Unit.INSTANCE;
            } finally {
                ComposerImpl.access$setReader$p(composerImpl, access$getReader$p);
                ComposerImpl.access$setNodeCountOverrides$p(composerImpl, access$getNodeCountOverrides$p);
            }
        } finally {
            ComposerImpl.access$setChanges$p(composerImpl, access$getChanges$p);
        }
    }
}
