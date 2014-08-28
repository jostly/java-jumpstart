# Enhetstest av innehav

Sedan tidigare har vi en klass för att spåra innehav, samt metoder för att öka och minska innehavet. Nu vill vi ha ett enkelt sätt att verifiera att klassen fungerar som det är tänkt, samt ett sätt att se ifall vidare kodning råkar förstöra funktionalitet.

## Förbered projektet för enhetstestning (i IntelliJ)

1. Högerklicka på projektet och välj New -> Directory ![](create-test-folder.png)

2. Namnge nya mappen "test" eller "tests" eller vad ni tycker passar (test är standard)

3. Högerklicka på den nya mappen och välja Mark Directory As -> Test Sources Root ![](mark-folder-as-test-sources.png)

## Skapa ett nytt test

1. Högerklicka på klassnamnet **i editorfönstret** och välj Go To -> Test ![](go-to-test.png)

2. Välj "Create new test" ![](create-new-test.png)

3. Välj JUnit4 under "Testing library". Ni får en varning att den inte hittar JUnit4 i modulen. Klicka på "Fix" längst till höger. ![](add-junit-to-project.png)

4. Klicka OK




