package androidx.core.util;

import android.annotation.SuppressLint;

/* compiled from: Taobao */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes2.dex */
public interface Predicate<T> {
    @SuppressLint({"MissingNullability"})
    Predicate<T> and(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    @SuppressLint({"MissingNullability"})
    Predicate<T> negate();

    @SuppressLint({"MissingNullability"})
    /* renamed from: or */
    Predicate<T> m239or(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    boolean test(T t);
}
