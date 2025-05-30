package androidx.compose.p004ui.layout;

import org.jetbrains.annotations.NotNull;
import tb.bx1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface GraphicLayerInfo {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static long getOwnerViewId(@NotNull GraphicLayerInfo graphicLayerInfo) {
            return bx1.b(graphicLayerInfo);
        }
    }

    long getLayerId();

    long getOwnerViewId();
}
