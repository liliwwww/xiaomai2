package androidx.compose.foundation.shape;

import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class GenericShape implements Shape {
    public static final int $stable = 0;

    @NotNull
    private final Function3<Path, Size, LayoutDirection, Unit> builder;

    /* JADX WARN: Multi-variable type inference failed */
    public GenericShape(@NotNull Function3<? super Path, ? super Size, ? super LayoutDirection, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "builder");
        this.builder = function3;
    }

    @Override // androidx.compose.p004ui.graphics.Shape
    @NotNull
    /* renamed from: createOutline-Pq9zytI */
    public Outline mo1164createOutlinePq9zytI(long j, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path Path = AndroidPath_androidKt.Path();
        this.builder.invoke(Path, Size.m2613boximpl(j), layoutDirection);
        Path.close();
        return new Outline.Generic(Path);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        GenericShape genericShape = obj instanceof GenericShape ? (GenericShape) obj : null;
        return Intrinsics.areEqual(genericShape != null ? genericShape.builder : null, this.builder);
    }

    public int hashCode() {
        return this.builder.hashCode();
    }
}
