package homeworkgame;
import java.util.Random;
import java.util.Scanner;//подключили сканер

public class Main {

    public static void main(String[] args) {
        //menu
        menuGame();
    }

    //menu
    private static void menuGame(){
        int playGame = 0;
        while (playGame != 3) {
            System.out.println("В какую игру Вы хотите сыграть? 1 - Угадай число / 2 - Угадай слово / 3 - Выход");
            Scanner scan = new Scanner(System.in);
            playGame = scan.nextInt();
            if (playGame == 1) {
                playRandomGame();
            } else if (playGame == 2) {
                playGuessWord();
            } else {
                System.out.println("Вы вышли!");
            }
        }
    }

    /**
     * 1. Написать программу, которая загадывает случайное число от 0 до 9,
     * и пользователю дается 3 попытки угадать это число.
     * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
     * или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
     * 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */
     private static void playRandomGame(){
         int firstNumber = 0;//от 0
         int lastNumber = 9;//до 9
         int random = firstNumber + (int) (Math.random() * lastNumber);//диапазон от 0 до 9
         //System.out.println(random);

         for (int i = 0; i < 3; i++){ //цикл где пользователь угадывает число

             System.out.println("Введите число от 0 до 9");
             Scanner scan = new Scanner(System.in);
             int number = scan.nextInt();

             if (random > number){
                 System.out.println ("Ваше число меньше");
             }else if (random < number){
                 System.out.println ("Ваше число больше");
             }else{
                 System.out.println("Вы угадали!");
                 break;
             }

             if (i == 2){
                 System.out.println ("Вы проиграли!");
             }
         }

         System.out.println("Повторить игру ещё раз? 1 – да / 0 – нет");
         Scanner scan = new Scanner(System.in);
         int answer = scan.nextInt();

         if (answer == 1){
             playRandomGame();
         }
         else {
             System.out.println("See you later!");
         }
     }

    /**
     * 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
     * "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
     * "pear", "pepper", "pineapple", "pumpkin", "potato"};
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
     * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно, можно пользоваться:
     * String str = "apple";
     * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово
     * Используем только маленькие буквы
     */
    private static void playGuessWord(){

        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int randomNumber = (int) Math.floor(Math.random() * words.length);
        System.out.println(words[randomNumber]);

        String[] resultArray = {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"};
        char[] randomWordsToArray = words[randomNumber].toCharArray();//преобразуем строку userWords в массив символов

        Scanner sc = new Scanner(System.in);
        System.out.println("Отгадайте фрукт (овощ)");
        String userWords = sc.nextLine();

        boolean isPlay = true;//играем пока isPlay true

        while (isPlay) {

            if (userWords.equals(words[randomNumber])) {
                System.out.println("Вы угадали!");
                isPlay = false;

            }else{
                char[] userWordsToArray = userWords.toCharArray();//преобразуем строку userWords в массив символов

                for (int i = 0; i < userWordsToArray.length; i++) {//цикл преобразования в массив
                    System.out.print(userWordsToArray[i] + " ");
                }
                System.out.println();

                int minLen = userWordsToArray.length < randomWordsToArray.length ? userWordsToArray.length : randomWordsToArray.length;
                for (int i = 0; i < minLen; i++) {//подставляем в resultArray символы от userWords

                    if (userWordsToArray[i] == randomWordsToArray[i]) {
                        resultArray[i] = "" + userWordsToArray[i];
                    }
                }

                for (int i = 0; i < resultArray.length; i++) {//подставляем в массив resultArray (загаданое слово) слово, которое ввёл пользователь и записываем совпавшие символы.
                    System.out.print(resultArray[i]);
                }
                System.out.println();


                sc = new Scanner(System.in);
                System.out.println("Продолжите отгадывать фрукт (овощ)");
                userWords = sc.nextLine();
            }
        }
     }
}
