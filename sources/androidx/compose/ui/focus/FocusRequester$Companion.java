package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FocusRequester$Companion {
    private FocusRequester$Companion() {
    }

    public /* synthetic */ FocusRequester$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getCancel$annotations() {
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final FocusRequesterFactory createRefs() {
        return FocusRequesterFactory.INSTANCE;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final FocusRequester getCancel() {
        return FocusRequester.access$getCancel$cp();
    }

    @NotNull
    public final FocusRequester getDefault() {
        return FocusRequester.access$getDefault$cp();
    }
}
