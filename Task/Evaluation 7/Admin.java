package Railway.Accounts;

import Railway.RailwayReservation;
import Railway.Tickets.Ticket;
import java.util.*;

public class Admin {
    Scanner s = new Scanner(System.in);
    LinkedList<Ticket> tickets = RailwayReservation.tickets;
    RailwayReservation rr;
    private int id;
    private String name;
    private String password;

    public Admin(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void bookTickets() {
        System.out.print("\nHow many Tickets you are willing to book: ");
        int numTickets = s.nextInt();

        for (int i = 0; i < numTickets; i++) {
            System.out.println("Enter name, age, gender(M/F)");
            String name = s.next();
            int age = s.nextInt();
            char gender = s.next().charAt(0);
            char berthPref = 'X';
            if (age > 60 || gender == 'f')
                berthPref = 'L';
			
            int pos = checkBerth(berthPref);

            if (RailwayReservation.waitingList.size() < 9) {
                if (RailwayReservation.RAC.size() < 19) {
                    if (tickets.size < 64) {
                        tickets.get(pos).bookThisTicket(name, age, gender);
                    } else
                        RailwayReservation.RAC.get(pos).bookThisTicket(name, age, gender);
                } else
                    RailwayReservation.waitingList.get(pos).bookThisTicket(name, age, gender);
            }
        }
    }

    public void cancelTicket() {
        System.out.println("Enter seat number: ");
        int seat = s.nextInt();

        tickets.get(seat).cancelThisTicket();
        if (RailwayReservation.RAC.size() > 0) {
            tickets.get(seat).bookThisTicket(RailwayReservation.RAC.pollFirst());
        }
        if (RailwayReservation.waitingList.size() > 0) {
            RailwayReservation.RAC.add(
                RailwayReservation.waitingList.pollFirst());
        }
    }

    public int checkBerth(char b) {
        if (b == 'L') {
            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getBerth() == 'L'
                    && !(tickets.get(i).isBooked())) {
                    return i;
                }
            }
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (!(tickets.get(i).isBooked())) {
                return i;
            }
        }
        return -1;
    }

    public void printTickets() {
        int i = 0;
        for (Ticket t : tickets) {
            i++;
            if (i % 4 == 0)
                System.out.println();
            System.out.print(t.toString() + "\t");
        }
    }
}