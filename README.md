# Phosphorus (Atomic number: 15)
A PHAR extractor for JVM written in Groovy   
Never extract? Unable to extract? Let me try!   

# Usage
In command line:
- `--input=(filename)` Input file name (full path) of the PHAR file. (required)
- `--output=(dirname)` Output directory to save extracted result (default is `input+"_extracted"`)
- `--stub=(filename)` Relative path from output to save stub file (default is null, and never save)
- `--check` Check the input from command line, and never save any file
