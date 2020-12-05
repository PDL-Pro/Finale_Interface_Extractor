Design
======


## Project Architecture

WikipediaMatrix is composed of two main packages. One with main source code called src/main/java and an other one with tests class called src/test/java.

### Source code

The first package contains Extractor.java, an interface implemented by two class HTMLExtractor.java and WikiTextExtractor.java. They allow the conversion of tables from HTML and WikiText pages to CSV format. The class page.java is used to recover the title from the wikipedia page. To parse the page to be processed we use the abstract PageChecker.java class in the URL.java class. Its check the links and if there are tables in the page. WikipediaMatrix.java is the main class with the user interface.

## Diagrams

### Class diagram

![](/media/PDL_Master.png)

- A page given to necessarily, one and only one URL

- PageChecker checks one or more Page and a Page is checked by a single PageChecker

- WikiTextExtractor and HTMLExtractor inherit the interface

- WikipediaMatrix has 0 or more Pages, relation -> from WikipediaMatrix to Page

- WikipediaMatrix has 0 or more Urls, relation -> from WikipediaMatrix to Url
### Sequence Diagram

#### Add wikipedia link

![](/media/Sequence_Diagram_addLink.jpg)

#### Save tables as csv

![](/media/Sequence_Diagram_saveCSV.jpg)

### Use Case

![](/media/Use_Case.png)
- The user can put Wikipedia links in wikipedia_links_list.txt file to extract the tables from the page. He can add and remove several.
- The user can choose the backup path to save the tables in save_path.txt file.

- We found that the previous diagram did not correctly describe all the use cases. We therefore mean the 5 features developed for said project, namely a user can:

- List the links

- Add a link

- Remove a link

- Change the save location

- Save tables



Include (The user is connected to the application)
