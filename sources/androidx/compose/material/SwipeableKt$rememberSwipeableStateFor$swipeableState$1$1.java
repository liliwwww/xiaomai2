package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1<T> extends Lambda implements Function1<T, Boolean> {
    public static final SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1 INSTANCE = new SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1();

    SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "it");
        return Boolean.TRUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m827invoke(Object obj) {
        return invoke((SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1<T>) obj);
    }
}
