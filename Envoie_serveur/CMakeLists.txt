cmake_minimum_required(VERSION 3.7)
project(Envoie_serveur serveur)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c11 -lcurl")

set(SOURCE_FILES main.c)
add_executable(Envoie_serveur ${SOURCE_FILES})
target_link_libraries(Envoie_serveur curl)
