package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.C1421a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    RouteException(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    void addConnectException(IOException iOException) {
        C1421a.m465b(this.firstException, iOException);
        this.lastException = iOException;
    }

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }
}
