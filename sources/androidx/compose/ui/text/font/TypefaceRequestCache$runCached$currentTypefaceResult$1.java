package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TypefaceRequestCache$runCached$currentTypefaceResult$1 extends Lambda implements Function1<TypefaceResult, Unit> {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ TypefaceRequestCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TypefaceRequestCache$runCached$currentTypefaceResult$1(TypefaceRequestCache typefaceRequestCache, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = typefaceRequestCache;
        this.$typefaceRequest = typefaceRequest;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypefaceResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TypefaceResult typefaceResult) {
        Intrinsics.checkNotNullParameter(typefaceResult, "finalResult");
        SynchronizedObject lock$ui_text_release = this.this$0.getLock$ui_text_release();
        TypefaceRequestCache typefaceRequestCache = this.this$0;
        TypefaceRequest typefaceRequest = this.$typefaceRequest;
        synchronized (lock$ui_text_release) {
            if (typefaceResult.getCacheable()) {
                TypefaceRequestCache.access$getResultCache$p(typefaceRequestCache).put(typefaceRequest, typefaceResult);
            } else {
                TypefaceRequestCache.access$getResultCache$p(typefaceRequestCache).remove(typefaceRequest);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
