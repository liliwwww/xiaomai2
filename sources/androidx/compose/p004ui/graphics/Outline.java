package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.RoundRect;
import androidx.compose.p004ui.geometry.RoundRectKt;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class Outline {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Generic extends Outline {

        @NotNull
        private final Path path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Generic(@NotNull Path path) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Generic) && Intrinsics.areEqual(this.path, ((Generic) obj).path);
        }

        @Override // androidx.compose.p004ui.graphics.Outline
        @NotNull
        public Rect getBounds() {
            return this.path.getBounds();
        }

        @NotNull
        public final Path getPath() {
            return this.path;
        }

        public int hashCode() {
            return this.path.hashCode();
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class Rectangle extends Outline {

        @NotNull
        private final Rect rect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rectangle(@NotNull Rect rect) {
            super(null);
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.rect = rect;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rectangle) && Intrinsics.areEqual(this.rect, ((Rectangle) obj).rect);
        }

        @Override // androidx.compose.p004ui.graphics.Outline
        @NotNull
        public Rect getBounds() {
            return this.rect;
        }

        @NotNull
        public final Rect getRect() {
            return this.rect;
        }

        public int hashCode() {
            return this.rect.hashCode();
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class Rounded extends Outline {

        @NotNull
        private final RoundRect roundRect;

        @Nullable
        private final Path roundRectPath;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Rounded(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.geometry.RoundRect r3) {
            /*
                r2 = this;
                java.lang.String r0 = "roundRect"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r0 = 0
                r2.<init>(r0)
                r2.roundRect = r3
                boolean r1 = androidx.compose.p004ui.graphics.OutlineKt.access$hasSameCornerRadius(r3)
                if (r1 != 0) goto L19
                androidx.compose.ui.graphics.Path r0 = androidx.compose.p004ui.graphics.AndroidPath_androidKt.Path()
                r0.addRoundRect(r3)
            L19:
                r2.roundRectPath = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Outline.Rounded.<init>(androidx.compose.ui.geometry.RoundRect):void");
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rounded) && Intrinsics.areEqual(this.roundRect, ((Rounded) obj).roundRect);
        }

        @Override // androidx.compose.p004ui.graphics.Outline
        @NotNull
        public Rect getBounds() {
            return RoundRectKt.getBoundingRect(this.roundRect);
        }

        @NotNull
        public final RoundRect getRoundRect() {
            return this.roundRect;
        }

        @Nullable
        public final Path getRoundRectPath$ui_graphics_release() {
            return this.roundRectPath;
        }

        public int hashCode() {
            return this.roundRect.hashCode();
        }
    }

    private Outline() {
    }

    public /* synthetic */ Outline(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract Rect getBounds();
}
