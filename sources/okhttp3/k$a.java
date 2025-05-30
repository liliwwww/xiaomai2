package okhttp3;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class k$a {
    final List<String> a = new ArrayList(20);

    public k$a a(String str, String str2) {
        k.a(str);
        k.b(str2, str);
        return c(str, str2);
    }

    k$a b(String str) {
        int indexOf = str.indexOf(":", 1);
        return indexOf != -1 ? c(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? c("", str.substring(1)) : c("", str);
    }

    k$a c(String str, String str2) {
        this.a.add(str);
        this.a.add(str2.trim());
        return this;
    }

    public k$a d(String str, String str2) {
        k.a(str);
        return c(str, str2);
    }

    public k e() {
        return new k(this);
    }

    public k$a f(String str) {
        int i = 0;
        while (i < this.a.size()) {
            if (str.equalsIgnoreCase(this.a.get(i))) {
                this.a.remove(i);
                this.a.remove(i);
                i -= 2;
            }
            i += 2;
        }
        return this;
    }

    public k$a g(String str, String str2) {
        k.a(str);
        k.b(str2, str);
        f(str);
        c(str, str2);
        return this;
    }
}
