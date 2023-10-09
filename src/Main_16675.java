import java.util.Scanner;
/*
[Case Work] 두 개의 손
[MS]      [TK]
      "MS승"  / "TK승"
 RS    PP SS /
 RP    RR SS
 RR    SS    / PR PS PP
 PS    PP RR
 PP    RR    / PS RS SS
 SS    PP    / PR RS RR
 */
public class Main_16675 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String  ML,MR,TL,TR;
        ML = s.next();
        MR = s.next();
        TL = s.next();
        TR = s.next();
        String result="?";
        //MS 한 손 주먹
        if (ML.equals("R") || MR.equals("R")){
            if (ML.equals("S") || MR.equals("S")) { //MS 주먹 가위
                if (TL.equals("P") && TR.equals("P") || TL.equals("S") && TR.equals("S")) result = "MS";
            }
            else if(ML.equals("P") || MR.equals("P")) { //MS가 주먹 보자기
                if (TL.equals("R") && TR.equals("R") || TL.equals("S") && TR.equals("S")) result = "MS";
            }
            else { //MS가 주먹 주먹
                if (TL.equals("P") || TR.equals("P")) result = "TK";
                else if (TL.equals("S") && TR.equals("S")) result="MS";
            }
        }
        // MS 한 손 보자기
        else if (ML.equals("P") || MR.equals("P")){
            if (ML.equals("S") || MR.equals("S")) { //MS가 보자기 가위
                if (TL.equals("P") && TR.equals("P") || TL.equals("R") && TR.equals("R")) result="MS";
            }
            else { //MS가 보자기 보자기
                if (TL.equals("R") && TR.equals("R")) result="MS";
                else if (TL.equals("S") || TR.equals("S")) result="TK";
            }
        }

        else if (ML.equals("S") || MR.equals("S")){ //MS 가위 가위
            if (TL.equals("P") && TR.equals("P")) result="MS";
            else if (TL.equals("R") || TR.equals("R")) result="TK";
        }

        System.out.println(result);
    }
}
