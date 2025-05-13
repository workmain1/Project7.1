public class Person implements Comparable<Person> {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(this.birthYear, otherPerson.birthYear);
    }
    public static void main(String[] args) {
        Person person1 = new Person("Andrii", 2005);
        Person person2 = new Person("Ivan", 2006);
        Person person3 = new Person("Igor", 2004);

        int comparison1 = person1.compareTo(person2);
        int comparison2 = person2.compareTo(person3);
        int comparison3 = person1.compareTo(person3);

        System.out.println(person1.getName() + " born in " + person1.getBirthYear() +
                " compared to " + person2.getName() + " born in " + person2.getBirthYear() +
                ": " + (comparison1 < 0 ? "Before" : (comparison1 == 0 ? "Same year" : "After")));

        System.out.println(person2.getName() + " born in " + person2.getBirthYear() +
                " compared to " + person3.getName() + " born in " + person3.getBirthYear() +
                ": " + (comparison2 < 0 ? "Before" : (comparison2 == 0 ? "Same year" : "After")));

        System.out.println(person1.getName() + " born in " + person1.getBirthYear() +
                " compared to " + person3.getName() + " born in " + person3.getBirthYear() +
                ": " + (comparison3 < 0 ? "Before" : (comparison3 == 0 ? "Same year" : "After")));
    }
}