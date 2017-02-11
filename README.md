# Phosphorus (Atomic number: 15)
A PHAR extractor for JVM written in Groovy   
Never extract? Unable to extract? Let me try! (If the file is not broken)   

# Usage
In command line:
- `--input=(filename)` Input file name (full path) of the PHAR file. (required)
- `--output=(dirname)` Output directory to save extracted result (default is `input+"_extracted"`)
- `--stub=(filename)` Relative path from output to save stub file (default is null, and do not save)
- `--check` Check the input from command line, and do nothing

# Compile
Please install [Gradle](https://gradle.org) for compilation.    
And type this on command line: `gradle assembleExecutableJar`     
You'll see `Phosphorus.jar` at `Project Directory/build/libs`    
