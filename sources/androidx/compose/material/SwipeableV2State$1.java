package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableV2State$1<T> extends Lambda implements Function1<T, Boolean> {
    public static final SwipeableV2State$1 INSTANCE = new SwipeableV2State$1();

    SwipeableV2State$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(T t) {
        return Boolean.TRUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m830invoke(Object obj) {
        return invoke((SwipeableV2State$1<T>) obj);
    }
}
