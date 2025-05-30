package androidx.compose.p004ui.text.android;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class HorizontalPositionCache {
    private int cachedKey;
    private float cachedValue;

    @NotNull
    private final TextLayout layout;

    public HorizontalPositionCache(@NotNull TextLayout textLayout) {
        Intrinsics.checkNotNullParameter(textLayout, "layout");
        this.layout = textLayout;
        this.cachedKey = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final float get(int r6, boolean r7, boolean r8, boolean r9) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L20
            androidx.compose.ui.text.android.TextLayout r2 = r5.layout
            android.text.Layout r2 = r2.getLayout()
            int r2 = androidx.compose.p004ui.text.android.LayoutCompatKt.getLineForOffset(r2, r6, r7)
            androidx.compose.ui.text.android.TextLayout r3 = r5.layout
            int r3 = r3.getLineStart(r2)
            androidx.compose.ui.text.android.TextLayout r4 = r5.layout
            int r2 = r4.getLineEnd(r2)
            if (r6 == r3) goto L1e
            if (r6 != r2) goto L20
        L1e:
            r2 = 1
            goto L21
        L20:
            r2 = 0
        L21:
            int r3 = r6 * 4
            if (r9 == 0) goto L29
            if (r2 == 0) goto L2e
            r0 = 0
            goto L2e
        L29:
            if (r2 == 0) goto L2d
            r0 = 2
            goto L2e
        L2d:
            r0 = 3
        L2e:
            int r3 = r3 + r0
            int r0 = r5.cachedKey
            if (r0 != r3) goto L36
            float r6 = r5.cachedValue
            return r6
        L36:
            if (r9 == 0) goto L3f
            androidx.compose.ui.text.android.TextLayout r9 = r5.layout
            float r6 = r9.getPrimaryHorizontal(r6, r7)
            goto L45
        L3f:
            androidx.compose.ui.text.android.TextLayout r9 = r5.layout
            float r6 = r9.getSecondaryHorizontal(r6, r7)
        L45:
            if (r8 == 0) goto L4b
            r5.cachedKey = r3
            r5.cachedValue = r6
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.text.android.HorizontalPositionCache.get(int, boolean, boolean, boolean):float");
    }

    @NotNull
    public final TextLayout getLayout() {
        return this.layout;
    }

    public final float getPrimaryDownstream(int i) {
        return get(i, false, false, true);
    }

    public final float getPrimaryUpstream(int i) {
        return get(i, true, true, true);
    }

    public final float getSecondaryDownstream(int i) {
        return get(i, false, false, false);
    }

    public final float getSecondaryUpstream(int i) {
        return get(i, true, true, false);
    }
}
