package merge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import merge.controller.MergeController;

/**
 * This represents a Merge Runner. It interprets arguments and attempts to merge two PDFs.
 */
public class Merger {
  public static void main(String[] args) throws IOException {
    if (args == null || args.length == 0) {
      throw new IllegalArgumentException("Need more info.");
    } else {
      String saveDir = "";
      String newFileName = "";
      List<String> files = new ArrayList<String>();
      for (int i = 0; i < args.length; i++) {
        if (args[i].equals("-save") || args[i].equals("-s")) {
          if (i + 1 < args.length) {
            saveDir = args[i + 1];
          }
        } else if (args[i].equals("-name") || args[i].equals("-n")) {
          if (i + 1 < args.length) {
            newFileName = args[i + 1];
          }
        } else if (args[i].equals("-files") || args[i].equals("-f")) {
          if (i + 1 < args.length) {
            int j = i + 1;
            while (j < args.length && !(args[j].startsWith("-"))) {
              files.add(args[j]);
              j++;
            }
          }
        }
      }
      if ((saveDir.length() == 0) || (newFileName.length() == 0) || (files.isEmpty())) {
        throw new IllegalArgumentException("You must provide a save location, a new file name," +
                "and a list of files separated by spaces.");
      } else {
        MergeController mergeController = new MergeController();
        mergeController.merge(files, saveDir, newFileName);
      }
    }
  }
}
