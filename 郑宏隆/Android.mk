LOCAL_PATH:=$(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE:=CVE-2014-3153
LOCAL_SRC_FILES:=CVE-2014-3153.c
LOCAL_LDFLAGS += --static
LOCAL_FORCE_STATIC_EXECUTABLE := true


include $(BUILD_EXECUTABLE)
