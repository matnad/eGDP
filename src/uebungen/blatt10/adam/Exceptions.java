package uebungen.blatt10.adam;

class Exceptions {
    public static class E1 extends Exception {}
    public static class E2 extends Exception {}
    static boolean condition = false; // oder false
    public static void main (String[] args) {
        try {
            System.out.print("Urs ");
            m1();
            System.out.print("Regula ");
        } catch (E1 e) {
            System.out.print("Kino ");
        } catch (E2 e) {
            System.out.print("allein ");
        } finally {
            System.out.print("nach ");
        }
        System.out.println("Hause");
    }
    static void m1() throws E1, E2 {
        try {
            System.out.print("geht ");
            if (condition)
                throw new E1();
            else
                throw new E2();
        } catch (E1 e) {
            System.out.print("sehr ");
        }
        finally {
            System.out.print("gerne ");
        }
        System.out.print("mit ");
    }
}