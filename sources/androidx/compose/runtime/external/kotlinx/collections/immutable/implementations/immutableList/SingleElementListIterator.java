package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SingleElementListIterator<E> extends AbstractListIterator<E> {
    private final E element;

    public SingleElementListIterator(E e, int i) {
        super(i, 1);
        this.element = e;
    }

    public E next() {
        checkHasNext$runtime_release();
        setIndex(getIndex() + 1);
        return this.element;
    }

    public E previous() {
        checkHasPrevious$runtime_release();
        setIndex(getIndex() - 1);
        return this.element;
    }
}
