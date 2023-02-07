import java.util.HashMap;
import java.util.Scanner;
import java.io.*;	

class Portal implements Serializable
{
    static Scanner s = new Scanner(System.in);
    int[] countId = { 1001, 1001, 1001, 1001 };
    HashMap<Integer, Board> boards = new HashMap<>();
    HashMap<Integer, User> users = new HashMap<>();
	public static final long  serialVersionUID = 11111l;
	static Portal p = new Portal();
	
	public void upload()
	{
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.tmp"));
			oos.writeObject(p);
			oos.close();
		} catch(Exception e) {
			System.out.println("Sathiya sothanai : " + e);
		}
	}
	
	public void download()
	{
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.tmp"));
			p = (Portal)ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("Yenna elavu da ithu : " + e);
		}
	}
    public static void portal() throws Exception
    {
		p.download();
        p.cli();
		p.upload();
        p.s.close();
    }

    public void cli() throws Exception
    {
        String[] inputs;

    out:
        while (true) {
            System.out.print("\n//> : ");
			inputs = (s.nextLine()).split(" ");
            

            switch (inputs[0]) {
                case "BOARD":
                    switch (inputs[1]) {
                        case "CREATE":
                            boards.put(countId[0], new Board(countId[0], inputs[2]));
                            countId[0]++;
                            break;

                        case "DELETE":
                            boards.remove(Integer.parseInt(inputs[2]));
                            break;

                        default:
                            if (boards.containsKey(Integer.parseInt(inputs[1]))) {
                                switch (inputs[2]) {
                                    case "NAME":
                                        boards.get(Integer.parseInt(inputs[1])).name = inputs[3];
                                        break;

                                    case "PRIVACY":
                                        if (inputs[3].equals("PRIVATE"))
                                            boards.get(Integer.parseInt(inputs[1])).isPrivate = true;
                                        else
                                            boards.get(Integer.parseInt(inputs[1])).isPrivate = false;
                                        break;

                                    case "ADD_MEMBER":
                                        boards.get(Integer.parseInt(inputs[1])).members.put(Integer.parseInt(inputs[3]), users.get(Integer.parseInt(inputs[3])));
                                        break;
                                    case "REMOVE_MEMBER":
                                        boards.remove(Integer.parseInt(inputs[3]));
                                        break;
                                }
                            } else
                                System.out.println("INVALID COMMAND");
                            break;
                    }
                    break;

                case "SHOW":
                    if (inputs.length == 1) 
					{
                        if (boards.size() == 0)
                            System.out.println("No boards");
                        else
                            for (Board b : boards.values()) {
                                System.out.println(b.toString());
                            }
                    } else
                        switch (inputs[1]) {
                            case "BOARD":
                                System.out.println(boards.get(Integer.parseInt(inputs[2])).toString());
                                break;

                            case "LIST":
                                boolean res = false;

                            loop:
                                for (Board B : boards.values()) {
                                    if (B.lists.containsKey(Integer.parseInt(inputs[2]))) {
                                        System.out.println(boards.get(Integer.parseInt(inputs[2])).toString());
                                        res = true;
                                        break loop;
                                    }
                                }
                                if (!res)
                                    System.out.println("NO SUCH LIST");
                                break;

                            case "CARD":
                                res = false;

                            loop:
                                for (Board B : boards.values()) {
                                    for (Lists l : B.lists.values()) {
                                        if (l.cards.containsKey(Integer.parseInt(inputs[2]))) {
                                            System.out.println(l.cards.get(Integer.parseInt(inputs[2])).toString());
                                            break loop;
                                        }
                                    }
                                }
                                break;
                        }
                    break;

                case "LIST":
                    switch(inputs[1])
                    {
                        case "CREATE":
                            boards.get(Integer.parseInt(inputs[2])).lists.put(countId[1], new Lists(countId[1], inputs[3]));
                            countId[1]++;
                            break;

                        case "DELETE":
                            for (Board b : boards.values()) {
                                if (b.lists.containsKey(Integer.parseInt(inputs[2]))) {
                                    b.lists.remove(Integer.parseInt(inputs[2]));
                                    break;
                                }
                            }
                            break;

                        default:
                            String name = "";
                            for (int i = 3; i < inputs.length; i++) {
                                name += inputs[i] + " ";
                            }
                            if (inputs[3].equals("name")) {
                                for (Board b : boards.values()) {
                                    if (b.lists.containsKey(Integer.parseInt(inputs[2]))) {
                                        b.lists.get(Integer.parseInt(inputs[2])).name = name;
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                    break;

                case "CARD":
                    switch (inputs[1]) {
                        case "CREATE":
                            for (Board b : boards.values()) {
                                if (b.lists.containsKey(Integer.parseInt(inputs[2]))) {
                                    b.lists.get(Integer.parseInt(inputs[2])).cards.put(countId[2], new Card(countId[2], inputs[3]));
                                }
                            }
                            break;

                        case "ASSIGN":
                            for (Board b : boards.values()) {
                                for (Lists l : b.lists.values()) {
                                    if (l.cards.containsKey(Integer.parseInt(inputs[2]))) {
                                        if (b.members.containsKey(Integer.parseInt(inputs[3]))) {
                                            l.cards.get(Integer.parseInt(inputs[2])).assignedUser = b.members.get(Integer.parseInt(inputs[3]));
                                            break;
                                        }
                                    }
                                }
                            }
                            break;

                        case "UNASSIGN":
                            for (Board b : boards.values()) {
                                for (Lists l : b.lists.values()) {
                                    if (l.cards.containsKey(Integer.parseInt(inputs[2]))) {
                                        l.cards.get(Integer.parseInt(inputs[2])).assignedUser = null;
                                    }
                                }
                            }
                            break;

                        case "MOVE":
                            Card card = null;
                        loop:
                            for (Board b : boards.values()) {
                                for (Lists l : b.lists.values()) {
                                    if (l.cards.containsKey(Integer.parseInt(inputs[2]))) {
                                        card = l.cards.get(Integer.parseInt(inputs[2]));
                                        l.cards.remove(Integer.parseInt(inputs[2]));
                                        break loop;
                                    }
                                }
                            }

                            if (card != null) {
                            loop:
                                for (Board b : boards.values()) {
                                    if (b.lists.containsKey(Integer.parseInt(inputs[3]))) {
                                        b.lists.get(Integer.parseInt(inputs[3])).cards.put(card.id, card);
                                        break loop;
                                    }
                                }
                            }
                            break;
                        case "DELETE":
                        loop:
                            for (Board b : boards.values()) {
                                for (Lists l : b.lists.values()) {
                                    if (l.cards.containsKey(Integer.parseInt(inputs[2]))) {
                                        l.cards.remove(Integer.parseInt(inputs[2]));
                                        break loop;
                                    }
                                }
                            }
                            break;
                    }
					break;
                case "EXIT":
                    break out;
				
				case "HELP":
				System.out.println(
				  "\n+--------------------------+------------------------------------+"
				+ "\n| Create Board             | BOARD CREATE <NAME>                |" 
				+ "\n| Rename Board             | BOARD <BOARD_ID> NAME <NEW_NAME>   |"
				+ "\n| Change Privacy           | BOARD PRIVACY <PUBLIC/PRIVATE>     |"
				+ "\n| Add member to Board      | BOARD ADD_MEMBER <USER_ID>         |"
				+ "\n| Remove member from board | BOARD REMOVE_MEMBER <USER_ID>      |"
				+ "\n| Delete Board             | BOARD DELETE <BOARD_ID>            |"
				+ "\n+--------------------------+------------------------------------+"
				+ "\n| Create List              | LIST CREATE <BOARD_ID> <LIST_NAME> |"
				+ "\n| Delete List              | LIST DELETE <LIST_ID>              |"
				+ "\n| Rename List              | LIST <LIST_ID> NAME <NEW_NAME>     |"
				+ "\n+--------------------------+------------------------------------+"
				+ "\n| Crete card               | CARD CREATE <LIST_ID> <CARD_NAME>  |"
				+ "\n| Rename card              | CARD <CARD_ID> NAME <NEW_NAME>     |"
				+ "\n| Assign member to card    | CARD <CARD_ID> ASSIGN <USER_ID>    |"
				+ "\n| Unassign member to card  | CARD <CARD_ID> UNASSIGN            |"
				+ "\n| Delete card              | CARD DELETE <CARD_ID>              |"
				+ "\n| Move card to new list    | CARD <CARD_ID> MOVE <NEW_LIST_ID>  |"
				+ "\n+--------------------------+------------------------------------+"
);
				break;
				default :
				System.out.println("Invalid Command. Enter HELP to see valid commands");
				
            }
        }
    }
}