package androidx.compose.foundation;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class NoIndication$NoIndicationInstance implements IndicationInstance {

    @NotNull
    public static final NoIndication$NoIndicationInstance INSTANCE = new NoIndication$NoIndicationInstance();

    private NoIndication$NoIndicationInstance() {
    }

    public void drawIndication(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        contentDrawScope.drawContent();
    }
}
