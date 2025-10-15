import java.util.Scanner;


public class Casino {
    public static void main(String[] args) {
        // Casino
        // 총 n개의 게임 중 골라서 게임을 진행 가능
        // 초기 자본은 1000원을 준다.
        // 배팅을 할 수 있다.
        // 게임은 홀짝, 가위바위보, 로또, 업다운
        // 퇴장을 하거나, 모든 돈을 잃으면 게임이 끝이난다.
        int coin = 1000;

        Scanner scanner = new Scanner(System.in);

        System.out.println("***************************");
        System.out.println("******* 중앙 카지노 *******");
        System.out.println("***************************");
        
        while (true) {
            System.out.println("다음 중 진행할 게임을 선택하세요.");
            System.out.println("1. 홀짝");
            System.out.println("2. 가위바위보");
            System.out.println("3. 로또");
            System.out.println("4. 업다운");
            System.out.println("0. 끝내기");
            System.out.print("선택 > ");

            String command = scanner.nextLine();

            // 게임 종료 커맨드
            if(command.equals("0")){
                break;
            }

            // 게임 선택 화면
            if(command.equals("1")){
                System.out.println("홀짝");
                System.out.println("************************");
                System.out.println("*********홀짝 게임******");
                System.out.println("************************");
                System.out.print("배팅액 입력( 잔액 : "+ coin +") > ");
                int bet = Integer.parseInt(scanner.nextLine());
                coin -= bet;

                System.out.println("홀 또는 짝을 선택해주세요  ");
                System.out.println("1. 홀");
                System.out.println("1. 짝");
                System.out.print("입력 > ");
                String even = scanner.nextLine();

                //String resultEven = (int)(Math.random()*2)+1+"";    //숫자 + 문자 = 문자
                int resultEven = (int)(Math.random()*2)+1;    
                // if(even.equals("홀")){
                //     int num = 1;
                //     if(resultEven == num){System.out.println("홀 정답 입니다.");}
                //     else if(resultEven != num){System.out.println("홀 틀렸습니다.");}
                // }else if(even.equals("짝")){
                //     int num = 2;
                //     if(resultEven == num){System.out.println("짝 정답 입니다.");}
                //     else if(resultEven != num){System.out.println("짝 틀렸습니다.");}
                // }else{System.out.println("잘못 입력하셨습니다.");}
                String strResult = resultEven +"";
                String textEvenResult = resultEven ==1 ?"홀": "짝";
                System.out.println(textEvenResult + "이 나왔습니다.");

                if(strResult.equals(even)){
                    coin += bet*2;
                    System.out.println(coin + "잔액, 당신은 이겼습니다.");
                }else{
                    System.out.println(coin + "잔액, 당신은 졌습니다.");
                }
                System.out.println("------------게임을 종료합니다.------------");
                

            }else if (command.equals("2")){
                System.out.println("가위바위보");
                System.out.println("************************");
                System.out.println("******가위바위보 게임*******");
                System.out.println("************************");
                System.out.println("배팅 금액 (잔액 " + coin + ")"); 
                int bet = Integer.parseInt(scanner.nextLine());               
                coin -= bet;
                System.out.println("가위 바위 보 중에 선택해주세요");
                System.out.print(" > ");
                String handsType = scanner.nextLine();
                String botHandsType = (int)(Math.random()*3)+1+"";

                if(handsType.equals("가위")){
                    if(botHandsType.equals("1")){
                        System.out.println(handsType + "vs 가위 비겼습니다.");
                    }else if(botHandsType.equals("2")){
                        System.out.println(handsType + "vs 바위 졌습니다.");
                    }else if(botHandsType.equals("3")){
                        coin += bet*2;
                        System.out.println(handsType + "vs 보 이겼습니다.");
                    }
                }else if(handsType.equals("바위")){
                    if(botHandsType.equals("1")){
                        System.out.println(handsType + "vs 가위 이겼습니다.");
                        coin += bet*2;
                    }else if(botHandsType.equals("2")){
                        System.out.println(handsType + "vs 바위 비겼습니다.");
                    }else if(botHandsType.equals("3")){  
                        System.out.println(handsType + "vs 보 졌습니다.");
                    }
                }else if(handsType.equals("보")){
                    if(botHandsType.equals("1")){
                        System.out.println(handsType + "vs 가위 졌습니다.");
                    }else if(botHandsType.equals("2")){
                        System.out.println(handsType + "vs 바위 이겼습니다.");
                        coin +=bet*2;
                    }else if(botHandsType.equals("3")){  
                        System.out.println(handsType + "vs 보 비겼습니다.");
                    }
                }else {System.out.println("잘못된 값 입력.");}
                System.out.println("게임을 종료합니다.");

            }else if (command.equals("3")){
                System.out.println("****** 배율 X 5배 *******");
                System.out.println("************************");
                System.out.println("*********로또 게임*******");
                System.out.println("************************");
                System.out.println("배팅 금액 (잔액" + coin + ") > ");
                int bet = Integer.parseInt(scanner.nextLine());
                coin -= bet;

                System.out.println("이진 로또 입니다.");
                System.out.println("5자리 숫자를 맞추시면 됩니다.");
                System.out.println("자리당 경우의 수는 '0' 또는 '1'입니다.");

                String userNumber = scanner.nextLine();
                String botNumber = "";
                for(int i=0;i<5;i++){
                    botNumber += (int)(Math.random()*2)+"";
                } 
                if(userNumber.equals(botNumber)){
                    System.out.println("***********************");
                    System.out.println("******* JackPot *******");
                    System.out.println("***********************");
                    coin += bet*5;
                    System.out.println("현재 남은 Coin : "+ coin);
                }else{
                    System.out.println("이번 로또의 값은"+ botNumber + "입니다.");
                }
                System.out.println("게임을 종료합니다.");

            }else if (command.equals("4")){
                System.out.println("업다운 ");
                System.out.println("************************");
                System.out.println("*********업 앤 다운*******");
                System.out.println("************************");
                System.out.println("숫자는 0~46사이의 값이 있습니다.");
                System.out.println("총 시도 횟수는 5회 입니다.");


                System.out.println("배팅 금액 (잔액" + coin + ") > ");
                int bet = Integer.parseInt(scanner.nextLine());
                coin -= bet;
                int targetNumber = (int)(Math.random()*47);
                boolean jundap = false;
                for (int tryCount = 5; tryCount > 0; tryCount--){
                    System.out.print("예상 값을 입력하세요 (남은 횟수 "+tryCount+") > ");
                    int guessNumber = Integer.parseInt(scanner.nextLine());
                    if(targetNumber > guessNumber){
                        System.out.println("up");
                    }else if(targetNumber < guessNumber){
                        System.out.println("down");
                    }else{
                        System.out.println("정답");
                        coin += bet *3;
                        jundap =true;
                        break;
                    }

                }if(!jundap){
                    System.out.println("정답을 맞추지 못했습니다. ");
                }

            }else {
                System.out.println("잘못된 값을 입력하셨습니다.");
                continue;
            }
            //.. 각 게임 종료 시점 ...
            if(coin <= 0){
                System.out.println("모든 돈을 잃었습니다.");
                break;
            }
            System.out.println("계속 진행 하시려면 Enter를 입력하세요... > ");
            scanner.nextLine();
        }

        System.out.println("게임을 종료합니다."); 
    }
}
