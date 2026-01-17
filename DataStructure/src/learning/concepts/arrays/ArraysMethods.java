package learning.concepts.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethods {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(10000L,24);
        employees[1] = new Employee(10000L,23);
        employees[2] = new Employee(50000L,26);
        employees[3] = new Employee(45000L,25);
        employees[4] = new Employee(75000L,28);

//        Arrays.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                if(o1.getSalary() != o2.getSalary()) {
//                    return (int) (o2.getSalary() - o1.getSalary());
//                } else {
//                    return o1.getAge() - o2.getAge();
//                }
//            }
//        });

        Arrays.sort(employees, (o1, o2) -> {
            if(o1.getSalary() != o2.getSalary()) {
                return (int) (o2.getSalary() - o1.getSalary());
            } else {
                return o1.getAge() - o2.getAge();
            }
        });

        for(int i = 0; i< employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
}

class Employee {
    private Long salary;
    private int age;

    Employee (Long salary, int age) {
        this.salary = salary;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public Long getSalary() {
        return salary;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */

    public int compareTo(Employee o) {
        if(this.salary != o.salary) {
            return (int) (this.salary - o.salary);
        }
        else {
            return o.age - this.age;
        }
    }
}
