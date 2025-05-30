package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Landroidx/window/layout/FoldingFeature$State;", "", "", "toString", "description", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FoldingFeature$State {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmField
    @NotNull
    public static final FoldingFeature$State FLAT = new FoldingFeature$State("FLAT");

    @JvmField
    @NotNull
    public static final FoldingFeature$State HALF_OPENED = new FoldingFeature$State("HALF_OPENED");

    @NotNull
    private final String description;

    private FoldingFeature$State(String str) {
        this.description = str;
    }

    @NotNull
    /* renamed from: toString, reason: from getter */
    public String getDescription() {
        return this.description;
    }
}
