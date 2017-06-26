cmake_minimum_required(VERSION 3.7)
project(C_fonctionnel)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c11 -lcurl")

set(SOURCE_FILES main.c)
add_executable(C_fonctionnel ${SOURCE_FILES})
target_link_libraries(C_fonctionnel curl)