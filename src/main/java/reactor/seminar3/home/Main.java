package reactor.seminar3.home;

public class Main {
    public static void main(String[] args) {

    }


    // 1. Необходимо изменить файл emails.json. Сделать емейл ключом, а ему в значение рандомно поставить значения true или false.
    //       Файл должен быть валиден.
    // 2. С помощью метода Flux.create - достать данные построчно используя метод Files.lines() и отфильтровать строки, которые не содержат
    //       пары ключ-значение. Остальные строки прокинуть через слив в downstream
    // 3. С помощью метода handle((s, sink) -> {...}) пропустить те емейлы, у которых значение равно true.
    // 4. Для прошедщих фильтрацию - отправить сообщение (Можно просто вывести в консоль емейл и сообщение для него)
    public static void spamBot() {

    }
}
