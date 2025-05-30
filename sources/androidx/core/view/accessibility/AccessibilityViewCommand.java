package androidx.core.view.accessibility;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface AccessibilityViewCommand {

    /* compiled from: Taobao */
    public static final class MoveHtmlArguments extends CommandArguments {
        @Nullable
        public String getHTMLElement() {
            return ((CommandArguments) this).mBundle.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
        }
    }

    boolean perform(@NonNull View view, @Nullable CommandArguments commandArguments);
}
