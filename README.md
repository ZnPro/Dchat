# Dchat
![bandicam 2021-04-06 12-29-06-865](https://user-images.githubusercontent.com/35490108/113655380-a4f9ce80-96d4-11eb-9f8b-64d255caa3e6.gif)

### 1차 임시 쓰는 java 파일
- ChatActivity.java
- ChatAdapter.java
- ChatData.java
- MainActivity.java


### 1차 임시 쓰는 res 파일
- activity_chat.xml
- activity_main.xml(activity_list_item.xml이랑 )
- row_chat.xml


### 1차 임시 쓰는 나머지

- drawable, values 전체


### gradle
프로젝트
```
dependencies {
        classpath "com.android.tools.build:gradle:4.1.3"

        classpath 'com.google.gms:google-services:4.3.5'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
```

앱
```


dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.google.firebase:firebase-core:18.0.2'
    implementation 'com.google.firebase:firebase-storage:19.2.2'
    implementation platform('com.google.firebase:firebase-bom:26.7.0')
    //noinspection GradleCompatible
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.firebase:firebase-database'
    implementation 'de.hdodenhof:circleimageview:3.1.0'
    implementation 'com.google.android.material:material:1.4.0-alpha02'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.10.0'


    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'org.jetbrains:annotations:15.0'
    implementation 'androidx.recyclerview:recyclerview:1.2.0-rc01'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
}

//gms.google-services는 맨 마지막에 넣는게 오류가 안뜬다.
apply plugin: 'com.google.gms.google-services'
```


