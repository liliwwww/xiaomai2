package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Table$1 implements Comparator<Integer> {
    final /* synthetic */ Table this$0;
    final /* synthetic */ ByteBuffer val$bb;

    Table$1(Table table, ByteBuffer byteBuffer) {
        this.this$0 = table;
        this.val$bb = byteBuffer;
    }

    @Override // java.util.Comparator
    public int compare(Integer num, Integer num2) {
        return this.this$0.keysCompare(num, num2, this.val$bb);
    }
}
