package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ObserverNode$Companion {
    static final /* synthetic */ ObserverNode$Companion $$INSTANCE = new ObserverNode$Companion();

    @NotNull
    private static final Function1<ObserverNode, Unit> OnObserveReadsChanged = OnObserveReadsChanged.1.INSTANCE;

    private ObserverNode$Companion() {
    }

    @NotNull
    public final Function1<ObserverNode, Unit> getOnObserveReadsChanged$ui_release() {
        return OnObserveReadsChanged;
    }
}
