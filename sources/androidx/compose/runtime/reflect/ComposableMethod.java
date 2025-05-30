package androidx.compose.runtime.reflect;

import android.taobao.windvane.jsbridge.WVPluginManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class ComposableMethod {
    public static final int $stable = 8;

    @NotNull
    private final ComposableInfo composableInfo;

    @NotNull
    private final Method method;

    public ComposableMethod(@NotNull Method method, @NotNull ComposableInfo composableInfo) {
        Intrinsics.checkNotNullParameter(method, WVPluginManager.KEY_METHOD);
        Intrinsics.checkNotNullParameter(composableInfo, "composableInfo");
        this.method = method;
        this.composableInfo = composableInfo;
    }

    @NotNull
    public final Method asMethod() {
        return this.method;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ComposableMethod) {
            return Intrinsics.areEqual(this.method, ((ComposableMethod) obj).method);
        }
        return false;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    @NotNull
    public final Class<?>[] getParameterTypes() {
        Class<?>[] parameterTypes = this.method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
        return (Class[]) ArraysKt.copyOfRange(parameterTypes, 0, this.composableInfo.getRealParamsCount());
    }

    @NotNull
    public final Parameter[] getParameters() {
        Parameter[] parameters = this.method.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "method.parameters");
        return (Parameter[]) ArraysKt.copyOfRange(parameters, 0, this.composableInfo.getRealParamsCount());
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    @Nullable
    public final Object invoke(@NotNull Composer composer, @Nullable Object obj, @NotNull Object... objArr) {
        Object obj2;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(objArr, "args");
        ComposableInfo composableInfo = this.composableInfo;
        int component2 = composableInfo.component2();
        int component3 = composableInfo.component3();
        int component4 = composableInfo.component4();
        int length = this.method.getParameterTypes().length;
        int i = component2 + 1;
        int i2 = component3 + i;
        Object[] objArr2 = new Integer[component4];
        for (int i3 = 0; i3 < component4; i3++) {
            int i4 = i3 * 31;
            IntRange until = RangesKt.until(i4, Math.min(i4 + 31, component2));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            IntIterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                arrayList.add(Integer.valueOf((nextInt >= objArr.length || objArr[nextInt] == null) ? 1 : 0));
            }
            int i5 = 0;
            int i6 = 0;
            for (Object obj3 : arrayList) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                i5 |= ((Number) obj3).intValue() << i6;
                i6 = i7;
            }
            objArr2[i3] = Integer.valueOf(i5);
        }
        Object[] objArr3 = new Object[length];
        int i8 = 0;
        while (i8 < length) {
            if (i8 >= 0 && i8 < component2) {
                if (i8 < 0 || i8 > ArraysKt.getLastIndex(objArr)) {
                    Class<?> cls = this.method.getParameterTypes()[i8];
                    Intrinsics.checkNotNullExpressionValue(cls, "method.parameterTypes[idx]");
                    obj2 = ComposableMethodKt.getDefaultValue(cls);
                } else {
                    obj2 = objArr[i8];
                }
            } else if (i8 == component2) {
                obj2 = composer;
            } else {
                if (i8 != i) {
                    if (!(i + 1 <= i8 && i8 < i2)) {
                        if (!(i2 <= i8 && i8 < length)) {
                            throw new IllegalStateException("Unexpected index".toString());
                        }
                        obj2 = objArr2[i8 - i2];
                    }
                }
                obj2 = 0;
            }
            objArr3[i8] = obj2;
            i8++;
        }
        return this.method.invoke(obj, Arrays.copyOf(objArr3, length));
    }
}
