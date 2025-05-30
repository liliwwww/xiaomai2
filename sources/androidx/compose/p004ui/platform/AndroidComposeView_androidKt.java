package androidx.compose.p004ui.platform;

import android.content.res.Configuration;
import androidx.annotation.RestrictTo;
import androidx.compose.p004ui.InternalComposeUiApi;
import androidx.compose.p004ui.text.input.PlatformTextInputService;
import androidx.compose.p004ui.text.input.TextInputService;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidComposeView_androidKt {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    private static Function1<? super PlatformTextInputService, ? extends TextInputService> textInputServiceFactory = new Function1<PlatformTextInputService, TextInputService>() { // from class: androidx.compose.ui.platform.AndroidComposeView_androidKt$textInputServiceFactory$1
        @NotNull
        public final TextInputService invoke(@NotNull PlatformTextInputService platformTextInputService) {
            Intrinsics.checkNotNullParameter(platformTextInputService, "it");
            return new TextInputService(platformTextInputService);
        }
    };

    /* renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m4478dotp89u6pk(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = i * 4;
        return (fArr[i3 + 0] * fArr2[0 + i2]) + (fArr[i3 + 1] * fArr2[4 + i2]) + (fArr[i3 + 2] * fArr2[8 + i2]) + (fArr[i3 + 3] * fArr2[12 + i2]);
    }

    @NotNull
    public static final LayoutDirection getLocaleLayoutDirection(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        return layoutDirectionFromInt(configuration.getLayoutDirection());
    }

    @NotNull
    public static final Function1<PlatformTextInputService, TextInputService> getTextInputServiceFactory() {
        return textInputServiceFactory;
    }

    @InternalComposeUiApi
    public static /* synthetic */ void getTextInputServiceFactory$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutDirection layoutDirectionFromInt(int i) {
        return i != 0 ? i != 1 ? LayoutDirection.Ltr : LayoutDirection.Rtl : LayoutDirection.Ltr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m4479preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float m4478dotp89u6pk = m4478dotp89u6pk(fArr2, 0, fArr, 0);
        float m4478dotp89u6pk2 = m4478dotp89u6pk(fArr2, 0, fArr, 1);
        float m4478dotp89u6pk3 = m4478dotp89u6pk(fArr2, 0, fArr, 2);
        float m4478dotp89u6pk4 = m4478dotp89u6pk(fArr2, 0, fArr, 3);
        float m4478dotp89u6pk5 = m4478dotp89u6pk(fArr2, 1, fArr, 0);
        float m4478dotp89u6pk6 = m4478dotp89u6pk(fArr2, 1, fArr, 1);
        float m4478dotp89u6pk7 = m4478dotp89u6pk(fArr2, 1, fArr, 2);
        float m4478dotp89u6pk8 = m4478dotp89u6pk(fArr2, 1, fArr, 3);
        float m4478dotp89u6pk9 = m4478dotp89u6pk(fArr2, 2, fArr, 0);
        float m4478dotp89u6pk10 = m4478dotp89u6pk(fArr2, 2, fArr, 1);
        float m4478dotp89u6pk11 = m4478dotp89u6pk(fArr2, 2, fArr, 2);
        float m4478dotp89u6pk12 = m4478dotp89u6pk(fArr2, 2, fArr, 3);
        float m4478dotp89u6pk13 = m4478dotp89u6pk(fArr2, 3, fArr, 0);
        float m4478dotp89u6pk14 = m4478dotp89u6pk(fArr2, 3, fArr, 1);
        float m4478dotp89u6pk15 = m4478dotp89u6pk(fArr2, 3, fArr, 2);
        float m4478dotp89u6pk16 = m4478dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = m4478dotp89u6pk;
        fArr[1] = m4478dotp89u6pk2;
        fArr[2] = m4478dotp89u6pk3;
        fArr[3] = m4478dotp89u6pk4;
        fArr[4] = m4478dotp89u6pk5;
        fArr[5] = m4478dotp89u6pk6;
        fArr[6] = m4478dotp89u6pk7;
        fArr[7] = m4478dotp89u6pk8;
        fArr[8] = m4478dotp89u6pk9;
        fArr[9] = m4478dotp89u6pk10;
        fArr[10] = m4478dotp89u6pk11;
        fArr[11] = m4478dotp89u6pk12;
        fArr[12] = m4478dotp89u6pk13;
        fArr[13] = m4478dotp89u6pk14;
        fArr[14] = m4478dotp89u6pk15;
        fArr[15] = m4478dotp89u6pk16;
    }

    public static final void setTextInputServiceFactory(@NotNull Function1<? super PlatformTextInputService, ? extends TextInputService> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        textInputServiceFactory = function1;
    }
}
