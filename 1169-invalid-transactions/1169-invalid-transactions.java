import java.util.ArrayList;
import java.util.List;

class Solution {
    class Person {
        String name;
        int startTime;
        int amount;
        String city;
        int endTime; // startTime + 60

        Person(String name, int startTime, int amount, String city, int endTime) {
            this.name = name;
            this.amount = amount;
            this.city = city;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String toCommaSeparatedString() {
            return name + "," + startTime + "," + amount + "," + city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Person[] newArray = new Person[transactions.length];
        int i = 0;
        for (String s : transactions) {
            String[] arr = s.split(",");
            Person p = new Person(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), arr[3],
                    Integer.parseInt(arr[1]) + 60);
            newArray[i] = p;
            i++;
        }

        List<String> result = new ArrayList<>();

        for (Person person : newArray) {
            if (person.amount > 1000) {
                result.add(person.toCommaSeparatedString());
                continue;
            }

            boolean invalid = false;

            for (Person prev : newArray) {
                if (person.name.equals(prev.name) && !person.city.equals(prev.city)
                        && Math.abs(person.startTime - prev.startTime) <= 60) {
                    invalid = true;
                    break;
                }
            }

            if (invalid) {
                result.add(person.toCommaSeparatedString());
            }
        }

        return result;
    }
}
