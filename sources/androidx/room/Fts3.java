package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.TYPE})
@RequiresApi(16)
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public @interface Fts3 {
    String tokenizer() default "simple";

    String[] tokenizerArgs() default {};
}
