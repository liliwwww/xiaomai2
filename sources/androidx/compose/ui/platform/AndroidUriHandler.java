package androidx.compose.ui.platform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidUriHandler implements UriHandler {
    public static final int $stable = 8;

    @NotNull
    private final Context context;

    public AndroidUriHandler(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public void openUri(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uri");
        this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
