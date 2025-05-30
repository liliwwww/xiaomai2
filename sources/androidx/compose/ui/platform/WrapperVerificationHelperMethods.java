package androidx.compose.ui.platform;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class WrapperVerificationHelperMethods {

    @NotNull
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    private WrapperVerificationHelperMethods() {
    }

    @DoNotInline
    @RequiresApi(29)
    @NotNull
    public final Map<Integer, Integer> attributeSourceResourceMap(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<Integer, Integer> attributeSourceResourceMap = view.getAttributeSourceResourceMap();
        Intrinsics.checkNotNullExpressionValue(attributeSourceResourceMap, "view.attributeSourceResourceMap");
        return attributeSourceResourceMap;
    }
}
