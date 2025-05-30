package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface ObserverNode extends DelegatableNode {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    void onObservedReadsChanged();
}
