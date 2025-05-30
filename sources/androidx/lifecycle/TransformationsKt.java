package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.arch.core.util.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TransformationsKt {
    @CheckResult
    @NotNull
    public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        LiveData<X> distinctUntilChanged = Transformations.distinctUntilChanged(liveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(this)");
        return distinctUntilChanged;
    }

    @CheckResult
    @NotNull
    public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> liveData, @NotNull final Function1<? super X, ? extends Y> function1) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LiveData<Y> map = Transformations.map(liveData, new Function() { // from class: androidx.lifecycle.TransformationsKt$map$1
            /* JADX WARN: Type inference failed for: r2v1, types: [Y, java.lang.Object] */
            public final Y apply(X x) {
                return function1.invoke(x);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "crossinline transform: (…p(this) { transform(it) }");
        return map;
    }

    @CheckResult
    @NotNull
    public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> liveData, @NotNull final Function1<? super X, ? extends LiveData<Y>> function1) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LiveData<Y> switchMap = Transformations.switchMap(liveData, new Function() { // from class: androidx.lifecycle.TransformationsKt$switchMap$1
            public final LiveData<Y> apply(X x) {
                return (LiveData) function1.invoke(x);
            }

            /* renamed from: apply, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2809apply(Object obj) {
                return apply((TransformationsKt$switchMap$1<I, O>) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "crossinline transform: (…p(this) { transform(it) }");
        return switchMap;
    }
}
