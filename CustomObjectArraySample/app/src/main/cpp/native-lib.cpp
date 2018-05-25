#include <jni.h>
#include <string>
#include <vector>

extern "C" {
JNIEXPORT jstring

JNICALL
Java_com_jaesung_customobjectarraysample_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


typedef struct _JNI_POSREC {
    jclass cls;
    jmethodID constructorID;

    jfieldID nameID;
    jfieldID rollNumberID;
    jfieldID departementID;
    jfieldID totalMarkID;
    jfieldID hasReservationID;

} JNI_POSREC;

/**
*   Return Search class.
*/
struct SearchRecord {
    std::string name;
    int rollNumber;
    std::string departement;
    float totalMark;
    bool hasReservation;
};

JNI_POSREC *jniPosRec = NULL;

/**
*   Fills the Student Record Details.
*/
void FillStudentRecordDetails(std::vector<SearchRecord *> *searchRecordResult) {
    SearchRecord *pRecord1 = new SearchRecord();
    pRecord1->name = "Ram";
    pRecord1->rollNumber = 1;
    pRecord1->departement = "Computer Science";
    pRecord1->totalMark = 512.500;
    pRecord1->hasReservation = true;
    searchRecordResult->push_back(pRecord1);

    SearchRecord *pRecord2 = new SearchRecord();
    pRecord2->name = "Raju";
    pRecord2->rollNumber = 2;
    pRecord2->departement = "Electronics";
    pRecord2->totalMark = 572.25;
    pRecord2->hasReservation = false;
    searchRecordResult->push_back(pRecord2);
}

/**
*   Fills JNI details.
*/
void LoadJniPosRec(JNIEnv *env) {

    if (jniPosRec != NULL)
        return;

    jniPosRec = new JNI_POSREC;

    jniPosRec->cls = env->FindClass("com/jaesung/customobjectarraysample/StudentRecord");

    if (jniPosRec->cls != NULL) {
        printf("sucessfully created class");
    }

    jniPosRec->constructorID = env->GetMethodID(jniPosRec->cls, "<init>", "()V");
    if (jniPosRec->constructorID != NULL) {
        printf("sucessfully created constructorID");
    }

    jniPosRec->nameID = env->GetFieldID(jniPosRec->cls, "name", "Ljava/lang/String;");
    jniPosRec->rollNumberID = env->GetFieldID(jniPosRec->cls, "rollNumber", "I");
    jniPosRec->departementID = env->GetFieldID(jniPosRec->cls, "departement", "Ljava/lang/String;");
    jniPosRec->totalMarkID = env->GetFieldID(jniPosRec->cls, "totalMark", "F");
    jniPosRec->hasReservationID = env->GetFieldID(jniPosRec->cls, "hasReservation", "Z");

}

void FillStudentRecValuesToJni(JNIEnv *env, jobject jPosRec, SearchRecord *cPosRec) {

    env->SetObjectField(jPosRec, jniPosRec->nameID, env->NewStringUTF(cPosRec->name.c_str()));
    jint rollNum = (jint) cPosRec->rollNumber;
    env->SetIntField(jPosRec, jniPosRec->rollNumberID, rollNum);
    env->SetObjectField(jPosRec, jniPosRec->departementID,
                        env->NewStringUTF(cPosRec->departement.c_str()));
    jfloat totalMark = (jfloat) cPosRec->totalMark;
    env->SetFloatField(jPosRec, jniPosRec->totalMarkID, totalMark);
    jboolean hasReservation = (jboolean) cPosRec->hasReservation;
    env->SetBooleanField(jPosRec, jniPosRec->hasReservationID, hasReservation);
}

/**
* JNI method calling from JAVA
*/
JNIEXPORT jobjectArray JNICALL
Java_com_jaesung_customobjectarraysample_MainActivity_getStudentDetails(JNIEnv *env, jclass cls) {
    jniPosRec = NULL;
    LoadJniPosRec(env);
    std::vector<SearchRecord *> searchRecordResult;
    FillStudentRecordDetails(&searchRecordResult);
    printf("searchRecordResult size is = %ld", searchRecordResult.size());
    jobjectArray jPosRecArray = env->NewObjectArray((jsize) searchRecordResult.size(), jniPosRec->cls,
                                                    NULL);

    for (size_t i = 0; i < searchRecordResult.size(); i++) {
        jobject jPosRec = env->NewObject(jniPosRec->cls, jniPosRec->constructorID);
        FillStudentRecValuesToJni(env, jPosRec, searchRecordResult[i]);
        env->SetObjectArrayElement(jPosRecArray, i, jPosRec);
    }

    return jPosRecArray;
}

}
