package androidx.room;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class RoomDatabase$MigrationContainer {
    private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations = new HashMap<>();

    private void addMigration(Migration migration) {
        int i = migration.startVersion;
        int i2 = migration.endVersion;
        TreeMap<Integer, Migration> treeMap = this.mMigrations.get(Integer.valueOf(i));
        if (treeMap == null) {
            treeMap = new TreeMap<>();
            this.mMigrations.put(Integer.valueOf(i), treeMap);
        }
        Migration migration2 = treeMap.get(Integer.valueOf(i2));
        if (migration2 != null) {
            Log.w("ROOM", "Overriding migration " + migration2 + " with " + migration);
        }
        treeMap.put(Integer.valueOf(i2), migration);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0016 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<androidx.room.migration.Migration> findUpMigrationPath(java.util.List<androidx.room.migration.Migration> r7, boolean r8, int r9, int r10) {
        /*
            r6 = this;
        L0:
            if (r8 == 0) goto L5
            if (r9 >= r10) goto L5a
            goto L7
        L5:
            if (r9 <= r10) goto L5a
        L7:
            java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.migration.Migration>> r0 = r6.mMigrations
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            java.lang.Object r0 = r0.get(r1)
            java.util.TreeMap r0 = (java.util.TreeMap) r0
            r1 = 0
            if (r0 != 0) goto L17
            return r1
        L17:
            if (r8 == 0) goto L1e
            java.util.NavigableSet r2 = r0.descendingKeySet()
            goto L22
        L1e:
            java.util.Set r2 = r0.keySet()
        L22:
            java.util.Iterator r2 = r2.iterator()
        L26:
            boolean r3 = r2.hasNext()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L56
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r8 == 0) goto L40
            if (r3 > r10) goto L45
            if (r3 <= r9) goto L45
        L3e:
            r5 = 1
            goto L45
        L40:
            if (r3 < r10) goto L45
            if (r3 >= r9) goto L45
            goto L3e
        L45:
            if (r5 == 0) goto L26
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            java.lang.Object r9 = r0.get(r9)
            androidx.room.migration.Migration r9 = (androidx.room.migration.Migration) r9
            r7.add(r9)
            r9 = r3
            goto L57
        L56:
            r4 = 0
        L57:
            if (r4 != 0) goto L0
            return r1
        L5a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase$MigrationContainer.findUpMigrationPath(java.util.List, boolean, int, int):java.util.List");
    }

    public void addMigrations(@NonNull Migration... migrationArr) {
        for (Migration migration : migrationArr) {
            addMigration(migration);
        }
    }

    @Nullable
    public List<Migration> findMigrationPath(int i, int i2) {
        if (i == i2) {
            return Collections.emptyList();
        }
        return findUpMigrationPath(new ArrayList(), i2 > i, i, i2);
    }

    @NonNull
    public Map<Integer, Map<Integer, Migration>> getMigrations() {
        return Collections.unmodifiableMap(this.mMigrations);
    }

    public void addMigrations(@NonNull List<Migration> list) {
        Iterator<Migration> it = list.iterator();
        while (it.hasNext()) {
            addMigration(it.next());
        }
    }
}
