# Phosphorus (原子番号15)
Groovyで書かれたJVM用PHAR解凍ソフトウェアです。    
解凍禁止? 解凍不可? やってみましょう。(壊れてなければのお話ですが)    

# 使い方
コマンドライン引数にて、
- `--input=(filename)` 入力のPHARファイルのフルパスを指定します。(必須)
- `--output=(dirname)` 解凍したファイルの出力先のディレクトリを指定します。(デフォルトは`input+"_extracted"`)
- `--stub=(filename)` スタブファイルの保存先ファイル名を、`output`からの相対パスで指定します。(デフォルトは`null`で、保存はしません。)
- `--check` コマンドライン引数の内容をチェックするだけで、何もしません。

# コンパイル
コンパイルには、[Gradle](https://gradle.org)が必要です。    
コンパイルの際は、このrepoのあるディレクトリにcdした上で`gradle assembleExecutableJar`を実行して下さい。     
コンパイルに成功すると、`repoのディレクトリ/build/libs`に`Phosphorus.jar`があります。(他のファイルは無視して下さい。)    
