package application.letter;

import application.translate.Dictionary;
import application.translate.DictionaryIterator;

import java.io.File;
import java.io.IOException;

/**
 * Generates batches of form letters from a template and one or more dictionary files.
 *
 * @author JDT - KLH551
 */
public class FormLetterBatch {

   /**
    * Generates one output file per Dictionary found in inFile, writing results into outDir.
    *
    * @param letter the form letter template to render
    * @param inFile the dictionary file containing one or more dictionary blocks
    * @param outDir the directory in which to place the generated output files
    */
   public void generate(FormLetter letter, File inFile, File outDir) throws IOException {
      DictionaryIterator dicIter = new DictionaryIterator(inFile.getPath());
      String templateName = letter.getTemplateFile().getName();
      templateName = templateName.substring(0, templateName.lastIndexOf('.'));
      String dictName = inFile.getName();
      dictName = dictName.substring(0, dictName.indexOf('.'));
      int counter = 1;
      Dictionary d;
      while ((d = dicIter.next()) != null) {
         String outputFileName = templateName + "-" + dictName + "-" + counter + ".txt";
         letter.setDictionary(d);
         File output = new File(outDir, outputFileName);
         letter.printLetter(output);
         counter++;
      }
   }

   /**
    * Generates form letters for all dictionary files in inDirName, writing output to outDirName.
    *
    * @param templatePath the path to the template file
    * @param inDirName    the input directory path
    * @param outDirName   the output directory path
    */
   public void generateAll(String templatePath, String inDirName, String outDirName) throws IOException {
      // 2. Create the output directory if it doesn't exist: new File(outDirName).mkdirs()
      // 3. Get all files in the input directory: new File(inDirName).listFiles()
      // 4. For each file in the array, call generate(letter, file, new File(outDirName))
      // NOTE: Never hold more than one Dictionary in memory at a time.
      //       DictionaryIterator handles this naturally — next() gives you one at a time.
      FormLetter fl = new FormLetter(templatePath);
      new File(outDirName).mkdirs();
      File outDir = new File(outDirName);
      File[] files = new File(inDirName).listFiles();
      for (File f : files) {
         generate(fl, f, outDir);
      }


   }
}

