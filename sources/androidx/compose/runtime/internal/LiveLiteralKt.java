package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LiveLiteralKt {
    private static boolean isLiveLiteralsEnabled;

    @NotNull
    private static final HashMap<String, MutableState<Object>> liveLiteralCache = new HashMap<>();

    @InternalComposeApi
    public static final void enableLiveLiterals() {
        isLiveLiteralsEnabled = true;
    }

    public static final boolean isLiveLiteralsEnabled() {
        return isLiveLiteralsEnabled;
    }

    @ComposeCompilerApi
    @InternalComposeApi
    public static /* synthetic */ void isLiveLiteralsEnabled$annotations() {
    }

    @ComposeCompilerApi
    @InternalComposeApi
    @NotNull
    public static final <T> State<T> liveLiteral(@NotNull String str, T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, MutableState<Object>> hashMap = liveLiteralCache;
        MutableState<Object> mutableState = hashMap.get(str);
        if (mutableState == null) {
            mutableState = SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
            hashMap.put(str, mutableState);
        }
        Intrinsics.checkNotNull(mutableState, "null cannot be cast to non-null type androidx.compose.runtime.State<T of androidx.compose.runtime.internal.LiveLiteralKt.liveLiteral>");
        return mutableState;
    }

    @InternalComposeApi
    public static final void updateLiveLiteralValue(@NotNull String str, @Nullable Object obj) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, MutableState<Object>> hashMap = liveLiteralCache;
        MutableState<Object> mutableState = hashMap.get(str);
        if (mutableState == null) {
            MutableState<Object> mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(obj, (SnapshotMutationPolicy) null, 2, (Object) null);
            hashMap.put(str, mutableStateOf$default);
            mutableState = mutableStateOf$default;
            z = false;
        } else {
            z = true;
        }
        MutableState<Object> mutableState2 = mutableState;
        if (z) {
            mutableState2.setValue(obj);
        }
    }
}
