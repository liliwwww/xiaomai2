package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SemanticsPropertiesAndroid {
    public static final int $stable = 0;

    @NotNull
    public static final SemanticsPropertiesAndroid INSTANCE = new SemanticsPropertiesAndroid();

    @NotNull
    private static final SemanticsPropertyKey<Boolean> TestTagsAsResourceId = new SemanticsPropertyKey<>("TestTagsAsResourceId", TestTagsAsResourceId.1.INSTANCE);

    private SemanticsPropertiesAndroid() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getTestTagsAsResourceId$annotations() {
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final SemanticsPropertyKey<Boolean> getTestTagsAsResourceId() {
        return TestTagsAsResourceId;
    }
}
