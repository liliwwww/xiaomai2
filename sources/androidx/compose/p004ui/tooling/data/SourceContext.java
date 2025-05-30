package androidx.compose.p004ui.tooling.data;

import androidx.compose.p004ui.unit.IntRect;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@UiToolingDataApi
/* loaded from: classes2.dex */
public interface SourceContext {
    @NotNull
    IntRect getBounds();

    int getDepth();

    @Nullable
    SourceLocation getLocation();

    @Nullable
    String getName();

    @NotNull
    List<ParameterInformation> getParameters();
}
