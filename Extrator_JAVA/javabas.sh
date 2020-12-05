echo "----------Execution de l'extrateur JAVA -----------------"
cd "/home/bamba/Bureau/Interface_Extrator/extracteur"
mvn exec:java -Dexec.mainClass="pdl.wiki.WikipediaMatrixInterface" -Dexec.classpathScope=runtime

