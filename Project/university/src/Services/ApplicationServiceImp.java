package Services;

import POJOs.CardNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApplicationServiceImp implements ApplicationService {
    @Override
    public List<String> generateNonRepeatingNumbers(CardNumbers existingNumbers) {
        long t = System.currentTimeMillis();//获得当前时间的毫秒数
        Random rand = new Random(t);//作为种子数传入到Random的构造器中
        int [] numbers=new int[9];
        List<String> phoneNumbers=new ArrayList<String>();
        for(int i=0;i<9;i++) {
            //去除已注册的电话号码
            while(true) {
                numbers[i] = rand.nextInt(100000000);
                boolean judge = true;
                for (String cardNumber : existingNumbers.cardNumbers) {
                    if (numbers[i] == Integer.parseInt(cardNumber.substring(3, 11))) {
                        judge=false;
                        break;
                    }
                }
                //去除重复生成的随机数
                for(int j=0;j<i;j++){
                    if (numbers[i] == numbers[j]) {
                        judge = false;
                        break;
                    }
                }
                if(judge)
                    break;
            }
            phoneNumbers.add("139"+String.format("%08d", numbers[i]));
        }
        return phoneNumbers;
    }
}
