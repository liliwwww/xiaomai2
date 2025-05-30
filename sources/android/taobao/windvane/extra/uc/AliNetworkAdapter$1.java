package android.taobao.windvane.extra.uc;

import android.net.Uri;
import android.taobao.windvane.util.TaoLog;
import anetwork.channel.IBodyHandler;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AliNetworkAdapter$1 implements IBodyHandler {
    byte[] buffer;
    List<InputStream> instream;
    final /* synthetic */ AliNetworkAdapter this$0;
    final /* synthetic */ Map val$dataMap;
    final /* synthetic */ Map val$fileMap;
    final /* synthetic */ int val$totalFileNum;
    boolean isCompleted = false;
    int postedLen = 0;
    int curFilenum = 0;
    String fileNameValue = null;
    byte[] dataValue = null;
    boolean hasInitilized = false;

    AliNetworkAdapter$1(AliNetworkAdapter aliNetworkAdapter, int i, Map map, Map map2) {
        this.this$0 = aliNetworkAdapter;
        this.val$totalFileNum = i;
        this.val$fileMap = map;
        this.val$dataMap = map2;
        this.buffer = new byte[AliNetworkAdapter.access$000(aliNetworkAdapter)];
        this.instream = new ArrayList(i);
    }

    public void initStream() {
        try {
            this.curFilenum = 0;
            while (true) {
                int i = this.curFilenum;
                if (i >= this.val$totalFileNum) {
                    return;
                }
                this.fileNameValue = (String) this.val$fileMap.get(String.valueOf(i));
                this.dataValue = (byte[]) this.val$dataMap.get(String.valueOf(this.curFilenum));
                if (TaoLog.getLogStatus() && this.dataValue != null) {
                    String str = this.this$0.LOGTAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("len =");
                    sb.append(this.dataValue.length);
                    sb.append(",datavalue=");
                    byte[] bArr = this.dataValue;
                    sb.append(new String(bArr, 0, bArr.length));
                    TaoLog.d(str, sb.toString());
                }
                String str2 = this.fileNameValue;
                if (str2 == null) {
                    this.instream.add(this.curFilenum, new ByteArrayInputStream(this.dataValue));
                } else if (str2.toLowerCase().startsWith("content://")) {
                    this.instream.add(this.curFilenum, AliNetworkAdapter.access$100(this.this$0).getContentResolver().openInputStream(Uri.parse(this.fileNameValue)));
                } else {
                    this.instream.add(this.curFilenum, new FileInputStream(this.fileNameValue));
                }
                this.curFilenum++;
            }
        } catch (Exception unused) {
        }
    }

    public boolean isCompleted() {
        boolean z = this.isCompleted;
        if (!z) {
            return z;
        }
        this.isCompleted = false;
        this.hasInitilized = false;
        try {
            Iterator<InputStream> it = this.instream.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.instream.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int read(byte[] bArr) {
        if (!this.hasInitilized) {
            initStream();
            List<InputStream> list = this.instream;
            if (list == null || list.size() == 0) {
                this.isCompleted = true;
                return 0;
            }
            this.hasInitilized = true;
        }
        Iterator<InputStream> it = this.instream.iterator();
        while (it.hasNext()) {
            try {
                int read = it.next().read(this.buffer, 0, AliNetworkAdapter.access$000(this.this$0) > bArr.length ? bArr.length : AliNetworkAdapter.access$000(this.this$0));
                if (read != -1) {
                    System.arraycopy(this.buffer, 0, bArr, 0, read);
                    this.postedLen += read;
                    TaoLog.i(this.this$0.LOGTAG, "read len=" + read);
                    return read;
                }
            } catch (Exception e) {
                TaoLog.i(this.this$0.LOGTAG, "read exception" + e.getMessage());
                this.isCompleted = true;
                return 0;
            }
        }
        TaoLog.i(this.this$0.LOGTAG, "read finish");
        this.isCompleted = true;
        return 0;
    }
}
