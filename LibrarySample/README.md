# LibrarySample



### aar vs jar

aar has more resource related android.



### aar

from empty android project

file > new > new module > Android Library

set cursor library project directory > Build > Make Module

### jar

from empty android project

file > new > new module > Java or Kotlin Library



#### my_aar
normal android library

34kb size output

using custom activity

```groovy
implementation 'androidx.appcompat:appcompat:1.3.0'
implementation 'com.google.android.material:material:1.4.0'
```

#### my_pure_aar

pure android library

**2k** size output

using Log

removed all dependencies

using android .jar internal



**13KB** added below dependencies

```groovy
compileOnly 'androidx.appcompat:appcompat:1.3.0'
```

almost same size aar output **14KB**

```groovy
implementation 'androidx.appcompat:appcompat:1.3.0'
```

