package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface CallbackToFutureAdapter$Resolver<T> {
    @Nullable
    Object attachCompleter(@NonNull CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer) throws Exception;
}
