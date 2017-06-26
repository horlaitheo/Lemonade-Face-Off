cmake_minimum_required(VERSION 3.7)
project(Serial)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c11 -lcurl")

set(SOURCE_FILES main.c)
add_executable(Serial ${SOURCE_FILES})
target_link_libraries(Serial curl)