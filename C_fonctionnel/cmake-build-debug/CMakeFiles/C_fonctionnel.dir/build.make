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
CMAKE_SOURCE_DIR = /home/maxwell/Desktop/1A/untitled/C_fonctionnel

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/maxwell/Desktop/1A/untitled/C_fonctionnel/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/C_fonctionnel.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/C_fonctionnel.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/C_fonctionnel.dir/flags.make

CMakeFiles/C_fonctionnel.dir/main.c.o: CMakeFiles/C_fonctionnel.dir/flags.make
CMakeFiles/C_fonctionnel.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/maxwell/Desktop/1A/untitled/C_fonctionnel/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/C_fonctionnel.dir/main.c.o"
	/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/C_fonctionnel.dir/main.c.o   -c /home/maxwell/Desktop/1A/untitled/C_fonctionnel/main.c

CMakeFiles/C_fonctionnel.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/C_fonctionnel.dir/main.c.i"
	/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/maxwell/Desktop/1A/untitled/C_fonctionnel/main.c > CMakeFiles/C_fonctionnel.dir/main.c.i

CMakeFiles/C_fonctionnel.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/C_fonctionnel.dir/main.c.s"
	/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/maxwell/Desktop/1A/untitled/C_fonctionnel/main.c -o CMakeFiles/C_fonctionnel.dir/main.c.s

CMakeFiles/C_fonctionnel.dir/main.c.o.requires:

.PHONY : CMakeFiles/C_fonctionnel.dir/main.c.o.requires

CMakeFiles/C_fonctionnel.dir/main.c.o.provides: CMakeFiles/C_fonctionnel.dir/main.c.o.requires
	$(MAKE) -f CMakeFiles/C_fonctionnel.dir/build.make CMakeFiles/C_fonctionnel.dir/main.c.o.provides.build
.PHONY : CMakeFiles/C_fonctionnel.dir/main.c.o.provides

CMakeFiles/C_fonctionnel.dir/main.c.o.provides.build: CMakeFiles/C_fonctionnel.dir/main.c.o


# Object files for target C_fonctionnel
C_fonctionnel_OBJECTS = \
"CMakeFiles/C_fonctionnel.dir/main.c.o"

# External object files for target C_fonctionnel
C_fonctionnel_EXTERNAL_OBJECTS =

C_fonctionnel: CMakeFiles/C_fonctionnel.dir/main.c.o
C_fonctionnel: CMakeFiles/C_fonctionnel.dir/build.make
C_fonctionnel: CMakeFiles/C_fonctionnel.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/maxwell/Desktop/1A/untitled/C_fonctionnel/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable C_fonctionnel"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/C_fonctionnel.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/C_fonctionnel.dir/build: C_fonctionnel

.PHONY : CMakeFiles/C_fonctionnel.dir/build

CMakeFiles/C_fonctionnel.dir/requires: CMakeFiles/C_fonctionnel.dir/main.c.o.requires

.PHONY : CMakeFiles/C_fonctionnel.dir/requires

CMakeFiles/C_fonctionnel.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/C_fonctionnel.dir/cmake_clean.cmake
.PHONY : CMakeFiles/C_fonctionnel.dir/clean

CMakeFiles/C_fonctionnel.dir/depend:
	cd /home/maxwell/Desktop/1A/untitled/C_fonctionnel/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/maxwell/Desktop/1A/untitled/C_fonctionnel /home/maxwell/Desktop/1A/untitled/C_fonctionnel /home/maxwell/Desktop/1A/untitled/C_fonctionnel/cmake-build-debug /home/maxwell/Desktop/1A/untitled/C_fonctionnel/cmake-build-debug /home/maxwell/Desktop/1A/untitled/C_fonctionnel/cmake-build-debug/CMakeFiles/C_fonctionnel.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/C_fonctionnel.dir/depend

