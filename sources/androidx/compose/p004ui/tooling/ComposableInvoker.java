package androidx.compose.p004ui.tooling;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@Deprecated(message = "Use androidx.compose.runtime.reflect.ComposableMethodInvoker instead")
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public final class ComposableInvoker {
    public static final int $stable = 0;
    private static final int BITS_PER_INT = 31;

    @NotNull
    public static final ComposableInvoker INSTANCE = new ComposableInvoker();
    private static final int SLOTS_PER_INT = 10;

    private ComposableInvoker() {
    }

    private final int changedParamCount(int i, int i2) {
        if (i == 0) {
            return 1;
        }
        return (int) Math.ceil((i + i2) / 10.0d);
    }

    private final boolean compatibleTypes(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z;
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        int length = clsArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(Boolean.valueOf(clsArr[i].isAssignableFrom(clsArr2[i2])));
            i++;
            i2++;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        return z;
    }

    private final int defaultParamCount(int i) {
        return (int) Math.ceil(i / 31.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final /* synthetic */ <T> T[] dup(T t, int i) {
        IntRange until = RangesKt.until(0, i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        IntIterator it = until.iterator();
        while (it.hasNext()) {
            it.nextInt();
            arrayList.add(t);
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        T[] tArr = (T[]) arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return tArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.reflect.Method findComposableMethod(java.lang.Class<?> r10, java.lang.String r11, java.lang.Object... r12) {
        /*
            r9 = this;
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r1 = 0
            r2 = 0
            int r3 = r12.length     // Catch: java.lang.ReflectiveOperationException -> L7e
            int r3 = r9.changedParamCount(r3, r2)     // Catch: java.lang.ReflectiveOperationException -> L7e
            kotlin.jvm.internal.SpreadBuilder r4 = new kotlin.jvm.internal.SpreadBuilder     // Catch: java.lang.ReflectiveOperationException -> L7e
            r5 = 3
            r4.<init>(r5)     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.ReflectiveOperationException -> L7e
            r5.<init>()     // Catch: java.lang.ReflectiveOperationException -> L7e
            int r6 = r12.length     // Catch: java.lang.ReflectiveOperationException -> L7e
            r7 = 0
        L17:
            if (r7 >= r6) goto L2b
            r8 = r12[r7]     // Catch: java.lang.ReflectiveOperationException -> L7e
            if (r8 == 0) goto L22
            java.lang.Class r8 = r8.getClass()     // Catch: java.lang.ReflectiveOperationException -> L7e
            goto L23
        L22:
            r8 = r1
        L23:
            if (r8 == 0) goto L28
            r5.add(r8)     // Catch: java.lang.ReflectiveOperationException -> L7e
        L28:
            int r7 = r7 + 1
            goto L17
        L2b:
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.lang.Object[] r12 = r5.toArray(r12)     // Catch: java.lang.ReflectiveOperationException -> L7e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r0)     // Catch: java.lang.ReflectiveOperationException -> L7e
            r4.addSpread(r12)     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.lang.Class<androidx.compose.runtime.Composer> r12 = androidx.compose.runtime.Composer.class
            r4.add(r12)     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch: java.lang.ReflectiveOperationException -> L7e
            kotlin.ranges.IntRange r3 = kotlin.ranges.RangesKt.until(r2, r3)     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.ReflectiveOperationException -> L7e
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r6)     // Catch: java.lang.ReflectiveOperationException -> L7e
            r5.<init>(r6)     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.ReflectiveOperationException -> L7e
        L51:
            boolean r6 = r3.hasNext()     // Catch: java.lang.ReflectiveOperationException -> L7e
            if (r6 == 0) goto L61
            r6 = r3
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6     // Catch: java.lang.ReflectiveOperationException -> L7e
            r6.nextInt()     // Catch: java.lang.ReflectiveOperationException -> L7e
            r5.add(r12)     // Catch: java.lang.ReflectiveOperationException -> L7e
            goto L51
        L61:
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.lang.Object[] r12 = r5.toArray(r12)     // Catch: java.lang.ReflectiveOperationException -> L7e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r0)     // Catch: java.lang.ReflectiveOperationException -> L7e
            r4.addSpread(r12)     // Catch: java.lang.ReflectiveOperationException -> L7e
            int r12 = r4.size()     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.lang.Class[] r12 = new java.lang.Class[r12]     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.lang.Object[] r12 = r4.toArray(r12)     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.lang.Class[] r12 = (java.lang.Class[]) r12     // Catch: java.lang.ReflectiveOperationException -> L7e
            java.lang.reflect.Method r12 = r9.getDeclaredCompatibleMethod(r10, r11, r12)     // Catch: java.lang.ReflectiveOperationException -> L7e
            goto L9c
        L7e:
            java.lang.reflect.Method[] r12 = r10.getDeclaredMethods()     // Catch: java.lang.ReflectiveOperationException -> L9b
            java.lang.String r0 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)     // Catch: java.lang.ReflectiveOperationException -> L9b
            int r0 = r12.length     // Catch: java.lang.ReflectiveOperationException -> L9b
        L88:
            if (r2 >= r0) goto L9b
            r3 = r12[r2]     // Catch: java.lang.ReflectiveOperationException -> L9b
            java.lang.String r4 = r3.getName()     // Catch: java.lang.ReflectiveOperationException -> L9b
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r11)     // Catch: java.lang.ReflectiveOperationException -> L9b
            if (r4 == 0) goto L98
            r1 = r3
            goto L9b
        L98:
            int r2 = r2 + 1
            goto L88
        L9b:
            r12 = r1
        L9c:
            if (r12 == 0) goto L9f
            return r12
        L9f:
            java.lang.NoSuchMethodException r12 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = r10.getName()
            r0.append(r10)
            r10 = 46
            r0.append(r10)
            r0.append(r11)
            java.lang.String r10 = r0.toString()
            r12.<init>(r10)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.tooling.ComposableInvoker.findComposableMethod(java.lang.Class, java.lang.String, java.lang.Object[]):java.lang.reflect.Method");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[EDGE_INSN: B:10:0x003c->B:11:0x003c BREAK  A[LOOP:0: B:2:0x0013->B:9:0x0038], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038 A[LOOP:0: B:2:0x0013->B:9:0x0038, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.reflect.Method getDeclaredCompatibleMethod(java.lang.Class<?> r8, java.lang.String r9, java.lang.Class<?>... r10) {
        /*
            r7 = this;
            int r0 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r0)
            java.lang.Class[] r10 = (java.lang.Class[]) r10
            java.lang.reflect.Method[] r8 = r8.getDeclaredMethods()
            java.lang.String r0 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L13:
            if (r2 >= r0) goto L3b
            r3 = r8[r2]
            java.lang.String r4 = r3.getName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r4)
            if (r4 == 0) goto L34
            androidx.compose.ui.tooling.ComposableInvoker r4 = androidx.compose.p004ui.tooling.ComposableInvoker.INSTANCE
            java.lang.Class[] r5 = r3.getParameterTypes()
            java.lang.String r6 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            boolean r4 = r4.compatibleTypes(r5, r10)
            if (r4 == 0) goto L34
            r4 = 1
            goto L35
        L34:
            r4 = 0
        L35:
            if (r4 == 0) goto L38
            goto L3c
        L38:
            int r2 = r2 + 1
            goto L13
        L3b:
            r3 = 0
        L3c:
            if (r3 == 0) goto L3f
            return r3
        L3f:
            java.lang.NoSuchMethodException r8 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            java.lang.String r9 = " not found"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.tooling.ComposableInvoker.getDeclaredCompatibleMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Object getDefaultValue(Class<?> cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return Double.valueOf(0.0d);
                }
                return null;
            case 104431:
                if (name.equals("int")) {
                    return 0;
                }
                return null;
            case 3039496:
                if (name.equals("byte")) {
                    return (byte) 0;
                }
                return null;
            case 3052374:
                if (name.equals("char")) {
                    return (char) 0;
                }
                return null;
            case 3327612:
                if (name.equals("long")) {
                    return 0L;
                }
                return null;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return Boolean.FALSE;
                }
                return null;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    return Float.valueOf(0.0f);
                }
                return null;
            case 109413500:
                if (name.equals("short")) {
                    return (short) 0;
                }
                return null;
            default:
                return null;
        }
    }

    private final Object invokeComposableMethod(Method method, Object obj, Composer composer, Object... objArr) {
        Object obj2;
        Class<?>[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        int i = -1;
        int length = parameterTypes.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (Intrinsics.areEqual(parameterTypes[length], Composer.class)) {
                    i = length;
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        int i3 = i + 1;
        int changedParamCount = changedParamCount(i, obj != null ? 1 : 0) + i3;
        int length2 = method.getParameterTypes().length;
        if (!((length2 != changedParamCount ? defaultParamCount(i) : 0) + changedParamCount == length2)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Object[] objArr2 = new Object[length2];
        int i4 = 0;
        while (i4 < length2) {
            if (i4 >= 0 && i4 < i) {
                if (i4 < 0 || i4 > ArraysKt.getLastIndex(objArr)) {
                    ComposableInvoker composableInvoker = INSTANCE;
                    Class<?> cls = method.getParameterTypes()[i4];
                    Intrinsics.checkNotNullExpressionValue(cls, "parameterTypes[idx]");
                    obj2 = composableInvoker.getDefaultValue(cls);
                } else {
                    obj2 = objArr[i4];
                }
            } else if (i4 == i) {
                obj2 = composer;
            } else {
                if (i3 <= i4 && i4 < changedParamCount) {
                    obj2 = 0;
                } else {
                    if (!(changedParamCount <= i4 && i4 < length2)) {
                        throw new IllegalStateException("Unexpected index".toString());
                    }
                    obj2 = 2097151;
                }
            }
            objArr2[i4] = obj2;
            i4++;
        }
        return method.invoke(obj, Arrays.copyOf(objArr2, length2));
    }

    @ExperimentalComposeUiApi
    public final void invokeComposable(@NotNull String str, @NotNull String str2, @NotNull Composer composer, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, "methodName");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(objArr, "args");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "composableClass");
            Method findComposableMethod = findComposableMethod(cls, str2, Arrays.copyOf(objArr, objArr.length));
            findComposableMethod.setAccessible(true);
            if (Modifier.isStatic(findComposableMethod.getModifiers())) {
                invokeComposableMethod(findComposableMethod, null, composer, Arrays.copyOf(objArr, objArr.length));
            } else {
                invokeComposableMethod(findComposableMethod, cls.getConstructor(new Class[0]).newInstance(new Object[0]), composer, Arrays.copyOf(objArr, objArr.length));
            }
        } catch (ReflectiveOperationException e) {
            throw new ClassNotFoundException("Composable Method '" + str + '.' + str2 + "' not found", e);
        }
    }
}
