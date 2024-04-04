import java.util.List;
import java.util.ArrayList;

public class StringFormatter
{
  /* Part (a) */
  public static int totalLetters(List<String> wordList)
  {
    int letters = 0;

    for(String word : wordList)
        letters += word.length();
	
    return letters; }

  /* Part (b) */
  public static int basicGapWidth(List<String> wordList, int formattedLen)
  {
    int gaps = wordList.size() - 1;
    int spaces = formattedLen - totalLetters(wordList);
     return spaces / gaps;   }

  /* Part (c) */
  public static String format(List<String> wordList, int formattedLen)
  {
    int width = basicGapWidth(wordList, formattedLen);
    int leftoverRemaining = leftoverSpaces(wordList, formattedLen);
  }
  
  public static int leftoverSpaces(List<String> wordList, int formattedLen)
  {
    return formattedLen - totalLetters(wordList) -
                 basicGapWidth(wordList, formattedLen) * (wordList.size() - 1);
  }
}