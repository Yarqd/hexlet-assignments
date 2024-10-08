package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        SafetyList list = new SafetyList();

        Thread thread1 = new ListThread(list);
        Thread thread2 = new ListThread(list);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Количество элементов: " + list.getSize());
    }
}
