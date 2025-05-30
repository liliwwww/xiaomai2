package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AsyncFontListLoader implements State<Object> {

    @NotNull
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable;

    @NotNull
    private final List<Font> fontList;

    @NotNull
    private final Function1<TypefaceResult$Immutable, Unit> onCompletion;

    @NotNull
    private final PlatformFontLoader platformFontLoader;

    @NotNull
    private final TypefaceRequest typefaceRequest;

    @NotNull
    private final MutableState value$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(@NotNull List<? extends Font> list, @NotNull Object obj, @NotNull TypefaceRequest typefaceRequest, @NotNull AsyncTypefaceCache asyncTypefaceCache, @NotNull Function1<? super TypefaceResult$Immutable, Unit> function1, @NotNull PlatformFontLoader platformFontLoader) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(list, "fontList");
        Intrinsics.checkNotNullParameter(obj, "initialType");
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(asyncTypefaceCache, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(function1, "onCompletion");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.value$delegate = mutableStateOf$default;
        this.cacheable = true;
    }

    private void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }

    public final boolean getCacheable$ui_text_release() {
        return this.cacheable;
    }

    @Override // androidx.compose.runtime.State
    @NotNull
    public Object getValue() {
        return this.value$delegate.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[Catch: all -> 0x0107, TRY_LEAVE, TryCatch #1 {all -> 0x0107, blocks: (B:20:0x0075, B:22:0x008c, B:27:0x00bb, B:31:0x00ef), top: B:19:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ef A[Catch: all -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0107, blocks: (B:20:0x0075, B:22:0x008c, B:27:0x00bb, B:31:0x00ef), top: B:19:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0102 -> B:13:0x0103). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x010a -> B:14:0x010c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object load(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.load(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadWithTimeoutOrNull$ui_text_release(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = (androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.text.font.Font r8 = (androidx.compose.ui.text.font.Font) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            goto L4b
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = 15000(0x3a98, double:7.411E-320)
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2 r9 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            r9.<init>(r7, r8, r4)     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            r0.L$0 = r8     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            r0.label = r3     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            java.lang.Object r9 = kotlinx.coroutines.TimeoutKt.d(r5, r9, r0)     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            if (r9 != r1) goto L4b
            return r1
        L4b:
            r4 = r9
            goto L85
        L4d:
            r9 = move-exception
            kotlin.coroutines.CoroutineContext r1 = r0.getContext()
            kotlinx.coroutines.CoroutineExceptionHandler$a r2 = kotlinx.coroutines.CoroutineExceptionHandler.Key
            kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r2)
            kotlinx.coroutines.CoroutineExceptionHandler r1 = (kotlinx.coroutines.CoroutineExceptionHandler) r1
            if (r1 == 0) goto L85
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Unable to load font "
            r3.append(r5)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r2.<init>(r8, r9)
            r1.handleException(r0, r2)
            goto L85
        L7a:
            r8 = move-exception
            kotlin.coroutines.CoroutineContext r9 = r0.getContext()
            boolean r9 = tb.bb2.m(r9)
            if (r9 == 0) goto L86
        L85:
            return r4
        L86:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setCacheable$ui_text_release(boolean z) {
        this.cacheable = z;
    }
}
