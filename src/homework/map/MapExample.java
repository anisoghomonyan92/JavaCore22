package homework.map;


import java.util.*;

public class MapExample {


    public static void main(String[] args) {
        List<FootballTeamMember> members = new ArrayList<>();
        members.add(new FootballTeamMember(5, "Ronaldo"));
        members.add(new FootballTeamMember(7, "Messi"));
        members.add(new FootballTeamMember(9, "Mxitaryan"));

        Map<Integer, String> memberMap = new HashMap<>();
        memberMap.put(5, "Ronaldo");
        memberMap.put(7, "Messi");
        memberMap.put(9, "Mxitaryan");

        System.out.println(createFootballTeam(members));
        System.out.println(removeFromMap(memberMap, 1));
        printAllMemberNames(memberMap);
        printAllMembers(memberMap);


    }

    static Map<Integer, String> createFootballTeam(List<FootballTeamMember> members) {
        Map<Integer, String> team = new HashMap<>();
        for (FootballTeamMember member : members) {
            team.put(member.getNumber(), member.getName());
        }
        return team;
    }

    static boolean removeFromMap(Map<Integer, String> memberMap, Integer removedNumber) {
        System.out.println(memberMap.size());
        boolean remove = memberMap.remove(5, "Ronaldo");
        System.out.println("Is Ronaldo remuve? " + remove);
        System.out.println(memberMap);
        return false;
    }

    static void printAllMemberNames(Map<Integer, String> memberMap) {
        Collection<String> values = memberMap.values();
        System.out.println(values);
    }

    static void printAllMembers(Map<Integer, String> memberMap) {

        Set<Map.Entry<Integer, String>> entries = memberMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    static class FootballTeamMember {
        private int number;
        private String name;

        public FootballTeamMember(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
