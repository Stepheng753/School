public class main
{
    public static void main(String[] args) {
        MyVector<Object> vector = new MyVector<>(3);
        // Vector Grows Dynamically
        for (int i = 0; i < 20; i++) {
            vector.add(1);
            System.out.println(vector.get(i));
        }

        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.getCapacity());

        // Return 0 from indexOf
        MyVector<Object> vector1 = new MyVector<>();
        vector1.add('a');
        vector1.add('b');
        vector1.add('c');
        vector1.add('d');
        for (int i = 0; i < vector1.size(); i++) {
            System.out.println(vector1.get(i));
        }
        System.out.println("Index of a: " + vector1.indexOf('a'));

        // Trim reduces vector to capacity 5
        MyVector<Object> vector2 = new MyVector<>();
        vector2.add(1);
        vector2.add(2);
        vector2.add(3);
        vector2.add(4);
        vector2.add(5);
        for (int i = 0; i < vector2.size(); i++) {
            System.out.println(vector2.get(i));
        }
        System.out.println("Size: " + vector2.size());
        System.out.println("OG Capacity: " + vector2.getCapacity());
        vector2.trimToSize();
        System.out.println("Trimmed Capacity: " + vector2.getCapacity());

        // Return 6 and -1 when using lastIndexOf
        MyVector<Object> vector3 = new MyVector<>();
        vector3.add(3);
        vector3.add(1);
        vector3.add(3);
        vector3.add(1);
        vector3.add(3);
        vector3.add(1);
        vector3.add(3);
        System.out.println("Last Index of '3': "+ vector3.lastIndexOf(3));
        System.out.println("Last Index of '6': "+ vector3.lastIndexOf(6));




















    }
}
