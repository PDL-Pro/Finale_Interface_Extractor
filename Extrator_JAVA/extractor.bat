@echo off
cls
call echo "----------Execution de l'extrateur JAVA -----------------"
cd "home/bamba/Bureau/Interface_Extrator/extracteur/src/main/java/pdl/wiki"
call mvn exec:java -Dexec.mainClass="pdl.wiki.WikipediaMatrixInterface" -Dexec.classpathScope=runtime


pause


