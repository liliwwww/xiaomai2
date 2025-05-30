package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DraggableKt$draggable$4 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ boolean $startDragImmediately;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableKt$draggable$4(boolean z) {
        super(0);
        this.$startDragImmediately = z;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m170invoke() {
        return Boolean.valueOf(this.$startDragImmediately);
    }
}
