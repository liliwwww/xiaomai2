package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> Object[] addElementAtIndex(Object[] objArr, int i, E e) {
        Object[] objArr2 = new Object[objArr.length + 1];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i + 1, i, objArr.length);
        objArr2[i] = e;
        return objArr2;
    }

    private static final int filterTo(Object[] objArr, Object[] objArr2, int i, Function1<Object, Boolean> function1) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length) {
            CommonFunctionsKt.m2432assert(i3 <= i2);
            if (((Boolean) function1.invoke(objArr[i2])).booleanValue()) {
                objArr2[i + i3] = objArr[i2];
                i3++;
                CommonFunctionsKt.m2432assert(i + i3 <= objArr2.length);
            }
            i2++;
        }
        return i3;
    }

    static /* synthetic */ int filterTo$default(Object[] objArr, Object[] objArr2, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeKt$filterTo$1
                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m2428invoke(@Nullable Object obj2) {
                    return Boolean.valueOf(obj2 != TrieNode.Companion.getEMPTY$runtime_release());
                }
            };
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < objArr.length) {
            CommonFunctionsKt.m2432assert(i4 <= i3);
            if (((Boolean) function1.invoke(objArr[i3])).booleanValue()) {
                objArr2[i + i4] = objArr[i3];
                i4++;
                CommonFunctionsKt.m2432assert(i + i4 <= objArr2.length);
            }
            i3++;
        }
        return i4;
    }

    public static final int indexSegment(int i, int i2) {
        return (i >> i2) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] removeCellAtIndex(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i, i + 1, objArr.length);
        return objArr2;
    }
}
