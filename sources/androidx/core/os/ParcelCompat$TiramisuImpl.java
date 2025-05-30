package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ParcelCompat$TiramisuImpl {
    private ParcelCompat$TiramisuImpl() {
    }

    @DoNotInline
    public static <T> T[] readArray(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        return (T[]) parcel.readArray(classLoader, cls);
    }

    @DoNotInline
    public static <T> ArrayList<T> readArrayList(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
        return parcel.readArrayList(classLoader, cls);
    }

    @DoNotInline
    public static <V, K> HashMap<K, V> readHashMap(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
        return parcel.readHashMap(classLoader, cls, cls2);
    }

    @DoNotInline
    public static <T> void readList(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        parcel.readList(list, classLoader, cls);
    }

    @DoNotInline
    public static <K, V> void readMap(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
        parcel.readMap(map, classLoader, cls, cls2);
    }

    @DoNotInline
    static <T extends Parcelable> T readParcelable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return (T) parcel.readParcelable(classLoader, cls);
    }

    @DoNotInline
    static <T> T[] readParcelableArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return (T[]) parcel.readParcelableArray(classLoader, cls);
    }

    @DoNotInline
    public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        return parcel.readParcelableCreator(classLoader, cls);
    }

    @DoNotInline
    static <T> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return parcel.readParcelableList(list, classLoader, cls);
    }

    @DoNotInline
    static <T extends Serializable> T readSerializable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return (T) parcel.readSerializable(classLoader, cls);
    }

    @DoNotInline
    public static <T> SparseArray<T> readSparseArray(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
        return parcel.readSparseArray(classLoader, cls);
    }
}
