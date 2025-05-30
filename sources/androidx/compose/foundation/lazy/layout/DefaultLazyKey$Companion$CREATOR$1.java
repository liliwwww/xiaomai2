package androidx.compose.foundation.lazy.layout;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DefaultLazyKey$Companion$CREATOR$1 implements Parcelable.Creator<DefaultLazyKey> {
    DefaultLazyKey$Companion$CREATOR$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    @NotNull
    public DefaultLazyKey createFromParcel(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new DefaultLazyKey(parcel.readInt());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    @NotNull
    public DefaultLazyKey[] newArray(int i) {
        return new DefaultLazyKey[i];
    }
}
