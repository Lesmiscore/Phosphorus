日本語での説明をご覧になりたい方は、[こちら](https://github.com/nao20010128nao/Phosphorus/blob/master/README.ja.md)からご覧頂けます。

# Phosphorus (Atomic number: 15)
A PHAR extractor for JVM written in Groovy   
Extraction restricted? Unable to extract? Let me try! (If the file is not broken)   

# Usage
In command line:
- `--input=(filename)` Input file name (full path) of the PHAR file. (required)
- `--output=(dirname)` Output directory to save extracted result (default is `input+"_extracted"`)
- `--stub=(filename)` Relative path from `output` to export stub file (default is `null`, and do not export)
- `--check` Check the input from command line, and do nothing

# Compile
Please install [Gradle](https://gradle.org) for compilation.    
Change the current directory where this repo cloned, and type this on command line: `gradle assembleExecutableJar`     
You'll see `Phosphorus.jar` at `Repo Directory/build/libs` (Please just ignore other files.)    
