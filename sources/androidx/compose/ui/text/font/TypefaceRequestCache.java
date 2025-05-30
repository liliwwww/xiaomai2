package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TypefaceRequestCache {

    @NotNull
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();

    @NotNull
    private final LruCache<TypefaceRequest, TypefaceResult> resultCache = new LruCache<>(16);

    @Nullable
    public final TypefaceResult get$ui_text_release(@NotNull TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResult;
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        synchronized (this.lock) {
            typefaceResult = this.resultCache.get(typefaceRequest);
        }
        return typefaceResult;
    }

    @NotNull
    public final SynchronizedObject getLock$ui_text_release() {
        return this.lock;
    }

    public final int getSize$ui_text_release() {
        int size;
        synchronized (this.lock) {
            size = this.resultCache.size();
        }
        return size;
    }

    public final void preWarmCache(@NotNull List<TypefaceRequest> list, @NotNull Function1<? super TypefaceRequest, ? extends TypefaceResult> function1) {
        TypefaceResult typefaceResult;
        Intrinsics.checkNotNullParameter(list, "typefaceRequests");
        Intrinsics.checkNotNullParameter(function1, "resolveTypeface");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TypefaceRequest typefaceRequest = list.get(i);
            synchronized (this.lock) {
                typefaceResult = this.resultCache.get(typefaceRequest);
            }
            if (typefaceResult == null) {
                try {
                    TypefaceResult typefaceResult2 = (TypefaceResult) function1.invoke(typefaceRequest);
                    if (typefaceResult2 instanceof TypefaceResult.Async) {
                        continue;
                    } else {
                        synchronized (this.lock) {
                            this.resultCache.put(typefaceRequest, typefaceResult2);
                        }
                    }
                } catch (Exception e) {
                    throw new IllegalStateException("Could not load font", e);
                }
            }
        }
    }

    @NotNull
    public final State<Object> runCached(@NotNull TypefaceRequest typefaceRequest, @NotNull Function1<? super Function1<? super TypefaceResult, Unit>, ? extends TypefaceResult> function1) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(function1, "resolveTypeface");
        synchronized (this.lock) {
            TypefaceResult typefaceResult = this.resultCache.get(typefaceRequest);
            if (typefaceResult != null) {
                if (typefaceResult.getCacheable()) {
                    return typefaceResult;
                }
                this.resultCache.remove(typefaceRequest);
            }
            try {
                TypefaceResult typefaceResult2 = (TypefaceResult) function1.invoke(new runCached.currentTypefaceResult.1(this, typefaceRequest));
                synchronized (this.lock) {
                    if (this.resultCache.get(typefaceRequest) == null && typefaceResult2.getCacheable()) {
                        this.resultCache.put(typefaceRequest, typefaceResult2);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return typefaceResult2;
            } catch (Exception e) {
                throw new IllegalStateException("Could not load font", e);
            }
        }
    }
}
