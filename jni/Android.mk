LOCAL_PATH := $(call my-dir)
 
include $(CLEAR_VARS)
 
LOCAL_LDLIBS    := -llog
 
LOCAL_MODULE    := main-lib
LOCAL_SRC_FILES := main.cpp game_item.cpp map.cpp monster.cpp Player.cpp room.cpp spell.cpp
 
include $(BUILD_SHARED_LIBRARY)