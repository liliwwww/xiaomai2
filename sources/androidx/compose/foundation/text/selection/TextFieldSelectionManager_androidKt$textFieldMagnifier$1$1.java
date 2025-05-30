package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextFieldSelectionManager_androidKt$textFieldMagnifier$1$1 extends Lambda implements Function0<Offset> {
    final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;
    final /* synthetic */ TextFieldSelectionManager $manager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager_androidKt$textFieldMagnifier$1$1(TextFieldSelectionManager textFieldSelectionManager, MutableState<IntSize> mutableState) {
        super(0);
        this.$manager = textFieldSelectionManager;
        this.$magnifierSize$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m837boximpl(m491invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0, reason: not valid java name */
    public final long m491invokeF1C5BW0() {
        return TextFieldSelectionManagerKt.m490calculateSelectionMagnifierCenterAndroidO0kMr_c(this.$manager, TextFieldSelectionManager_androidKt.textFieldMagnifier.1.access$invoke$lambda$1(this.$magnifierSize$delegate));
    }
}
