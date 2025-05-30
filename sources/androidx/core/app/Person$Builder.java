package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Person$Builder {

    @Nullable
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;

    @Nullable
    String mKey;

    @Nullable
    CharSequence mName;

    @Nullable
    String mUri;

    public Person$Builder() {
    }

    @NonNull
    public Person build() {
        return new Person(this);
    }

    @NonNull
    public Person$Builder setBot(boolean z) {
        this.mIsBot = z;
        return this;
    }

    @NonNull
    public Person$Builder setIcon(@Nullable IconCompat iconCompat) {
        this.mIcon = iconCompat;
        return this;
    }

    @NonNull
    public Person$Builder setImportant(boolean z) {
        this.mIsImportant = z;
        return this;
    }

    @NonNull
    public Person$Builder setKey(@Nullable String str) {
        this.mKey = str;
        return this;
    }

    @NonNull
    public Person$Builder setName(@Nullable CharSequence charSequence) {
        this.mName = charSequence;
        return this;
    }

    @NonNull
    public Person$Builder setUri(@Nullable String str) {
        this.mUri = str;
        return this;
    }

    Person$Builder(Person person) {
        this.mName = person.mName;
        this.mIcon = person.mIcon;
        this.mUri = person.mUri;
        this.mKey = person.mKey;
        this.mIsBot = person.mIsBot;
        this.mIsImportant = person.mIsImportant;
    }
}
