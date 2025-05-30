package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class RippleHostMap {

    @NotNull
    private final Map<AndroidRippleIndicationInstance, RippleHostView> indicationToHostMap = new LinkedHashMap();

    @NotNull
    private final Map<RippleHostView, AndroidRippleIndicationInstance> hostToIndicationMap = new LinkedHashMap();

    @Nullable
    public final RippleHostView get(@NotNull AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        Intrinsics.checkNotNullParameter(androidRippleIndicationInstance, "indicationInstance");
        return this.indicationToHostMap.get(androidRippleIndicationInstance);
    }

    public final void remove(@NotNull AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        Intrinsics.checkNotNullParameter(androidRippleIndicationInstance, "indicationInstance");
        RippleHostView rippleHostView = this.indicationToHostMap.get(androidRippleIndicationInstance);
        if (rippleHostView != null) {
            this.hostToIndicationMap.remove(rippleHostView);
        }
        this.indicationToHostMap.remove(androidRippleIndicationInstance);
    }

    public final void set(@NotNull AndroidRippleIndicationInstance androidRippleIndicationInstance, @NotNull RippleHostView rippleHostView) {
        Intrinsics.checkNotNullParameter(androidRippleIndicationInstance, "indicationInstance");
        Intrinsics.checkNotNullParameter(rippleHostView, "rippleHostView");
        this.indicationToHostMap.put(androidRippleIndicationInstance, rippleHostView);
        this.hostToIndicationMap.put(rippleHostView, androidRippleIndicationInstance);
    }

    @Nullable
    public final AndroidRippleIndicationInstance get(@NotNull RippleHostView rippleHostView) {
        Intrinsics.checkNotNullParameter(rippleHostView, "rippleHostView");
        return this.hostToIndicationMap.get(rippleHostView);
    }
}
