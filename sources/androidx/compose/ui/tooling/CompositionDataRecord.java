package androidx.compose.ui.tooling;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface CompositionDataRecord {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    Set<CompositionData> getStore();
}
