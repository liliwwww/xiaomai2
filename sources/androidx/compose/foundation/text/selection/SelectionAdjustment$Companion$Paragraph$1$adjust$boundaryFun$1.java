package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
/* synthetic */ class SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1 extends FunctionReferenceImpl implements Function1<Integer, TextRange> {
    SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(Object obj) {
        super(1, obj, StringHelpersKt.class, "getParagraphBoundary", "getParagraphBoundary(Ljava/lang/CharSequence;I)J", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return TextRange.m2318boximpl(m604invokejx7JFs(((Number) obj).intValue()));
    }

    /* renamed from: invoke--jx7JFs, reason: not valid java name */
    public final long m604invokejx7JFs(int i) {
        return StringHelpersKt.getParagraphBoundary((CharSequence) ((CallableReference) this).receiver, i);
    }
}
