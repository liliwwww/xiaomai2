package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.InternalComposeUiApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@InternalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface WindowRecomposerFactory {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    Recomposer createRecomposer(@NotNull View view);
}
