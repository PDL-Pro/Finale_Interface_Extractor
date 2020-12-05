          ## manual test

        we tested 10 links we had a success rate of 100%

        we tested 5 wikipedia links and 5 that  are not wikipedia links

         * for 5 wikipedia links :
          the software returned us the number of tables , and managed to save CSV files

          * for 5 are not wikipedia links:

           the software returned us a message to inform us that is not wikipedia links

     concerning the error  :
                         we noticed that the software dont return a message for inform us that isn't a wikipedia link



     ## test JUnit

     - PageTest : the JUnit tests of the PageTest class work at about 90%
                  the tests fail at the getTitleWithoutSpace () method
                  this function does not manage to extract the title of wikipédias links containing accents

     -SavePathTest:


     - ExtractorTest: the JUnit tests of the ExtractorTest class work at about 90%

                      the problem lies in the compareNumberOfTable method which compares the number of tables found with the number of tables in the wikipedia link


                     the problem lies with the compareNumberOfTable method which compares the number of rows found in the table with the number of rows in the csv




     -PageCheckerTest : the JUnit tests of the PageCheckerTestTest class work at about 95%

                    the TestJUnit of the existingPagesTest_WithoutHttps () method fails to Check if a page without http can be tested


