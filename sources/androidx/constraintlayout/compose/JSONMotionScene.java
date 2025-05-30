package androidx.constraintlayout.compose;

import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0014R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/constraintlayout/compose/JSONMotionScene;", "Landroidx/constraintlayout/compose/EditableJSONLayout;", "Landroidx/constraintlayout/compose/MotionScene;", "", "name", "content", "", "setConstraintSetContent", "setTransitionContent", "getConstraintSet", "", "index", "getTransition", "", "getForcedProgress", "resetForcedProgress", "onNewContent", "progress", "onNewProgress", "Ljava/util/HashMap;", "constraintSetsContent", "Ljava/util/HashMap;", "transitionsContent", "forcedProgress", "F", "<init>", "(Ljava/lang/String;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class JSONMotionScene extends EditableJSONLayout implements MotionScene {

    @NotNull
    private final HashMap<String, String> constraintSetsContent;
    private float forcedProgress;

    @NotNull
    private final HashMap<String, String> transitionsContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSONMotionScene(@Language("json5") @NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "content");
        this.constraintSetsContent = new HashMap<>();
        this.transitionsContent = new HashMap<>();
        this.forcedProgress = Float.NaN;
        initialization();
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    @Nullable
    public String getConstraintSet(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.constraintSetsContent.get(name);
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public float getForcedProgress() {
        return this.forcedProgress;
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    @Nullable
    public String getTransition(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.transitionsContent.get(name);
    }

    protected void onNewContent(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        super.onNewContent(content);
        try {
            ConstraintSetParserKt.parseMotionSceneJSON(this, content);
        } catch (Exception unused) {
        }
    }

    protected void onNewProgress(float progress) {
        this.forcedProgress = progress;
        signalUpdate();
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public void resetForcedProgress() {
        this.forcedProgress = Float.NaN;
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public void setConstraintSetContent(@NotNull String name, @NotNull String content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        this.constraintSetsContent.put(name, content);
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public void setTransitionContent(@NotNull String name, @NotNull String content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        this.transitionsContent.put(name, content);
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    @Nullable
    public String getConstraintSet(int index) {
        Collection<String> values = this.constraintSetsContent.values();
        Intrinsics.checkNotNullExpressionValue(values, "constraintSetsContent.values");
        return (String) CollectionsKt.elementAtOrNull(values, index);
    }
}
