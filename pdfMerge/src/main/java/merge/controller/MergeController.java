package merge.controller;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MergeController {

  public void merge(List<String> filePaths, String saveTo, String newName) throws IOException {
    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
    for (String filePath : filePaths) {
      pdfMergerUtility.addSource(filePath);
    }
    pdfMergerUtility.setDestinationFileName(saveTo + File.separator + newName);
    pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
  }
}
