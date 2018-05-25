#include <jni.h>
#include <string>
#include <vector>
extern "C"
{

JNIEXPORT
jstring JNICALL Java_com_jaesung_customobjectarray_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());

}

JNIEXPORT
jstring JNICALL Java_com_jaesung_customobjectarray_MainActivity_stringFromJNI2(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++2";
    return env->NewStringUTF(hello.c_str());

}

struct JniStruct{
    jclass cls;
    jmethodID constructorId;

    jfieldID nameId;
};
JniStruct *jniStruct = nullptr;


void LoadJniStruct(JNIEnv *env) {
    if (jniStruct != nullptr) {
        return;
    }

    jniStruct = new JniStruct();

    jniStruct->cls = env->FindClass("com/jaesung/customobjectarray/MyModel");

    jniStruct->constructorId = env->GetMethodID(jniStruct->cls, "<init>", "()V");

    jniStruct->nameId = env->GetFieldID(jniStruct->cls, "name", "Ljava/lang/String;");

}
struct Model {
    std::string name;
};
std::vector<Model> generateModelArray() {
    std::vector<Model> returnArray;
    for (int i = 0; i < 3; ++i) {
        Model model;
        model.name = "nnn";
        returnArray.push_back(model);
    }
    return returnArray;
}
void fillModelValuesToJni(JNIEnv *env, jobject dstObj, Model *src) {
//    void SetObjectField(jobject obj, jfieldID fieldID, jobject value)
    env->SetObjectField(dstObj, jniStruct->nameId, env->NewStringUTF(src->name.c_str()));

}
JNIEXPORT jobjectArray JNICALL
Java_com_jaesung_customobjectarray_MainActivity_getMyModelArray(JNIEnv *env, jclass cls) {
    jniStruct = nullptr;
    LoadJniStruct(env);

    auto result = generateModelArray();
    jobjectArray returnArray = env->NewObjectArray((jsize)result.size(), jniStruct->cls, nullptr);

    for (size_t i = 0 ; i < result.size() ; ++i ) {
        jobject jobj = env->NewObject(jniStruct->cls, jniStruct->constructorId);
        Model *item = &result.at(i);
        fillModelValuesToJni(env, jobj, item);
        env->SetObjectArrayElement(returnArray, i, jobj);
    }
//    return result;
//    for (size_t i = 0; i < result.size(); ++i) {
//
//    }
    return returnArray;
}

}
