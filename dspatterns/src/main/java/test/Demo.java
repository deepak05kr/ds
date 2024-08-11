package test;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<Emp> set = new HashSet<>();
        set.add(new Emp(1, "Deepak"));
        set.add(new Emp(2, "Varnika"));
        set.add(new Emp(3, "Anvika"));
        Emp em = new Emp(4, "Swati");
        set.add(em);
        set.stream().forEach(System.out::println);
        em.setId(1);
        set.add(em);
        System.out.println(set.size());
        set.stream().forEach(System.out::println);
    }

    static class Emp {
        int id;
        String name;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Emp)) return false;
            Emp emp = (Emp) o;
            return id == emp.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
