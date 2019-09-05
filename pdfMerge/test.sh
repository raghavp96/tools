echo "Listing files in tesfiles directory...."
ls testfiles

echo "Building pdfMerge ..."
mvn clean compile assembly:single
echo "Running pdfMerge to merge both files ..."
java -cp "target/pdfMerge-1.0-SNAPSHOT-jar-with-dependencies.jar" Runner -merge -save "testfiles" -name fileOut.pdf -files "testfiles/test1.pdf" "testfiles/test2.pdf"
echo "Destroying pdfMerge..."
mvn clean

echo "Listing files in testfiles directory...."
ls testfiles