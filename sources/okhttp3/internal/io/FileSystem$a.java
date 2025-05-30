package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;
import okio.h;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class FileSystem$a implements FileSystem {
    FileSystem$a() {
    }

    public Sink appendingSink(File file) throws FileNotFoundException {
        try {
            return h.a(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return h.a(file);
        }
    }

    public void delete(File file) throws IOException {
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("failed to delete " + file);
    }

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

    public boolean exists(File file) {
        return file.exists();
    }

    public void rename(File file, File file2) throws IOException {
        delete(file2);
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException("failed to rename " + file + " to " + file2);
    }

    public Sink sink(File file) throws FileNotFoundException {
        try {
            return h.e(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return h.e(file);
        }
    }

    public long size(File file) {
        return file.length();
    }

    public Source source(File file) throws FileNotFoundException {
        return h.i(file);
    }
}
