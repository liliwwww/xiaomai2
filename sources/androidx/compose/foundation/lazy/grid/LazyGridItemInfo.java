package androidx.compose.foundation.lazy.grid;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface LazyGridItemInfo {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int UnknownColumn = -1;
    public static final int UnknownRow = -1;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int UnknownColumn = -1;
        public static final int UnknownRow = -1;

        private Companion() {
        }
    }

    int getColumn();

    int getIndex();

    @NotNull
    Object getKey();

    /* renamed from: getOffset-nOcc-ac, reason: not valid java name */
    long mo1565getOffsetnOccac();

    int getRow();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo1566getSizeYbymL2g();
}
