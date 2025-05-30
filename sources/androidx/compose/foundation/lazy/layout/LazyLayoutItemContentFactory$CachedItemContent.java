package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyLayoutItemContentFactory$CachedItemContent {

    @Nullable
    private Function2<? super Composer, ? super Integer, Unit> _content;

    @NotNull
    private final Object key;

    @NotNull
    private final MutableState lastKnownIndex$delegate;
    final /* synthetic */ LazyLayoutItemContentFactory this$0;

    @Nullable
    private final Object type;

    public LazyLayoutItemContentFactory$CachedItemContent(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, @NotNull int i, @Nullable Object obj, Object obj2) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(obj, "key");
        this.this$0 = lazyLayoutItemContentFactory;
        this.key = obj;
        this.type = obj2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i), null, 2, null);
        this.lastKnownIndex$delegate = mutableStateOf$default;
    }

    private final Function2<Composer, Integer, Unit> createContentLambda() {
        return ComposableLambdaKt.composableLambdaInstance(1403994769, true, new createContentLambda.1(this.this$0, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastKnownIndex(int i) {
        this.lastKnownIndex$delegate.setValue(Integer.valueOf(i));
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getContent() {
        Function2<? super Composer, ? super Integer, Unit> function2 = this._content;
        if (function2 != null) {
            return function2;
        }
        Function2<Composer, Integer, Unit> createContentLambda = createContentLambda();
        this._content = createContentLambda;
        return createContentLambda;
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    public final int getLastKnownIndex() {
        return ((Number) this.lastKnownIndex$delegate.getValue()).intValue();
    }

    @Nullable
    public final Object getType() {
        return this.type;
    }
}
