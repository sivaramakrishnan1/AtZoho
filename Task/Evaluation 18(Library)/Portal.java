import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



class Portal implements Serializable {
    List<Admin> admins = new ArrayList<>();
    List<User> users = new ArrayList<>();
    Library lib;
	public final long serialVersionUID = 12345l;

    {
        admins.add(new Admin(101, "admiN101"));
        users.add(new User(201, "useR201"));
    }

	public void objectWrite()
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("adminsObj.tmp"));
			oos.writeObject(admins);
            oos.close();

            oos = new ObjectOutputStream(new FileOutputStream("usersObj.tmp"));
			oos.writeObject(users);
            oos.close();
            
            oos = new ObjectOutputStream(new FileOutputStream("lib.tmp"));
			oos.writeObject(lib);
            oos.close();
            System.out.println("Write Serialization completed");
		}
		catch(WriteAbortedException e) {
            System.out.println("Error vanthuduchu da : " + e);
            e.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("Error vanthuduchu da : " + e);
        }
	}
	
    @SuppressWarnings("unchecked")
	public void objectRead()
	{
		try
		{
            
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("adminsObj.tmp"));
			admins = (List<Admin>)(oos.readObject());
            oos.close();

			oos = new ObjectInputStream(new FileInputStream("usersObj.tmp"));
			users = (List<User>)oos.readObject();
            oos.close();

			oos = new ObjectInputStream(new FileInputStream("lib.tmp"));
			lib = (Library) oos.readObject();
            oos.close();
            System.out.println("Read Serialization completed");
		}
		catch(Exception e) {
            System.out.println("Error vanthuduchu da : " + e);
        }
	}

    public static void login() throws Exception {
        Scanner s = new Scanner(System.in);
        Portal portal = new Portal();
        portal.objectRead();

        String prompt = "/> ";
        loop: while (true) {
            System.out.print(prompt);
            String[] cmd = (s.nextLine()).split(" ");
            switch (cmd[0]) {
                case "admin_login": {
                    for (Admin a : portal.admins) {
                        if (a.getId() == Integer.parseInt(cmd[1]) && a.authenticate(cmd[2])) {
                            portal.adminPage(a);
                        }
                    }
                    break;
                }

                case "user_login": {
                    for (User u : portal.users) {
                        if (u.getId() == Integer.parseInt(cmd[1]) && u.authenticate(cmd[2])) {
                            portal.userPage(u);
                        }
                    }
                    break;
                }

                case "exit": {
                    break loop;
                }

                default: {
                    System.out.println("Commands you can give \nadmin_login <id> <pwd> \nuser_login <id> <pwd>");
                }
            }
        }
		portal.objectWrite();
    }

    public void userPage(User u) throws Exception {
        Scanner s = new Scanner(System.in);
        String prompt = u.getId() + " > ";

        try {
            loop: while (true) {
                System.out.print("\n" + prompt);
                String[] cmd = (s.nextLine()).split(" ");

                switch (cmd[0]) {
                    case "borrow_book": {
                        lib.borrowBook(Integer.parseInt(cmd[1]), u, cmd[2]);
                        break;
                    }

                    case "borrow_book_copy": {
                        lib.borrowBookCopy(cmd[1], u, cmd[2]);
                        break;
                    }

                    case "return_book_copy": {
                        lib.returnBook(u.removeBook(cmd[1]), cmd[1], u);
                        break;
                    }

                    case "search": {
                        switch (cmd[1]) {
                            case "book_id":
                                lib.userSearch(0, cmd[2]);
                                break;
                            case "title":
                                lib.userSearch(1, cmd[2]);
                                break;
                            case "author":
                                lib.userSearch(2, cmd[2]);
                                break;
                            case "publisher":
                                lib.userSearch(3, cmd[2]);
                                break;
                            case "book_copy_id":
                                lib.userSearch(4, cmd[2]);
                                break;
                            default:
                                System.out.println(
                                        "Valid commands are \"search\" followed by book_id/title/author/publisher/book_copy_id");
                                break;
                        }
                        break;
                    }

                    case "print_borrowed": {
                        u.viewBorrowedBooks();
                        break;
                    }

                    case "exit": {
                        break loop;
                    }

                    default: {
                        System.out.println(
                                "Valid commands are : borrow_book / borrow_book_copy / return_book_copy / print_borrowed / exit");
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Library may not be created: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide sufficient data: " + e);
        }
    }

    public void adminPage(Admin a) throws Exception {
        Scanner s = new Scanner(System.in);
        String prompt = a.getId() + " > ";

        try {
            loop: while (true) {
                System.out.print("\n" + prompt);
                String[] cmd = (s.nextLine()).split(" ");

                switch (cmd[0]) {
                    case "create_library": {
                        lib = new Library(Integer.parseInt(cmd[1]));
                        break;
                    }
                    case "add_book": {
                        lib.addBook(Integer.parseInt(cmd[1]), cmd[2], cmd[3], cmd[4], cmd[5]);
                        break;
                    }

                    case "remove_book_copy": {
                        lib.removeBook(cmd[1]);
                        break;
                    }

                    case "print_borrowed": {
                        lib.printBorrwed();
                        break;
                    }

                    case "search": {
                        switch (cmd[1]) {
                            case "book_id":
                                lib.adminSearch(0, cmd[2]);
                                break;
                            case "title":
                                lib.adminSearch(1, cmd[2]);
                                break;
                            case "author":
                                lib.adminSearch(2, cmd[2]);
                                break;
                            case "publisher":
                                lib.adminSearch(3, cmd[2]);
                                break;
                            case "book_copy_id":
                                lib.adminSearch(4, cmd[2]);
                                break;
                            case "user_id":
                                for (User u : users) {
                                    u.viewBorrowedBooks();
                                }
                                break;
                            default: {
                                System.out.println(
                                        "Valid commands are \"search\" followed by book_id / title / author / publisher / book_copy_id / user_id");
                                break;
                            }
                        }
                        break;
                    }

                    case "add_user": {
                        if (validatePassword(cmd[2])) {
                            users.add(new User(Integer.parseInt(cmd[1]), cmd[2]));
                        }
                        break;
                    }

                    case "view_data_base": {
                        lib.viewDataBase();
                        break;
                    }

                    case "exit": {
                        break loop;
                    }

                    default: {
                        System.out.println(
                                "Valid commands are : create_library / add_book / remove_book_copy / print_borrowed / search / add_user / view_data_base / exit");
                    }

                }
            }
        } catch (NullPointerException e) {
            System.out.println("Library may not be created: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide sufficient data: " + e);
        }
    }

    public boolean validatePassword(String password) {
        String[] patterns = { "[A-Za-z0-9]*[a-z][A-Za-z0-9]*", "[A-Za-z0-9]*[A-Z][A-Za-z0-9]*",
                "[A-Za-z0-9]*[0-9][A-Za-z0-9]*", ".{6,}" };
        for (int i = 0; i < patterns.length; i++) {
            Pattern p = Pattern.compile(patterns[i]);
            Matcher m = p.matcher(password);
            if (!m.find()) {
                System.out.println(
                        "Password must contain and uppercase, lowercase and numerical character and should be more than 6 charcters");
                return false;
            }
        }
        return true;
    }
}