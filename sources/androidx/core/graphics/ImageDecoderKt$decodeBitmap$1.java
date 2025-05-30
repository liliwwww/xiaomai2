package androidx.core.graphics;

import android.graphics.ImageDecoder;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ImageDecoderKt$decodeBitmap$1 implements ImageDecoder.OnHeaderDecodedListener {
    final /* synthetic */ Function3<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, Unit> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageDecoderKt$decodeBitmap$1(Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
        this.$action = function3;
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(@NotNull ImageDecoder imageDecoder, @NotNull ImageDecoder.ImageInfo imageInfo, @NotNull ImageDecoder.Source source) {
        Intrinsics.checkNotNullParameter(imageDecoder, "decoder");
        Intrinsics.checkNotNullParameter(imageInfo, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        this.$action.invoke(imageDecoder, imageInfo, source);
    }
}
