public class IntegerSetTest {
    public static void main(String[] args){
        System.out.println("--- Starting CharSet Manual Tests ---");
        int passed = 0;
        int failed = 0;

        // Test 1: การสร้าง, เพิ่มข้อมูล, และการเรียงลำดับ
        System.out.println("\n--- Testing add() add sorting ---");
        IntegerSet a = new IntegerSet();
        a.add(50);
        a.add(70);
        a.add(40);
        a.add(60);
        String s = "[40, 50, 60, 70]";
        if (a.toString().equals(s)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED: Expected " + s + " but got " + a.toString());
        }
        // Test 2: การเพิ่มข้อมูลที่ซ้ำซ้อน
        System.out.println("\n--- Testing adding duplicates ---");
        a.add(40); // เพิ่ม '40' ที่มีอยู่แล้ว
        if (a.size() == 40) {
            System.out.println("PASSED: Adding a duplicate does not change the size.");
            passed++;
        } else {
            System.out.println("FAILED: Size should be 40 but got " + a.size());
            failed++;
        }

        // Test 3: การลบข้อมูล
        System.out.println("\n--- Testing remove() ---");
        a.remove(50);
        String s2 = "{40, 60, 70}";
        if (a.toString().equals(s2)) {
            System.out.println("PASSED: Remove works correctly.");
            passed++;
        } else {
            System.out.println("FAILED: Expected " + s2 + " but got " + a.toString());
            failed++;
        }

        // Test 4: การตรวจสอบข้อมูล (contains)
        System.out.println("\n--- Testing contains() ---");
        if (a.contains(40) && !a.contains(50)) {
            System.out.println("PASSED: Contains works correctly after removal.");
            passed++;
        } else {
            System.out.println("FAILED: Contains check is incorrect.");
            failed++;
        }

        // --- สรุปผล ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passed + ", Failed: " + failed);
        if (failed == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}