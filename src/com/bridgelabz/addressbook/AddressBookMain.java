package com.bridgelabz.addressbook;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    HashMap<String, AddressBook> hashMap = new HashMap<String,AddressBook>();
    Scanner sc = new Scanner(System.in);
    public void addAddressBook(){
        AddressBook addressBook = new AddressBook();
        System.out.println("Enter Name of AddressBook");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            System.out.println("Enter different name for the AddressBook");
            addAddressBook();
        }else {
            addressBook.setAddressBookName(name);
            hashMap.put(addressBook.getAddressBookName(), addressBook);
            System.out.println("Address book Added.....");
        }
    }
    public void addContact() {
        if (hashMap.isEmpty()) {
            System.out.println("your addressbook is empty first please add new Addressbook");
            addAddressBook();
        }
        System.out.println("Enter name of the addressbook  in which you want to add contact:");
        String name = sc.nextLine();
        if (hashMap.containsKey(name)) {
            AddressBook temp = hashMap.get(name);
            temp.addContact();
        }
    }
    public void displayContact(){
        System.out.println("Enter name of Addressbook in which you want to display contact");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            AddressBook temp = hashMap.get(name);
            temp.displayContact();
        }
    }
    public void deleteContact(){

        System.out.println("Enter name of the addressbok in which you want to Delete contact: ");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            AddressBook temp = hashMap.get(name);
            temp.deleteContact();
        }
    }
    public void editContact(){
        System.out.println("Enter name of the addressbok in which you want to Edit contact: ");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            AddressBook temp = hashMap.get(name);
            temp.editContact();
        }
    }

    public void displayAllAddressbook(){
        System.out.println("Displaying all addressbook");
        if(hashMap.isEmpty()){
            System.out.println("Addressbook is empty");
        }else {
            System.out.println(hashMap);
        }
    }
    public void searchByCity(){
        System.out.println("Enter the Name Of City by Which you want Search");
        String  cityName = sc.next();
        List<Contact> cityList = new ArrayList<>();
        hashMap.values().stream().forEach(addressBook -> {
            cityList.addAll(addressBook.getContactArrayList().stream().filter(Contact ->
                    Contact.getCity().equalsIgnoreCase(cityName)).collect(Collectors.toList()));
        });
        int count = cityList.size();
        System.out.println("Total Number of Contact Person");
        System.out.println(count + "Person Found... which belongs to " + cityName + "city");
        System.out.println(cityList);
    }
    public void searchByState(){
        System.out.println("Enter the Name Of State by Which you want Search");
        String  stateName = sc.next();
        List<Contact> stateList = new ArrayList<>();
        hashMap.values().stream().forEach(addressBook -> {
            stateList.addAll(addressBook.getContactArrayList().stream().filter(Contact ->
                    Contact.getCity().equalsIgnoreCase(stateName)).collect(Collectors.toList()));
        });
        int count = stateList.size();
        System.out.println("Total Number of Contact Person");
        System.out.println(count + "Person Found... which belongs to " + stateName + "State");
        System.out.println(stateList);
    }
    public void displaySortedAddressBook(){
        System.out.println("Enter the name of the address book  you want to display");
        String name = sc.next();
        if(hashMap.containsKey(name)){
            AddressBook temp = hashMap.get(name);
            System.out.println("Choose the option to sort the contacts in the Address Book based on");
            System.out.println("1.First Name\n 2.City \n 3.State \n 4.Zip Code...");
            int choice = sc.nextInt();

            List<Contact> sortedList = new ArrayList<>();
            switch (choice){
                case 1:
                    sortedList = temp.getContactArrayList().stream().sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList());
                    break;
                case 2:
                    sortedList = temp.getContactArrayList().stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
                    break;
                case 3:
                    sortedList = temp.getContactArrayList().stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
                    break;
                case 4:
                    sortedList = temp.getContactArrayList().stream().sorted(Comparator.comparing(Contact::getZip)).collect(Collectors.toList());
                    break;
            }
            System.out.println("The sorted Contacts....");
            System.out.println(sortedList);
            System.out.println();
        }else
            System.out.println("Given AddressBook Not Found....");
    }
    public static void main(String[] args) {
        System.out.println("******Welcome to Address Book Program******");
        System.out.println("Contacts created in Address Book");
        AddressBookMain addressBookMain = new AddressBookMain();
        Scanner sc = new Scanner(System.in);

        boolean flag1 = true;
        while (flag1){

            System.out.println("-----\nSelect option");
//            System.out.println("1.Add Details \n 2.Edit Contact\n 3.Delete contact \n 4.Display\n 5.Add AddressBook\n 6.Display All Addressbook\n 7. exit\n 8.");
            System.out.println(" 1 : Press 1 to Add New Contact.... ");
            System.out.println(" 2 : Press 2 to Edit Contact.... ");
            System.out.println(" 3 : Press 3 to Delete Contact....  ");
            System.out.println(" 4 : Press 4 to Display Contact.... ");
            System.out.println(" 5 : Press 5 to Add AddressBook.... ");
            System.out.println(" 6 : Press 6 to Display All AddressBook.... ");
            System.out.println(" 7 : Press 7 to Display All the Contact from Specified City.... ");
            System.out.println(" 8 : Press 8 to Display All the Contact from Specified State.... ");
            System.out.println(" 9 : Press 5 to Display Dictionary of AddressBook.... ");
            System.out.println(" 10 : Press 10 to Display Sorted AddressBook.... ");
            System.out.println(" 11 : Press 11 to Exit.... ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    addressBookMain.addContact();
                    break;
                case 2:
                    addressBookMain.editContact();
                    break;
                case 3:
                    addressBookMain.deleteContact();
                    break;
                case 4:
                    addressBookMain.displayContact();
                    break;
                case 5 :
                    addressBookMain.addAddressBook();
                    break;
                case 6:
                    addressBookMain.displayAllAddressbook();
                case 7:
                    addressBookMain.searchByCity();
                case 8:
                    addressBookMain.searchByState();
                case 9:
                    System.out.println(addressBookMain.hashMap);
                case 10:
                   addressBookMain.displaySortedAddressBook();
                case 11:
                    flag1 = false;
                    break;
                default:
                    System.out.println(option + "is not valid option");
                    break;
            }
        }

    }
}

