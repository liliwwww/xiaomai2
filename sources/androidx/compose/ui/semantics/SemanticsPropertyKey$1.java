package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SemanticsPropertyKey$1<T> extends Lambda implements Function2<T, T, T> {
    public static final SemanticsPropertyKey$1 INSTANCE = new SemanticsPropertyKey$1();

    SemanticsPropertyKey$1() {
        super(2);
    }

    @Nullable
    public final T invoke(@Nullable T t, T t2) {
        return t == null ? t2 : t;
    }
}
