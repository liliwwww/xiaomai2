package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Recomposer$writeObserverOf$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ ControlledComposition $composition;
    final /* synthetic */ IdentityArraySet<Object> $modifiedValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$writeObserverOf$1(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        super(1);
        this.$composition = controlledComposition;
        this.$modifiedValues = identityArraySet;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m906invoke(obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m906invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        this.$composition.recordWriteOf(obj);
        IdentityArraySet<Object> identityArraySet = this.$modifiedValues;
        if (identityArraySet != null) {
            identityArraySet.add(obj);
        }
    }
}
