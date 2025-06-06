package androidx.compose.p004ui.graphics.vector;

import androidx.compose.p004ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PathBuilder {

    @NotNull
    private final List<PathNode> nodes = new ArrayList();

    private final PathBuilder addNode(PathNode pathNode) {
        this.nodes.add(pathNode);
        return this;
    }

    @NotNull
    public final PathBuilder arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        return addNode(new PathNode.ArcTo(f, f2, f3, z, z2, f4, f5));
    }

    @NotNull
    public final PathBuilder arcToRelative(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        return addNode(new PathNode.RelativeArcTo(f, f2, f3, z, z2, f4, f5));
    }

    @NotNull
    public final PathBuilder close() {
        return addNode(PathNode.Close.INSTANCE);
    }

    @NotNull
    public final PathBuilder curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        return addNode(new PathNode.CurveTo(f, f2, f3, f4, f5, f6));
    }

    @NotNull
    public final PathBuilder curveToRelative(float f, float f2, float f3, float f4, float f5, float f6) {
        return addNode(new PathNode.RelativeCurveTo(f, f2, f3, f4, f5, f6));
    }

    @NotNull
    public final List<PathNode> getNodes() {
        return this.nodes;
    }

    @NotNull
    public final PathBuilder horizontalLineTo(float f) {
        return addNode(new PathNode.HorizontalTo(f));
    }

    @NotNull
    public final PathBuilder horizontalLineToRelative(float f) {
        return addNode(new PathNode.RelativeHorizontalTo(f));
    }

    @NotNull
    public final PathBuilder lineTo(float f, float f2) {
        return addNode(new PathNode.LineTo(f, f2));
    }

    @NotNull
    public final PathBuilder lineToRelative(float f, float f2) {
        return addNode(new PathNode.RelativeLineTo(f, f2));
    }

    @NotNull
    public final PathBuilder moveTo(float f, float f2) {
        return addNode(new PathNode.MoveTo(f, f2));
    }

    @NotNull
    public final PathBuilder moveToRelative(float f, float f2) {
        return addNode(new PathNode.RelativeMoveTo(f, f2));
    }

    @NotNull
    public final PathBuilder quadTo(float f, float f2, float f3, float f4) {
        return addNode(new PathNode.QuadTo(f, f2, f3, f4));
    }

    @NotNull
    public final PathBuilder quadToRelative(float f, float f2, float f3, float f4) {
        return addNode(new PathNode.RelativeQuadTo(f, f2, f3, f4));
    }

    @NotNull
    public final PathBuilder reflectiveCurveTo(float f, float f2, float f3, float f4) {
        return addNode(new PathNode.ReflectiveCurveTo(f, f2, f3, f4));
    }

    @NotNull
    public final PathBuilder reflectiveCurveToRelative(float f, float f2, float f3, float f4) {
        return addNode(new PathNode.RelativeReflectiveCurveTo(f, f2, f3, f4));
    }

    @NotNull
    public final PathBuilder reflectiveQuadTo(float f, float f2) {
        return addNode(new PathNode.ReflectiveQuadTo(f, f2));
    }

    @NotNull
    public final PathBuilder reflectiveQuadToRelative(float f, float f2) {
        return addNode(new PathNode.RelativeReflectiveQuadTo(f, f2));
    }

    @NotNull
    public final PathBuilder verticalLineTo(float f) {
        return addNode(new PathNode.VerticalTo(f));
    }

    @NotNull
    public final PathBuilder verticalLineToRelative(float f) {
        return addNode(new PathNode.RelativeVerticalTo(f));
    }
}
