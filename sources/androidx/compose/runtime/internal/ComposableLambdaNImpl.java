package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public final class ComposableLambdaNImpl implements ComposableLambdaN {

    @Nullable
    private Object _block;
    private final int arity;
    private final int key;

    @Nullable
    private RecomposeScope scope;

    @Nullable
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    public ComposableLambdaNImpl(int i, boolean z, int i2) {
        this.key = i;
        this.tracked = z;
        this.arity = i2;
    }

    private final int realParamCount(int i) {
        int i2 = (i - 1) - 1;
        for (int i3 = 1; i3 * 10 < i2; i3++) {
            i2--;
        }
        return i2;
    }

    private final void trackRead(Composer composer) {
        RecomposeScope recomposeScope;
        if (!this.tracked || (recomposeScope = composer.getRecomposeScope()) == null) {
            return;
        }
        composer.recordUsed(recomposeScope);
        if (ComposableLambdaKt.replacableWith(this.scope, recomposeScope)) {
            this.scope = recomposeScope;
            return;
        }
        List<RecomposeScope> list = this.scopes;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.scopes = arrayList;
            arrayList.add(recomposeScope);
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (ComposableLambdaKt.replacableWith(list.get(i), recomposeScope)) {
                list.set(i, recomposeScope);
                return;
            }
        }
        list.add(recomposeScope);
    }

    private final void trackWrite() {
        if (this.tracked) {
            RecomposeScope recomposeScope = this.scope;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
                this.scope = null;
            }
            List<RecomposeScope> list = this.scopes;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invalidate();
                }
                list.clear();
            }
        }
    }

    public int getArity() {
        return this.arity;
    }

    public final int getKey() {
        return this.key;
    }

    @Nullable
    public Object invoke(@NotNull final Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        final int realParamCount = realParamCount(objArr.length);
        Object obj = objArr[realParamCount];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Object[] array = ArraysKt.slice(objArr, RangesKt.until(0, objArr.length - 1)).toArray(new Object[0]);
        Object obj2 = objArr[objArr.length - 1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj2).intValue();
        Composer startRestartGroup = ((Composer) obj).startRestartGroup(this.key);
        trackRead(startRestartGroup);
        int differentBits = intValue | (startRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(realParamCount) : ComposableLambdaKt.sameBits(realParamCount));
        Object obj3 = this._block;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread(array);
        spreadBuilder.add(Integer.valueOf(differentBits));
        Object invoke = ((FunctionN) obj3).invoke(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaNImpl$invoke$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                    invoke((Composer) obj4, ((Number) obj5).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(composer, "nc");
                    Object[] array2 = ArraysKt.slice(objArr, RangesKt.until(0, realParamCount)).toArray(new Object[0]);
                    Object obj4 = objArr[realParamCount + 1];
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) obj4).intValue();
                    Object[] objArr2 = objArr;
                    Object[] array3 = ArraysKt.slice(objArr2, RangesKt.until(realParamCount + 2, objArr2.length)).toArray(new Object[0]);
                    ComposableLambdaNImpl composableLambdaNImpl = this;
                    SpreadBuilder spreadBuilder2 = new SpreadBuilder(4);
                    spreadBuilder2.addSpread(array2);
                    spreadBuilder2.add(composer);
                    spreadBuilder2.add(Integer.valueOf(intValue2 | 1));
                    spreadBuilder2.addSpread(array3);
                    composableLambdaNImpl.invoke(spreadBuilder2.toArray(new Object[spreadBuilder2.size()]));
                }
            });
        }
        return invoke;
    }

    public final void update(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "block");
        if (Intrinsics.areEqual(obj, this._block)) {
            return;
        }
        boolean z = this._block == null;
        this._block = (FunctionN) obj;
        if (z) {
            return;
        }
        trackWrite();
    }
}
