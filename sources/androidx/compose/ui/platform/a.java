package androidx.compose.ui.platform;

import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Function0 a;

    @Override // java.lang.Runnable
    public final void run() {
        AndroidComposeView.snapshotObserver.1.a(this.a);
    }
}
