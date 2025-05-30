package androidx.compose.ui.viewinterop;

import androidx.compose.ui.viewinterop.AndroidViewHolder;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Function0 a;

    @Override // java.lang.Runnable
    public final void run() {
        AndroidViewHolder.onCommitAffectingUpdate.1.a(this.a);
    }
}
