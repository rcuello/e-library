@echo off
cd "elibraryConsoleApp\"


set JAVA_HOME=C:\Program Files\Java\jdk-18.0.2
set Maven_Home="C:\Program Files\NetBeans-14\netbeans\java\maven\bin\mvn"

echo Cambiando entorno java a la version %JAVA_HOME%

echo Compilar proyecto

call %Maven_Home% clean install


pause