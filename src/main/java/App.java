import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    boolean isEnd = false;
    int lastId = 1;
    WiseSaying[] wiseArr = new WiseSaying[100];

    void run() {
        System.out.println("== 명언 앱 ==");

        while(!isEnd) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            switch(cmd) {
                case "종료":
                    isEnd = true;
                    break;
                case "등록":
                    actionRegister();
                    break;
                case "목록":
                    actionList();
                    break;
            }
        }
    }

    private void actionRegister() {
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying item = write(author, content);

        System.out.printf("%d번 명언이 등록되었습니다.\n", item.getId());
    }

    private WiseSaying write(String author, String content) {
        int id = lastId++;
        WiseSaying item = new WiseSaying(id, author, content);

        wiseArr[id-1] = item;

        return item;
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(int i=lastId-2; i>=0; i--) {
            System.out.println(wiseArr[i].toListString());
        }
    }
}
