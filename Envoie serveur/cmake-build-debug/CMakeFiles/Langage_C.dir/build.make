# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.7

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /opt/clion-2017/bin/cmake/bin/cmake

# The command to remove a file.
RM = /opt/clion-2017/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/maxwell/Desktop/1A/Projet_dinte/Langage_C

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/maxwell/Desktop/1A/Projet_dinte/Langage_C/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Langage_C.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Langage_C.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Langage_C.dir/flags.make

CMakeFiles/Langage_C.dir/main.c.o: CMakeFiles/Langage_C.dir/flags.make
CMakeFiles/Langage_C.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/maxwell/Desktop/1A/Projet_dinte/Langage_C/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/Langage_C.dir/main.c.o"
	/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/Langage_C.dir/main.c.o   -c /home/maxwell/Desktop/1A/Projet_dinte/Langage_C/main.c

CMakeFiles/Langage_C.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Langage_C.dir/main.c.i"
	/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/maxwell/Desktop/1A/Projet_dinte/Langage_C/main.c > CMakeFiles/Langage_C.dir/main.c.i

CMakeFiles/Langage_C.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Langage_C.dir/main.c.s"
	/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/maxwell/Desktop/1A/Projet_dinte/Langage_C/main.c -o CMakeFiles/Langage_C.dir/main.c.s

CMakeFiles/Langage_C.dir/main.c.o.requires:

.PHONY : CMakeFiles/Langage_C.dir/main.c.o.requires

CMakeFiles/Langage_C.dir/main.c.o.provides: CMakeFiles/Langage_C.dir/main.c.o.requires
	$(MAKE) -f CMakeFiles/Langage_C.dir/build.make CMakeFiles/Langage_C.dir/main.c.o.provides.build
.PHONY : CMakeFiles/Langage_C.dir/main.c.o.provides

CMakeFiles/Langage_C.dir/main.c.o.provides.build: CMakeFiles/Langage_C.dir/main.c.o


# Object files for target Langage_C
Langage_C_OBJECTS = \
"CMakeFiles/Langage_C.dir/main.c.o"

# External object files for target Langage_C
Langage_C_EXTERNAL_OBJECTS =

Langage_C: CMakeFiles/Langage_C.dir/main.c.o
Langage_C: CMakeFiles/Langage_C.dir/build.make
Langage_C: CMakeFiles/Langage_C.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/maxwell/Desktop/1A/Projet_dinte/Langage_C/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable Langage_C"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Langage_C.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Langage_C.dir/build: Langage_C

.PHONY : CMakeFiles/Langage_C.dir/build

CMakeFiles/Langage_C.dir/requires: CMakeFiles/Langage_C.dir/main.c.o.requires

.PHONY : CMakeFiles/Langage_C.dir/requires

CMakeFiles/Langage_C.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Langage_C.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Langage_C.dir/clean

CMakeFiles/Langage_C.dir/depend:
	cd /home/maxwell/Desktop/1A/Projet_dinte/Langage_C/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/maxwell/Desktop/1A/Projet_dinte/Langage_C /home/maxwell/Desktop/1A/Projet_dinte/Langage_C /home/maxwell/Desktop/1A/Projet_dinte/Langage_C/cmake-build-debug /home/maxwell/Desktop/1A/Projet_dinte/Langage_C/cmake-build-debug /home/maxwell/Desktop/1A/Projet_dinte/Langage_C/cmake-build-debug/CMakeFiles/Langage_C.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Langage_C.dir/depend
