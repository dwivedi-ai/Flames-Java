import java.util.Scanner;
public class Flames
{
    // This is a flames program
    String user_name, crush_name;
    int count;
    Flames()
    {
        user_name = "";
        crush_name = "";
        count = 0;
    }
    public boolean hasBeenChecked(String alreadyChecked, char letter)
    {
        int flag = 0;
        for (int i = 0; i < alreadyChecked.length(); i++)
        {
            if (letter == alreadyChecked.charAt(i))
                flag = 1;
        }
        if (flag == 1)
            return true;
        else
            return false;
    }
    public String removeDuplicates(String word)
    {
        String checked = "";
        for(int i = 0; i < word.length(); i++)
        {
            if (!hasBeenChecked(checked, word.charAt(i)))
                checked += word.charAt(i);
        }
        return checked;
    }
    public int countDifferentLetters(int flagged)
    {
        count = user_name.length() + crush_name.length();
        for (int i = 0; i < user_name.length(); i++)
        {
            for (int j = 0; j < crush_name.length(); j++)
            {
                if (user_name.charAt(i) == crush_name.charAt(j))
                {
                    flagged++;
                }
            }
            if (flagged != 1)
                count -= flagged;
            flagged = 1;
        }
        return count;
    }
    public void displayResults()
    {
        switch((count%6 == 0)?count%6:(count%6)-1)
        {
            case 0: System.out.println("Friends");
                break;
            case 1: System.out.println("Love");
                break;
            case 2: System.out.println("Affectionate");
                break;
            case 3: System.out.println("Marriage");
                break;
            case 4: System.out.println("Enemies");
                break;
            case 5: System.out.println("Sister");
        }
    }
    public static void main(String [] args)
    {
        Flames object = new Flames();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        object.user_name = sc.next();
        System.out.print("Enter your crush's name: ");
        object.crush_name = sc.next();
        object.user_name = object.removeDuplicates(object.user_name.toUpperCase());
        object.crush_name = object.removeDuplicates(object.crush_name.toUpperCase());
        object.count = object.countDifferentLetters(1);
        object.displayResults();
        sc.close();
    }
}
