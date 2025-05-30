package androidx.compose.ui.text.intl;

import androidx.compose.runtime.Immutable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LocaleList implements Collection<Locale>, KMappedMarker {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final List<Locale> localeList;
    private final int size;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LocaleList getCurrent() {
            List<PlatformLocale> current = PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent();
            ArrayList arrayList = new ArrayList(current.size());
            int size = current.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new Locale(current.get(i)));
            }
            return new LocaleList(arrayList);
        }
    }

    public LocaleList(@NotNull List<Locale> list) {
        Intrinsics.checkNotNullParameter(list, "localeList");
        this.localeList = list;
        this.size = list.size();
    }

    /* renamed from: add, reason: avoid collision after fix types in other method */
    public boolean add2(Locale locale) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Locale locale) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends Locale> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Locale) {
            return contains((Locale) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.localeList.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocaleList) && Intrinsics.areEqual(this.localeList, ((LocaleList) obj).localeList);
    }

    @NotNull
    public final Locale get(int i) {
        return this.localeList.get(i);
    }

    @NotNull
    public final List<Locale> getLocaleList() {
        return this.localeList;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.localeList.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.localeList.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<Locale> iterator() {
        return this.localeList.iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super Locale> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @NotNull
    public String toString() {
        return "LocaleList(localeList=" + this.localeList + ')';
    }

    public boolean contains(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "element");
        return this.localeList.contains(locale);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public LocaleList(@org.jetbrains.annotations.NotNull java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "languageTags"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = ","
            java.lang.String[] r2 = new java.lang.String[]{r0}
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r8
            java.util.List r8 = kotlin.text.StringsKt.split$default(r1, r2, r3, r4, r5, r6)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r8.size()
            r0.<init>(r1)
            int r1 = r8.size()
            r2 = 0
            r3 = 0
        L23:
            if (r3 >= r1) goto L39
            java.lang.Object r4 = r8.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.CharSequence r4 = kotlin.text.StringsKt.trim(r4)
            java.lang.String r4 = r4.toString()
            r0.add(r4)
            int r3 = r3 + 1
            goto L23
        L39:
            java.util.ArrayList r8 = new java.util.ArrayList
            int r1 = r0.size()
            r8.<init>(r1)
            int r1 = r0.size()
        L46:
            if (r2 >= r1) goto L59
            java.lang.Object r3 = r0.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            androidx.compose.ui.text.intl.Locale r4 = new androidx.compose.ui.text.intl.Locale
            r4.<init>(r3)
            r8.add(r4)
            int r2 = r2 + 1
            goto L46
        L59:
            r7.<init>(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.intl.LocaleList.<init>(java.lang.String):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocaleList(@NotNull Locale... localeArr) {
        this((List<Locale>) ArraysKt.toList(localeArr));
        Intrinsics.checkNotNullParameter(localeArr, "locales");
    }
}
