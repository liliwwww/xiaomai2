package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.core.motion.key.MotionKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PainterModifierKt {
    @NotNull
    public static final Modifier paint(@NotNull Modifier modifier, @NotNull final Painter painter, final boolean z, @NotNull final Alignment alignment, @NotNull final ContentScale contentScale, final float f, @Nullable final ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        return modifier.then(new PainterModifier(painter, z, alignment, contentScale, f, colorFilter, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.draw.PainterModifierKt$paint$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("paint");
                inspectorInfo.getProperties().set("painter", Painter.this);
                inspectorInfo.getProperties().set("sizeToIntrinsics", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("alignment", alignment);
                inspectorInfo.getProperties().set("contentScale", contentScale);
                inspectorInfo.getProperties().set(MotionKey.ALPHA, Float.valueOf(f));
                inspectorInfo.getProperties().set("colorFilter", colorFilter);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    public static /* synthetic */ Modifier paint$default(Modifier modifier, Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Object obj) {
        boolean z2 = (i & 2) != 0 ? true : z;
        if ((i & 4) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        Alignment alignment2 = alignment;
        if ((i & 8) != 0) {
            contentScale = ContentScale.Companion.getInside();
        }
        ContentScale contentScale2 = contentScale;
        float f2 = (i & 16) != 0 ? 1.0f : f;
        if ((i & 32) != 0) {
            colorFilter = null;
        }
        return paint(modifier, painter, z2, alignment2, contentScale2, f2, colorFilter);
    }
}
