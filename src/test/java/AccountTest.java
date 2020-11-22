import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void constructor() {
        // Test to see that all 3 player numbers work
        Account account2players = new Account(2);
        assertEquals(20, account2players.getCoins(),"Test at line 10 failed");
        System.out.println("Testing if correct amount of coins are given for 2 players. \n Correct amount given.");
        Account account3players = new Account(3);
        assertEquals(18, account3players.getCoins(),"Test at line 13 failed");
        System.out.println("Testing if correct amount of coins are given for 3 players. \n Correct amount given.");
        Account account4players = new Account(4);
        assertEquals(16, account4players.getCoins(),"Test at line 16 failed.");
        System.out.println("Testing if correct amount of coins are given for 3 players. \n Correct amount given.");

        //Test to see any amount of player numbers that are invalid
        System.out.println("\n Testing what happens if there is too many players");
        try {
            Account account5players = new Account(5);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Test successful");
        }

    }

    @Test
    void addCoins() {
        // test if +- works
        System.out.println("\nMakes new account.");
        Account account = new Account(2);
        account.addCoins(100);
        account.addCoins(20);
        account.addCoins(30);
        account.addCoins(-10);
        account.addCoins(-30);
        account.addCoins(50);
        account.addCoins(-100);
        System.out.println("Adds/subtracts 100+20+30-10-30+50-100 coins over multiple adds.");
        assertEquals(20+100+20+30-10-30+50-100, account.getCoins()); //we started with 20 coins and then just added the above sequence.
        System.out.println("Testing if subtraction and addition works correctly. It does.");

        //test if going below min coins works correctly
        account.getCoins();
        int amount = account.getCoins();

    }

    @Test
    void getCoins() {
        // todo
    }

    @Test
    void testToString() {
        // todo
    }
}