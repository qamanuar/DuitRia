import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


    class Dice{
        
        Random random;
        
        public Dice(){ //initalize variable
            this.random = new Random();
        }
        
        public int singleRoll(){
            return random.nextInt(6)+1;
        }
        
        public int roll(){ //better names
            return random.nextInt(12)+1;
        }
    }
    
    class DuitRiaBoard{
        List<Space> spaces;
        List<Player> players;
        int numplayer=0;
        
        public DuitRiaBoard() {
            this.spaces = new ArrayList<>();
            this.players = new ArrayList<>();
            iniboard();
    }

        public void iniboard() {
            spaces.add(new Go("Go",2000000));//0
            spaces.add(new Property("Petaling Street", 600000, 60000, 120000, 320000, 520000, 720000, ""));//1
            spaces.add(new Fate("Fate"));//2
            spaces.add(new Property("Jonker Street", 600000, 60000, 120000, 320000, 520000, 720000, ""));//3
            spaces.add(new Tax("Tax",2000000));//4
            spaces.add(new SpecialProperty("KLIA", 2000000,200000, ""));//5
            spaces.add(new Property("Masjid Jamek", 1000000, 100000, 200000, 400000, 600000, 800000, ""));//6
            spaces.add(new Fate("Fate"));//7
            spaces.add(new Property("Batu Caves", 1000000, 100000, 200000, 400000, 600000, 800000, ""));//8
            spaces.add(new Property("Sri Maha Mariaman Temple", 1200000, 120000, 240000, 420000, 620000, 820000, ""));//9
            spaces.add(new VisitJail("Jail"));//10
            spaces.add(new Property("National Museum", 1400000, 140000, 280000, 480000, 680000, 880000, ""));//11
            spaces.add(new Property("Tenaga Nasional Berhad", 1500000, 150000, 300000, 500000, 700000, 800000, ""));//12
            spaces.add(new Property("Royale Palace", 1400000, 140000, 280000, 480000, 680000, 880000, ""));//13
            spaces.add(new Property("Merdeka Square", 1400000, 140000, 280000, 480000, 680000, 880000, ""));//14
            spaces.add(new SpecialProperty("KLIA 2", 2000000,200000,""));//15
            spaces.add(new Property("A Famosa Fort", 1700000, 170000, 340000, 540000, 740000, 840000, ""));//16
            spaces.add(new Fate("Fate"));//17
            spaces.add(new Property("Kellie Castle", 1800000, 180000, 360000, 560000, 760000, 860000, ""));//18
            spaces.add(new Property("Stadthuy's", 2000000, 200000, 400000, 600000, 800000, 1000000, ""));//19
            spaces.add(new FreeParking("Free Parking"));//20
            spaces.add(new Property("Fraser's Hill", 2200000, 220000, 440000, 640000, 840000, 1040000, ""));//21
            spaces.add(new Fate("Fate"));//22
            spaces.add(new Property("Cameron Highland", 2200000, 220000, 440000, 640000, 840000, 1040000, ""));//23
            spaces.add(new Property("Genting Highland", 2400000, 240000, 480000, 680000, 880000, 1080000, ""));//24
            spaces.add(new SpecialProperty("KL Sentral Station", 2000000,200000,""));//25
            spaces.add(new Property("Pahang National Park", 2600000, 260000, 520000, 720000, 920000, 1120000, ""));//26
            spaces.add(new Property("Jabatan Bekalan Air", 1500000, 150000, 300000, 500000, 700000, 800000, ""));//27
            spaces.add(new Property("Gunung Mulu National Park", 2600000, 260000, 520000, 720000, 920000, 1120000, ""));//28
            spaces.add(new Property("Kinabalu National Park", 2700000, 270000, 540000, 740000, 940000, 1140000, ""));//29
            spaces.add(new Jail("Jail",250000));//30
            spaces.add(new Property("Thomas Island", 3000000, 300000, 600000, 800000, 1000000, 1200000, ""));//31
            spaces.add(new Property("Perhentian Island", 3000000, 300000, 600000, 800000, 1000000, 1200000, ""));//32
            spaces.add(new Fate("Fate"));//33
            spaces.add(new Property("Sepadan Islands", 3200000, 320000, 620000, 820000, 1020000, 1220000, ""));//34
	        spaces.add(new SpecialProperty("Pudu Sentral Station", 2000000,200000,""));//35
            spaces.add(new Fate("Fate"));//36
            spaces.add(new Property("KLCC", 3500000, 350000, 700000, 900000, 1100000, 1300000, ""));//37
            spaces.add(new Tax("Tax",2000000));//38
            spaces.add(new Property("Sepang II Circuit", 4000000, 400000, 800000, 1000000, 1200000, 1400000, ""));//39
    }
        
        public int numPlayer(){
            return numplayer++;
        }
        
        public int getNumPlayer(){
            return numplayer;
        }
        
        public void miscellaneous(Player player){
            Scanner scan = new Scanner(System.in);
            DuitRiaBoard board = new DuitRiaBoard();
            
            boolean cont = true;
            while(cont){
            System.out.println("Do you want to \n1. sell your house\n2. sell your property\n3. nothing");
                        String response = scan.nextLine();
                switch (response) {
                    case "1":
                        if(player.getOwnedHouse()>0){
                            System.out.println("You have "+player.getOwnedHouse()+" house in total");
                            System.out.println(player.getOwnedProperties());
                            System.out.println("How many house would you sell ?");
                            int sellhouse = scan.nextInt();
                            player.deductOwnedHouse(sellhouse);
                            player.addMoney(sellhouse*100000);
                        }
                        else{
                            System.out.println("Sorry you dont have any house.");
                        }
                        break;
                    case "2":
                            System.out.println("You owned this property (note that you only get 50% of property price)");
                            System.out.println(player.getOwnedPropertiesPawn());
                            System.out.println(player.getOwnedSpecialPropertiesPawn());
                            System.out.println("Please enter the name of property you want to sell");
                            String sellproperty = scan.nextLine();
                        if(player.getOwnedProperties().equals(sellproperty)){
                            player.sellProperty(sellproperty, player);
                            break;
                        } else{
                            System.out.println("Cant find the property");
                            break;
                        }
                    default:
                        System.out.println("Goodbye !");
                        cont=false;
                        continue;
                    }
                }
            }
        
        public Space getSpaceAtPosition(int position, String name) {
            if (position >= 0 && position < spaces.size()) {
                Space space = spaces.get(position);
                System.out.println(name +" is now at " + position+" ("+getSpaceName(space)+")");
                return space;
            }
            return null;
        }
        
        public Space getSpaceVar(int position, String name, Player player, List<Player> players, int origin){
            DuitRiaBoard board = new DuitRiaBoard();
            Space space = spaces.get(position);
            Scanner scan = new Scanner(System.in);
            
            if (space instanceof Property) {
                Property property = (Property) space;
                if ( property.getSlot() == 0 && player.getMoney()>= property.getCost()) {
                System.out.println("Property Cost: " + property.getCost());
                System.out.println("Property Rent: " + property.getRent(property.getNumHouse()));
                if (player.getMoney() >= property.getCost()) {
                        System.out.println("Do you want to buy this property? (y/n): ");
                        String response = scan.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            player.buyProperty(property);
                            System.out.println(player.getName() + " bought " + property.getName());
                            System.out.println(player.getName()+" new money is : "+player.getMoney());
                            property.slot++;
                            property.setOwner(player.getName());
                        }
                }
                    } else if(property.getSlot() == 0&&player.getMoney() < property.getCost()){
                        //while(true){
                        System.out.println("Property Cost : "+ property.getCost());
                        System.out.println("Property Rent : "+ property.getRent(0));
                        System.out.println("This property is available but you don't have enough money");
                        miscellaneous(player);
                        //}
                    }else {
                        Player owner =  findPropertyOwner(property, players);
                        if (property.owner != player.getName()) {
                            //pay rent to owner of the property
                            System.out.println("This Property is owned by "+property.owner);
                            player.payRent(property, property.getNumHouse());
                            owner.addMoney(property.getRent(property.getNumHouse()));
                            System.out.println("Rent for "+property.getNumHouse()+" house(s) is : "+property.getRent(property.getNumHouse()));
                            System.out.println(player.getName() + " paid rent to " + owner.getName());
                            System.out.println(player.getName()+" new money is : "+player.getMoney());
                            System.out.println(owner.getName()+"(owner) new money is "+owner.getMoney());
                        }
                        else{
                            //buy house etc
                            System.out.println("You are the owner of this Property !");
                            System.out.println("a house will cost you 200k");
                            System.out.println("Do you want to build house ? (y/n)(limit to 4) ");
                            String response = scan.nextLine();
                            if (response.equalsIgnoreCase("y")) {
                                while(true){
                                    System.out.println();
                                    System.out.println("Currently you have "+property.getNumHouse()+" house(s)");
                                    System.out.println("How many house would you built ? (enter '0' if you want to see rent list)");
                                    int numhouse = scan.nextInt();
                                    if(numhouse==0){
                                        property.seeListRent();
                                    }
                                    else if(property.getNumHouse()+numhouse<=4){
                                        property.houseBuilt(property, numhouse);
                                        player.deductMoney(numhouse*200000);
                                        player.addOwnedHouse(numhouse);
                                        System.out.println(player.getName()+"(owner) new money is "+player.getMoney());
                                        break;
                                    }
                                    else{
                                        System.out.println("You can only have 4 houses max !");
                                    }
                                }
                            }
                            else{
                                System.out.println("Goodbye !");
                            }
                        }
                    }
                
            } else if (space instanceof Tax) {
                Tax tax = (Tax) space;
                System.out.println("Tax Amount: " + tax.getTax());
                player.deductMoney(tax.getTax());
                System.out.println(player.getName()+" new money is : "+player.getMoney());
                
            } else if (space instanceof Jail) {
                Jail jail = (Jail) space;
                Dice dice = new Dice();
                player.setPosition(30);
                System.out.println("You got Jailed ! (10)");
                System.out.println("To get out of Jail, you need to throw doubles");
                int firstDice = dice.singleRoll();
                System.out.println("First dice rolled : "+firstDice);
                int secondDice = dice.singleRoll();
                System.out.println("Second dice rolled : "+secondDice);
                
                if(firstDice==secondDice){
                    System.out.println("GG! you got out of the Jail");
                }
                else{
                    System.out.println("You got fined.");
                    System.out.println("Fine for Jail: " + jail.getFine());
                    player.deductMoney(jail.getFine());
                    System.out.println("Your new money is "+player.getMoney());
                }
                
                System.out.println("");
                
            } else if (space instanceof VisitJail) {
                System.out.println("Dont worry you are just visiting this jail :3");
                
            
            } else if (space instanceof SpecialProperty special) {
                if(origin ==1){
                    if (special.getSlot() == 0&&player.getMoney() >= special.getCost()) {
                    System.out.println("Property Cost : "+ special.getCost());
                    System.out.println("Property Rent : "+ special.getRent());
                    System.out.println("Do you want to buy this property? (y/n): ");
                    String response = scan.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            player.buySpecialProperty(special);
                            System.out.println(player.getName() + " bought " + special.getName());
                            System.out.println(player.getName()+" new money is : "+player.getMoney());
                            special.slot++;
                            special.setOwner(player.getName());
                        }
                        else{
                            System.out.println("Goodbye !");
                        }
                    } else if(special.getSlot() == 0&&player.getMoney() < special.getCost()){
                        //while(true){
                        System.out.println("Property Cost : "+ special.getCost());
                        System.out.println("Property Rent : "+ special.getRent());
                        System.out.println("This property is available but you don't have enough money");
                        miscellaneous(player);
                        //}
                    } else {
                            Player owner = findSpecialPropertyOwner(special, players);
                            if (special.owner != player.getName() && player.getMoney() >= special.getCost()) {
                            //pay rent to owner of the property
                            System.out.println("This Property is owned by "+special.owner);
                            player.paySpecialRentfromFate(special);
                            owner.addMoney(special.getRentfromFate());
                            System.out.println("Rent for this property is "+special.getRentfromFate());
                            System.out.println(player.getName() + " paid rent to " + owner.getName());
                            System.out.println(player.getName()+" new money is : "+player.getMoney());
                            System.out.println(owner.getName()+"(owner) new money is "+owner.getMoney());
                            }
                            else if (special.owner != player.getName() && player.getMoney() < special.getCost()) {
                            //not enough money to pay rent to owner of the property
                            System.out.println("This Property is owned by "+special.owner);
                            player.paySpecialRentfromFate(special);
                            owner.addMoney(special.getRentfromFate());
                            System.out.println("Rent for this property is "+special.getRentfromFate());
                            System.out.println(player.getName() + " paid rent to " + owner.getName());
                            System.out.println(player.getName()+" new money is : "+player.getMoney());
                            System.out.println(owner.getName()+"(owner) new money is "+owner.getMoney());
                            }
                            else{
                                System.out.println("You are the owner of this property.");
                                System.out.println("Thankyou for visiting !");
                            }
                    }
                }
                else if(origin==0){
                    {
                    if (special.getSlot() == 0&&player.getMoney() >= special.getCost()) {
                    System.out.println("Property Cost : "+ special.getCost());
                    System.out.println("Property Rent : "+ special.getRent());
                    System.out.println("Do you want to buy this property? (y/n): ");
                    String response = scan.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            player.buySpecialProperty(special);
                            System.out.println(player.getName() + " bought " + special.getName());
                            System.out.println(player.getName()+" new money is : "+player.getMoney());
                            special.slot++;
                            special.setOwner(player.getName());
                        }
                        else{
                            System.out.println("Goodbye !");
                        }
                    } else if(special.getSlot() == 0&&player.getMoney() < special.getCost()){
                        //while(true){
                        System.out.println("Property Cost : "+ special.getCost());
                        System.out.println("Property Rent : "+ special.getRent());
                        System.out.println("This property is available but you don't have enough money");
                        miscellaneous(player);
                        //}
                    } else {
                            Player owner = findSpecialPropertyOwner(special, players);
                            if (special.owner != player.getName() && player.getMoney() >= special.getCost()) {
                            //pay rent to owner of the property
                            System.out.println("This Property is owned by "+special.owner);
                            player.paySpecialRentfromFate(special);
                            owner.addMoney(special.getRentfromFate());
                            System.out.println("Rent for this property is "+special.getRentfromFate());
                            System.out.println(player.getName() + " paid rent to " + owner.getName());
                            System.out.println(player.getName()+" new money is : "+player.getMoney());
                            System.out.println(owner.getName()+"(owner) new money is "+owner.getMoney());
                            }
                            else if (special.owner != player.getName() && player.getMoney() < special.getCost()) {
                            //not enough money to pay rent to owner of the property
                            System.out.println("This Property is owned by "+special.owner);
                            player.paySpecialRentfromFate(special);
                            owner.addMoney(special.getRentfromFate());
                            System.out.println("Rent for this property is "+special.getRentfromFate());
                            System.out.println(player.getName() + " paid rent to " + owner.getName());
                            System.out.println(player.getName()+" new money is : "+player.getMoney());
                            System.out.println(owner.getName()+"(owner) new money is "+owner.getMoney());
                            }
                            else{
                                System.out.println("You are the owner of this property.");
                                System.out.println("Thankyou for visiting !");
                            }
                    }
                }
                }
            }
            else if (space instanceof Go) {
                Go go = (Go) space;
                System.out.println(player.getName()+" receive 2M as a salary !");
                player.addMoney(2000000);
                System.out.println(player.getName()+" new money is : "+player.getMoney());
            }
            else if (space instanceof Fate) {
                Fate fate = (Fate) space;
                String drawFate = fate.drawFate();
                System.out.println("Draw 1 fate card.");
                System.out.println(drawFate);
                fate.performFate(drawFate, player, position, players);
                
                
            }
            else if (space instanceof FreeParking) {
                System.out.println("Enjoy this free parking !");
            }
            return space;
        }
        
        public static Player findPropertyOwner(Property property, List<Player> players) {
        for (Player player : players) {
            if (player.getName().equals(property.owner)) {
                return player;
            }
        }
        return null;
    }
        
        public static Player findSpecialPropertyOwner(SpecialProperty special, List<Player> players) {
        for (Player player : players) {
            if (player.getName().equals(special.owner)) {
                return player;
            }
        }
        return null;
    }
        
        String getSpaceName(Space space) {
            if (space instanceof Property) {
                return ((Property) space).getName();
            } else if (space instanceof Fate) {
                return ((Fate) space).getName();
            } else if (space instanceof FreeParking) {
                return "Free Parking";
            }
            else if (space instanceof Go) {
                return ((Go) space).getName();
            }
            else if (space instanceof VisitJail) {
                return "Visit Jail";
            }
            else if (space instanceof Jail) {
                return "Jail";
            }
            else if (space instanceof Tax) {
                return ((Tax) space).getName();
            }
            else if (space instanceof SpecialProperty) {
                return ((SpecialProperty) space).getName();
            }
            // Add more checks for other space types if needed
            return "Unknown Space";
        }
        
        public List<Space> getSpaces() {
            return spaces;
        }
    }

    interface Space{
        String getType();
        /*
        Property
        Fate
        FreeParking
        Jail
        VisitJail
        Go
        SpecialProperty
        Tax
        */
    }
    
    class Fate implements Space{
        String name;
        
        public Fate(String name){
            this.name=name;
        }
        
        public String getName(){
            return name;
        }
        
        public String drawFate(){
            String[] fateList = {
            "Advance to Go",
            "It is your birthday. Collect RM 100K from every player",
            "Bank error in your favor. Collect RM 2M",
            "Go Back 3 Spaces",
            "Go to Jail. Go directly to Jail, do not pass Go, do not collect RM 2M",
            "Make general repairs on all your property. For each house pay RM 200K.",
            "Pay hospital fees of RM 250K",
            "Pay school fees of RM 100K",
            "Speeding fine RM 100K",
            "Advance to the nearest Railroad."
        };
        
            Random random = new Random();
            int randomFate = random.nextInt(fateList.length);

        return fateList[randomFate];
        }
        
        public static Player Birthday(Player birthdayboy,List<Player> players){
            for (Player player : players) {
            if (player.getName().equals(birthdayboy.getName())) {
                return player;
            }
        }
        return null;
        }
        
        public static void performFate(String fateDrawn, Player player, int position,List<Player> players) {
        DuitRiaBoard board = new DuitRiaBoard();
            
            switch (fateDrawn) {
                case "Advance to Go":
                    player.setPosition(0);
                    board.getSpaceVar(player.position,player.getName(), player, players,0);
                    break;
                case "It is your birthday. Collect RM 100K from every player":
                    //habiskan
                    Player birthdayboy =  Birthday(player, players);
                    System.out.println("Your new money is "+player.getMoney());
                    for (Player otherplayer : players){
                        if(otherplayer.getName().equals(birthdayboy.getName())){
                            birthdayboy.addMoney(100000*(board.getNumPlayer()-1));
                            System.out.println(otherplayer.getName()+" new money is : "+otherplayer.getMoney());
                        }
                        else{
                            otherplayer.deductMoney(100000);
                            System.out.println(otherplayer.getName()+" new money is : "+otherplayer.getMoney());
                        }
                    }
                    break;
                case "Pay 50k":
                    player.deductMoney(50000);
                    System.out.println("Your new money is "+player.getMoney());
                    break;
                case "Bank error in your favor. Collect RM 2M":
                    player.addMoney(2000000);
                    System.out.println("Your new money is "+player.getMoney());
                    break;
                case "Go Back 3 Spaces":
                    player.move(-3, player);
                    System.out.println("Your new position is "+player.getPosition());
                    break;
                case "Go to Jail. Go directly to Jail, do not pass Go, do not collect RM 2M":
                    player.setPosition(30);
                    board.getSpaceVar(player.position,player.getName(), player, players,0);
                    break;
                case "Make general repairs on all your property. For each house pay RM 200K.":
                    System.out.println("You have "+player.getOwnedHouse()+" house(s) in total : "+player.getOwnedHouse()*200+"K");
                    player.deductMoney(player.getOwnedHouse()*200000);
                    System.out.println("Your new money is "+player.getMoney());
                    break;
                case "Pay hospital fees of RM 250K":
                    player.deductMoney(250000);
                    System.out.println("Your new money is "+player.getMoney());
                    break;
                case "Pay school fees of RM 100K":
                    player.deductMoney(100000);
                    System.out.println("Your new money is "+player.getMoney());
                    break;
                case "Speeding fine RM 100K":
                    player.deductMoney(100000);
                    System.out.println("Your new money is "+player.getMoney());
                    break;
                case "Advance to the nearest Railroad.":
                    // habiskan
                    if(player.getPosition()==36 || player.getPosition()==2){
                        player.setPosition(5);
                        board.getSpaceVar(player.position,player.getName(), player, players, 1);
                    }
                    else if(player.getPosition()==7){
                        player.setPosition(15);
                        board.getSpaceVar(player.position,player.getName(), player, players,1);
                    }
                    else if(player.getPosition()==17 || player.getPosition()==22){
                        player.setPosition(25);
                        board.getSpaceVar(player.position,player.getName(), player, players,1);
                    }
                    if(player.getPosition()==33){
                        player.setPosition(35);
                        board.getSpaceVar(player.position,player.getName(), player, players,1);
                    }
                    break;
                default:
                    System.out.println("Invalid fate instruction");
                    break;
            }
        }
        
        
        @Override
        public String getType(){
            return "Fate";
        }
    }

    class Go implements Space{
        String name;
        int salary;
        
        public Go(String name, int salary){
            this.name=name;
            this.salary=salary;
        }
        
        public String getType(){
            return "Go";
        }
        
        public int getSalary(){
            return salary;
        }
            
        public String getName(){
            return name;
        }
    }

    class SpecialProperty implements Space{
        String name;
        int cost;
        int rent;
        String owner;
        int slot;
        
        public SpecialProperty(String name, int cost, int rent, String owner){
            this.name=name;
            this.cost=cost;
            this.rent=rent;
            this.owner= owner;
        }
        
        public int getSlot(){
        return slot;
        }
        
        public int getRentfromFate(){
            return rent*2;
        }
        
        public String getName(){
            return name;
        }
        
        public String getOwner(){
            return owner;
        }
        
        public void setOwner(String owner){
            this.owner = owner;
    }
        
        public int getCost(){
            return cost;
        }
        
        public int getRent(){
            return rent;
        }
        
        public String getType(){
            return "Property";
        }
    }
    
    class Jail implements Space{
        String name;
        int fine;
        
        public Jail(String name, int fine){
            this.name=name;
            this.fine=fine;
        }
        
        public String getName(){
            return name;
        }
        
        public int getFine(){
            return fine;
        }
        
        public void visitJail(){
            System.out.println("you are visiting jail.");
        }
        
        public String getType(){
            return "Jail";
        }
    }

    class VisitJail implements Space{
        String name;
        
        public VisitJail(String name){
            this.name=name;
        }
        
        public String getName(){
            return name;
        }
        
        public String getType(){
            return "VisitJail";
        }
    }

    class Tax implements Space{
        String name;
        int tax;
        
        public Tax(String name, int tax){
            this.name=name;
            this.tax=tax;
        }
        
        public String getType(){
            return "Tax";
        }
        
        public String getName(){
            return name;
        }
        
        public int getTax(){
            return tax;
        }
    }

    class FreeParking implements Space{
        String name;
        
        public FreeParking(String name){
            this.name=name;
        }
        
        public String getName(){
            return name;
        }
        
        public String getType(){
            return "FreParking";
        }
    }
    
    class Property implements Space{
     String name;
     int cost;
     int rent,rent1,rent2,rent3,rent4;
     int slot=0;
     int numhouse=0;
     String owner;

    public Property(String name, int cost, int rent, int rent1, int rent2, int rent3, int rent4, String owner) {
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }
    
    public String getOwner(){
        return owner;
    }
    
    public void setOwner(String owner){
            this.owner = owner;
    }
    
    public void  paidRenttoOwner(Player player,Property property,int numhouse){
        int rent = property.getRent(numhouse);
        player.addMoney(rent);
    }
    
    public void houseBuilt(Property property, int newhouse){
        int rent = property.getRent(numhouse);
        numhouse += newhouse;
        System.out.println();
        System.out.println("Cost for "+newhouse+" new house : "+newhouse*200+"k.");
        System.out.println("Congratulations! You built "+newhouse+" new house !");
        System.out.println("Your new amount of rent is "+property.getRent(numhouse));
    }
    
    public int getSlot(){
        return slot;
    }

    public int getCost() {
        return cost;
    }
    
    public int getNumHouse(){
        return numhouse;
    }

    public int getRent(int numhouse) {
        switch(numhouse){
            case 0:return rent;
            case 1:return rent1;
            case 2:return rent2;
            case 3:return rent3;
            case 4:return rent4;
                
        }
        return 0;
    }
    
    public void seeListRent(){
        System.out.println();
        System.out.println("0 house : "+rent);
        System.out.println("1 house : "+rent1);
        System.out.println("2 house : "+rent2);
        System.out.println("3 house : "+rent3);
        System.out.println("4 house : "+rent4);
    }
    
    public String getType(){
        return "Property";
    }
}

    class Player{
        String name;
        int money;
        int position;
        List<Property> ownedProperties;
        List<SpecialProperty> ownedSpecialProperties;
        int ownedhouse=0;
        Scanner scan = new Scanner(System.in);
        int loan;
        int slotloan=0;
        int turn;
        int matured=0;
        
        public Player(String name, int money,int turn){
            this.name=name;
            this.money = money;
            this.position=0;    
            this.turn=turn;
            this.ownedProperties = new ArrayList<>();
            this.ownedSpecialProperties = new ArrayList<>();
        }
        
        public void move(int spaces, Player player){
            if(position+spaces>40){
                System.out.println(player.getName()+" receive 2M as a salary !");
                player.addMoney(2000000);
                position = (position + spaces)%40;
                player.justMatured();
            }
            else{
                position = (position + spaces)%40;
            }
        }
        
        public int getOwnedHouse(){
            return ownedhouse;
        }
        
        public void addOwnedHouse(int newhouse){
            ownedhouse += newhouse;
        }
        
        public void deductOwnedHouse(int sellhouse){
            ownedhouse -= sellhouse;
        }
        
        public String getName(){
            return name;
        }
        
        public int getPosition(){
            return position;
        }

        public int getMatured(){
            return matured;
        }

        public void justMatured(){
            matured++;
        }
        
        public int getTurn(){
            return turn;
        }
        
        public void setPosition(int spaces){
            this.position = spaces;
        }
        
        public int getMoney(){
            return money;
        }
        
        public void setTurn(int newTurn){
            turn = newTurn;
        }
        
        public void addMoney(int amount){
            money += amount;
        }
        
        public void deductMoney(int amount){
            money -= amount;
        }
        
        public void buyProperty(Property property) {
            ownedProperties.add(property);
            deductMoney(property.getCost());
        }  

        public void sellProperty(String propertyName, Player player) {
        Property propertyToRemove = null;

        for (Property property : ownedProperties) {
            if (property.getName().equals(propertyName)) {
                propertyToRemove = property;
                break;
            }
        }

        if (propertyToRemove != null) {
            ownedProperties.remove(propertyToRemove);
            System.out.println("Property '" + propertyName + "' has been sold.");
            player.addMoney(propertyToRemove.getCost()/2);
            System.out.println(player.getName()+" new money is : "+player.getMoney());
        }
    }
        
        public void buySpecialProperty(SpecialProperty special) {
            ownedSpecialProperties.add(special);
            deductMoney(special.getCost());
        }

        public void sellSpecialProperty(SpecialProperty special) {
            ownedSpecialProperties.remove(special);
            addMoney(special.getCost()/2);
        }

        public void payRent(Property property, int numhouse) {
            int rent = property.getRent(numhouse);
            deductMoney(rent);
        }
        
        public void paySpecialRent(SpecialProperty special) {
            int rent = special.getRent();
            deductMoney(rent);
        }
        
        public void paySpecialRentfromFate(SpecialProperty special) {
            int rent = special.getRentfromFate();
            deductMoney(rent);
        }
        
        public String getOwnedProperties() {
            for(Property property : ownedProperties){
                return property.getName();
            }
            return "0";
        }

        public void removeProperty(){
            for (Property property : ownedProperties) {
            property.slot=0;
        }
        }

        public String getOwnedPropertiesPawn() {
            for(Property property : ownedProperties){
                return property.getName()+" RM"+property.getCost()/2;
            }
            return "0";
        }
        
        public void addOwnedProperties(Property property){
            ownedProperties.add(property);
        }
        
        public void addOwnedSpecialProperties(SpecialProperty special){
            ownedSpecialProperties.add(special);
        }

        public String getOwnedSpecialProperties() {
            for(SpecialProperty special : ownedSpecialProperties){
                return special.getName();
            }
            return "0";
        }

        public String getOwnedSpecialPropertiesPawn() {
            for(SpecialProperty special : ownedSpecialProperties){
                return special.getName()+" RM"+special.getCost()/2;
            }
            return "0";
        }

        public int getNetWorth(){

            for (Property property : ownedProperties) {
                addMoney(property.getCost()/2);
            }

            for(SpecialProperty special : ownedSpecialProperties){
                addMoney(special.getCost()/2);
            }

            return getMoney();
        }

    }
    
public class DuitRia{
    public static void main(String[] args) {
        
        Dice dice = new Dice();
        DuitRiaBoard board = new DuitRiaBoard();
        Scanner scan = new Scanner(System.in);
        GUI gui = new GUI();
        
        List<Player> players = new ArrayList<>();
        
        gui.GUI();

        while(true){
            System.out.println("How many players ? (2-4 only)");
            int numplayer = scan.nextInt();
            if(numplayer<2 || numplayer>4){
                System.out.println("error !");
            }
            else{
                register(players,numplayer);
                break;
            }
        }
        
        System.out.println("Names of Players by turn :");
        int a=1;
        for (Player player : players) {
            System.out.println(a+". "+player.getName());
            a++;
        }
        System.out.println("");

        while(a!=0){
        for (Player player : players) {
                int diceResult = dice.roll();
                System.out.println("________________________________________\n");
                System.out.println(player.name+" Rolled : "+diceResult);
                player.move(diceResult, player);
                board.getSpaceAtPosition(player.position, player.getName());
                if(player.getMatured()==0){
                continue;
            }
            board.getSpaceVar(player.position,player.getName(), player, players,0);
            
            System.out.println("Your turn ends\npress \"Enter\" to continue or \"quit\" to end game");
            System.out.println("p/s : You can only quit if you are in property board.");
            String enter = scan.nextLine();
            switch(enter){
                case "":break;
                case "quit":
                //removePlayer(players,player.getName());
                endGame(players);
                a=0;
                break;
            }
        }
    }

        }

        public static void endGame(List<Player> players){

            int richestMoney=0;
            String richestName = "";
            System.out.println();

            for(Player player : players){
                int tempmoney=player.getNetWorth();
                System.out.println(player.getName()+"'s Net Worth : "+tempmoney);
                if(tempmoney>richestMoney){
                    richestMoney=tempmoney;
                    richestName=player.getName();
                }
            }

            System.out.println();
            System.out.println("The winner is "+richestName+" with "+richestMoney+" !!!");
            System.exit(0);
        }

        public static void removePlayer(List<Player> players, String playerName) {
            ArrayList<Player> playersToRemove = new ArrayList<>();
    
            for (Player player : players) {
                if (player.getName().equals(playerName)) {
                    playersToRemove.add(player);
                    player.removeProperty();
                }
            }
    
            players.removeAll(playersToRemove);
        }
    
        public static void register(List<Player> players, int numplayer){
            Scanner scan = new Scanner(System.in);
            Dice dice = new Dice();
            DuitRiaBoard board = new DuitRiaBoard();
            
            String[] names = new String[numplayer+1];
            int[] turn = new int[numplayer];
            
            for (int i = 0; i <= numplayer-1; i++) {
                System.out.print("Enter the name of Player " + (i+1) + ": ");
                String playerName = scan.nextLine();
                names[i]=playerName;
        }
            for(int j=0;j<=numplayer-1;j++){
                int diceRolled = dice.roll();
                System.out.println(names[j]+" Rolled "+diceRolled);
                turn[j]=diceRolled;
            }
            
            for(int i=0;i<numplayer-1;i++){
                for(int j=0;j<numplayer-i-1;j++){
                    if(turn[j]<turn[j+1]){
                        String hold=names[j];
                        names[j]=names[j+1];
                        names[j+1]=hold;
                        
                        int temp=turn[j];
                        turn[j]=turn[j+1];
                        turn[j+1]=temp;
                    }
                }
            }
            
            for(int k=0;k<=numplayer-1;k++){
                players.add(new Player(names[k], 15000000,k)); // Initial money for player
                board.numPlayer();
            }
            
        }
    }
    
    class GUI{
        JFrame frame;
        JPanel titlep,registerp,startp,okayp;
        JLabel titlel,textlab;
        JButton startb,okayb;
        Container cont;
        String position;
        
        Font titlefont = new Font("Times New Roman",Font.PLAIN,50);
        Font normalfont = new Font("Times New Roman",Font.PLAIN,30);
        
        public void GUI(){
            position = "first";
            frame = new JFrame("DuitRia !");
            titlep = new JPanel();
            titlel = new JLabel("\nDuitRia Game Board !");
            
            frame.setSize(800,500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.black);
            frame.setLayout(null);
            cont = frame.getContentPane();
            
            startp = new JPanel();
            startp.setBounds(270,300,240,70);
            startp.setBackground(Color.black);
            
            startb = new JButton("Start");
            startb.setBackground(Color.black);
            startb.setForeground(white);
            startb.setFont(normalfont);
            startb.addActionListener(new TitleScreenHandler());
            startb.setFocusPainted(false);
            
            titlep.setBounds(100,100,600,150);
            titlep.setBackground(Color.black);
            titlep.add(titlel);
            startp.add(startb);
            
            titlel.setForeground(Color.white);
            titlel.setFont(titlefont);
            cont.add(titlep);
            cont.add(startp);
            
            }
        
        public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            switch(position){
                case "first":intro();break;
                case "intro":second();break;
                case "second":third();break;
                case "third":forth();break;
                case "forth":frame.dispose();break;
            }
            
            }
        }
            
            public void intro(){
            position = "intro";
            titlep.setVisible(false);
            startp.setVisible(false);
        
            registerp = new JPanel();
            registerp.setBackground(Color.black);
            registerp.setForeground(white);
            registerp.setBounds(100,150,600,200);
            cont.add(registerp);
            
            textlab = new JLabel("<html>In this classic board game,<br>your goal is to become the wealthiest player by<br>buying, selling, and trading properties.</html>");
            textlab.setFont(normalfont);
            textlab.setForeground(Color.white);
            textlab.setBounds(100, 100, 100, 100);
            registerp.add(textlab);
            
            okayp = new JPanel();
            okayp.setBackground(Color.black);
            okayp.setBounds(350, 330, 100, 100);
            cont.add(okayp);
            
            okayb = new JButton("Next");
            okayb.setBackground(Color.black);
            okayb.setForeground(white);
            okayb.setFont(normalfont);
            okayb.addActionListener(new TitleScreenHandler());
            okayb.setFocusPainted(false);
            okayp.add(okayb);
        }
            
            public void second(){
                position="second";
                textlab.setText("<html>You will move around the board, <br>acquire properties, and build houses.</html>");
            }
            
            public void third(){
                position="third";
                textlab.setText("<html>Beware of other players, and enjoy the strategic <br>and unpredictable nature of DuitRia!</html>");
            }
            
            public void forth(){
                position="forth";
                textlab.setText("<html>Let's roll the dice and see <br>who will be the ultimate tycoon!</html>");
                okayp.setBounds(300, 330, 200, 100);
                okayb.setText("Yeay!");
            }
}
     

