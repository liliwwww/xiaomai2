package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SavedStateHandle$Companion {
    private SavedStateHandle$Companion() {
    }

    public /* synthetic */ SavedStateHandle$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @NotNull
    public final SavedStateHandle createHandle(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new SavedStateHandle();
            }
            HashMap hashMap = new HashMap();
            for (String str : bundle2.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                hashMap.put(str, bundle2.get(str));
            }
            return new SavedStateHandle(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (!((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true)) {
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = parcelableArrayList.get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
        }
        return new SavedStateHandle(linkedHashMap);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public final boolean validateValue(@Nullable Object obj) {
        if (obj == null) {
            return true;
        }
        for (Class cls : SavedStateHandle.access$getACCEPTABLE_CLASSES$cp()) {
            Intrinsics.checkNotNull(cls);
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }
}
