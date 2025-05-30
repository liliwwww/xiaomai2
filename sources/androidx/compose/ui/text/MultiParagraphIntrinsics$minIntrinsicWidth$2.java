package androidx.compose.ui.text;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MultiParagraphIntrinsics$minIntrinsicWidth$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ MultiParagraphIntrinsics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultiParagraphIntrinsics$minIntrinsicWidth$2(MultiParagraphIntrinsics multiParagraphIntrinsics) {
        super(0);
        this.this$0 = multiParagraphIntrinsics;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Float m2256invoke() {
        Object obj;
        ParagraphIntrinsics intrinsics;
        List infoList$ui_text_release = this.this$0.getInfoList$ui_text_release();
        if (infoList$ui_text_release.isEmpty()) {
            obj = null;
        } else {
            Object obj2 = infoList$ui_text_release.get(0);
            float minIntrinsicWidth = ((ParagraphIntrinsicInfo) obj2).getIntrinsics().getMinIntrinsicWidth();
            int lastIndex = CollectionsKt.getLastIndex(infoList$ui_text_release);
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj3 = infoList$ui_text_release.get(i);
                    float minIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj3).getIntrinsics().getMinIntrinsicWidth();
                    if (Float.compare(minIntrinsicWidth, minIntrinsicWidth2) < 0) {
                        obj2 = obj3;
                        minIntrinsicWidth = minIntrinsicWidth2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            obj = obj2;
        }
        ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
        return Float.valueOf((paragraphIntrinsicInfo == null || (intrinsics = paragraphIntrinsicInfo.getIntrinsics()) == null) ? 0.0f : intrinsics.getMinIntrinsicWidth());
    }
}
