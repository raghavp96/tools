Made September 2017

# pdfMerge
Simple tool for PDF merging (more utlity to come).

# Background

There are multiple free online PDF mergers on the internet, and some are very user-friendly.
I've even used a few. Recently, however, I wanted to merge some financial documents, and was
on the verge of using an online tool. I then stopped to consider what happens with the files I upload.
Are they stored? They must be, because the server performing the pdf merge must have to create, at the
very least, the merged document in a temporary location, and then send that document back. What happens
to the temporary file? Is it deleted? How can I be sure.

Rather than worry about the sceruity of online tools, I've created my own that can be use via the command
line, and not have to worry about confidential information being stored.

# Current State

Merging multiple PDFs is possible. I will likely be adding new features, like signing PDFs,
creating new PDF's with a certain text. 

You can now build the project with `mvn clean compile assembly:single` to build the target dir, and then run:

```
java -cp target\pdfMerge-1.0-SNAPSHOT-jar-with-dependencies.jar Runner -merge -save path\to\SaveDir -name fileName.pdf -files "path\To\first.pdf" "path\To\Second.pdf"
```


from the command line.

You can also test it by running: `./test.sh`, which will merge the two PDFs in the testfiles folder.


# Goals
Some short term goals:
  - Consolidate logging and output to console (considering log4j2)
  - Provide build scripts for this tool, so that anyone can clone the project and build the tool
    - Potentially ship the JDK with project, so the user need not have to have JRE installed

Long term:
  - Remove the need for users to even download the tool
  - Host tool on webapp (the issue here is that I would want to show that nothing is saved after it is
  sent back.
