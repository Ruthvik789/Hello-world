class Program2 {
    static int staticVariable = 10;
    int instanceVariable = 20;
    public void displayVariable() {
        int localVariable = 30;
        System.out.println("Static Variable: " + staticVariable);
        System.out.println("Instance Variable: " + instanceVariable);
        System.out.println("Local Variable: " + localVariable);
    }
    public static void main(String[] args) {
        Program2 example = new Program2();
        example.displayVariable();
        System.out.println("Accessing Static Variable from main: " + Program2.staticVariable);
    }
}