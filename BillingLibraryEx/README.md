# BillingLibraryEx

if use implementation billing library in aar, app can use billing feature without implementation billing library.

aar only defines implementation in dependencies
```groovy
dependencies {
    def billing_version = "4.0.0"
    implementation "com.android.billingclient:billing:$billing_version"
}
```

if use compileOnly and do not import(implementation) external library.
I causes crash.

aar
```groovy
dependencies {
    def billing_version = "4.0.0"
    compileOnly "com.android.billingclient:billing:$billing_version"
}
```

```
2021-07-15 02:55:29.790 5424-5424/com.js.billing.libraryex E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.js.billing.libraryex, PID: 5424
    java.lang.NoClassDefFoundError: Failed resolution of: Lcom/android/billingclient/api/PurchasesUpdatedListener;
```

app
```groovy
dependencies {
    def billing_version = "4.0.0"
    implementation "com.android.billingclient:billing:$billing_version"
}
```

if use implementation in library it increases aar size.
about **36KB**

if use compileOnly it size is only **4KB**
if create empty android library, it size is about **3KB**.

