package Game;

import java.util.ArrayList;

public class DotComBust {
    private int numsOfGuesses = 0;
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private GameHelper helper = new GameHelper();
    public void setUpGame (){
        DotCom dotCom = new DotCom();
        DotCom dotCom2 = new DotCom();
        DotCom dotCom3 = new DotCom();
        dotCom.setName("vk.com");
        dotCom2.setName("github.com");
        dotCom3.setName("365porn.ru");
        dotComsList.add(dotCom);
        dotComsList.add(dotCom2);
        dotComsList.add(dotCom3);
        System.out.println("Ваша цель - потопить 3 сайта.");
        System.out.println("vk.com, github.com, 365porn.com");
        System.out.println("Попытайтесь потопить их за минимальное кол-во ходов.");

        for(DotCom dc : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dc.setLocationCells(newLocation);
        }

    }
    private void startPlaying(){
        while (!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Сделайте ход: ");
            checkUserGues(userGuess);
        }
        finishGame();
    }

    private void checkUserGues(String userGuess){
        numsOfGuesses++;
        String result = "Мимо";

        for(DotCom dc : dotComsList){
            result = dc.checkYourSelf(userGuess);
            if(result.equals("Попал")){
                break;
            }
            if(result.equals("Потопил")){
                dotComsList.remove(dc);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if(numsOfGuesses<=18){
            System.out.println("Это заняло у вас всего "+numsOfGuesses+" попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули");
        } else{
            System.out.println("Это заняло у вас довольно много времени. "+numsOfGuesses+" попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
