package androidx.room.util;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TableInfo$Column {

    @ColumnInfo.SQLiteTypeAffinity
    public final int affinity;
    public final String defaultValue;
    private final int mCreatedFrom;
    public final String name;
    public final boolean notNull;
    public final int primaryKeyPosition;
    public final String type;

    @Deprecated
    public TableInfo$Column(String str, String str2, boolean z, int i) {
        this(str, str2, z, i, null, 0);
    }

    private static boolean containsSurroundingParenthesis(@NonNull String str) {
        if (str.length() == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (i2 == 0 && charAt != '(') {
                return false;
            }
            if (charAt == '(') {
                i++;
            } else if (charAt == ')' && i - 1 == 0 && i2 != str.length() - 1) {
                return false;
            }
        }
        return i == 0;
    }

    public static boolean defaultValueEquals(@NonNull String str, @Nullable String str2) {
        if (str2 == null) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        if (containsSurroundingParenthesis(str)) {
            return str.substring(1, str.length() - 1).trim().equals(str2);
        }
        return false;
    }

    @ColumnInfo.SQLiteTypeAffinity
    private static int findAffinity(@Nullable String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.US);
        if (upperCase.contains("INT")) {
            return 3;
        }
        if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
            return 2;
        }
        if (upperCase.contains("BLOB")) {
            return 5;
        }
        return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo$Column)) {
            return false;
        }
        TableInfo$Column tableInfo$Column = (TableInfo$Column) obj;
        if (Build.VERSION.SDK_INT >= 20) {
            if (this.primaryKeyPosition != tableInfo$Column.primaryKeyPosition) {
                return false;
            }
        } else if (isPrimaryKey() != tableInfo$Column.isPrimaryKey()) {
            return false;
        }
        if (!this.name.equals(tableInfo$Column.name) || this.notNull != tableInfo$Column.notNull) {
            return false;
        }
        if (this.mCreatedFrom == 1 && tableInfo$Column.mCreatedFrom == 2 && (str3 = this.defaultValue) != null && !defaultValueEquals(str3, tableInfo$Column.defaultValue)) {
            return false;
        }
        if (this.mCreatedFrom == 2 && tableInfo$Column.mCreatedFrom == 1 && (str2 = tableInfo$Column.defaultValue) != null && !defaultValueEquals(str2, this.defaultValue)) {
            return false;
        }
        int i = this.mCreatedFrom;
        return (i == 0 || i != tableInfo$Column.mCreatedFrom || ((str = this.defaultValue) == null ? tableInfo$Column.defaultValue == null : defaultValueEquals(str, tableInfo$Column.defaultValue))) && this.affinity == tableInfo$Column.affinity;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
    }

    public boolean isPrimaryKey() {
        return this.primaryKeyPosition > 0;
    }

    public String toString() {
        return "Column{name='" + this.name + "', type='" + this.type + "', affinity='" + this.affinity + "', notNull=" + this.notNull + ", primaryKeyPosition=" + this.primaryKeyPosition + ", defaultValue='" + this.defaultValue + "'}";
    }

    public TableInfo$Column(String str, String str2, boolean z, int i, String str3, int i2) {
        this.name = str;
        this.type = str2;
        this.notNull = z;
        this.primaryKeyPosition = i;
        this.affinity = findAffinity(str2);
        this.defaultValue = str3;
        this.mCreatedFrom = i2;
    }
}
