import java.util.Scanner;

public class RpnTest
{
    public static void main(String [] args)
    {
	String infExpr, posExpr = null;
	Scanner in = new Scanner(System.in);

	menu();
	System.out.print("Your option: ");
	int selection = in.nextInt();
	eatline(in);

	while(selection != 2) {
	    if(selection == 1) {
		 System.out.print("Enter your infix expression: ");
	         infExpr = in.nextLine();
		 options();
	         System.out.print("Your option: ");
		 selection = in.nextInt();
		 eatline(in);
		 while(selection != 3) {
		     switch(selection) {
		     case 1:
			 if(posExpr != null || (posExpr = Rpn.InfixToPostfix(infExpr)) != null)
			     System.out.println("Postfix expression: " + posExpr);
			 break;
		     case 2:
			 if(posExpr != null || (posExpr = Rpn.InfixToPostfix(infExpr)) != null) 
			     System.out.println("Postfix expression: " + posExpr +
						"\nResult: " + Rpn.Evaluate(posExpr));
			 else
			     System.err.println("Can't evaluate result");
			 break;
		     default:
			 System.err.println("You've selected incorrect option. Please select 1,2 or 3");
			 break;
		     }
		     options();
		     System.out.print("Your option: ");
		     selection = in.nextInt();
		     eatline(in);
		 }
	    }
	    else
		System.err.println("You've selected incorrect option. Please select 1 or 2");
	    
            posExpr = null;
	    menu();
	    System.out.print("Your option: ");
	    selection = in.nextInt();
	    eatline(in);
	}
		
    }

    static void menu()
    {
	System.out.println("Menu:\n" +
                            "1. Enter the infix expression\n" +
                            "2. Quit");
    }


    static void options()
    {
	System.out.println("Select the option:\n" +
                           "1. Translate from infix to postfix\n" +
                           "2. Evaluate expression\n" +
                           "3. Return to main menu");
    }

    static void eatline(Scanner in)
    {
	in.nextLine();
    }
		
}
