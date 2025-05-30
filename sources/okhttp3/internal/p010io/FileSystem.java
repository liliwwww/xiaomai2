package okhttp3.internal.p010io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;
import okio.h;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = new C1461a();

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.io.FileSystem$a */
    /* loaded from: classes2.dex */
    class C1461a implements FileSystem {
        C1461a() {
        }

        @Override // okhttp3.internal.p010io.FileSystem
        public Sink appendingSink(File file) throws FileNotFoundException {
            try {
                return h.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return h.a(file);
            }
        }

        @Override // okhttp3.internal.p010io.FileSystem
        public void delete(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.p010io.FileSystem
        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }

        @Override // okhttp3.internal.p010io.FileSystem
        public boolean exists(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.p010io.FileSystem
        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.p010io.FileSystem
        public Sink sink(File file) throws FileNotFoundException {
            try {
                return h.e(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return h.e(file);
            }
        }

        @Override // okhttp3.internal.p010io.FileSystem
        public long size(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.p010io.FileSystem
        public Source source(File file) throws FileNotFoundException {
            return h.i(file);
        }
    }

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
