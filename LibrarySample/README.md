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



#### my_jar

**982 byte**

```groovy
compileOnly files("${System.env.ANDROID_HOME}/platforms/android-30/android.jar")
```

can use `android.util.Log package`

file size is smaller than my_pure_aar



**implementation** is also same size with compileOnly?

```groovy
implementation files("${System.env.ANDROID_HOME}platforms/android-30/android.jar")
```



https://stackoverflow.com/questions/44493378/whats-the-difference-between-implementation-and-compile-in-gradle



compile, compileOnly, compileInclude - old command but can understand easily.(jp)

https://www.liferay.co.jp/en/-/blog/tech/gradle-compile-vs-compileonly-vs-compileinclude-jp

