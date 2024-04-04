public class SystemLog
{
   /** Contains all the entries in this system log.
   * Guaranteed not to be null and to contain only non-null entries. */
   private List<LogMessage> messageList;
   
   public SystemLog(String[] messages)
   {
      messageList = new ArrayList<LogMessage>();
      for (String s : messages)
         messageList.add(new LogMessage(s));
   }

   /**
   * Removes from the system log all entries whose descriptions properly contain keyword,
   * and returns a list (possibly empty) containing the removed entries.
   * Postcondition:
   * - Entries in the returned list properly contain keyword and
   * are in the order in which they appeared in the system log.
   * - The remaining entries in the system log do
   * not properly contain keyword and
   * are in their original order.
   * - The returned list is empty if no
   * messages properly contain keyword.
   */
   public List<LogMessage> removeMessages(String keyword)
   { /* to be implemented in part (c) */ }
   
   
   public String toString() {
      String s = "";
      for (LogMessage msg : messageList)
         s += msg + "\n";
      return s;
   }
   
   // There may be instance variables, constructors, and methods that are not shown.
} 
