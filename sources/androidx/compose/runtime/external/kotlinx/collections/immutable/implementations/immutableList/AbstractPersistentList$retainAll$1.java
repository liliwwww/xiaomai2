package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AbstractPersistentList$retainAll$1<E> extends Lambda implements Function1<E, Boolean> {
    final /* synthetic */ Collection<E> $elements;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AbstractPersistentList$retainAll$1(Collection<? extends E> collection) {
        super(1);
        this.$elements = collection;
    }

    @NotNull
    public final Boolean invoke(E e) {
        return Boolean.valueOf(!this.$elements.contains(e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m917invoke(Object obj) {
        return invoke((AbstractPersistentList$retainAll$1<E>) obj);
    }
}
