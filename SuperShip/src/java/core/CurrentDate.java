/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author 
 */
public class CurrentDate {

    public String GetDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String GetDateAfterDays(int day) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date = new Date();
        String todate = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);
        Date todate1 = cal.getTime();
        String fromdate = dateFormat.format(todate1);
        return fromdate;
    }

    public static void main(String[] args) {
        quizlet();
    }

    public static void quizlet() {
        String text = "1\n" +
"びょうき\n" +
"Bệnh, ốm	\n" +
"びょうきになりました。\n" +
"Tôi đã bị bệnh.\n" +
"2\n" +
"びょういん\n" +
"Bệnh viện	\n" +
"びょういんへ行いきます。\n" +
"Tôi sẽ đi bệnh viện.\n" +
"3\n" +
"どうしましたか\n" +
"Anh / chị bị làm sao?	\n" +
"いしゃ「どうしましたか。」\n" +
"Bác sỹ : Anh / chị bị làm sao.\n" +
"4\n" +
"ねつ\n" +
"Sốt	\n" +
"A「きのうからねつがあります。」\n" +
"A : Tôi bị sốt từ hôm qua.\n" +
"5\n" +
"かぜ\n" +
"Cảm	\n" +
"いしゃ「かぜですね。」\n" +
"Bác sỹ: (Anh/chị) bị cảm.\n" +
"6\n" +
"インフルエンザ\n" +
"Cúm	\n" +
"いしゃ「インフルエンザです。おふろに入はいらないでください。」\n" +
"Bác sỹ: (Anh/chị) bị cúm. Đừng đi tắm nhé.\n" +
"7\n" +
"くすり\n" +
"Thuốc	\n" +
"一いち日にちに3かいくすりを飲のんでください。\n" +
"Bác sỹ: Hãy uống thuốc 1 ngày 3 lần.\n" +
"8\n" +
"はな\n" +
"Mũi	.\n" +
"\n" +
"9\n" +
"口\n" +
"くち\n" +
"Miệng	.\n" +
"\n" +
"10\n" +
"のど\n" +
"Cổ họng	.\n" +
"\n" +
"11\n" +
"耳\n" +
"みみ\n" +
"Tai	.\n" +
"\n" +
"12\n" +
"目\n" +
"め\n" +
"mắt	.\n" +
"\n" +
"13\n" +
"あたま\n" +
"Đầu	.\n" +
"\n" +
"14\n" +
"手\n" +
"て\n" +
"tay	.\n" +
"\n" +
"15\n" +
"かお\n" +
"Má	.\n" +
"\n" +
"16\n" +
"おなか\n" +
"Bụng	.\n" +
"\n" +
"17\n" +
"足\n" +
"おし\n" +
"Chân	.\n" +
"\n" +
"18\n" +
"おだいじに\n" +
"giữ gìn sức khỏe, mau khỏe. (Câu nói với người đang bị đau bệnh)	\n" +
"かんごし「おだいじに。」\n" +
"Y tá: Anh/chị mau khỏe nhé.\n" +
"19\n" +
"2、3日\n" +
"に，さんにち\n" +
"2, 3 ngày	\n" +
"2、3日にちかいしゃを休やすみます。\n" +
"Tôi nghỉ làm 2, 3 ngày.\n" +
"20\n" +
"〜がいたい\n" +
"Đau 〜	\n" +
"はがいたいです。\n" +
"Tôi đau răng.\n" +
"21\n" +
"はいしゃ[さん]\n" +
"Nha sỹ	\n" +
"きのう、はいしゃへ行いきました。\n" +
"Hôm qua tôi đã đi nha sỹ.\n" +
"22\n" +
"一人で\n" +
"ひとり\n" +
"Một mình	\n" +
"一人ひとりでびょういんへ行いきます。\n" +
"Tôi sẽ đi bệnh viện một mình.\n" +
"23\n" +
"けんこう\n" +
"Khỏe mạnh, sức khỏe	\n" +
"けんこうに気きをつけています。\n" +
"Tôi giữ gìn sức khỏe.\n" +
"24\n" +
"[けんこう]ほけんしょう\n" +
"Thẻ bảo hiểm (sức khỏe)	\n" +
"びょういんにけんこうほけんしょうをもっていきます。\n" +
"Tôi đem thẻ bảo hiểm (sức khỏe) đi bệnh viện.";
        String arr[] = text.split("\\.");
        int i = 0;
        while (true) {
            if (i < arr.length) {

                secondquizlet(arr[i]);
                
//                System.err.println(arr[i]);
                i++;
//                if(i==2){
//                break;
//                }

            } else {
                break;
            }

        }

    }

    public static void secondquizlet(String input) {
        String arr[] = input.split("\n");
        String newString = "";
        int i = 0;
        boolean flag= true;
        while (true) {
            if (i < arr.length) {
                if(flag==true){
                    arr[2]+="@";
                    flag=false;
                }
//                System.err.println(arr[i]);
                newString+=arr[i]+"\n";
            } else {
                break;
            }
            i++;
        }
         System.err.println(newString);
    }

}
