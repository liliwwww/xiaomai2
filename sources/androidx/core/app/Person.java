package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.graphics.drawable.IconCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";

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

    /* compiled from: Taobao */
    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Person fromPersistableBundle(PersistableBundle persistableBundle) {
            return new Builder().setName(persistableBundle.getString("name")).setUri(persistableBundle.getString(Person.URI_KEY)).setKey(persistableBundle.getString(Person.KEY_KEY)).setBot(persistableBundle.getBoolean(Person.IS_BOT_KEY)).setImportant(persistableBundle.getBoolean(Person.IS_IMPORTANT_KEY)).build();
        }

        @DoNotInline
        static PersistableBundle toPersistableBundle(Person person) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = person.mName;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString(Person.URI_KEY, person.mUri);
            persistableBundle.putString(Person.KEY_KEY, person.mKey);
            persistableBundle.putBoolean(Person.IS_BOT_KEY, person.mIsBot);
            persistableBundle.putBoolean(Person.IS_IMPORTANT_KEY, person.mIsImportant);
            return persistableBundle;
        }
    }

    /* compiled from: Taobao */
    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Person fromAndroidPerson(android.app.Person person) {
            return new Builder().setName(person.getName()).setIcon(person.getIcon() != null ? IconCompat.createFromIcon(person.getIcon()) : null).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }

        @DoNotInline
        static android.app.Person toAndroidPerson(Person person) {
            return new Person.Builder().setName(person.getName()).setIcon(person.getIcon() != null ? person.getIcon().toIcon() : null).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }
    }

    Person(Builder builder) {
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person person) {
        return Api28Impl.fromAndroidPerson(person);
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(ICON_KEY);
        return new Builder().setName(bundle.getCharSequence("name")).setIcon(bundle2 != null ? IconCompat.createFromBundle(bundle2) : null).setUri(bundle.getString(URI_KEY)).setKey(bundle.getString(KEY_KEY)).setBot(bundle.getBoolean(IS_BOT_KEY)).setImportant(bundle.getBoolean(IS_IMPORTANT_KEY)).build();
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle persistableBundle) {
        return Api22Impl.fromPersistableBundle(persistableBundle);
    }

    @Nullable
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @Nullable
    public String getKey() {
        return this.mKey;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    @Nullable
    public String getUri() {
        return this.mUri;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public String resolveToLegacyUri() {
        String str = this.mUri;
        if (str != null) {
            return str;
        }
        if (this.mName == null) {
            return "";
        }
        return "name:" + ((Object) this.mName);
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        return Api28Impl.toAndroidPerson(this);
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.mName);
        IconCompat iconCompat = this.mIcon;
        bundle.putBundle(ICON_KEY, iconCompat != null ? iconCompat.toBundle() : null);
        bundle.putString(URI_KEY, this.mUri);
        bundle.putString(KEY_KEY, this.mKey);
        bundle.putBoolean(IS_BOT_KEY, this.mIsBot);
        bundle.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return bundle;
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        return Api22Impl.toPersistableBundle(this);
    }
}
