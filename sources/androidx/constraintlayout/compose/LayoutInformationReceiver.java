package androidx.constraintlayout.compose;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "", "", "information", "", "setLayoutInformation", "Landroidx/constraintlayout/compose/LayoutInfoFlags;", "getLayoutInformationMode", "", "getForcedWidth", "getForcedHeight", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface LayoutInformationReceiver {
    int getForcedHeight();

    int getForcedWidth();

    @NotNull
    LayoutInfoFlags getLayoutInformationMode();

    void setLayoutInformation(@NotNull String information);
}
