package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.Index$Order;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TableInfo$Index {
    public static final String DEFAULT_PREFIX = "index_";
    public final List<String> columns;
    public final String name;
    public final List<String> orders;
    public final boolean unique;

    public TableInfo$Index(String str, boolean z, List<String> list) {
        this(str, z, list, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo$Index)) {
            return false;
        }
        TableInfo$Index tableInfo$Index = (TableInfo$Index) obj;
        if (this.unique == tableInfo$Index.unique && this.columns.equals(tableInfo$Index.columns) && this.orders.equals(tableInfo$Index.orders)) {
            return this.name.startsWith(DEFAULT_PREFIX) ? tableInfo$Index.name.startsWith(DEFAULT_PREFIX) : this.name.equals(tableInfo$Index.name);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.name.startsWith(DEFAULT_PREFIX) ? -1184239155 : this.name.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
    }

    public String toString() {
        return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + '}';
    }

    public TableInfo$Index(String str, boolean z, List<String> list, List<String> list2) {
        this.name = str;
        this.unique = z;
        this.columns = list;
        this.orders = (list2 == null || list2.size() == 0) ? Collections.nCopies(list.size(), Index$Order.ASC.name()) : list2;
    }
}
