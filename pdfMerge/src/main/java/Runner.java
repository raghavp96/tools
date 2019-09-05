import java.io.IOException;
import java.util.logging.Logger;

import merge.Merger;

/**
 * This represents a Runner class. Depending on the program args, it calls the appropriate function.
 */
public class Runner {
  static Logger logger = Logger.getLogger(Runner.class.getName());
  public static void main(String[] args) {
    try {
      if (args == null || args.length == 0) {
        logger.warning("No arguments were provided.");
        System.exit(1);
      } else {
        if (args[0].equals("-help") || args[0].equals("-h")) {
          displayHelpMessage();
        } else if (args[0].equals("-merge")) {
          String[] args2 = new String[args.length - 1];
          for (int i = 0; i < args2.length; i++) {
            args2[i] = args[i + 1];
          }
          Merger.main(args2);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void displayHelpMessage() {
    logger.info("Run tool with -merge command and following arguments\n");
    logger.info("Like so: \n");
    logger.info("-merge " +
            "\n\t-save [filepath of location to save to] " +
            "\n\t-name [filename of merged doc] " +
            "\n\t-files [list of filepaths of PDFs to merge, separated by space].\n");
  }
}
